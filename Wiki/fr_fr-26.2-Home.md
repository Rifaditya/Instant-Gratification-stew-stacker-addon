# 🍲 Minecraft 26.2 Documentation Portal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Avertissement sur la source du dépôt** : La documentation de ce wiki reflète **l'état actuel du code source dans le dépôt**, qui peut inclure des commits non publiés ou des fonctionnalités en cours de développement en avance sur CurseForge et Modrinth.

Bienvenue sur le portail de documentation technique dédié d'**Instant Gratification: Stew Stacker Addon** sur **Minecraft 26.2** (ciblant `MC 26.1.2 / 26.2`). Tous les documents reflètent les correspondances de bytecode exactes, les dépendances Loom et les spécifications de cette version.

---

## 🧭 Matrice de Navigation Minecraft 26.2

| Fonctionnalité / Sous-système | Description | Page Wiki Dédiée |
| :--- | :--- | :--- |
| **Empilement de Ragoûts & Ergonomie de Consommation** | Mécaniques d'empilement, restitution des bols, mathématiques de compression | [[26.2 Empilement de Ragoûts & Ergonomie de Consommation|fr_fr-26.2-Stew-Stacking-and-Consumption-Ergonomics]] |
| **Synchronisation Réseau & Données Utiles** | Cycle de vie des paquets S2C, poignée de main, rafraîchissement des menus | [[26.2 Synchronisation Réseau & Données Utiles|fr_fr-26.2-Network-Synchronization-and-Payloads]] |
| **Configuration & GameRules Dynamiques** | Matrice de référence complète des GameRules et options YACL v3 | [[26.2 Configuration & GameRules Dynamiques|fr_fr-26.2-Configuration-and-GameRules]] |
| **Architecture & Crochets d'Extension** | Architecture logicielle, zéro mixin, CustomStackSizeOverride | [[26.2 Architecture & Crochets d'Extension|fr_fr-26.2-Architecture-and-Addon-Hooks]] |
| **Environnement Développeur & Outils** | Environnement JDK 25, commandes Gradle 9.3+, configuration Loom | [[26.2 Environnement Développeur & Outils|fr_fr-26.2-Developer-Setup-and-Building]] |

---

## 📊 Infobox des Spécifications Techniques

| Paramètre | Spécification de Version |
| :--- | :--- |
| **Minecraft Release Target** | `MC 26.1.2 / 26.2` |
| **Mod SemVer Release** | `1.0.2+26.2` |
| **Fabric Loader Requirement** | `>=0.19.1` |
| **Java Platform** | OpenJDK 25 (Hotspot 64-bit) |
| **Fabric API Dependency** | `0.150.1+26.2` |
| **DasikLibrary Dependency** | `>=1.8.3` |
| **Stack Size Adjuster Dependency** | `>=1.4.10+26.2` |
| **Mixin Footprint** | 0 Mixins (Pure Callback Delegation) |
| **Primary Network Payload** | `stew-stacker:sync_limit` |

---

## 🍲 Points Forts du Sous-système

1. **Support complet de tous les ragoûts et soupes** : Ragoût de champignons, ragoût de lapin, soupe de betteraves et soupe suspecte empilables de 1 à 2 147 483 647 (par défaut : 16).
2. **Restitution intuitive des bols** : En mangeant, le bol vide revient dans l'inventaire ou tombe à vos pieds en toute sécurité s'il est plein.
3. **GameRules dynamiques** : Modification instantanée en jeu sans redémarrage via `stew-stacker-addon:stew_limit`.
4. **Autorité exclusive** : En présence de `potion-stacker-addon`, ce mod prend la gestion exclusive de tous les ragoûts sans conflit.

---

## 🔗 Navigation Globale
* [[🏠 Retour au Portail Principal|fr_fr-Home]]
* [[📊 Consulter la Matrice de Compatibilité des Versions|fr_fr-Version-Compatibility]]
* [[🔧 Consulter le Guide de Dépannage et FAQ|fr_fr-Troubleshooting-and-FAQ]]
