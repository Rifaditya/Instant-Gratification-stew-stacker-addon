# 🍲 Minecraft 26.3 Documentation Portal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **程式碼倉庫來源免責聲明**：本維基文件反映了**程式碼倉庫中的當前原始碼狀態**，可能包含領先於 CurseForge 與 Modrinth 平臺公開發布版本的最新未發布提交或開發中功能。

歡迎查閱 **Instant Gratification: Stew Stacker Addon（即時滿足：燉菜堆疊擴充）** 面向 **Minecraft 26.3**（針對 `MC 26.3-snapshot-6 / 26.3`）的專用技術文件門戶。該版本樹內的所有文件均嚴格反映針對該快照版本的位元組碼對映、Loom 相依性與功能規範。

---

## 🧭 Minecraft 26.3 導航矩陣

| 功能特性 / 子系統 | 說明 | 專用維基頁面 |
| :--- | :--- | :--- |
| **燉菜堆疊與食用人體工學** | 燉菜堆疊機制、空碗返還邏輯、容器儲存壓縮數學 | [[26.3 燉菜堆疊與食用人體工學|zh_tw-26.3-Stew-Stacking-and-Consumption-Ergonomics]] |
| **網路同步與資料負載** | S2C 負載生命週期、握手封包、動態選單狀態重新整理 | [[26.3 網路同步與資料負載|zh_tw-26.3-Network-Synchronization-and-Payloads]] |
| **配置與動態遊戲規則** | 全部 GameRule 與 YACL v3 配置項的完整參考矩陣 | [[26.3 配置與動態遊戲規則|zh_tw-26.3-Configuration-and-GameRules]] |
| **架構設計與擴充鉤子** | 套件結構設計、零 Mixin 架構、CustomStackSizeOverride 回呼 | [[26.3 架構設計與擴充鉤子|zh_tw-26.3-Architecture-and-Addon-Hooks]] |
| **開發者環境配置與工具鏈** | JDK 25 開發環境、Gradle 9.3+ 構建命令、Loom 配置 | [[26.3 開發者環境配置與工具鏈|zh_tw-26.3-Developer-Setup-and-Building]] |

---

## 📊 技術規範資訊框

| 參數 | 版本規範 |
| :--- | :--- |
| **Minecraft Release Target** | `MC 26.3-snapshot-6 / 26.3` |
| **Mod SemVer Release** | `1.0.2+26.3` |
| **Fabric Loader Requirement** | `>=0.19.3` |
| **Java Platform** | OpenJDK 25 (Hotspot 64-bit) |
| **Fabric API Dependency** | `0.156.1+26.3` |
| **DasikLibrary Dependency** | `>=1.8.36` |
| **Stack Size Adjuster Dependency** | `>=1.4.18` |
| **Mixin Footprint** | 0 Mixins (Pure Callback Delegation) |
| **Primary Network Payload** | `stew-stacker:sync_limit` |

---

## 🍲 核心子系統亮點

1. **全面涵蓋燉菜與湯類**：蘑菇煲、兔肉煲、甜菜湯和迷之燉菜均支援 1 到 2,147,483,647 的自訂堆疊上限（預設：16）。
2. **符合直覺的空碗返還**：食用堆疊燉菜時木碗自動進入背包；背包已滿時安全掉落於腳下，絕不遺失物品。
3. **動態遊戲規則驅動**：透過 `stew-stacker-addon:stew_limit` 支援遊戲內即時修改，無需重啟遊戲。
4. **獨佔權威與零衝突**：與 `potion-stacker-addon` 共存時，藥水擴充自動讓渡燉菜處理邏輯，由本模組獨佔權威控制。

---

## 🔗 全域性與外部導航
* [[🏠 返回維基總首頁|zh_tw-Home]]
* [[📊 查閱全域性版本相容性矩陣|zh_tw-Version-Compatibility]]
* [[🔧 查閱疑難排解與 FAQ 指南|zh_tw-Troubleshooting-and-FAQ]]
