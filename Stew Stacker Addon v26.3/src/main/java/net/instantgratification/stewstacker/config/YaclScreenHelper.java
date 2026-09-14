// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker.config;

// Verified against: YaclScreenHelper.java (YACL 3.9.5)
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.IntegerFieldControllerBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class YaclScreenHelper {
    public static ConfigScreenFactory<?> createScreen() {
        return YaclScreenHelper::buildScreen;
    }

    private static Screen buildScreen(Screen parent) {
        StewStackerConfig config = StewStackerConfig.get();

        return YetAnotherConfigLib.createBuilder()
            .title(Component.translatable("config.stew-stacker-addon.title"))
            .category(ConfigCategory.createBuilder()
                .name(Component.translatable("config.stew-stacker-addon.category.general"))
                .group(OptionGroup.createBuilder()
                    .name(Component.translatable("config.stew-stacker-addon.group.categories"))

                    // Stew Limit
                    .option(Option.<Integer>createBuilder()
                        .name(Component.translatable("config.stew-stacker-addon.option.stew_limit"))
                        .description(val -> {
                            if (val > 39768215) {
                                return OptionDescription.of(Component.translatable("config.stew-stacker-addon.option.warning", val));
                            }
                            return OptionDescription.of(Component.translatable("config.stew-stacker-addon.option.stew_limit.description"));
                        })
                        .binding(
                            16,
                            () -> config.stewLimit,
                            val -> config.stewLimit = val
                        )
                        .controller(opt -> IntegerFieldControllerBuilder.create(opt)
                            .min(1)
                            .max(Integer.MAX_VALUE)
                        )
                        .build()
                    )

                    .build()
                )
                .build()
            )
            .save(StewStackerConfig::save)
            .build()
            .generateScreen(parent);
    }
}
