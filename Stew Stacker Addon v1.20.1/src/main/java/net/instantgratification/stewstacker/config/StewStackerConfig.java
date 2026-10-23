// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker.config;

import net.dasik.social.api.config.ConfigHelper;
import net.dasik.social.api.config.ConfigOption;
import net.instantgratification.stewstacker.StewStackerFabric;

import java.nio.file.Path;

public class StewStackerConfig {
    private static StewStackerConfig INSTANCE = new StewStackerConfig();
    private static Path CONFIG_PATH;

    public static final int VERSION = 1;
    public int configVersion = VERSION;

    @ConfigOption(
        category = "general",
        group = "categories",
        nameKey = "config.stew-stacker-addon.option.stew_limit",
        descriptionKey = "config.stew-stacker-addon.option.stew_limit.description",
        min = 1,
        max = Integer.MAX_VALUE,
        syncGameRule = true,
        gameRuleName = "stew-stacker-addon:stew_limit"
    )
    public int stewLimit = 16;

    public static synchronized void load(Path configDir) {
        CONFIG_PATH = configDir.resolve("stew-stacker.json");
        INSTANCE = ConfigHelper.load(
            CONFIG_PATH,
            INSTANCE,
            StewStackerConfig.class,
            VERSION,
            cfg -> cfg.configVersion,
            (cfg, ver) -> cfg.configVersion = ver,
            null,
            StewStackerFabric.LOGGER
        );
    }

    public static synchronized void save() {
        if (CONFIG_PATH == null) return;
        ConfigHelper.save(CONFIG_PATH, INSTANCE, StewStackerFabric.LOGGER);
    }

    public static StewStackerConfig get() {
        return INSTANCE;
    }
}
