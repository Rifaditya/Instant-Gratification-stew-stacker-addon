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
