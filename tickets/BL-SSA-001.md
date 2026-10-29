# 🎫 [BL-SSA-001] Multi-Era Anchor Port: MC 26.1.2 (Modern Sovereign Lead)

- **Ticket ID**: `[BL-SSA-001]`
- **Category**: `[FEATURE]`
- **Priority**: `[HIGH]`
- **Scope**: `MC 26.1.2` (Java 25, Modern Sovereign Lead)
- **Status**: `✅ RESOLVED`
- **Target Repository / Root**: `Instant Gratification Collection/Stew Stacker Addon`
- **Companion Tickets**: [`BL-SSA-005`](BL-SSA-005.md) (MC 1.21.11), [`BL-SSA-006`](BL-SSA-006.md) (MC 1.21.1), [`BL-SSA-007`](BL-SSA-007.md) (MC 1.20.1)

---

## 🎯 1. Problem Statement & Player Impact
Currently, `Stew Stacker Addon` exists on `MC 26.2` and `MC 26.3`, but lacks support for `MC 26.1.2` (the initial stable 26.x sovereign release). Players running Minecraft 26.1.2 cannot take advantage of dynamic stew/soup stack limits with Stack Size Adjuster. In accordance with the "1 Jar 1 Version Policy" and Multi-Era Anchor Parity Law, this lead modern anchor must be ported into a dedicated subproject (`Stew Stacker Addon v26.1.2/`).

In-game behavior before vs. after:
- **Before**: Mod cannot load or run on Minecraft 26.1.2.
- **After**: Players on MC 26.1.2 experience fully functional stackable mushroom stew, rabbit stew, beetroot soup, and suspicious stew with dynamic GameRules (`stew-stacker-addon:stew_limit`) and config synchronization.

---

## 🔬 2. Architectural Blueprint & Target Classes
- Subproject Directory: `Stew Stacker Addon v26.1.2/`
- Toolchain:
  - Java 25 (`E:/JDK25`)
  - Fabric Loom 1.15-SNAPSHOT
  - `minecraft_version=26.1.2`, `fabric_version=0.145.4+26.1.2`, `fabric_loader_version=0.19.1`
  - Dependencies: `net.dasik.social:dasik-library:1.8.24`, `net.instantgratification:stack-size-adjuster:1.4.19+26.1.2`
- Core Classes to Scaffold & Wire:
  - `net.instantgratification.stewstacker.StewStackerFabric` (ModInitializer)
  - `net.instantgratification.stewstacker.StewStackerFabricClient` (ClientModInitializer)
  - `net.instantgratification.stewstacker.network.StewLimitSyncPayload` (CustomPacketPayload)
  - `net.instantgratification.stewstacker.util.StewStackerManager`
  - `net.instantgratification.stewstacker.config.StewStackerConfig`
  - `net.instantgratification.stewstacker.config.ModMenuIntegration`
- Test Harness (Pillar 5):
  - `StewStackerAddonSidednessContractTest.java` in `src/test/java/`

---

## ⚓ 3. Multi-Era Anchor Parity Specifications
- **Identifier**: Modern Mojang syntax `Identifier.fromNamespaceAndPath(MOD_ID, path)`.
- **Networking**: `PayloadTypeRegistry.clientboundPlay().register(StewLimitSyncPayload.TYPE, StewLimitSyncPayload.CODEC)`.
- **DataComponents**: Uses DataComponents with `using_converts_to` natively supported by vanilla 26.1.2.
- **Stack Size Adjuster Hook**: `StackSizeManager.registerOverride((item, original) -> StewStackerManager.getModifiedStackSize(item, original))`.

---

## 🛡️ 4. Edge Cases, Collisions & Failure Modes
- Dedicated Server Sidedness: Zero client imports in common code; verified via headless test.
- Dynamic GameRule Registration: Verified category unfreezing via DasikLibrary `DynamicGameRuleManager`.
- Saturated Math: Uncapped `range(1, Integer.MAX_VALUE)` per Freedom Over Anti-Crash policy.
- Local Maven Resolution: Must verify `stack-size-adjuster:1.4.19+26.1.2` in `~/.m2/repository` before building.

---

## 🚀 5. Implementation Steps (Code-Level Plan)
1. Scaffold `Stew Stacker Addon v26.1.2/` subproject directory.
2. Configure `build.gradle`, `gradle.properties`, and `settings.gradle`.
3. Port core source classes and client networking payloads.
4. Scaffold Pillar 5 Sidedness Contract test in `src/test/java/`.
5. Execute `./gradlew test build --no-daemon --console=plain`.
6. Deploy release JAR via 4-point distribution and register in `RELEASE_QUEUE.md`.

---

## 🏁 6. 5-Pillar Verification Checklist
- [x] **Pillar 1 (Chaos Fuzzing)**: Saturated bounds verified for `stewLimit`.
- [x] **Pillar 2 (Concurrency Load)**: Thread-safe volatile state in `StewStackerManager`.
- [x] **Pillar 3 (Brigadier AST)**: GameRule discovery headlessly verified.
- [x] **Pillar 4 (GameTest)**: Server lifecycle event registration verified.
- [x] **Pillar 5 (Sidedness & Hygiene)**: 0 client imports in common classes; 100% GPLv3 headers.
- [x] **Anchor Compilation**: Clean `./gradlew test build` on `Stew Stacker Addon v26.1.2`.
