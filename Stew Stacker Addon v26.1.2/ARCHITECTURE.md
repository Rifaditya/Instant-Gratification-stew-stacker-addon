# Architecture & Symbol Index: Stew Stacker Addon (MC 26.1.2)

## 1. Mod Metadata & Entrypoint
- **Mod ID**: `stew-stacker-addon`
- **Main Entrypoint**: `net.instantgratification.stewstacker.StewStackerFabric` (`net.fabricmc.api.ModInitializer`)
- **Client Entrypoint**: `net.instantgratification.stewstacker.StewStackerFabricClient`

## 2. Core Mechanics & Subsystems
- **Source Root**: `src/main/java/`
- **Resource Root**: `src/main/resources/`
- **Stack Override**: Integrated with `net.instantgratification.stacksizeadjuster.util.StackSizeManager`
- **Network Sync**: `StewLimitSyncPayload` (`stew-stacker:sync_limit`) via Fabric Networking API

## 3. Dynamic GameRules & Commands
- **GameRules**: `stew-stacker-addon:stew_limit` (DynamicGameRuleManager)

## 4. Configuration & Sidedness Isolation
- **Sidedness**: Server-safe logic in main, client isolated with `@Environment(EnvType.CLIENT)`.
