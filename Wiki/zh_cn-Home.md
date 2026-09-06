# 🍲 即时满足：炖菜堆叠扩展 Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **代码仓库来源声明**：本 Wiki 中的技术文档反映了**代码仓库中当前的源代码状态**，可能包含领先于 CurseForge 与 Modrinth 正式发布版本的未发布提交或开发中特性。

欢迎查阅 **Instant Gratification: Stew Stacker Addon（即时满足：炖菜堆叠扩展）** 官方技术文档。本项目是为 Minecraft Fabric 平台设计的 **Stack Size Adjuster** 专用高性能扩展模组，彻底解决自原版以来炖菜和汤类占用背包槽位过多的痛点。支持对蘑菇煲、兔肉煲、甜菜汤以及迷之炖菜进行无缝动态堆叠配置。

---

## 🧭 多版本文档传送门

| Minecraft Target | Mod Version | Fabric Loader | Portal Link |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.0.2+26.2` | `>=0.19.1` | [[👉 Enter Minecraft 26.2 Documentation Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.0.2+26.3` | `>=0.19.3` | [[👉 Enter Minecraft 26.3 Documentation Portal|26.3-Home]] |

---

## ⚡ 核心设计理念与技术支柱

1. **释放背包空间**：默认将炖菜与汤类最大堆叠数提升至 16，并支持在 1 到 2,147,483,647 之间自由配置。
2. **符合直觉的空碗返还机制**：从堆叠中食用炖菜时，木碗会自动返还至玩家背包；若背包已满，则安全掉落于脚下，绝不丢失物品。
3. **客户端/服务端网络动态同步**：通过 `StewLimitSyncPayload` 与 `broadcastFullState()` 实时同步游戏规则，彻底消除幽灵物品。
4. **权威扩展协调**：与 `potion-stacker-addon` 共同安装时，药水扩展自动让渡炖菜处理逻辑，由本模组独占权威控制。
5. **零 Mixin 性能开销**：纯 API 驱动架构，直接向 `StackSizeManager` 注册 `CustomStackSizeOverride` 回调。

---

## 📊 默认 GameRule 快速参考表

| GameRule | Type | Default | Range | Target Items |
| :--- | :---: | :---: | :---: | :--- |
| `stew-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2,147,483,647 | Mushroom Stew, Rabbit Stew, Beetroot Soup, Suspicious Stew |

---

## 📚 重要文档链接

* [[📊 Version Compatibility Matrix|Version-Compatibility]]
* [[🔧 Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]]
* [[🛠️ Developer Setup & Build Guide|Developer-Setup-and-Building]]
* [[🏠 Return to Main Home Portal|Home]]
