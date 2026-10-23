// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker;

import net.instantgratification.stewstacker.config.StewStackerConfig;
import net.instantgratification.stewstacker.util.StewStackerManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StewStackerConfigTest {

    @Test
    @DisplayName("Verify Stew Stacker Default Configuration & Bounds")
    void testDefaultConfig() {
        StewStackerConfig config = new StewStackerConfig();
        assertEquals(16, config.stewLimit, "Default stew limit must be 16");
        assertEquals(1, config.configVersion, "Config version must be 1");
    }

    @Test
    @DisplayName("Verify Stew Stacker Manager State Updates")
    void testManagerLogic() {
        StewStackerManager.setClientLimit(32);
        assertEquals(32, StewStackerManager.getStewLimit(), "Client stew limit should be updated to 32");

        // Restore default
        StewStackerManager.setClientLimit(16);
        assertEquals(16, StewStackerManager.getStewLimit(), "Client stew limit should be reset to 16");
    }
}
