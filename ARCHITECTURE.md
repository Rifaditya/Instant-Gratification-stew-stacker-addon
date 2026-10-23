# Architecture & Symbol Index: Stew Stacker Addon

## 1. Project Identity & Storefront Metadata
- **Mod ID**: `stew-stacker-addon`
- **Modrinth ID**: `kwGC64eU` (`stew-stacker-addon`)
- **CurseForge ID**: `1634335` (`stew-stacker-addon`)
- **Required Core Dependency**: `stack-size-adjuster` (`net.instantgratification:stack-size-adjuster`)
- **Universal Library Dependency**: `dasik-library` (`net.dasik.social:dasik-library`)
- **Main Entrypoint**: `net.instantgratification.stewstacker.StewStackerFabric` (`net.fabricmc.api.ModInitializer`)
- **Client Entrypoint**: `net.instantgratification.stewstacker.StewStackerFabricClient` (`net.fabricmc.api.ClientModInitializer`)
- **ModMenu Integration**: `net.instantgratification.stewstacker.config.ModMenuIntegration` (`com.terraformersmc.modmenu.api.ModMenuApi`)

---

## 2. Multi-Era Version Anchor Matrix (6/6 Parity)

| Target Anchor | Subproject Directory | Java / Toolchain | Loader / Fabric API | Core Dependencies | Networking & Bytecode Strategy |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **MC 26.3** | `Stew Stacker Addon v26.3/` | Java 25 / Loom 1.15 | Loader 0.19.5 / FAPI 0.161.0+26.3 | DasikLib 1.9.2, SSA 1.4.19 | `CustomPayload` (`stew-stacker-addon:sync_limit`), DataComponents stack size |
| **MC 26.2** | `Stew Stacker Addon v26.2/` | Java 25 / Loom 1.15 | Loader 0.19.1 / FAPI 0.150.1+26.2 | DasikLib 1.8.3, SSA 1.4.19 | `CustomPayload` (`stew-stacker-addon:sync_limit`), DataComponents stack size |
| **MC 26.1.2** | `Stew Stacker Addon v26.1.2/` | Java 25 / Loom 1.15 | Loader 0.19.1 / FAPI 0.145.4+26.1.2 | DasikLib 1.8.24, SSA 1.4.19 | `CustomPayload` (`stew-stacker-addon:sync_limit`), DataComponents stack size |
| **MC 1.21.11** | `Stew Stacker Addon v1.21.11/` | Java 21 / Loom 1.15 | Loader 0.19.3 / FAPI 0.141.6+1.21.11 | DasikLib 1.4.0, SSA 1.0.1 | `CustomPayload` (`stew-stacker-addon:sync_limit`), DataComponents stack size |
| **MC 1.21.1** | `Stew Stacker Addon v1.21.1/` | Java 21 / Loom 1.10 | Loader 0.19.1 / FAPI 0.102.0+1.21.1 | DasikLib 1.4.0, SSA 1.0.1 | `CustomPayload` (`stew-stacker-addon:sync_limit`), DataComponents stack size |
| **MC 1.20.1** | `Stew Stacker Addon v1.20.1/` | Java 17 / Loom 1.10 | Loader 0.19.1 / FAPI 0.92.2+1.20.1 | DasikLib 1.4.0, SSA 1.0.1 | Legacy `PacketByteBufs` (`stew-stacker-addon:sync_limit`), Bytecode Mixin bowl recovery |

---

## 3. Bytecode Mixin Target Registry

| Target Vanilla Class | Mixin Class | Anchors | Purpose |
| :--- | :--- | :--- | :--- |
| `net.minecraft.world.item.BowlFoodItem` (`BowlFoodItem` / `StewItem`) | `net.instantgratification.stewstacker.mixin.BowlFoodItemMixin` | `1.20.1` | Hooks `finishUsing` on bowl consumption; safely decrements item stack and returns empty bowl without replacing entire stack. |
| `net.minecraft.world.item.SuspiciousStewItem` (`SuspiciousStewItem`) | `net.instantgratification.stewstacker.mixin.SuspiciousStewItemMixin` | `1.20.1` | Intercepts consumption of suspicious stew; ensures stack preservation and safe bowl return. |

> [!NOTE]
> On MC 1.21.1, 1.21.11, and 26.x, Minecraft's Data Component architecture natively decrements stack count on item consumption without clearing the remainder stack, rendering bytecode consumption mixins obsolete on modern anchors.

---

## 4. Core Mechanics & Subsystems

- **Core Manager (`StewStackerManager`)**:
  - Dynamically registers max stack size overrides for mushroom stew, rabbit stew, beetroot soup, and suspicious stew.
  - Interfaces directly with `Stack Size Adjuster` API hooks across all targeted versions.
- **Dynamic GameRules (`StewStackerFabric`)**:
  - Registers dynamic server-wide GameRule `stew-stacker-addon:stew_limit` (integer, default 16).
  - Automatically broadcasts updated limit to connecting and joined players.
- **Networking Architecture (`network.*`)**:
  - **Modern (1.21.1 – 26.3)**: `StewLimitSyncPayload` implementing `CustomPayload` with `PayloadTypeRegistry.playS2C()`.
  - **Legacy (1.20.1)**: Direct `PacketByteBuf` serialization via `ServerPlayNetworking.send` / `ClientPlayNetworking.registerGlobalReceiver`.
- **Client Configuration GUI (`config.*`)**:
  - Optional YetAnotherConfigLib (YACL v3) screen via `YaclScreenHelper`.
  - ModMenu configuration integration via `ModMenuIntegration` strictly guarded with `@Environment(EnvType.CLIENT)`.

---

## 5. Configuration & Sidedness Isolation

- **Configuration File**: Delta JSON config located at `config/stew-stacker-addon.json`.
- **Sidedness Contract**:
  - Server-safe logic in root and manager classes.
  - Client GUI and payload receivers isolated behind `@Environment(EnvType.CLIENT)` and dedicated client entrypoints.
  - Headless sidedness contract verification enforced via JUnit 5 (`StewStackerAddonSidednessContractTest`).
