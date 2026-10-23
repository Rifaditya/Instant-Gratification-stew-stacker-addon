# 🎫 [BL-SSA-005] Multi-Era Anchor Port: MC 1.21.11 (Transitional Modern Anchor)

- **Ticket ID**: `[BL-SSA-005]`
- **Category**: `[FEATURE]`
- **Priority**: `[HIGH]`
- **Scope**: `MC 1.21.11` (Java 21, Transitional Modern Anchor, SDL3)
- **Status**: `📌 DEFERRED`
- **Target Repository / Root**: `Instant Gratification Collection/Stew Stacker Addon`
- **Parent Master Ticket**: [`BL-SSA-001`](tickets/BL-SSA-001.md)

---

## 🎯 1. Problem Statement & Player Impact
Players running Minecraft 1.21.11 cannot currently use `Stew Stacker Addon` because no dedicated anchor subproject exists for this transitional era. Under the Studio Constitution and Multi-Era Anchor Parity Law, this version must be ported into `Stew Stacker Addon v1.21.11/`.

In-game behavior before vs. after:
- **Before**: Mod unavailable on MC 1.21.11.
- **After**: 100% feature parity with modern versions, including dynamic stack size overrides, synchronized GameRules, and ModMenu configuration support.

---

## 🔬 2. Architectural Blueprint & Target Classes
- Subproject Directory: `Stew Stacker Addon v1.21.11/`
- Toolchain:
  - Java 21 (`E:/JDK21`)
  - Fabric Loom 1.15-SNAPSHOT (`fabric-loom-remap`)
  - Mojang Mappings
  - `minecraft_version=1.21.11`, `fabric_version=0.118.0+1.21.11`, `fabric_loader_version=0.19.1`
  - Dependencies: `net.dasik.social:dasik-library:1.3.0`, `net.instantgratification:stack-size-adjuster:1.0.1+1.21.11`
- Target Classes:
  - `StewStackerFabric.java`
  - `StewStackerFabricClient.java`
  - `StewLimitSyncPayload.java` (using `CustomPacketPayload` and `Identifier.of`)
  - `StewStackerManager.java`
  - `StewStackerConfig.java`

---

## ⚓ 3. Multi-Era Anchor Parity Specifications
- **Identifier**: `Identifier.of(MOD_ID, path)`.
- **Networking**: `PayloadTypeRegistry.clientboundPlay().register(StewLimitSyncPayload.TYPE, StewLimitSyncPayload.CODEC)`.
- **Loom**: Requires `:remapJar` task during compilation.

---

## 🛡️ 4. Edge Cases, Collisions & Failure Modes
- RemapJar Execution: Ensure build outputs remapped jar to `build/libs/`.
- Sidedness Safety: Zero client imports in common code.
- Local Maven Dependency: `stack-size-adjuster:1.0.1+1.21.11` must be published to `mavenLocal`.

---

## 🚀 5. Implementation Steps (Code-Level Plan)
1. Scaffold `Stew Stacker Addon v1.21.11/` subproject directory.
2. Configure `build.gradle`, `gradle.properties`, and `settings.gradle`.
3. Port classes adapting `Identifier` and networking payloads to 1.21.11 standards.
4. Author 5-Pillar Sidedness test in `src/test/java/`.
5. Execute `./gradlew test build remapJar --no-daemon --console=plain`.
6. Deploy release JAR via 4-point distribution.

---

## 🏁 6. 5-Pillar Verification Checklist
- [ ] **Pillar 1 (Chaos Fuzzing)**: Fuzzing tests pass for config limits.
- [ ] **Pillar 2 (Concurrency Load)**: Atomic state access thread-safe.
- [ ] **Pillar 3 (Brigadier AST)**: GameRules dynamically registered.
- [ ] **Pillar 4 (GameTest)**: Server events trigger without crash.
- [ ] **Pillar 5 (Sidedness & Hygiene)**: 0 client imports in common code; single-line GPLv3 header.
- [ ] **Anchor Compilation**: Clean `./gradlew test build remapJar` on `Stew Stacker Addon v1.21.11`.
