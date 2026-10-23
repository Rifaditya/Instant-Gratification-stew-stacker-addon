// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameRules;
import net.instantgratification.stacksizeadjuster.util.StackSizeManager;
import net.instantgratification.stewstacker.config.StewStackerConfig;
import net.instantgratification.stewstacker.util.StewStackerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StewStackerFabric implements ModInitializer {
    public static final String MOD_ID = "stew-stacker-addon";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final ResourceLocation SYNC_LIMIT_ID = new ResourceLocation(MOD_ID, "sync_limit");

    public static CustomGameRuleCategory CUSTOM_CATEGORY;
    public static GameRules.Key<GameRules.IntegerValue> STEW_LIMIT;

    @Override
    public void onInitialize() {
        LOGGER.info("Instant Gratification: Stew Stacker Initialized (1.20.1)");

        // Load config baseline template
        StewStackerConfig.load(FabricLoader.getInstance().getConfigDir());

        // Register custom stack size override into Stack Size Adjuster's manager
        StackSizeManager.registerOverride((net.instantgratification.stacksizeadjuster.util.CustomStackSizeOverride) (item, original) ->
            StewStackerManager.getModifiedStackSize(item, original)
        );

        // Register Category
        CUSTOM_CATEGORY = DynamicGameRuleManager.registerCategory(
            new ResourceLocation(MOD_ID, MOD_ID),
            Component.translatable("gamerule.category.stew-stacker-addon.stew-stacker-addon")
        );

        // Register Stew Limit GameRule with dynamic default loaded from baseline config
        STEW_LIMIT = DynamicGameRuleManager.integerRule(MOD_ID + ":stew_limit", CUSTOM_CATEGORY, StewStackerConfig.get().stewLimit)
            .name("Stew Limit")
            .description("Maximum stack size for stews and beetroot soup. Default: 16")
            .range(1, Integer.MAX_VALUE)
            .register();

        // Sync limits to client when player joins the world
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            FriendlyByteBuf buf = PacketByteBufs.create();
            buf.writeVarInt(StewStackerManager.getStewLimit());
            sender.sendPacket(SYNC_LIMIT_ID, buf);
        });

        // Periodic sync in case gamerules are changed via in-game commands
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if (server.getTickCount() % 20 == 0) {
                GameRules rules = server.getGameRules();
                int sLimit = rules.getInt(STEW_LIMIT);
                if (sLimit != StewStackerManager.getStewLimit()) {
                    StewStackerManager.setLimit(sLimit, server);
                }
            }
        });

        // Initialize/update active limits on server starting
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            // Reload config baseline template to fetch main-menu updates
            StewStackerConfig.load(FabricLoader.getInstance().getConfigDir());

            GameRules rules = server.getGameRules();
            
            // If the world is newly created (not initialized yet), apply the baseline config template directly to the active GameRules
            if (!server.getWorldData().overworldData().isInitialized()) {
                rules.getRule(STEW_LIMIT).set(StewStackerConfig.get().stewLimit, server);
            }

            int sLimit = rules.getInt(STEW_LIMIT);
            StewStackerManager.setLimit(sLimit, server);
        });
    }

    public static void syncLimits(MinecraftServer server) {
        if (server == null) return;
        FriendlyByteBuf buf = PacketByteBufs.create();
        buf.writeVarInt(StewStackerManager.getStewLimit());
        for (ServerPlayer player : server.getPlayerList().getPlayers()) {
            ServerPlayNetworking.send(player, SYNC_LIMIT_ID, PacketByteBufs.copy(buf));
            if (player.containerMenu != null) {
                player.containerMenu.broadcastFullState();
            }
            if (player.inventoryMenu != null && player.containerMenu != player.inventoryMenu) {
                player.inventoryMenu.broadcastFullState();
            }
        }
    }
}
