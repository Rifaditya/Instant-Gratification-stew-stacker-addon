# 🛠️ 开发者环境配置与工具链 (Minecraft 26.3)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **代码仓库来源免责声明**：本维基文档反映了**代码仓库中的当前源码状态**，可能包含领先于 CurseForge 和 Modrinth 平台公开发布版本的最新未发布提交或开发中功能。

## 1. Technical Toolchain Specifications

| Toolchain Property | Anchor Specification |
| :--- | :--- |
| **Minecraft Version** | `MC 26.3-snapshot-6 / 26.3` |
| **Mod SemVer** | `1.0.2+26.3` |
| **Java SDK Platform** | OpenJDK 25 (Hotspot 64-bit) |
| **Gradle Wrapper** | Gradle 9.3+ (`gradlew`) |
| **Fabric Loader** | `>=0.19.3` |
| **Fabric API** | `0.156.1+26.3` |
| **DasikLibrary** | `>=1.8.36` |
| **Stack Size Adjuster** | `>=1.4.18` |

---

## 2. Compilation & Verification Commands

```bash
./gradlew build --no-daemon
```

The compiled binary will be located at:
`build/libs/stew-stacker-addon-1.0.2+26.3.jar`

---

## 3. Version-Specific `gradle.properties` Settings

```properties
minecraft_version=26.3
mod_version=1.0.2+26.3
fabric_version=0.156.1+26.3
fabric_loader_version=0.19.3
dasik_library_version=1.8.36
```

---

## 4. 全局与外部导航
* [[🍲 返回 Minecraft 26.3 门户|zh_cn-26.3-Home]]
* [[🛠️ 开发者环境配置与构建指南|zh_cn-Developer-Setup-and-Building]]
* [[📊 查阅全局版本兼容性矩阵|zh_cn-Version-Compatibility]]
