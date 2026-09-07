# 📊 版本兼容性矩阵

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **代码仓库来源免责声明**：本维基文档反映了**代码仓库中的当前源码状态**，可能包含领先于 CurseForge 和 Modrinth 平台公开发布版本的最新未发布提交或开发中功能。

## 1. Official Infobox
| Parameter | Technical Specification |
| :--- | :--- |
| **Mod Identifier** | `stew-stacker-addon` |
| **Mod Collection** | Instant Gratification (IG) |
| **Supported Fabric Anchors** | `26.2` (MC 26.1.2 / 26.2), `26.3` (MC 26.3-snapshot-6 / 26.3) |
| **Java Platform** | OpenJDK 25 (Hotspot 64-bit) |
| **Build Toolchain** | Gradle 9.3+ with Fabric Loom |
| **Architecture Standard** | 1 Jar 1 Version Policy |
| **Required Dependencies** | `fabricloader`, `fabric-api`, `dasik-library`, `stack-size-adjuster` |
| **Optional Integrations** | `modmenu`, `cloth-config` / YetAnotherConfigLib (YACL) |

---

## 2. Multi-Version Lifecycle & Compatibility Matrix

| Minecraft Target | Mod SemVer | Fabric Loader | Java Requirement | Fabric API Version | DasikLibrary Dependency | Stack Size Adjuster | Distribution Status |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **MC 26.2** (`26.1.2` / `26.2`) | `1.0.2+26.2` | `>=0.19.1` | JDK 25 (`>=25`) | `0.150.1+26.2` | `>=1.8.3` | `>=1.4.10+26.2` | 🟢 Standard Anchor |
| **MC 26.3** (`26.3-snapshot-6` / `26.3`) | `1.0.2+26.3` | `>=0.19.3` | JDK 25 (`>=25`) | `0.156.1+26.3` | `>=1.8.36` | `>=1.4.18` | 🟢 Modern Lead |

---

## 3. The 1 Jar 1 Version Policy vs. Universal Library Bounds

### Dedicated Addon Binaries
* `stew-stacker-addon-1.0.2+26.2.jar`: Target anchor for stable MC 26.1.2 and MC 26.2 installations.
* `stew-stacker-addon-1.0.2+26.3.jar`: Target anchor for developmental snapshot environments (MC 26.3-snapshot-6 and beyond).

### Universal DasikLibrary Integration
Stew Stacker Addon relies on **DasikLibrary** for dynamic runtime GameRule registration (`DynamicGameRuleManager`), category allocation, and configuration management (`ConfigHelper`). DasikLibrary follows an open version bound architecture (`>=26.1.2-`).

---

## 4. Installation & Prerequisites Workflow

```
[ Download Compatible Addon Jar ]
               |
               +---> Check Minecraft Target (26.2 vs 26.3)
               |
[ Verify Core Dependencies ]
       |
       +---> Fabric Loader (>=0.19.1 for 26.2 | >=0.19.3 for 26.3)
       +---> Fabric API (matching MC release)
       +---> DasikLibrary (>=1.8.3 for 26.2 | >=1.8.36 for 26.3)
       +---> Stack Size Adjuster (>=1.4.10+26.2 for 26.2 | >=1.4.18 for 26.3)
               |
[ Deploy to .minecraft/mods/ ]
               |
[ Launch Game with OpenJDK 25 ]
```

---

## 5. 全局与外部导航
* [[🏠 返回维基总首页|zh_cn-Home]]
* [[🍲 阅读 26.2 炖菜堆叠与食用人体工学|zh_cn-26.2-Stew-Stacking-and-Consumption-Ergonomics]]
* [[🍲 阅读 26.3 炖菜堆叠与食用人体工学|zh_cn-26.3-Stew-Stacking-and-Consumption-Ergonomics]]
* [[🔧 查阅故障排除与 FAQ 指南|zh_cn-Troubleshooting-and-FAQ]]
