# 📜 Developer History & Ticket Ledger: Stew Stacker Addon

This ledger tracks technical development milestones, architectural refactors, and ticket executions adhering to the **Multi-Era Anchor Parity Law** and **Modular Backlog Standard**.

---

## 🏁 [BL-SSA-001] Multi-Era Anchor Porting Sprint (2026-10-23)
- **Ticket IDs**: [`BL-SSA-001`](../../../tickets/BL-SSA-001.md) (MC 26.1.2), [`BL-SSA-005`](../../../tickets/BL-SSA-005.md) (MC 1.21.11), [`BL-SSA-006`](../../../tickets/BL-SSA-006.md) (MC 1.21.1), [`BL-SSA-007`](../../../tickets/BL-SSA-007.md) (MC 1.20.1)
- **Category**: `[FEATURE]`
- **Scope**: All Missing Anchors (`26.1.2`, `1.21.11`, `1.21.1`, `1.20.1`)
- **Status**: `✅ RESOLVED`
- **Architectural Deliverables**:
  - `Stew Stacker Addon v26.1.2/`: Established sovereign transitional anchor on Java 25, Fabric Loom 1.15-SNAPSHOT, Fabric Loader 0.19.1, Fabric API 0.145.4+26.1.2, DasikLibrary 1.8.24, and Stack Size Adjuster 1.4.19+26.1.2. Wired modern `CustomPayload` networking via `stew-stacker-addon:sync_limit`.
  - `Stew Stacker Addon v1.21.11/`: Established modern LTS anchor on Java 21, Fabric Loom 1.15-SNAPSHOT, Fabric Loader 0.19.3, Fabric API 0.141.6+1.21.11, DasikLibrary 1.4.0+1.21.11, and Stack Size Adjuster 1.0.1+1.21.11. Implemented `StewLimitSyncPayload` packet serialization with `PayloadTypeRegistry`.
  - `Stew Stacker Addon v1.21.1/`: Established prime LTS anchor on Java 21, Fabric Loom 1.10.2, Fabric Loader 0.19.1, Fabric API 0.102.0+1.21.1, DasikLibrary 1.4.0+1.21.1, and Stack Size Adjuster 1.0.1+1.21.1. DataComponents stack limits with bidirectional GameRule synchronization.
  - `Stew Stacker Addon v1.20.1/`: Established legacy LTS anchor on Java 17, Fabric Loom 1.10.2, Fabric Loader 0.19.1, Fabric API 0.92.2+1.20.1, DasikLibrary 1.4.0+1.20.1, and Stack Size Adjuster 1.0.1+1.20.1. Implemented legacy PacketByteBufs networking channel `stew-stacker-addon:sync_limit`.
  - **1.20.1 Legacy Bowl Recovery Interception**: Authored and registered `BowlFoodItemMixin` and `SuspiciousStewItemMixin` hooking `finishUsing` to safely decrement item stacks and return empty bowls to inventory or ground without clearing the active stew stack.
  - Stamped 100% single-line license headers (`// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3`) and `@Environment(EnvType.CLIENT)` sidedness across all anchors.
  - Verified 100% full parity (**6/6 Anchors**) across all studio version anchors.

---

## 🏁 [BL-SSA-003] Adopt 5-Pillar Testing & Sidedness Verification Harness (2026-10-28)
- **Ticket ID**: [`BL-SSA-003`](../../../tickets/BL-SSA-003.md)
- **Category**: `[TECH_DEBT]`
- **Scope**: All Anchors (`1.20.1`, `1.21.1`, `1.21.11`, `26.1.2`, `26.2`, `26.3`)
- **Status**: `✅ RESOLVED`
- **Architectural Deliverables**:
  - **Pillar 1 — Chaos Property Fuzzing (`StewStackerAddonStressFuzzTest`)**:
    - Executes 10,000 to 50,000 pseudo-random iterations verifying saturation bounds, arithmetic overflow prevention, and `NaN`/`Infinity` guards across all anchors.
  - **Pillar 2 — Virtual Concurrency Load (`StewStackerAddonConcurrencyLoadTest`)**:
    - Stresses stew stack limits, atomic GameRule cache reads, and concurrent mutations across 50 virtual threads with zero race conditions or memory corruption.
  - **Pillar 3 — Brigadier AST & Permissions (`StewStackerAddonCommandTest`)**:
    - Headlessly verifies Brigadier command syntax, literal/argument tree structures, and level-2 operator permission requirements for config synchronization commands.
  - **Pillar 4 — Headless State Simulation GameTest (`StewStackerAddonGameTest`)**:
    - Verifies item stacking mechanics, item use simulation, and bowl recovery behaviors in headless test environments across all versions.
  - **Pillar 5 — Sidedness & License Hygiene Contract (`StewStackerAddonSidednessContractTest`)**:
    - Automated source scanner asserting 0 `net.minecraft.client.*` imports inside common codebase, proper `@Environment(EnvType.CLIENT)` guarding, and 100% compliant single-line GPLv3 license headers (`// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3`).
  - **Full Multi-Era Anchor Parity (6/6 Anchors)**:
    - 100% green test execution with zero warnings/failures across MC 1.20.1, 1.21.1, 1.21.11, 26.1.2, 26.2, and 26.3.

---

## 🏁 [BL-SSA-004] Migrate Client Configuration GUI to UniversalConfigScreen (2026-10-29)
- **Ticket ID**: [`BL-SSA-004`](../../../tickets/BL-SSA-004.md)
- **Category**: `[TECH_DEBT]`
- **Scope**: All Anchors (`1.20.1`, `1.21.1`, `1.21.11`, `26.1.2`, `26.2`, `26.3`)
- **Status**: `✅ RESOLVED`
- **Architectural Deliverables**:
  - **Universal Zero-Boilerplate Client GUI Migration**:
    - Replaced custom `YaclScreenHelper.java` implementations with centralized `UniversalConfigScreen.createFactory(StewStackerConfig.class)` across all 6 version anchors.
    - Purged 80–150 lines of duplicate category, group, slider, and option-builder boilerplate per anchor.
  - **Server-Safe `@ConfigOption` Annotations**:
    - Annotated configuration fields (`stewLimit`) in `StewStackerConfig` using `net.dasik.social.api.config.ConfigOption`.
    - Maintained 100% side-safety with zero client-side imports in common classes, safeguarding dedicated server environments from classloader crashes.
  - **Embedded Creator Support & Live GameRule Sync**:
    - Automated injection of creator support action buttons (`[Support on Ko-fi]` and `[Join Discord]`) into ModMenu config categories.
    - Preserved real-time bidirectional GameRule synchronization pushing client adjustments to active server GameRules.
  - **Multi-Era Lockstep Release (1.0.3)**:
    - Bumped `mod_version` to `1.0.3+<mc>` across all 6 anchors (`1.20.1`, `1.21.1`, `1.21.11`, `26.1.2`, `26.2`, `26.3`).
    - Commits: `92314bb` (modern lead anchors `26.1.2`, `26.2`, `26.3`) and `498e2ef` (multi-era anchors `1.20.1`, `1.21.1`, `1.21.11`).
    - 100% clean test suites and headless verification pass across all anchors.
