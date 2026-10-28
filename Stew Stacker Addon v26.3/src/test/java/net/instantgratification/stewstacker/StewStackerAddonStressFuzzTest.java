// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker;

import net.instantgratification.stewstacker.config.StewStackerConfig;
import net.instantgratification.stewstacker.util.StewStackerManager;
import net.minecraft.SharedConstants;
import net.minecraft.server.Bootstrap;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * StewStackerAddonStressFuzzTest: Pillar 1 Chaos Property Fuzzing & Saturated Bounds.
 *
 * Verifies mathematical soundness, saturated arithmetic, non-negative bounds,
 * stew identification invariants, null-safety, and manager limit synchronization
 * across 20,000 randomized chaos iterations.
 */
public class StewStackerAddonStressFuzzTest {

    private static final int[] BOUNDARY_VALUES = new int[]{
            Integer.MIN_VALUE, -100, -1, 0, 1, 2, 16, 64, 99, 100, 1000, 1_000_000, Integer.MAX_VALUE
    };

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
    @DisplayName("Pillar 1 Chaos: Boundary Matrix verification on getModifiedStackSize across all items and limits")
    void testBoundaryMatrixStackSize() {
        Item[] stewItems = new Item[]{
                Items.MUSHROOM_STEW,
                Items.RABBIT_STEW,
                Items.BEETROOT_SOUP,
                Items.SUSPICIOUS_STEW
        };

        Item[] nonStewItems = new Item[]{
                Items.APPLE,
                Items.DIAMOND,
                Items.DIRT
        };

        for (int limit : BOUNDARY_VALUES) {
            StewStackerManager.setClientLimit(limit);
            assertEquals(limit, StewStackerManager.getStewLimit(), "Client limit must match configured value");

            // 1. Stew items
            for (Item stew : stewItems) {
                assertTrue(StewStackerManager.isStewOrSoup(stew), "Stew item must be recognized as stew/soup: " + stew);
                for (int amount : BOUNDARY_VALUES) {
                    int modified = StewStackerManager.getModifiedStackSize(stew, amount);
                    if (amount <= 0) {
                        assertEquals(amount, modified, "original <= 0 must return original unchanged for stew: " + stew);
                    } else {
                        assertEquals(limit, modified, "original > 0 must return active stew limit for stew: " + stew);
                    }
                }
            }

            // 2. Non-stew items
            for (Item nonStew : nonStewItems) {
                assertFalse(StewStackerManager.isStewOrSoup(nonStew), "Non-stew item must not be recognized as stew/soup: " + nonStew);
                for (int amount : BOUNDARY_VALUES) {
                    int modified = StewStackerManager.getModifiedStackSize(nonStew, amount);
                    if (amount <= 0) {
                        assertEquals(amount, modified, "original <= 0 must return original unchanged for non-stew: " + nonStew);
                    } else {
                        assertEquals(-1, modified, "Non-stew items with original > 0 must return -1 (pass-through)");
                    }
                }
            }

            // 3. Null item guard
            assertFalse(StewStackerManager.isStewOrSoup(null), "Null item must not be recognized as stew/soup");
            for (int amount : BOUNDARY_VALUES) {
                int modified = StewStackerManager.getModifiedStackSize(null, amount);
                if (amount <= 0) {
                    assertEquals(amount, modified, "original <= 0 must return original unchanged for null item");
                } else {
                    assertEquals(-1, modified, "Null item with original > 0 must return -1 without throwing NPE");
                }
            }
        }
    }

    @Test
    @DisplayName("Pillar 1 Chaos: 20,000 iterations of randomized fuzzing on limits, items, and stack sizes")
    void testChaosFuzzing20000Iterations() {
        Random rng = new Random(0xDA51C263L);

        Item[] itemPool = new Item[]{
                Items.MUSHROOM_STEW,
                Items.RABBIT_STEW,
                Items.BEETROOT_SOUP,
                Items.SUSPICIOUS_STEW,
                Items.APPLE,
                Items.DIAMOND,
                Items.DIRT,
                null
        };

        for (int i = 0; i < 20_000; i++) {
            // Select random limit
            int limit;
            int limitMode = rng.nextInt(3);
            if (limitMode == 0) {
                limit = BOUNDARY_VALUES[rng.nextInt(BOUNDARY_VALUES.length)];
            } else if (limitMode == 1) {
                limit = rng.nextInt(2001) - 1000;
            } else {
                limit = rng.nextInt();
            }

            StewStackerManager.setClientLimit(limit);
            assertEquals(limit, StewStackerManager.getStewLimit(), "Limit must match set value in iteration " + i);

            // Select random item from pool
            Item item = itemPool[rng.nextInt(itemPool.length)];

            // Select random amount
            int amount;
            int amountMode = rng.nextInt(3);
            if (amountMode == 0) {
                amount = BOUNDARY_VALUES[rng.nextInt(BOUNDARY_VALUES.length)];
            } else if (amountMode == 1) {
                amount = rng.nextInt(2001) - 1000;
            } else {
                amount = rng.nextInt();
            }

            int modified = StewStackerManager.getModifiedStackSize(item, amount);

            if (amount <= 0) {
                assertEquals(amount, modified, "original <= 0 must return original amount unchanged in iteration " + i);
            } else if (item != null && StewStackerManager.isStewOrSoup(item)) {
                assertEquals(limit, modified, "Stew item with original > 0 must return current limit in iteration " + i);
            } else {
                assertEquals(-1, modified, "Non-stew/null item with original > 0 must return -1 in iteration " + i);
            }
        }
    }

    @Test
    @DisplayName("Pillar 1 Chaos: Config bounds and extreme numeric resilience")
    void testConfigBoundsAndResilience() {
        StewStackerConfig config = new StewStackerConfig();
        assertEquals(16, config.stewLimit, "Default stew limit must be 16");
        assertEquals(1, config.configVersion, "Default config version must be 1");

        for (int limit : BOUNDARY_VALUES) {
            config.stewLimit = limit;
            assertEquals(limit, config.stewLimit, "Config stewLimit must store boundary value: " + limit);
        }

        // Reset to default
        config.stewLimit = 16;
        assertEquals(16, config.stewLimit);
    }
}
