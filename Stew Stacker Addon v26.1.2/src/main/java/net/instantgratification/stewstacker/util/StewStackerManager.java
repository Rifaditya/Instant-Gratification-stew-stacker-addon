// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker.util;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.instantgratification.stewstacker.network.StewLimitSyncPayload;

public class StewStackerManager {
    private static volatile int stewLimit = 16;

    public static int getStewLimit() {
        return stewLimit;
    }

    public static int getModifiedStackSize(Item item, int original) {
        if (original <= 0) {
            return original;
        }
        if (isStewOrSoup(item)) {
            return stewLimit;
        }
        return -1;
    }

    public static boolean isStewOrSoup(Item item) {
        return item == net.minecraft.world.item.Items.MUSHROOM_STEW
            || item == net.minecraft.world.item.Items.RABBIT_STEW
            || item == net.minecraft.world.item.Items.BEETROOT_SOUP
            || item == net.minecraft.world.item.Items.SUSPICIOUS_STEW;
    }

    public static void setLimit(int sLimit, MinecraftServer server) {
        boolean changed = (sLimit != stewLimit);
        if (changed) {
            stewLimit = sLimit;
            if (server != null) {
                StewLimitSyncPayload payload = new StewLimitSyncPayload(sLimit);
                for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                    ServerPlayNetworking.send(player, payload);
                    
                    // Force refresh client's container and inventory menus dynamically
                    if (player.containerMenu != null) {
                        player.containerMenu.broadcastFullState();
                    }
                    if (player.inventoryMenu != null && player.containerMenu != player.inventoryMenu) {
                        player.inventoryMenu.broadcastFullState();
                    }
                }
            }
        }
    }

    public static void setClientLimit(int sLimit) {
        stewLimit = sLimit;
    }
}
