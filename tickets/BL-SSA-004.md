# 🎫 [BL-SSA-004] Migrate Client Configuration GUI to UniversalConfigScreen

- **Ticket ID**: `[BL-SSA-004]`
- **Category**: `[TECH_DEBT]`
- **Priority**: `[MEDIUM]`
- **Target Version**: `All Anchors`
- **Scope**: `Client GUI & Config Architecture`
- **Status**: `✅ RESOLVED`
- **Date Resolved**: `2026-10-29`
- **Master Workspace Reference**: [`BL-WS-023`](file:///e:/Minecraft%20Project/tickets/BL-WS-023.md)
- **Governance Mandate**: Item 1.5 of the [Studio Constitution](file:///e:/Minecraft%20Project/.agents/rules/Studio%20Constitution.md) (*Universal Zero-Boilerplate Client GUI Standard / UniversalConfigScreen Invariant*)

---

## 🎯 1. Problem Statement & Player Impact
Currently, **Stew Stacker Addon** maintains custom `YaclScreenHelper.java` classes containing 80–150 lines of redundant category, group, slider, and option-builder boilerplate across its version anchors. This creates unnecessary code churn, risks dedicated server classloader crashes if deferred reflection is improperly configured, and lacks automated creator support touchpoints (Ko-fi and Discord buttons).

Following the release of `Dasik Library` v1.11.0 (Modern Lead) and v1.3.0 (Multi-Era Anchors), Stew Stacker Addon must migrate to the centralized, zero-boilerplate `net.dasik.social.api.client.gui.UniversalConfigScreen` and `@ConfigOption` framework.

## 🔬 2. Architectural Blueprint & Target Refactoring
1. **Annotate Config Fields in Common Code**: Annotate all configuration fields in `StewStackerConfig` with `@ConfigOption` (specifying `category`, `group`, `nameKey`, `descriptionKey`, `min`, `max`, `slider`). `@ConfigOption` contains **zero client imports** and is strictly side-safe for dedicated servers.
2. **1-Line ModMenu Integration**: Update `ModMenuIntegration` client entrypoint across all active version anchors to:
   ```java
   @Override
   public ConfigScreenFactory<?> getModConfigScreenFactory() {
       return UniversalConfigScreen.createFactory(StewStackerConfig.class);
   }
   ```
3. **Boilerplate Purge**: Permanently delete custom `YaclScreenHelper.java` classes, eliminating 80–150 lines of duplicate code.
4. **Automated Creator Support**: Centralized Ko-fi (`[Support on Ko-fi]`) and Discord (`[Join Discord]`) action buttons are injected into every configuration category automatically.
5. **Live GameRule Synchronization**: Real-time bidirectional synchronization automatically pushes client GUI adjustments to running singleplayer server GameRules.

## ⚓ 3. Multi-Era Anchor Parity Specifications
- Execute migration across all active version anchors in lockstep.
- Backward compatibility: Preserves all existing translation keys, default values, and GameRule names.

## 🛡️ 4. Edge Cases & Sidedness Safety
- Strict sidedness: Zero `net.minecraft.client.*` imports in common code; Knot ClassLoader runtime safety.
- Graceful degradation: If YACL is absent, returns `parent -> null` via ModMenu's contract without exceptions.
- Dedicated server resilience: Dedicated server launches safely without attempting to load client GUI classes.

## 🚀 5. Implementation Steps
1. Pre-bump `mod_version` in `gradle.properties` in targeted anchor(s).
2. Annotate config fields in `StewStackerConfig` with `@ConfigOption`.
3. Update `ModMenuIntegration` to return `UniversalConfigScreen.createFactory(StewStackerConfig.class)`.
4. Delete obsolete `YaclScreenHelper.java`.
5. Verify via headless unit tests and Knot ClassLoader verification (`./gradlew test`).
6. Deploy release JARs via the 5-Link Release Chain.

## 🏁 6. Verification Checklist
- [x] `@ConfigOption` annotations applied to `StewStackerConfig` with 0 client imports.
- [x] `ModMenuIntegration` wired to `UniversalConfigScreen.createFactory(...)`.
- [x] Obsolete `YaclScreenHelper.java` deleted.
- [x] Headless tests pass (`./gradlew test`).
- [x] Dedicated server boot verifies zero classloader crashes.

---

## 🏆 Resolution Summary
Successfully migrated all 6 version anchors (`1.20.1`, `1.21.1`, `1.21.11`, `26.1.2`, `26.2`, `26.3`) of **Stew Stacker Addon** to `UniversalConfigScreen` and `@ConfigOption` from `Dasik Library`:
- **Modern Lead Anchors** (`26.1.2`, `26.2`, `26.3`): Resolved via commit `92314bb`.
- **Multi-Era Anchors** (`1.20.1`, `1.21.1`, `1.21.11`): Resolved via commit `498e2ef`.
- Purged 80–150 lines of duplicate `YaclScreenHelper` boilerplate per anchor.
- Embedded automated Ko-fi and Discord creator support action buttons into config categories.
- Guaranteed 100% side-safety for dedicated server classloading, verified via headless Pillar 5 tests and gradle test suites across all 6 anchors.
