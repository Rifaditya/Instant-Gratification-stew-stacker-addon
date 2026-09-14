// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker.config;

import java.nio.file.Path;

public class StewStackerConfig {
    private static StewStackerConfig INSTANCE = new StewStackerConfig();
    private static Path CONFIG_PATH;

    public static final int VERSION = 1;
    public int configVersion = VERSION;

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
