# 📊 Matriz de Compatibilidade de Versões

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Isenção de responsabilidade da fonte do repositório**: A documentação nesta Wiki reflete o **estado atual do código-fonte no repositório**, que pode incluir commits recentes não lançados ou recursos em desenvolvimento à frente dos lançamentos públicos no CurseForge e Modrinth.

## 1. Official Infobox
| Parameter | Technical Specification |
| :--- | :--- |
| **Mod Identifier** | `stew-stacker-addon` |
| **Mod Collection** | Instant Gratification (IG) |
| **Supported Fabric Anchors** | `26.2` (MC 26.1.2 / 26.2), `26.3` (MC 26.3-snapshot-6 / 26.3) |
| **Java Platform** | OpenJDK 25 (Hotspot 64-bit) |
| **Build Toolchain** | Gradle 9.3+ with Fabric Loom |
| **Architecture Standard** | 1 Jar 1 Version Policy |
| **Required Dependencies** | `fabricloader`, `fabric-api`, `dasik-library`, `stack-size-adjuster` |
| **Optional Integrations** | `modmenu`, `cloth-config` / YetAnotherConfigLib (YACL) |

---

## 2. Multi-Version Lifecycle & Compatibility Matrix

| Minecraft Target | Mod SemVer | Fabric Loader | Java Requirement | Fabric API Version | DasikLibrary Dependency | Stack Size Adjuster | Distribution Status |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **MC 26.2** (`26.1.2` / `26.2`) | `1.0.2+26.2` | `>=0.19.1` | JDK 25 (`>=25`) | `0.150.1+26.2` | `>=1.8.3` | `>=1.4.10+26.2` | 🟢 Standard Anchor |
| **MC 26.3** (`26.3-snapshot-6` / `26.3`) | `1.0.2+26.3` | `>=0.19.3` | JDK 25 (`>=25`) | `0.156.1+26.3` | `>=1.8.36` | `>=1.4.18` | 🟢 Modern Lead |

---

## 3. The 1 Jar 1 Version Policy vs. Universal Library Bounds

### Dedicated Addon Binaries
* `stew-stacker-addon-1.0.2+26.2.jar`: Target anchor for stable MC 26.1.2 and MC 26.2 installations.
* `stew-stacker-addon-1.0.2+26.3.jar`: Target anchor for developmental snapshot environments (MC 26.3-snapshot-6 and beyond).

### Universal DasikLibrary Integration
Stew Stacker Addon relies on **DasikLibrary** for dynamic runtime GameRule registration (`DynamicGameRuleManager`), category allocation, and configuration management (`ConfigHelper`). DasikLibrary follows an open version bound architecture (`>=26.1.2-`).

---

## 4. Installation & Prerequisites Workflow

```
[ Download Compatible Addon Jar ]
               |
               +---> Check Minecraft Target (26.2 vs 26.3)
               |
[ Verify Core Dependencies ]
       |
       +---> Fabric Loader (>=0.19.1 for 26.2 | >=0.19.3 for 26.3)
       +---> Fabric API (matching MC release)
       +---> DasikLibrary (>=1.8.3 for 26.2 | >=1.8.36 for 26.3)
       +---> Stack Size Adjuster (>=1.4.10+26.2 for 26.2 | >=1.4.18 for 26.3)
               |
[ Deploy to .minecraft/mods/ ]
               |
[ Launch Game with OpenJDK 25 ]
```

---

## 5. Navegação Global
* [[🏠 Voltar ao Portal Principal da Wiki|pt_br-Home]]
* [[🍲 Ler 26.2 Empilhamento de Ensopados e Ergonomia de Consumo|pt_br-26.2-Stew-Stacking-and-Consumption-Ergonomics]]
* [[🍲 Ler 26.3 Empilhamento de Ensopados e Ergonomia de Consumo|pt_br-26.3-Stew-Stacking-and-Consumption-Ergonomics]]
* [[🔧 Consultar o Guia de Solução de Problemas e FAQ|pt_br-Troubleshooting-and-FAQ]]
