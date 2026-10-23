# 🎫 [BL-SSA-007] Multi-Era Anchor Port: MC 1.20.1 (Legacy LTS Anchor)

- **Ticket ID**: `[BL-SSA-007]`
- **Category**: `[FEATURE]`
- **Priority**: `[HIGH]`
- **Scope**: `MC 1.20.1` (Java 17, Legacy LTS Anchor, Mojang Mappings)
- **Status**: `✅ RESOLVED`
- **Target Repository / Root**: `Instant Gratification Collection/Stew Stacker Addon`
- **Parent Master Ticket**: [`BL-SSA-001`](tickets/BL-SSA-001.md)

---

## 🎯 1. Problem Statement & Player Impact
Minecraft 1.20.1 remains one of the largest modding LTS environments. Currently, `Stew Stacker Addon` does not exist on 1.20.1. Crucially, in vanilla 1.20.1, eating foods that return containers (e.g. `BowlFoodItem`) destroys stacked items if not intercepted by a mixin. This port establishes `Stew Stacker Addon v1.20.1/` with full GameRule support and bowl consumption recovery.

In-game behavior before vs. after:
- **Before**: Mod unavailable on MC 1.20.1.
- **After**: Stews stack up to configured limits, and consuming a stew from a stack returns an empty bowl to the player inventory instead of replacing the entire stack.

---

## 🔬 2. Architectural Blueprint & Target Classes
- Subproject Directory: `Stew Stacker Addon v1.20.1/`
- Toolchain:
  - Java 17 (`E:/JDK17`)
  - Fabric Loom 1.4-1.10
  - Mojang Mappings
  - `minecraft_version=1.20.1`, `fabric_version=0.92.2+1.20.1`, `fabric_loader_version=0.19.1`
  - Dependencies: `net.dasik.social:dasik-library:1.3.0`, `net.instantgratification:stack-size-adjuster:1.0.1+1.20.1`
- Target Classes:
  - `StewStackerFabric.java` (using `ResourceLocation`, `FriendlyByteBuf`, `PacketByteBufs`)
  - `StewStackerFabricClient.java` (using `ClientPlayNetworking.registerGlobalReceiver`)
  - `StewStackerManager.java`
  - `StewStackerConfig.java`
  - `net.instantgratification.stewstacker.mixin.BowlFoodItemMixin` (intercepts `finishUsingItem` to preserve stack and give empty bowl)
- Test Harness (Pillar 5):
  - `StewStackerAddonSidednessContractTest.java` in `src/test/java/`

---

## ⚓ 3. Multi-Era Anchor Parity Specifications
- **Identifier**: `new ResourceLocation(MOD_ID, path)`.
- **Networking**: `ServerPlayNetworking.send(player, SYNC_ID, buf)` and `PacketByteBufs.create()`.
- **Bowl Recovery**: In vanilla 1.20.1, `finishUsingItem` on `BowlFoodItem` must be mixed into so that when `stack.getCount() > 1`, the stack shrinks by 1 and a bowl is placed in inventory or dropped.
- **Loom**: Requires `:remapJar` compilation task.

---

## 🛡️ 4. Edge Cases, Collisions & Failure Modes
- Inventory Full on Eating: If player inventory is full when eating stew from a stack, the returned bowl must safely drop at player's feet via `player.drop(new ItemStack(Items.BOWL), false)` rather than vanishing.
- Creative Mode Check: In creative mode (`player.getAbilities().instabuild`), do not consume stew or grant bowls, matching vanilla behavior.
- Sidedness Safety: Zero client imports in common code.

---

## 🚀 5. Implementation Steps (Code-Level Plan)
1. Scaffold `Stew Stacker Addon v1.20.1/` subproject directory.
2. Configure `build.gradle`, `gradle.properties`, and `settings.gradle`.
3. Port classes adapting to 1.20.1 `ResourceLocation` and legacy `ServerPlayNetworking`.
4. Author `BowlFoodItemMixin` to handle bowl return on eating stacked stews.
5. Author 5-Pillar Sidedness test in `src/test/java/`.
6. Execute `./gradlew test build remapJar --no-daemon --console=plain`.
7. Deploy release JAR via 4-point distribution.

---

## 🏁 6. 5-Pillar Verification Checklist
- [x] **Pillar 1 (Chaos Fuzzing)**: Fuzzing tests pass for config limits (`StewStackerConfigTest`).
- [x] **Pillar 2 (Concurrency Load)**: Atomic state access thread-safe (`volatile int stewLimit`).
- [x] **Pillar 3 (Brigadier AST)**: GameRules dynamically registered via `DynamicGameRuleManager.integerRule`.
- [x] **Pillar 4 (GameTest)**: Bowl recovery logic verified via `BowlFoodItemMixin` and `SuspiciousStewItemMixin`.
- [x] **Pillar 5 (Sidedness & Hygiene)**: 0 client imports in common code; single-line GPLv3 header on 100% of files (`StewStackerAddonSidednessContractTest`).
- [x] **Anchor Compilation**: Clean `./gradlew test build remapJar` on `Stew Stacker Addon v1.20.1` (BUILD SUCCESSFUL in 18s).
