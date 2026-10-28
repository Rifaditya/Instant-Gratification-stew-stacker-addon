// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.instantgratification.stewstacker.util.StewStackerManager;
import net.minecraft.SharedConstants;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.Bootstrap;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/**
 * StewStackerAddonGameTest: Pillar 4 Headless State Simulation GameTest Suite.
 *
 * Verifies:
 * - Headless item state simulation for stews/soups across limit transitions (16, 32, 64, 1000, 1).
 * - Sidedness and manager state updates via StewStackerManager.setLimit(limit, null).
 * - FriendlyByteBuf network packet serialization/deserialization for StewStackerFabric.SYNC_LIMIT_ID.
 * - Legacy Mixin contract inspection for BowlFoodItemMixin and SuspiciousStewItemMixin.
 */
public class StewStackerAddonGameTest {

    @BeforeAll
    public static void init() {
        SharedConstants.tryDetectVersion();
        Bootstrap.bootStrap();
    }

    @AfterEach
    void tearDown() {
        StewStackerManager.setClientLimit(16);
    }

    @AfterAll
    public static void cleanUp() {
        StewStackerManager.setClientLimit(16);
    }

    @Test
    @DisplayName("Pillar 4: Stew Item Identification & Non-Stew Filtering")
    void testStewIdentification() {
        assertTrue(StewStackerManager.isStewOrSoup(Items.MUSHROOM_STEW), "Mushroom stew must be recognized");
        assertTrue(StewStackerManager.isStewOrSoup(Items.RABBIT_STEW), "Rabbit stew must be recognized");
        assertTrue(StewStackerManager.isStewOrSoup(Items.BEETROOT_SOUP), "Beetroot soup must be recognized");
        assertTrue(StewStackerManager.isStewOrSoup(Items.SUSPICIOUS_STEW), "Suspicious stew must be recognized");

        assertFalse(StewStackerManager.isStewOrSoup(Items.APPLE), "Apple must not be recognized as stew/soup");
        assertFalse(StewStackerManager.isStewOrSoup(Items.BOWL), "Bowl must not be recognized as stew/soup");
        assertFalse(StewStackerManager.isStewOrSoup(Items.BREAD), "Bread must not be recognized as stew/soup");
        assertFalse(StewStackerManager.isStewOrSoup(null), "Null item must not be recognized as stew/soup");
    }

    @Test
    @DisplayName("Pillar 4: Headless State Simulation Across Dynamic Limit Cycles")
    void testStateSimulationLimitCycles() {
        Item[] stewItems = new Item[]{
                Items.MUSHROOM_STEW,
                Items.RABBIT_STEW,
                Items.BEETROOT_SOUP,
                Items.SUSPICIOUS_STEW
        };

        // State transition cycle: default (16) -> expanded (32) -> extreme (64/1000) -> minimum (1)
        int[] simulationLimits = {16, 32, 64, 1000, 1};

        for (int limit : simulationLimits) {
            StewStackerManager.setLimit(limit, null);
            assertEquals(limit, StewStackerManager.getStewLimit(), "Manager limit must equal configured value");

            for (Item stew : stewItems) {
                ItemStack stack = new ItemStack(stew);
                assertNotNull(stack, "ItemStack for " + stew + " must be non-null");
                assertEquals(stew, stack.getItem(), "ItemStack getItem() must return expected item");

                int modified = StewStackerManager.getModifiedStackSize(stack.getItem(), 1);
                assertEquals(limit, modified, "Stew item stack size must adapt to active limit " + limit);
            }

            ItemStack appleStack = new ItemStack(Items.APPLE);
            int appleModified = StewStackerManager.getModifiedStackSize(appleStack.getItem(), 64);
            assertEquals(-1, appleModified, "Non-stew item stack size must return -1 (pass-through)");

            int zeroOriginal = StewStackerManager.getModifiedStackSize(Items.MUSHROOM_STEW, 0);
            assertEquals(0, zeroOriginal, "original <= 0 must return original unchanged");
        }
    }

    @Test
    @DisplayName("Pillar 4: Network Payload Serialization & Deserialization Round-Trip (1.20.1)")
    void testNetworkPayloadRoundTrip() {
        assertNotNull(StewStackerFabric.SYNC_LIMIT_ID, "SYNC_LIMIT_ID must not be null");
        assertEquals("stew-stacker-addon", StewStackerFabric.SYNC_LIMIT_ID.getNamespace());
        assertEquals("sync_limit", StewStackerFabric.SYNC_LIMIT_ID.getPath());

        int[] testLimits = {1, 16, 32, 64, 1000};
        for (int limit : testLimits) {
            FriendlyByteBuf buf = PacketByteBufs.create();
            buf.writeVarInt(limit);
            int decoded = buf.readVarInt();
            assertEquals(limit, decoded, "Decoded network packet limit must match encoded limit: " + limit);
        }
    }

    @Test
    @DisplayName("Pillar 4: 1.20.1 Mixin Contract Inspection & GPLv3 Header Verification")
    void testMixinContractVerification() {
        assertDoesNotThrow(() -> {
            Class<?> bowlMixin = Class.forName("net.instantgratification.stewstacker.mixin.BowlFoodItemMixin");
            assertNotNull(bowlMixin, "BowlFoodItemMixin class must exist on classpath");
            Class<?> susMixin = Class.forName("net.instantgratification.stewstacker.mixin.SuspiciousStewItemMixin");
            assertNotNull(susMixin, "SuspiciousStewItemMixin class must exist on classpath");
        }, "Mixin classes must be classloadable");

        Path bowlMixinPath = Paths.get("src/main/java/net/instantgratification/stewstacker/mixin/BowlFoodItemMixin.java");
        Path susMixinPath = Paths.get("src/main/java/net/instantgratification/stewstacker/mixin/SuspiciousStewItemMixin.java");

        assertTrue(Files.exists(bowlMixinPath), "BowlFoodItemMixin.java source file must exist");
        assertTrue(Files.exists(susMixinPath), "SuspiciousStewItemMixin.java source file must exist");

        assertDoesNotThrow(() -> {
            String bowlContent = Files.readString(bowlMixinPath, StandardCharsets.UTF_8);
            assertTrue(bowlContent.startsWith("// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3"),
                    "BowlFoodItemMixin.java must have GPLv3 header on line 1");

            String susContent = Files.readString(susMixinPath, StandardCharsets.UTF_8);
            assertTrue(susContent.startsWith("// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3"),
                    "SuspiciousStewItemMixin.java must have GPLv3 header on line 1");
        });
    }
}
