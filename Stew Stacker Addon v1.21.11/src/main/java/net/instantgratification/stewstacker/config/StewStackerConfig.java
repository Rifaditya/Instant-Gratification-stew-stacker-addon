// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker.config;

import net.dasik.social.api.config.ConfigHelper;
import net.dasik.social.api.config.ConfigOption;

import java.nio.file.Path;

public class StewStackerConfig {
    private static StewStackerConfig INSTANCE = new StewStackerConfig();
    private static Path CONFIG_PATH;

    public static final int VERSION = 1;
    public int configVersion = VERSION;

    @ConfigOption(
        category = "general",
        group = "categories",
        min = 1.0,
        max = 2147483647.0,
        step = 1.0,
        slider = false,
        syncGameRule = true,
        gameRuleName = "stew-stacker-addon:stew_limit",
        nameKey = "config.stew-stacker-addon.option.stew_limit",
        descriptionKey = "config.stew-stacker-addon.option.stew_limit.description"
    )
    public int stewLimit = 16;

    public static synchronized void load(Path configDir) {
        CONFIG_PATH = configDir.resolve("stew-stacker.json");
        INSTANCE = ConfigHelper.loadOrCreate(CONFIG_PATH, StewStackerConfig.class, StewStackerConfig::new);
    }

    public static synchronized void save() {
        if (CONFIG_PATH == null) return;
        ConfigHelper.save(CONFIG_PATH, INSTANCE);
    }

    public static StewStackerConfig get() {
        return INSTANCE;
    }
}
