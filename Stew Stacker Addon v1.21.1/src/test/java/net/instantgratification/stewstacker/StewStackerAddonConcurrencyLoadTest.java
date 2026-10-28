// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker;

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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * StewStackerAddonConcurrencyLoadTest: Pillar 2 Virtual Concurrency Load Harness.
 *
 * Verifies thread safety, absence of deadlocks, memory consistency, and high-contention
 * read/write stability across 50 concurrent worker threads and 50,000 operations.
 */
public class StewStackerAddonConcurrencyLoadTest {

    private static final int THREAD_COUNT = 50;
    private static final int WRITER_COUNT = 25;
    private static final int OPERATIONS_PER_THREAD = 1000;
    private static final int TIMEOUT_SECONDS = 15;

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
    @DisplayName("Pillar 2 Concurrency: 50 concurrent worker threads (25 writers, 25 readers, 50,000 ops) zero-deadlock load")
    void testHighContentionReadWriteConcurrencyLoad() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch readyLatch = new CountDownLatch(THREAD_COUNT);
        CountDownLatch startLatch = new CountDownLatch(1);
        List<Future<Void>> futures = new ArrayList<>(THREAD_COUNT);

        try {
            for (int t = 0; t < THREAD_COUNT; t++) {
                final boolean isWriter = (t < WRITER_COUNT);
                final int threadId = t;

                Callable<Void> task = () -> {
                    readyLatch.countDown();
                    assertTrue(startLatch.await(5, TimeUnit.SECONDS), "Thread timed out waiting for startLatch");

                    if (isWriter) {
                        for (int i = 0; i < OPERATIONS_PER_THREAD; i++) {
                            int newLimit = 1 + ((i + threadId) % 64);
                            StewStackerManager.setClientLimit(newLimit);
                        }
                    } else {
                        for (int i = 0; i < OPERATIONS_PER_THREAD; i++) {
                            int limit = StewStackerManager.getStewLimit();
                            assertTrue(limit > 0, "Stew limit must be positive under concurrent load: " + limit);

                            int mod = StewStackerManager.getModifiedStackSize(Items.MUSHROOM_STEW, 1);
                            assertTrue(mod > 0, "Modified stack size must be positive under concurrent load: " + mod);

                            int nonStewMod = StewStackerManager.getModifiedStackSize(Items.DIAMOND, 1);
                            assertEquals(-1, nonStewMod, "Non-stew item must always return -1 pass-through");
                        }
                    }
                    return null;
                };

                futures.add(executor.submit(task));
            }

            // Await all threads reaching the gate
            assertTrue(readyLatch.await(5, TimeUnit.SECONDS), "Not all threads became ready in time");
            // Unleash all 50 threads simultaneously
            startLatch.countDown();

            // Await completion with strict timeout
            for (Future<Void> future : futures) {
                future.get(TIMEOUT_SECONDS, TimeUnit.SECONDS);
            }
        } finally {
            executor.shutdown();
            assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS), "Executor did not terminate within timeout");
            StewStackerManager.setClientLimit(16);
        }
    }

    @Test
    @DisplayName("Pillar 2 Concurrency: Concurrent multi-stew variant reads during high-frequency limit mutations")
    void testConcurrentMultiStewVariantReads() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch readyLatch = new CountDownLatch(THREAD_COUNT);
        CountDownLatch startLatch = new CountDownLatch(1);
        List<Future<Void>> futures = new ArrayList<>(THREAD_COUNT);

        Item[] stewVariants = new Item[]{
                Items.MUSHROOM_STEW,
                Items.RABBIT_STEW,
                Items.BEETROOT_SOUP,
                Items.SUSPICIOUS_STEW
        };

        try {
            for (int t = 0; t < THREAD_COUNT; t++) {
                final boolean isWriter = (t < WRITER_COUNT);
                final int threadId = t;

                Callable<Void> task = () -> {
                    readyLatch.countDown();
                    assertTrue(startLatch.await(5, TimeUnit.SECONDS), "Thread timed out waiting for startLatch");

                    if (isWriter) {
                        for (int i = 0; i < OPERATIONS_PER_THREAD; i++) {
                            int newLimit = 1 + ((i * 7 + threadId) % 100);
                            StewStackerManager.setClientLimit(newLimit);
                        }
                    } else {
                        for (int i = 0; i < OPERATIONS_PER_THREAD; i++) {
                            Item targetStew = stewVariants[(i + threadId) % stewVariants.length];
                            assertTrue(StewStackerManager.isStewOrSoup(targetStew), "Item must be recognized as stew: " + targetStew);

                            int mod = StewStackerManager.getModifiedStackSize(targetStew, 1);
                            assertTrue(mod > 0, "Modified stack size must be positive: " + mod);

                            int passThrough = StewStackerManager.getModifiedStackSize(targetStew, 0);
                            assertEquals(0, passThrough, "Original <= 0 must pass through unchanged");
                        }
                    }
                    return null;
                };

                futures.add(executor.submit(task));
            }

            assertTrue(readyLatch.await(5, TimeUnit.SECONDS), "Not all threads became ready in time");
            startLatch.countDown();

            for (Future<Void> future : futures) {
                future.get(TIMEOUT_SECONDS, TimeUnit.SECONDS);
            }
        } finally {
            executor.shutdown();
            assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS), "Executor did not terminate within timeout");
            StewStackerManager.setClientLimit(16);
        }
    }
}
