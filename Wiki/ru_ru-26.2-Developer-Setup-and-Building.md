# 🛠️ Среда разработчика и тулчейн (Minecraft 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Отказ от ответственности за источник репозитория**: Документация в этой вики отражает **текущее состояние исходного кода в репозитории**, которое может включать недавние невыпущенные коммиты или разрабатываемые функции, опережающие общедоступные сборки на CurseForge и Modrinth.

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

## 4. Глобальная навигация
* [[🍲 Вернуться к порталу Minecraft 26.2|ru_ru-26.2-Home]]
* [[🛠️ Среда разработчика и руководство по сборке|ru_ru-Developer-Setup-and-Building]]
* [[📊 Посмотреть глобальную матрицу совместимости|ru_ru-Version-Compatibility]]
