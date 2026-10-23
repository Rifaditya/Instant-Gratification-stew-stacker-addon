// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.dasik.social.api.config.GuiHelper;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return GuiHelper.getOptionalYaclFactory(
            "stew-stacker-addon",
            "net.instantgratification.stewstacker.config.YaclScreenHelper",
            "createScreen"
        );
    }
}
