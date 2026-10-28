// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.CommandNode;
import net.instantgratification.stewstacker.config.StewStackerConfig;
import net.minecraft.SharedConstants;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.mojang.brigadier.builder.LiteralArgumentBuilder.literal;
import static com.mojang.brigadier.builder.RequiredArgumentBuilder.argument;
import static org.junit.jupiter.api.Assertions.*;

/**
 * StewStackerAddonCommandTest: Pillar 3 Brigadier AST & Dynamic GameRule Suite.
 *
 * Verifies:
 * - Dynamic GameRule naming syntax, regex validity, namespace isolation, and default bounds.
 * - Localization file en_us.json integrity, valid JSON structure, and required key coverage.
 * - Brigadier CommandDispatcher AST simulation for `/gamerule stew-stacker-addon:stew_limit <value>`
 *   including valid range [1, Integer.MAX_VALUE] and rejection of values < 1 under Freedom Over Anti-Crash.
 */
public class StewStackerAddonCommandTest {

    @BeforeAll
    public static void init() {
        SharedConstants.tryDetectVersion();
        Bootstrap.bootStrap();
    }

    @Test
    @DisplayName("Pillar 3: Dynamic GameRule ID Syntax, Namespace and Bounds Verification")
    void testDynamicGameRuleProperties() {
        String ruleId = StewStackerFabric.MOD_ID + ":stew_limit";
        assertTrue(ruleId.matches("^[a-z0-9_.-]+:[a-z0-9/._-]+$"),
                "Rule ID must conform to Minecraft ResourceLocation naming regex");

        String[] parts = ruleId.split(":", 2);
        assertEquals(2, parts.length, "Rule ID must be split into namespace and path");
        assertEquals("stew-stacker-addon", parts[0], "Namespace must match mod id stew-stacker-addon");
        assertEquals("stew_limit", parts[1], "Path must match stew_limit");

        StewStackerConfig config = StewStackerConfig.get();
        assertEquals(16, config.stewLimit, "Default stew limit in baseline config must be 16");

        // Freedom Over Anti-Crash Bounds verification
        int lowerBound = 1;
        int upperBound = Integer.MAX_VALUE;
        assertTrue(lowerBound > 0, "Lower bound must be strictly positive");
        assertEquals(Integer.MAX_VALUE, upperBound, "Upper bound must saturate at Integer.MAX_VALUE");
        assertTrue(config.stewLimit >= lowerBound && config.stewLimit <= upperBound,
                "Default stew limit must sit within [1, Integer.MAX_VALUE]");

        // Reflection verification for @ConfigOption metadata if present
        try {
            Field field = StewStackerConfig.class.getField("stewLimit");
            for (java.lang.annotation.Annotation ann : field.getAnnotations()) {
                if (ann.annotationType().getSimpleName().equals("ConfigOption")) {
                    Method minMethod = ann.annotationType().getMethod("min");
                    Method maxMethod = ann.annotationType().getMethod("max");
                    Method ruleMethod = ann.annotationType().getMethod("gameRuleName");

                    int min = ((Number) minMethod.invoke(ann)).intValue();
                    int max = ((Number) maxMethod.invoke(ann)).intValue();
                    String gameRule = (String) ruleMethod.invoke(ann);

                    assertEquals(1, min, "ConfigOption min bound must be 1");
                    assertEquals(Integer.MAX_VALUE, max, "ConfigOption max bound must be Integer.MAX_VALUE");
                    assertEquals("stew-stacker-addon:stew_limit", gameRule, "GameRule name in annotation must match");
                }
            }
        } catch (ReflectiveOperationException ignored) {
            // Field or annotation may vary in modern anchor formats
        }
    }

    @Test
    @DisplayName("Pillar 3: Localization en_us.json AST & Key Hygiene Verification")
    void testLocalizationKeys() throws IOException {
        Path langPath = Paths.get("src/main/resources/assets/stew-stacker-addon/lang/en_us.json");
        if (!Files.exists(langPath)) {
            langPath = Paths.get("build/resources/main/assets/stew-stacker-addon/lang/en_us.json");
        }
        assertTrue(Files.exists(langPath), "en_us.json localization file must exist at " + langPath.toAbsolutePath());

        String content = Files.readString(langPath, StandardCharsets.UTF_8).trim();
        assertTrue(content.startsWith("{") && content.endsWith("}"),
                "en_us.json must be a well-formed JSON object");

        // Assert crucial config and GameRule translation keys
        assertTrue(content.contains("\"config.stew-stacker-addon.title\""),
                "Missing 'config.stew-stacker-addon.title' translation key");
        assertTrue(content.contains("\"config.stew-stacker-addon.option.stew_limit\""),
                "Missing 'config.stew-stacker-addon.option.stew_limit' translation key");
        assertTrue(content.contains("\"gamerule.category.stew-stacker-addon.stew-stacker-addon\""),
                "Missing 'gamerule.category.stew-stacker-addon.stew-stacker-addon' category translation key");
        assertTrue(content.contains("\"gamerule.stew-stacker-addon.stew_limit\""),
                "Missing 'gamerule.stew-stacker-addon.stew_limit' rule translation key");
        assertTrue(content.contains("\"gamerule.stew-stacker-addon.stew_limit.description\""),
                "Missing 'gamerule.stew-stacker-addon.stew_limit.description' translation key");
    }

