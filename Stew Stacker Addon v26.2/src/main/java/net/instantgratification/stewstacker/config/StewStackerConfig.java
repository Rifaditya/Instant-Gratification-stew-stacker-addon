// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker.config;

import java.nio.file.Path;
import net.dasik.social.api.config.ConfigOption;

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
        INSTANCE = net.dasik.social.api.config.ConfigHelper.load(
            CONFIG_PATH, INSTANCE, StewStackerConfig.class, VERSION,
            config -> config.configVersion, (config, ver) -> config.configVersion = ver,
            null, org.slf4j.LoggerFactory.getLogger("StewStacker")
        );
    }

    public static synchronized void save() {
        if (CONFIG_PATH == null) return;
        net.dasik.social.api.config.ConfigHelper.save(CONFIG_PATH, INSTANCE, org.slf4j.LoggerFactory.getLogger("StewStacker"));
    }

    public static StewStackerConfig get() {
        return INSTANCE;
    }
}
