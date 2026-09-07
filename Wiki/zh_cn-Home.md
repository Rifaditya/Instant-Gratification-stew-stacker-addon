# 🍲 即时满足：炖菜堆叠扩展 Wiki

🌐 **Languages**: [[🏠 维基首页|zh_cn-Home]] | [[🏠 维基首页|zh_cn-Home]] | [[🏠 维基首页|zh_cn-Home]] | [[🏠 维基首页|zh_cn-Home]] | [[🏠 维基首页|zh_cn-Home]] | [[🏠 维基首页|zh_cn-Home]] | [[🏠 维基首页|zh_cn-Home]] | [[🏠 维基首页|zh_cn-Home]] | [[🏠 维基首页|zh_cn-Home]] | [[🏠 维基首页|zh_cn-Home]] | [[🏠 维基首页|zh_cn-Home]]

> 📌 **代码仓库来源声明**：本 Wiki 中的技术文档反映了**代码仓库中当前的源代码状态**，可能包含领先于 CurseForge 与 Modrinth 正式发布版本的未发布提交或开发中特性。

欢迎查阅 **Instant Gratification: Stew Stacker Addon（即时满足：炖菜堆叠扩展）** 官方技术文档。本项目是为 Minecraft Fabric 平台设计的 **Stack Size Adjuster** 专用高性能扩展模组，彻底解决自原版以来炖菜和汤类占用背包槽位过多的痛点。支持对蘑菇煲、兔肉煲、甜菜汤以及迷之炖菜进行无缝动态堆叠配置。

---

## 🧭 多版本文档传送门

| Minecraft Target | Mod Version | Fabric Loader | Portal Link |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.0.2+26.2` | `>=0.19.1` | [[🏠 维基首页|zh_cn-Home]] |
| **Minecraft 26.3** | `1.0.2+26.3` | `>=0.19.3` | [[🏠 维基首页|zh_cn-Home]] |

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

* [[📊 版本兼容性矩阵|zh_cn-Version-Compatibility]]
* [[🔧 故障排除与常见问题|zh_cn-Troubleshooting-and-FAQ]]
* [[🛠️ 开发者环境配置与构建指南|zh_cn-Developer-Setup-and-Building]]
* [[🏠 维基首页|zh_cn-Home]]
