# 🏛️ 아키텍처 및 애드온 확장 훅 (Minecraft 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 면책 조항**: 본 위키의 문서는 CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 최신 미출시 커밋이나 개발 기능을 포함할 수 있는 **저장소의 현재 소스 코드 상태**를 반영합니다.

## 1. Official Infobox
| Parameter | Technical Details |
| :--- | :--- |
| **Subsystem Name** | Architecture & Addon Extension Hooks |
| **Root Package** | `net.instantgratification.stewstacker` |
| **Core Entrypoint** | `StewStackerFabric.java` (`ModInitializer`) |
| **Client Entrypoint** | `StewStackerFabricClient.java` (`ClientModInitializer`) |
| **ModMenu Entrypoint** | `ModMenuIntegration.java` (`ModMenuApi`) |
| **Core Manager** | `StewStackerManager.java` |
| **Network Payload** | `StewLimitSyncPayload.java` |
| **Configuration** | `StewStackerConfig.java`, `YaclScreenHelper.java` |
| **Mixin Count** | **0 Mixins** (100% Pure Addon Delegation) |
| **Upstream Framework** | Stack Size Adjuster (`StackSizeManager`) |

---

## 2. Step-by-Step Subsystem Lifecycle

1. **`onInitialize()` Lifecycle Execution**:
   * **Step A**: Load configuration baseline via `StewStackerConfig.load(...)`.
   * **Step B**: Register functional override callback into `StackSizeManager.registerOverride(...)`.
   * **Step C**: Register `STEW_LIMIT` GameRule under namespaced category.
   * **Step D**: Register S2C payload type and codec via `PayloadTypeRegistry.clientboundPlay()`.
   * **Step E**: Attach `ServerPlayConnectionEvents.JOIN` listener for client sync.
   * **Step F**: Attach `ServerLifecycleEvents.SERVER_STARTED` listener for world initialization checks.

2. **Client Initialization (`onInitializeClient`)**:
   * Register global receiver for `StewLimitSyncPayload.TYPE` on `ClientPlayNetworking`.

3. **Stack Query Resolution**:
   * When Minecraft queries item stack limit, Stack Size Adjuster iterates registered overrides.
   * Stew Stacker Addon inspects item class; returns `stewLimit` if stew or soup, or `-1` to continue chain.

---

## 3. Algorithmic Complexity & Zero-Allocation Path
* **Time Complexity**: $O(1)$ constant time lookup.
* **Space Complexity**: $O(1)$ zero heap allocation on the hot path.

---

## 4. Visual ASCII Architecture Diagram

```
+-------------------------------------------------------------------------+
|                            Minecraft Engine                             |
+------------------------------------+------------------------------------+
                                     |
                                     v
+-------------------------------------------------------------------------+
|                       Stack Size Adjuster (Core)                        |
|                     StackSizeManager.getStackSize()                     |
+------------------------------------+------------------------------------+
                                     |
                                     v
+-------------------------------------------------------------------------+
|                          Stew Stacker Addon                             |
|                        StewStackerManager.java                          |
+------------------------------------+------------------------------------+
                                     |
                                     v
+-------------------------------------------------------------------------+
|                           DasikLibrary (API)                            |
|       DynamicGameRuleManager  |  ConfigHelper  |  GuiHelper             |
+-------------------------------------------------------------------------+
```

---

## 5. Addon Hook Registration Schema

```java
@FunctionalInterface
public interface CustomStackSizeOverride {
    int getModifiedStackSize(Item item, int originalSize);
}
```

---

## 6. 전역 및 외부 내비게이션
* [[🍲 Minecraft 26.2 포털로 돌아가기|ko_kr-26.2-Home]]
* [[🍲 26.2 스튜 스태킹 및 섭취 인체공학 읽기|ko_kr-26.2-Stew-Stacking-and-Consumption-Ergonomics]]
* [[📡 26.2 네트워크 동기화 및 페이로드 읽기|ko_kr-26.2-Network-Synchronization-and-Payloads]]
* [[⚙️ 26.2 구성 및 동적 게임 규칙 읽기|ko_kr-26.2-Configuration-and-GameRules]]
