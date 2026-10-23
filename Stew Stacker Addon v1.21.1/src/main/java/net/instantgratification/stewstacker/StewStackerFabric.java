// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.GameRules;
import net.instantgratification.stewstacker.config.StewStackerConfig;
import net.instantgratification.stewstacker.network.StewLimitSyncPayload;
import net.instantgratification.stewstacker.util.StewStackerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StewStackerFabric implements ModInitializer {
    public static final String MOD_ID = "stew-stacker-addon";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static CustomGameRuleCategory CUSTOM_CATEGORY;
    public static GameRules.Key<GameRules.IntegerValue> STEW_LIMIT;

    @Override
    public void onInitialize() {
        LOGGER.info("Instant Gratification: Stew Stacker Initialized (1.21.1)");

        // Load config baseline template
        StewStackerConfig.load(FabricLoader.getInstance().getConfigDir());

        // Register custom stack size override into Stack Size Adjuster's manager
        net.instantgratification.stacksizeadjuster.util.StackSizeManager.registerOverride(
            (net.instantgratification.stacksizeadjuster.util.CustomStackSizeOverride) (item, originalSize) -> 
                StewStackerManager.getModifiedStackSize(item, originalSize)
        );

        // Register Category
        CUSTOM_CATEGORY = DynamicGameRuleManager.registerCategory(
            ResourceLocation.fromNamespaceAndPath(MOD_ID, MOD_ID),
            Component.translatable("gamerule.category.stew-stacker-addon.stew-stacker-addon")
        );

        // Register Stew Limit GameRule with dynamic default loaded from baseline config
        STEW_LIMIT = DynamicGameRuleManager.integerRule(MOD_ID + ":stew_limit", CUSTOM_CATEGORY, StewStackerConfig.get().stewLimit)
            .name("Stew Limit")
            .description("Maximum stack size for stews and beetroot soup. Default: 16")
            .range(1, Integer.MAX_VALUE)
            .register();

        // Register Payload S2C via playS2C()
        PayloadTypeRegistry.playS2C().register(StewLimitSyncPayload.TYPE, StewLimitSyncPayload.CODEC);

        // Sync limits to client when player joins the world
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            sender.sendPacket(new StewLimitSyncPayload(
                StewStackerManager.getStewLimit()
            ));
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
}
