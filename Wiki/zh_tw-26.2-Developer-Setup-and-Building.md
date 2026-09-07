# 🛠️ 開發者環境配置與工具鏈 (Minecraft 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **程式碼倉庫來源免責聲明**：本維基文件反映了**程式碼倉庫中的當前原始碼狀態**，可能包含領先於 CurseForge 與 Modrinth 平臺公開發布版本的最新未發布提交或開發中功能。

## 1. Technical Toolchain Specifications

| Toolchain Property | Anchor Specification |
| :--- | :--- |
| **Minecraft Version** | `MC 26.1.2 / 26.2` |
| **Mod SemVer** | `1.0.2+26.2` |
| **Java SDK Platform** | OpenJDK 25 (Hotspot 64-bit) |
| **Gradle Wrapper** | Gradle 9.3+ (`gradlew`) |
| **Fabric Loader** | `>=0.19.1` |
| **Fabric API** | `0.150.1+26.2` |
| **DasikLibrary** | `>=1.8.3` |
| **Stack Size Adjuster** | `>=1.4.10+26.2` |

---

## 2. Compilation & Verification Commands

```bash
./gradlew build --no-daemon
```

The compiled binary will be located at:
`build/libs/stew-stacker-addon-1.0.2+26.2.jar`

---

## 3. Version-Specific `gradle.properties` Settings

```properties
minecraft_version=26.2
mod_version=1.0.2+26.2
fabric_version=0.150.1+26.2
fabric_loader_version=0.19.1
dasik_library_version=1.8.3
```

---

## 4. 全域性與外部導航
* [[🍲 返回 Minecraft 26.2 門戶|zh_tw-26.2-Home]]
* [[🛠️ 開發者環境配置與構建指南|zh_tw-Developer-Setup-and-Building]]
* [[📊 查閱全域性版本相容性矩陣|zh_tw-Version-Compatibility]]
