# 🏛️ Arquitectura y Ganchos de Expansión (Minecraft 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Descargo de responsabilidad de la fuente del repositorio**: La documentación de esta Wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de las compilaciones públicas en CurseForge y Modrinth.

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

## 6. Enlaces Globales y Externos
* [[🍲 Volver al Portal de Minecraft 26.2|es_es-26.2-Home]]
* [[🍲 Leer 26.2 Apilado de Guisos y Ergonomía de Consumo|es_es-26.2-Stew-Stacking-and-Consumption-Ergonomics]]
* [[📡 Leer 26.2 Sincronización de Red y Cargas Útiles|es_es-26.2-Network-Synchronization-and-Payloads]]
* [[⚙️ Leer 26.2 Configuración y GameRules Dinámicas|es_es-26.2-Configuration-and-GameRules]]
