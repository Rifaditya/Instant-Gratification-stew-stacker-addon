// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.instantgratification.stewstacker.network.StewLimitSyncPayload;
import net.instantgratification.stewstacker.util.StewStackerManager;

// Verified against: ClientModInitializer.java (26.2+)
public class StewStackerFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(StewLimitSyncPayload.TYPE, (payload, context) -> {
            context.client().execute(() -> {
                StewStackerManager.setClientLimit(payload.stewLimit());
            });
        });
    }
}
