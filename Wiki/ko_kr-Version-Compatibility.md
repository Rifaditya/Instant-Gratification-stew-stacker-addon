# 📊 버전 호환성 매트릭스

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 면책 조항**: 본 위키의 문서는 CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 최신 미출시 커밋이나 개발 기능을 포함할 수 있는 **저장소의 현재 소스 코드 상태**를 반영합니다.

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

## 5. 전역 및 외부 내비게이션
* [[🏠 위키 메인 포털로 돌아가기|ko_kr-Home]]
* [[🍲 26.2 스튜 스태킹 및 섭취 인체공학 읽기|ko_kr-26.2-Stew-Stacking-and-Consumption-Ergonomics]]
* [[🍲 26.3 스튜 스태킹 및 섭취 인체공학 읽기|ko_kr-26.3-Stew-Stacking-and-Consumption-Ergonomics]]
* [[🔧 문제 해결 및 FAQ 가이드 확인|ko_kr-Troubleshooting-and-FAQ]]
