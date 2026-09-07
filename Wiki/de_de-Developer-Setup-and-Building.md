# 🛠️ Entwickler-Setup & Build-Anleitung

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Haftungsausschluss zur Repository-Quelle**: Die Dokumentation in diesem Wiki spiegelt den **aktuellen Quellcode-Zustand im Repository** wider, der neuere, unveröffentlichte Commits oder Entwicklungsfunktionen vor öffentlichen Builds auf CurseForge und Modrinth enthalten kann.

## 1. Developer Environment Prerequisites
* **Java Development Kit (JDK)**: OpenJDK 25 (e.g., Eclipse Adoptium Temurin 25 with Hotspot).
* **Build System**: Gradle 9.3+ (managed via project `./gradlew` wrapper).
* **Fabric Tooling**: Fabric Loom with Parchment mappings.
* **Core Dependencies**:
  - Fabric Loader: `>=0.19.1` (26.2) / `>=0.19.3` (26.3)
  - Fabric API: `0.150.1+26.2` (26.2) / `0.156.1+26.3` (26.3)
  - DasikLibrary: `>=1.8.3` (26.2) / `>=1.8.36` (26.3)
  - Stack Size Adjuster: `>=1.4.10+26.2` (26.2) / `>=1.4.18` (26.3)

---

## 2. Workspace Setup & Repository Cloning

```bash
git clone https://github.com/Rifaditya/Instant-Gratification-stew-stacker-addon.git
cd Instant-Gratification-stew-stacker-addon
```

---

## 3. Compilation & Build Tasks

```bash
./gradlew build --no-daemon
```

---

## 4. Multi-Version Project Topology

```
Instant Gratification Collection/Stew Stacker Addon/
├── Archive Jar of all versions/             # Consolidated binary release repository
├── Doc/                                     # Documentation, descriptions, and assets
├── Wiki/                                    # Master GitHub Wiki documentation suite
├── stew-stacker-addon/                      # Minecraft 26.2 anchor root project
└── Stew Stacker Addon v26.3/
    └── stew-stacker-addon/                  # Minecraft 26.3 anchor root project
```

---

## 5. Addon Hook Integration Example

```java
net.instantgratification.stacksizeadjuster.util.StackSizeManager.registerOverride(
    (item, originalSize) -> {
        if (item == net.minecraft.world.item.Items.SUSPICIOUS_STEW) {
            return 8; // Custom override
        }
        return -1; // Fallback to default
    }
);
```

---

## 6. Globale Navigation
* [[🏠 Zurück zum Hauptportal|de_de-Home]]
* [[🛠️ 26.2 Entwickler-Setup & Toolchain lesen|de_de-26.2-Developer-Setup-and-Building]]
* [[🛠️ 26.3 Entwickler-Setup & Toolchain lesen|de_de-26.3-Developer-Setup-and-Building]]
* [[📊 Versionskompatibilitätsmatrix anzeigen|de_de-Version-Compatibility]]
