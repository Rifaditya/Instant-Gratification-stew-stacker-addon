# 📊 Version Compatibility Matrix

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

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

Stew Stacker Addon strictly adheres to the **1 Jar 1 Version Policy**: every major Minecraft version anchor receives a discrete, dedicated binary compiled specifically against that target's obfuscation mapping, bytecode structure, and Fabric API lifecycle.

| Minecraft Target | Mod SemVer | Fabric Loader | Java Requirement | Fabric API Version | DasikLibrary Dependency | Stack Size Adjuster | Distribution Status |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **MC 26.2** (`26.1.2` / `26.2`) | `1.0.2+26.2` | `>=0.19.1` | JDK 25 (`>=25`) | `0.150.1+26.2` | `>=1.8.3` | `>=1.4.10+26.2` | 🟢 Standard Anchor |
| **MC 26.3** (`26.3-snapshot-6` / `26.3`) | `1.0.2+26.3` | `>=0.19.3` | JDK 25 (`>=25`) | `0.156.1+26.3` | `>=1.8.36` | `>=1.4.18` | 🟢 Modern Lead |

---

## 3. The 1 Jar 1 Version Policy vs. Universal Library Bounds

### Dedicated Addon Binaries
While pure computational libraries can occasionally span broad version bounds, mod addons that hook into game registries, networking payloads, and client GUI factories require strict compile-time verification against exact Mojang mappings and intermediate descriptors.
* `stew-stacker-addon-1.0.2+26.2.jar`: Target anchor for stable MC 26.1.2 and MC 26.2 installations.
* `stew-stacker-addon-1.0.2+26.3.jar`: Target anchor for developmental snapshot environments (MC 26.3-snapshot-6 and beyond).

### Universal DasikLibrary Integration
Stew Stacker Addon relies on **DasikLibrary** for dynamic runtime GameRule registration (`DynamicGameRuleManager`), category allocation, and configuration management (`ConfigHelper`). DasikLibrary follows an open version bound architecture (`>=26.1.2-`), guaranteeing:
1. Seamless backward and forward compatibility with server GameRule serialization.
2. In-game `/gamerule` dynamic tab completion across all game instances.
3. Client-side classloader safety (server-only evaluations guard against client crashes).

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

### Verification Checklist:
1. Ensure Java runtime is OpenJDK 25 Hotspot (e.g. Eclipse Adoptium `jdk-25.0.3+`).
2. Verify `fabric-api` is present in your mods directory.
3. Verify `dasik-library` is present in your mods directory.
4. Verify `stack-size-adjuster` is present in your mods directory.
5. Launch the game and inspect the log for:
   `[stew-stacker-addon] Instant Gratification: Stew Stacker Initialized`

---

## 5. Related Documentation Links
* Return to the [[Main Wiki Portal|Home]].
* Read the [[26.2 Stew Stacking & Consumption Ergonomics|26.2-Stew-Stacking-and-Consumption-Ergonomics]].
* Read the [[26.3 Stew Stacking & Consumption Ergonomics|26.3-Stew-Stacking-and-Consumption-Ergonomics]].
* Consult the [[Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]].
