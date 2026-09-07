# 🛠️ Entorno de Desarrollo y Herramientas (Minecraft 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Descargo de responsabilidad de la fuente del repositorio**: La documentación de esta Wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de las compilaciones públicas en CurseForge y Modrinth.

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

## 4. Enlaces Globales y Externos
* [[🍲 Volver al Portal de Minecraft 26.2|es_es-26.2-Home]]
* [[🛠️ Configuración de Desarrollador y Compilación|es_es-Developer-Setup-and-Building]]
* [[📊 Revisar la Matriz de Compatibilidad de Versiones|es_es-Version-Compatibility]]