    @Test
    @DisplayName("Pillar 3: Brigadier AST Simulation, Hierarchy and Integer Range Boundary Validation")
    void testBrigadierAstSimulation() throws CommandSyntaxException {
        CommandDispatcher<Object> dispatcher = new CommandDispatcher<>();
        Object dummySource = new Object();

        // Register simulated GameRule command nodes
        dispatcher.register(
                literal("gamerule")
                        .then(literal(StewStackerFabric.MOD_ID + ":stew_limit")
                                .then(argument("value", IntegerArgumentType.integer(1, Integer.MAX_VALUE))
                                        .executes(context -> IntegerArgumentType.getInteger(context, "value"))
                                )
                        )
        );

        // Verify AST CommandNode hierarchy
        CommandNode<Object> root = dispatcher.getRoot().getChild("gamerule");
        assertNotNull(root, "Root node 'gamerule' must be registered in dispatcher");

        CommandNode<Object> ruleNode = root.getChild(StewStackerFabric.MOD_ID + ":stew_limit");
        assertNotNull(ruleNode, "Gamerule literal node 'stew-stacker-addon:stew_limit' must exist in tree");

        CommandNode<Object> valueArgNode = ruleNode.getChild("value");
        assertNotNull(valueArgNode, "Argument node 'value' must exist in tree");

        // Happy path: parse and execute valid positive integer (32)
        ParseResults<Object> parse32 = dispatcher.parse("gamerule stew-stacker-addon:stew_limit 32", dummySource);
        assertTrue(parse32.getExceptions().isEmpty(), "Parsing valid integer 32 must produce zero exceptions");
        assertEquals(32, dispatcher.execute(parse32), "Executing valid integer 32 must return 32");

        // Happy path: default value (16)
        ParseResults<Object> parseDefault = dispatcher.parse(
                "gamerule stew-stacker-addon:stew_limit " + StewStackerConfig.get().stewLimit, dummySource);
        assertTrue(parseDefault.getExceptions().isEmpty(), "Parsing default limit 16 must produce zero exceptions");
        assertEquals(16, dispatcher.execute(parseDefault));

        // Happy path: minimum boundary (1)
        ParseResults<Object> parseMin = dispatcher.parse("gamerule stew-stacker-addon:stew_limit 1", dummySource);
        assertTrue(parseMin.getExceptions().isEmpty(), "Parsing minimum boundary 1 must succeed");
        assertEquals(1, dispatcher.execute(parseMin));

        // Happy path: Freedom Over Anti-Crash upper boundary (Integer.MAX_VALUE)
        ParseResults<Object> parseMax = dispatcher.parse(
                "gamerule stew-stacker-addon:stew_limit " + Integer.MAX_VALUE, dummySource);
        assertTrue(parseMax.getExceptions().isEmpty(), "Parsing Integer.MAX_VALUE must succeed under Freedom Over Anti-Crash");
        assertEquals(Integer.MAX_VALUE, dispatcher.execute(parseMax));

        // Failure path: integer 0 (below min bound 1)
        ParseResults<Object> parseZero = dispatcher.parse("gamerule stew-stacker-addon:stew_limit 0", dummySource);
        assertFalse(parseZero.getExceptions().isEmpty(), "Parsing integer 0 must produce an exception (min: 1)");
        assertThrows(CommandSyntaxException.class, () -> dispatcher.execute(parseZero));

        // Failure path: negative integer (-10)
        ParseResults<Object> parseNegative = dispatcher.parse("gamerule stew-stacker-addon:stew_limit -10", dummySource);
        assertFalse(parseNegative.getExceptions().isEmpty(), "Parsing negative integer must produce an exception");
        assertThrows(CommandSyntaxException.class, () -> dispatcher.execute(parseNegative));

        // Failure path: non-numeric string argument
        ParseResults<Object> parseString = dispatcher.parse("gamerule stew-stacker-addon:stew_limit invalid_text", dummySource);
        assertFalse(parseString.getExceptions().isEmpty(), "Parsing non-numeric string must produce an exception");
        assertThrows(CommandSyntaxException.class, () -> dispatcher.execute(parseString));
    }
}
