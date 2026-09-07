# 🍲 Instant Gratification: Stew Stacker Addon Wiki

🌐 **Languages**: [[🏠 Wiki-Startseite|de_de-Home]] | [[🏠 Wiki-Startseite|de_de-Home]] | [[🏠 Wiki-Startseite|de_de-Home]] | [[🏠 Wiki-Startseite|de_de-Home]] | [[🏠 Wiki-Startseite|de_de-Home]] | [[🏠 Wiki-Startseite|de_de-Home]] | [[🏠 Wiki-Startseite|de_de-Home]] | [[🏠 Wiki-Startseite|de_de-Home]] | [[🏠 Wiki-Startseite|de_de-Home]] | [[🏠 Wiki-Startseite|de_de-Home]] | [[🏠 Wiki-Startseite|de_de-Home]]

> 📌 **Hinweis zum Repository-Quellcode**: Diese Wiki-Dokumentation spiegelt den **aktuellen Stand des Quellcodes im Repository** wider, welcher unveröffentlichte Commits vor offiziellen Releases auf CurseForge und Modrinth enthalten kann.

Willkommen zur offiziellen technischen Dokumentation von **Instant Gratification: Stew Stacker Addon**. Entwickelt für Minecraft Fabric als spezialisierte Erweiterung für **Stack Size Adjuster**, befreit diese Mod Spieler von überfüllten Inventaren durch stapelbare Pilzsuppen, Kaninchenragouts, Rote-Bete-Suppen und seltsame Suppen.

---

## 🧭 Multi-Versions Dokumentationsportale

| Minecraft Version | Mod Version | Fabric Loader | Portal-Link |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.0.2+26.2` | `>=0.19.1` | [[🏠 Wiki-Startseite|de_de-Home]] |
| **Minecraft 26.3** | `1.0.2+26.3` | `>=0.19.3` | [[🏠 Wiki-Startseite|de_de-Home]] |

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

* [[📊 Versionskompatibilitätsmatrix|de_de-Version-Compatibility]]
* [[🔧 Fehlerbehebung & FAQ|de_de-Troubleshooting-and-FAQ]]
* [[🛠️ Entwickler-Setup & Build-Anleitung|de_de-Developer-Setup-and-Building]]
* [[🏠 Wiki-Startseite|de_de-Home]]
