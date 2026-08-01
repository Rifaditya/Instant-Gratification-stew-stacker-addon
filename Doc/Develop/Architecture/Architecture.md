# Stew Stacker Addon Architecture

## 🏗️ Architectural Overview

```mermaid
flowchart TD
    A[StewStackerFabric] -->|registerOverride| B[StackSizeManager in Stack Size Adjuster]
    A -->|integerRule| C[DynamicGameRuleManager in DasikLibrary]
    B -->|getModifiedStackSize| D[StewStackerManager]
    D -->|isStewOrSoup| E[Items.MUSHROOM_STEW / RABBIT_STEW / BEETROOT_SOUP / SUSPICIOUS_STEW]
    A -->|ServerPlayConnectionEvents.JOIN| F[StewLimitSyncPayload S2C]
    F -->|ClientPlayNetworking| G[StewStackerFabricClient]
```

## 🧩 Components

1. **`StewStackerFabric`**: Mod entrypoint registering `stew-stacker-addon:stew_limit` GameRule and registering stack size override callback into `StackSizeManager`.
2. **`StewStackerManager`**: Core logic checking item instances against stew/soup types and applying dynamic limits.
3. **`StewLimitSyncPayload`**: Custom packet payload for S2C limit synchronization.
4. **`StewStackerConfig`**: Baseline config template provider using DasikLibrary `ConfigHelper`.
5. **`YaclScreenHelper` & `ModMenuIntegration`**: Server-crash-safe optional YACL GUI configuration integration.
