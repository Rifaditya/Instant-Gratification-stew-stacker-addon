# 🍲 Instant Gratification: Stew Stacker Addon Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Hinweis zum Repository-Quellcode**: Diese Wiki-Dokumentation spiegelt den **aktuellen Stand des Quellcodes im Repository** wider, welcher unveröffentlichte Commits vor offiziellen Releases auf CurseForge und Modrinth enthalten kann.

Willkommen zur offiziellen technischen Dokumentation von **Instant Gratification: Stew Stacker Addon**. Entwickelt für Minecraft Fabric als spezialisierte Erweiterung für **Stack Size Adjuster**, befreit diese Mod Spieler von überfüllten Inventaren durch stapelbare Pilzsuppen, Kaninchenragouts, Rote-Bete-Suppen und seltsame Suppen.

---

## 🧭 Multi-Versions Dokumentationsportale

| Minecraft Version | Mod Version | Fabric Loader | Portal-Link |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.0.2+26.2` | `>=0.19.1` | [[👉 Enter Minecraft 26.2 Documentation Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.0.2+26.3` | `>=0.19.3` | [[👉 Enter Minecraft 26.3 Documentation Portal|26.3-Home]] |

---

## ⚡ Kernphilosophie & Architektur

1. **Befreiter Inventarplatz**: Standard-Stapelgröße auf 16 erhöht (konfigurierbar bis 2.147.483.647).
2. **Ergonomische Schüssel-Rückgabe**: Leere Holzschüsseln kehren beim Essen ins Inventar zurück oder fallen sicher zu Boden, falls das Inventar voll ist.
3. **Live-Netzwerksynchronisierung**: `StewLimitSyncPayload` und `broadcastFullState()` beseitigen Geister-Items zuverlässig.
4. **Intelligente Koexistenz**: `potion-stacker-addon` erkennt dieses Addon automatisch und überlässt Stew Stacker Addon die volle Kontrolle.
5. **Kein Mixin-Overhead**: Saubere API-Integration über `StackSizeManager.registerOverride`.

---

## 📊 Standard GameRule-Übersicht

| GameRule-Schlüssel | Typ | Standard | Bereich | Betroffene Gegenstände |
| :--- | :---: | :---: | :---: | :--- |
| `stew-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2.147.483.647 | Pilzsuppe, Kaninchenragout, Rote-Bete-Suppe, Seltsame Suppe |

---

## 📚 Wichtige Dokumentations-Hubs

* [[📊 Version Compatibility Matrix|Version-Compatibility]]
* [[🔧 Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]]
* [[🛠️ Developer Setup & Build Guide|Developer-Setup-and-Building]]
* [[🏠 Return to Main Home Portal|Home]]
