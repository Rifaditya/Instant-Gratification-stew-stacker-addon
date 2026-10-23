// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.instantgratification.stewstacker.util.StewStackerManager;

@Environment(EnvType.CLIENT)
public class StewStackerFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(StewStackerFabric.SYNC_LIMIT_ID, (client, handler, buf, responseSender) -> {
            int sLimit = buf.readVarInt();
            client.execute(() -> {
                StewStackerManager.setClientLimit(sLimit);
                if (client.player != null && client.player.containerMenu != null) {
                    client.player.containerMenu.broadcastFullState();
                }
            });
        });
    }
}
