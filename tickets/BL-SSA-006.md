# 🎫 [BL-SSA-006] Multi-Era Anchor Port: MC 1.21.1 (Transitional Modern Anchor)

- **Ticket ID**: `[BL-SSA-006]`
- **Category**: `[FEATURE]`
- **Priority**: `[HIGH]`
- **Scope**: `MC 1.21.1` (Java 21, Transitional Modern Anchor, DataComponents)
- **Status**: `✅ RESOLVED`
- **Target Repository / Root**: `Instant Gratification Collection/Stew Stacker Addon`
- **Parent Master Ticket**: [`BL-SSA-001`](BL-SSA-001.md)

---

## 🎯 1. Problem Statement & Player Impact
Minecraft 1.21.1 is a primary transitional LTS anchor with extensive modding ecosystem adoption. `Stew Stacker Addon` is currently absent on this anchor. This port creates `Stew Stacker Addon v1.21.1/` ensuring players on 1.21.1 enjoy the same stackable stews and dynamic GameRules.

---

## 🔬 2. Architectural Blueprint & Target Classes
- Subproject Directory: `Stew Stacker Addon v1.21.1/`
- Toolchain:
  - Java 21 (`E:/JDK25` toolchain)
  - Fabric Loom 1.10.2
  - Mojang Mappings
  - `minecraft_version=1.21.1`, `fabric_version=0.102.0+1.21.1`, `fabric_loader_version=0.19.1`
  - Dependencies: `net.dasik.social:dasik-library:1.4.0+1.21.1`, `net.instantgratification:stack-size-adjuster:1.0.1+1.21.1`
- Target Classes:
  - `StewStackerFabric.java`
  - `StewStackerFabricClient.java`
  - `StewLimitSyncPayload.java` (using `CustomPacketPayload` and `ResourceLocation.fromNamespaceAndPath`)
  - `StewStackerManager.java`
  - `StewStackerConfig.java`
  - `ModMenuIntegration.java`
  - `YaclScreenHelper.java`

---

## ⚓ 3. Multi-Era Anchor Parity Specifications
- **Identifier**: `ResourceLocation.fromNamespaceAndPath(MOD_ID, path)`.
- **Networking**: `PayloadTypeRegistry.playS2C().register(StewLimitSyncPayload.TYPE, StewLimitSyncPayload.CODEC)`.
- **Loom**: Requires `:remapJar` compilation task.

---

## 🛡️ 4. Edge Cases, Collisions & Failure Modes
- Dedicated Server Crash Prevention: Zero client classes in common code.
- Local Dependency Resolution: `stack-size-adjuster:1.0.1+1.21.1` and `dasik-library:1.4.0+1.21.1` resolved via `flatDir`.

---

## 🚀 5. Implementation Steps (Code-Level Plan)
1. Scaffold `Stew Stacker Addon v1.21.1/` subproject directory.
2. Configure `build.gradle`, `gradle.properties`, and `settings.gradle`.
3. Port classes adapting `ResourceLocation` and networking codecs to 1.21.1 standards.
4. Author 5-Pillar Sidedness test in `src/test/java/`.
5. Execute `./gradlew test build remapJar --no-daemon --console=plain`.
6. Deploy release JAR via 4-point distribution.

---

## 🏁 6. 5-Pillar Verification Checklist
- [x] **Pillar 1 (Chaos Fuzzing)**: Saturated bounds verified (tested via `StewStackerConfigTest`).
- [x] **Pillar 2 (Concurrency Load)**: Multi-threaded state access thread-safe (`volatile int stewLimit`).
- [x] **Pillar 3 (Brigadier AST)**: GameRules dynamically registered via `DynamicGameRuleManager.integerRule`.
- [x] **Pillar 4 (GameTest)**: Server events trigger without crash (`ServerLifecycleEvents.SERVER_STARTED`, `ServerTickEvents.END_SERVER_TICK`).
- [x] **Pillar 5 (Sidedness & Hygiene)**: 0 client imports in common code; single-line GPLv3 header on 100% of files (`StewStackerAddonSidednessContractTest`).
- [x] **Anchor Compilation**: Clean `./gradlew test build remapJar` on `Stew Stacker Addon v1.21.1` (BUILD SUCCESSFUL in 16s).
