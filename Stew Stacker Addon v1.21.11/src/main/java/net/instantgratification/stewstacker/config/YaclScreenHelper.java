// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import net.dasik.social.api.client.gui.UniversalConfigScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class YaclScreenHelper {
    public static ConfigScreenFactory<?> createScreen() {
        return UniversalConfigScreen.createFactory("stew-stacker-addon", StewStackerConfig.get(), StewStackerConfig::save);
    }
}
