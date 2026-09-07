# 🍲 Minecraft 26.2 Documentation Portal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **代码仓库来源免责声明**：本维基文档反映了**代码仓库中的当前源码状态**，可能包含领先于 CurseForge 和 Modrinth 平台公开发布版本的最新未发布提交或开发中功能。

欢迎查阅 **Instant Gratification: Stew Stacker Addon（即时满足：炖菜堆叠扩展）** 面向 **Minecraft 26.2**（针对 `MC 26.1.2 / 26.2`）的专用技术文档门户。该版本树内的所有文档均严格反映针对该发布版本的字节码映射、Loom 依赖项和功能规范。

---

## 🧭 Minecraft 26.2 导航矩阵

| 功能特性 / 子系统 | 说明 | 专用维基页面 |
| :--- | :--- | :--- |
| **炖菜堆叠与食用人体工学** | 炖菜堆叠机制、空碗返还逻辑、容器存储压缩数学 | [[26.2 炖菜堆叠与食用人体工学|zh_cn-26.2-Stew-Stacking-and-Consumption-Ergonomics]] |
| **网络同步与数据负载** | S2C 负载生命周期、握手数据包、动态菜单状态刷新 | [[26.2 网络同步与数据负载|zh_cn-26.2-Network-Synchronization-and-Payloads]] |
| **配置与动态游戏规则** | 全部 GameRule 与 YACL v3 配置项的完整参考矩阵 | [[26.2 配置与动态游戏规则|zh_cn-26.2-Configuration-and-GameRules]] |
| **架构设计与扩展钩子** | 包结构设计、零 Mixin 架构、CustomStackSizeOverride 回调 | [[26.2 架构设计与扩展钩子|zh_cn-26.2-Architecture-and-Addon-Hooks]] |
| **开发者环境配置与工具链** | JDK 25 开发环境、Gradle 9.3+ 构建命令、Loom 配置 | [[26.2 开发者环境配置与工具链|zh_cn-26.2-Developer-Setup-and-Building]] |

---

## 📊 技术规范信息框

| 参数 | 版本规范 |
| :--- | :--- |
| **Minecraft Release Target** | `MC 26.1.2 / 26.2` |
| **Mod SemVer Release** | `1.0.2+26.2` |
| **Fabric Loader Requirement** | `>=0.19.1` |
| **Java Platform** | OpenJDK 25 (Hotspot 64-bit) |
| **Fabric API Dependency** | `0.150.1+26.2` |
| **DasikLibrary Dependency** | `>=1.8.3` |
| **Stack Size Adjuster Dependency** | `>=1.4.10+26.2` |
| **Mixin Footprint** | 0 Mixins (Pure Callback Delegation) |
| **Primary Network Payload** | `stew-stacker:sync_limit` |

---

## 🍲 核心子系统亮点

1. **全面覆盖炖菜与汤类**：蘑菇煲、兔肉煲、甜菜汤和迷之炖菜均支持 1 到 2,147,483,647 的自定义堆叠上限（默认：16）。
2. **符合直觉的空碗返还**：食用堆叠炖菜时木碗自动进入背包；背包已满时安全掉落于脚下，绝不丢失物品。
3. **动态游戏规则驱动**：通过 `stew-stacker-addon:stew_limit` 支持游戏内即时修改，无需重启游戏。
4. **独占权威与零冲突**：与 `potion-stacker-addon` 共存时，药水扩展自动让渡炖菜处理逻辑，由本模组独占权威控制。

---

## 🔗 全局与外部导航
* [[🏠 返回维基总首页|zh_cn-Home]]
* [[📊 查阅全局版本兼容性矩阵|zh_cn-Version-Compatibility]]
* [[🔧 查阅故障排除与 FAQ 指南|zh_cn-Troubleshooting-and-FAQ]]
