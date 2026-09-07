# 📡 网络同步与数据负载 (Minecraft 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **代码仓库来源免责声明**：本维基文档反映了**代码仓库中的当前源码状态**，可能包含领先于 CurseForge 和 Modrinth 平台公开发布版本的最新未发布提交或开发中功能。

## 1. Official Infobox
| Parameter | Technical Details |
| :--- | :--- |
| **Subsystem Name** | Network Synchronization Protocol |
| **Payload Class** | `StewLimitSyncPayload.java` |
| **Payload Identifier** | `stew-stacker:sync_limit` |
| **Protocol Phase** | `Play` (clientbound S2C) |
| **Codec Implementation** | `StreamCodec<RegistryFriendlyByteBuf, StewLimitSyncPayload>` |
| **Client Receiver** | `StewStackerFabricClient.java` |
| **Server Dispatch Events** | `ServerPlayConnectionEvents.JOIN`, `DynamicGameRuleManager` listener |
| **Menu Synchronization** | `broadcastFullState()` on `containerMenu` and `inventoryMenu` |

---

## 2. Step-by-Step Player Workflow & Synchronization Lifecycle

1. **Initial Player Connection (Handshake)**:
   When a player connects to the dedicated server, `ServerPlayConnectionEvents.JOIN` triggers. The server queries current active limits from `StewStackerManager` and sends a `StewLimitSyncPayload` to the connecting client.

2. **Client-Side State Storage**:
   Upon packet receipt on the client, `StewStackerFabricClient` queues a task on the Minecraft client render thread (`context.client().execute(...)`) to update `StewStackerManager.setClientLimit(stewLimit)`.

3. **In-Game Administrator Mutation**:
   An administrator executes `/gamerule stew-stacker-addon:stew_limit 32`. `DynamicGameRuleManager` detects the change and invokes `StewStackerManager.setLimit(...)`.

4. **Full Multi-Client Broadcast & Menu Refresh**:
   The server loops through all online players (`server.getPlayerList().getPlayers()`), dispatches `StewLimitSyncPayload`, and invokes `broadcastFullState()` on container and inventory menus.

---

## 3. Mathematical Formulas & Network Bandwidth

$$B = \text{VarIntBytes}(S_{\text{limit}})$$

For default settings ($S = 16$):
$$B = 1\text{ byte}$$

Even at the maximum safe limit ($39{,}768{,}215$):
$$B = 4\text{ bytes}$$

---

## 4. Visual ASCII Diagrams & Packet Lifecycle

```
   [ Client ]                                               [ Dedicated Server ]
       |                                                             |
       |----------------- C2S Login / Handshake -------------------->|
       |                                                             |
       |                                              ServerPlayConnectionEvents.JOIN
       |                                                             |
       |                                              Query StewStackerManager
       |                                                sLimit=16
       |                                                             |
       |<--- S2C StewLimitSyncPayload(16) ---------------------------|
       |
   Receive Packet
   context.client().execute()
   StewStackerManager.setClientLimit(16)
       |
   Client GUI & Tooltips Synchronized
```

---

## 5. 全局与外部导航
* [[🍲 返回 Minecraft 26.2 门户|zh_cn-26.2-Home]]
* [[🍲 阅读 26.2 炖菜堆叠与食用人体工学|zh_cn-26.2-Stew-Stacking-and-Consumption-Ergonomics]]
* [[⚙️ 阅读 26.2 配置与动态游戏规则|zh_cn-26.2-Configuration-and-GameRules]]
* [[🏛️ 阅读 26.2 架构设计与扩展钩子|zh_cn-26.2-Architecture-and-Addon-Hooks]]
