// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * StewStackerAddonSidednessContractTest: Pillar 5 Sidedness & Mixin Contract Verification Suite
 *
 * Verifies:
 * - Zero unguarded net.minecraft.client.* or com.mojang.blaze3d.* references in common sources & bytecode.
 * - 100% presence of GPLv3 license header on line 1.
 * - Absence of obsolete Class.forName entrypoint hacks.
 * - Dynamic byte array token construction to prevent compiler constant-pool inlining (Testing Policy §4).
 */
public class StewStackerAddonSidednessContractTest {

    // Dynamic byte array construction prevents compiler constant-pool inlining (Testing & Runtime Verification Policy §4)
    private static final String FORBIDDEN_CLIENT_PACKAGE = new String(
            new byte[]{110, 101, 116, 46, 109, 105, 110, 101, 99, 114, 97, 102, 116, 46, 99, 108, 105, 101, 110, 116, 46},
            StandardCharsets.UTF_8); // "net.minecraft.client."

    private static final String FORBIDDEN_BLAZE3D_PACKAGE = new String(
            new byte[]{99, 111, 109, 46, 109, 111, 106, 97, 110, 103, 46, 98, 108, 97, 122, 101, 51, 100, 46},
            StandardCharsets.UTF_8); // "com.mojang.blaze3d."

    private static final String FORBIDDEN_CLIENT_BYTECODE = new String(
            new byte[]{110, 101, 116, 47, 109, 105, 110, 101, 99, 114, 97, 102, 116, 47, 99, 108, 105, 101, 110, 116, 47},
            StandardCharsets.ISO_8859_1); // "net/minecraft/client/"

    private static final String FORBIDDEN_BLAZE3D_BYTECODE = new String(
            new byte[]{99, 111, 109, 47, 109, 111, 106, 97, 110, 103, 47, 98, 108, 97, 122, 101, 51, 100, 47},
            StandardCharsets.ISO_8859_1); // "com/mojang/blaze3d/"

    private static final String FORBIDDEN_CLASS_FOR_NAME = new String(
            new byte[]{67, 108, 97, 115, 115, 46, 102, 111, 114, 78, 97, 109, 101},
            StandardCharsets.UTF_8); // "Class.forName"

    @Test
    @DisplayName("Pillar 5: Common Sources & Bytecode Contain Zero Unguarded Client References")
    void testCommonSidednessIsolation() throws IOException {
        Path srcRoot = Paths.get("src/main/java");
        assertTrue(Files.exists(srcRoot), "src/main/java must exist");

        try (Stream<Path> stream = Files.walk(srcRoot)) {
            List<Path> javaFiles = stream.filter(p -> p.toString().endsWith(".java")).toList();
            assertFalse(javaFiles.isEmpty(), "Java source files must exist");

            for (Path file : javaFiles) {
                String normalized = file.toString().replace('\\', '/');
                String content = Files.readString(file, StandardCharsets.UTF_8);

                assertTrue(content.startsWith("// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3"),
                        "Missing GPLv3 license header on line 1 in: " + normalized);

                // Exclude client entrypoint and GUI helper classes
                if (normalized.contains("StewStackerFabricClient")
                        || normalized.contains("ModMenuIntegration")
                        || normalized.contains("YaclScreenHelper")) {
                    continue;
                }

                // Any client GUI integration class must carry @Environment(EnvType.CLIENT)
                if (content.contains("@Environment(EnvType.CLIENT)")) {
                    continue;
                }

                assertFalse(content.contains(FORBIDDEN_CLIENT_PACKAGE),
                        "Forbidden client package reference in common source file: " + normalized);
                assertFalse(content.contains(FORBIDDEN_BLAZE3D_PACKAGE),
                        "Forbidden Blaze3D reference in common source file: " + normalized);
            }
        }

        Path classesRoot = Paths.get("build/classes/java/main");
        if (Files.exists(classesRoot)) {
            try (Stream<Path> stream = Files.walk(classesRoot)) {
                List<Path> classFiles = stream.filter(p -> p.toString().endsWith(".class")).toList();
                assertFalse(classFiles.isEmpty(), "build/classes/java/main must contain compiled class files");
                for (Path classFile : classFiles) {
                    String normalized = classFile.toString().replace('\\', '/');
                    if (normalized.contains("StewStackerFabricClient")
                            || normalized.contains("ModMenuIntegration")
                            || normalized.contains("YaclScreenHelper")) {
                        continue;
                    }
                    String rawBytes = new String(Files.readAllBytes(classFile), StandardCharsets.ISO_8859_1);
                    assertFalse(rawBytes.contains(FORBIDDEN_CLIENT_BYTECODE),
                            "Forbidden net/minecraft/client/ constant pool reference in common bytecode: " + normalized);
                    assertFalse(rawBytes.contains(FORBIDDEN_BLAZE3D_BYTECODE),
                            "Forbidden com/mojang/blaze3d/ constant pool reference in common bytecode: " + normalized);
                }
            }
        }
    }

    @Test
    @DisplayName("Pillar 5: Zero Unremapped Class.forName in Entrypoint")
    void testEntrypointIntegrity() throws IOException {
        Path entrypointPath = Paths.get("src/main/java/net/instantgratification/stewstacker/StewStackerFabric.java");
        assertTrue(Files.exists(entrypointPath), "StewStackerFabric.java must exist");
        String entrypointContent = Files.readString(entrypointPath, StandardCharsets.UTF_8);
        assertFalse(entrypointContent.contains(FORBIDDEN_CLASS_FOR_NAME),
                "StewStackerFabric.java must not invoke Class.forName");
    }
}
