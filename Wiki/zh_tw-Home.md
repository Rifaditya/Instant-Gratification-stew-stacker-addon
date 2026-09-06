# 🍲 即時滿足：燉菜堆疊擴展 Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **代碼倉庫來源聲明**：本 Wiki 中的技術文檔反映了**代碼倉庫中當前的源代碼狀態**，可能包含領先於 CurseForge 與 Modrinth 正式發布版本的未發布提交或開發中特性。

歡迎查閱 **Instant Gratification: Stew Stacker Addon（即時滿足：燉菜堆疊擴展）** 官方技術文檔。本專案是為 Minecraft Fabric 平台設計的 **Stack Size Adjuster** 專用高性能擴展模組，徹底解決自原版以來燉菜與湯類佔用背包欄位過多的痛點。支援對蘑菇煲、兔肉煲、甜菜湯以及迷之燉菜進行無縫動態堆疊配置。

---

## 🧭 多版本文檔傳送門

| Minecraft Target | Mod Version | Fabric Loader | Portal Link |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.0.2+26.2` | `>=0.19.1` | [[👉 Enter Minecraft 26.2 Documentation Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.0.2+26.3` | `>=0.19.3` | [[👉 Enter Minecraft 26.3 Documentation Portal|26.3-Home]] |

---

## ⚡ 核心設計理念與技術支柱

1. **釋放背包空間**：預設將燉菜與湯類最大堆疊數提升至 16，並支援在 1 到 2,147,483,647 之間自由配置。
2. **符合直覺的空碗返還機制**：從堆疊中食用燉菜時，木碗會自動返還至玩家背包；若背包已滿，則安全掉落於腳下，絕不遺失物品。
3. **客戶端/伺服器網路動態同步**：透過 `StewLimitSyncPayload` 與 `broadcastFullState()` 即時同步遊戲規則，徹底消除幽靈物品。
4. **權威擴展協調**：與 `potion-stacker-addon` 共同安裝時，藥水擴展自動讓渡燉菜處理邏輯，由本模組獨佔權威控制。
5. **零 Mixin 效能開銷**：純 API 驅動架構，直接向 `StackSizeManager` 註冊 `CustomStackSizeOverride` 回呼。

---

## 📊 預設 GameRule 快速參考表

| GameRule | Type | Default | Range | Target Items |
| :--- | :---: | :---: | :---: | :--- |
| `stew-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2,147,483,647 | Mushroom Stew, Rabbit Stew, Beetroot Soup, Suspicious Stew |

---

## 📚 重要文檔鏈接

* [[📊 Version Compatibility Matrix|Version-Compatibility]]
* [[🔧 Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]]
* [[🛠️ Developer Setup & Build Guide|Developer-Setup-and-Building]]
* [[🏠 Return to Main Home Portal|Home]]
