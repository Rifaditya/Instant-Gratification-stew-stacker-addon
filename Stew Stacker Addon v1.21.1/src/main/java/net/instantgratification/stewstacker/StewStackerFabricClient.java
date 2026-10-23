// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.instantgratification.stewstacker.network.StewLimitSyncPayload;
import net.instantgratification.stewstacker.util.StewStackerManager;

@Environment(EnvType.CLIENT)
public class StewStackerFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(StewLimitSyncPayload.TYPE, (payload, context) -> {
            context.client().execute(() -> {
                StewStackerManager.setClientLimit(payload.stewLimit());
                if (context.client().player != null && context.client().player.containerMenu != null) {
                    context.client().player.containerMenu.broadcastFullState();
                }
            });
        });
    }
}
