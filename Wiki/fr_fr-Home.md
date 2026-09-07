# 🍲 Instant Gratification: Stew Stacker Addon Wiki

🌐 **Languages**: [[🏠 Accueil du Wiki|fr_fr-Home]] | [[🏠 Accueil du Wiki|fr_fr-Home]] | [[🏠 Accueil du Wiki|fr_fr-Home]] | [[🏠 Accueil du Wiki|fr_fr-Home]] | [[🏠 Accueil du Wiki|fr_fr-Home]] | [[🏠 Accueil du Wiki|fr_fr-Home]] | [[🏠 Accueil du Wiki|fr_fr-Home]] | [[🏠 Accueil du Wiki|fr_fr-Home]] | [[🏠 Accueil du Wiki|fr_fr-Home]] | [[🏠 Accueil du Wiki|fr_fr-Home]] | [[🏠 Accueil du Wiki|fr_fr-Home]]

> 📌 **Avertissement sur la source du dépôt** : La documentation de ce Wiki reflète **l'état actuel du code source dans le dépôt**, qui peut inclure des modifications non publiées en avance sur CurseForge et Modrinth.

Bienvenue sur la documentation technique officielle de **Instant Gratification: Stew Stacker Addon**. Conçu pour Minecraft Fabric comme une extension haute performance pour **Stack Size Adjuster**, ce mod libère l'inventaire des joueurs en permettant d'empiler les soupes de champignons, ragoûts de lapin, soupes de betteraves et ragoûts suspects.

---

## 🧭 Portails de Documentation Multi-Versions

| Version de Minecraft | Version du Mod | Fabric Loader | Lien vers le Portail |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.0.2+26.2` | `>=0.19.1` | [[🏠 Accueil du Wiki|fr_fr-Home]] |
| **Minecraft 26.3** | `1.0.2+26.3` | `>=0.19.3` | [[🏠 Accueil du Wiki|fr_fr-Home]] |

---

## ⚡ Philosophie Centrale & Piliers Techniques

1. **Espace d'Inventaire Libéré** : Limite d'empilement par défaut augmentée à 16 (avec liberté totale jusqu'à 2 147 483 647).
2. **Logistique Ergonomique des Bols** : Le bol vide retourne automatiquement dans l'inventaire lors de la consommation (ou tombe au sol si plein).
3. **Synchronisation Réseau en Temps Réel** : `StewLimitSyncPayload` et `broadcastFullState()` empêchent tout item fantôme.
4. **Coexistence Parfaite** : En présence de `potion-stacker-addon`, le mod de potions cède automatiquement la gestion des ragoûts.
5. **Zéro Surcharge Mixin** : Intégration pure via l'API `StackSizeManager.registerOverride`.

---

## 📊 Matrice des GameRules par Défaut

| Identifiant GameRule | Type | Valeur | Plage | Objets ciblés |
| :--- | :---: | :---: | :---: | :--- |
| `stew-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2 147 483 647 | Soupe de champignons, ragoût de lapin, soupe de betteraves, ragoût suspect |

---

## 📚 Liens Utiles de Documentation

* [[📊 Matrice de Compatibilité des Versions|fr_fr-Version-Compatibility]]
* [[🔧 Dépannage et FAQ|fr_fr-Troubleshooting-and-FAQ]]
* [[🛠️ Configuration Développeur & Compilation|fr_fr-Developer-Setup-and-Building]]
* [[🏠 Accueil du Wiki|fr_fr-Home]]
