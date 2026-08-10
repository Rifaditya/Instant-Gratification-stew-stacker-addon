// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.resources.Identifier;
import net.instantgratification.stewstacker.config.StewStackerConfig;
import net.instantgratification.stewstacker.network.StewLimitSyncPayload;
import net.instantgratification.stewstacker.util.StewStackerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Verified against: ModInitializer.java (Fabric API)
// Verified against: DynamicGameRuleManager.java (DasikLibrary 1.8.2)
public class StewStackerFabric implements ModInitializer {
    public static final String MOD_ID = "stew-stacker-addon";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final GameRuleCategory CUSTOM_CATEGORY = DynamicGameRuleManager.registerCategory(
        Identifier.fromNamespaceAndPath(MOD_ID, MOD_ID)
    );

    public static GameRule<Integer> STEW_LIMIT;

    @Override
    public void onInitialize() {
        LOGGER.info("Instant Gratification: Stew Stacker Initialized");

        // Load config baseline template
        StewStackerConfig.load(FabricLoader.getInstance().getConfigDir());

        // Register custom stack size override into Stack Size Adjuster's manager
        net.instantgratification.stacksizeadjuster.util.StackSizeManager.registerOverride(
            (net.instantgratification.stacksizeadjuster.util.CustomStackSizeOverride) (item, originalSize) -> 
                StewStackerManager.getModifiedStackSize(item, originalSize)
        );

        // Register Stew Limit GameRule with dynamic default loaded from baseline config
        STEW_LIMIT = DynamicGameRuleManager.integerRule(MOD_ID + ":stew_limit", CUSTOM_CATEGORY, StewStackerConfig.get().stewLimit)
            .name("Stew Limit")
            .description("Maximum stack size for stews and beetroot soup. Default: 16")
            .range(1, Integer.MAX_VALUE)
            .register();

        // Register Payload S2C
        PayloadTypeRegistry.clientboundPlay().register(StewLimitSyncPayload.TYPE, StewLimitSyncPayload.CODEC);

        // Sync limits to client when player joins the world
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            sender.sendPacket(new StewLimitSyncPayload(
                StewStackerManager.getStewLimit()
            ));
        });

        // Initialize/update active limits on server starting
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            // Reload config baseline template to fetch main-menu updates
            StewStackerConfig.load(FabricLoader.getInstance().getConfigDir());

            GameRules rules = server.getGameRules();
            
            // If the world is newly created (not initialized yet), apply the baseline config template directly to the active GameRules
            if (!server.getWorldData().overworldData().isInitialized()) {
                rules.set(STEW_LIMIT, StewStackerConfig.get().stewLimit, server);
            }

            int sLimit = rules.get(STEW_LIMIT);
            StewStackerManager.setLimit(sLimit, server);
        });
    }
}
