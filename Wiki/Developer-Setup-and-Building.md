# 🛠️ Developer Setup & Build Guide

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## 1. Developer Environment Prerequisites
Building Stew Stacker Addon from source requires modern development tooling aligned with the Minecraft 26.x toolchain:
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

Clone the repository and inspect branches:
```bash
git clone https://github.com/Rifaditya/Instant-Gratification-stew-stacker-addon.git
cd Instant-Gratification-stew-stacker-addon
```

### IDE Configuration:
* **IntelliJ IDEA**: Open the folder as a Gradle project. Ensure Gradle JVM is configured to JDK 25 (`org.gradle.java.home=E:/JDK25` or your system JDK 25 installation).
* **VS Code**: Install the Extension Pack for Java and configure `java.configuration.runtimes` to include Java 25.

---

## 3. Compilation & Build Tasks

Execute a clean, non-daemon build using the Gradle wrapper:
```bash
./gradlew build --no-daemon
```

### Build Lifecycle Highlights:
1. `compileJava`: Compiles Java sources with `--release 25`.
2. `processResources`: Injects version metadata into `fabric.mod.json`.
3. `remapJar`: Generates production-ready remapped JAR files under `build/libs/`.
4. `archiveReleaseJar`: Automatically mirrors output JARs into `Archive Jar of all versions/` and local release hub directories.

---

## 4. Multi-Version Project Topology

The repository follows a clean multi-version directory structure:
```
Instant Gratification Collection/Stew Stacker Addon/
├── Archive Jar of all versions/             # Consolidated binary release repository
├── Doc/                                     # Documentation, descriptions, and assets
├── Wiki/                                    # Master GitHub Wiki documentation suite
├── stew-stacker-addon/                      # Minecraft 26.2 anchor root project
│   ├── src/main/java/                       # 26.2 Java sources
│   ├── src/main/resources/                  # 26.2 Assets & configs
│   ├── build.gradle                         # 26.2 Loom buildscript
│   └── gradle.properties                    # 26.2 Dependency properties
└── Stew Stacker Addon v26.3/
    └── stew-stacker-addon/                  # Minecraft 26.3 anchor root project
        ├── src/main/java/                   # 26.3 Java sources
        ├── src/main/resources/              # 26.3 Assets & configs
        ├── build.gradle                     # 26.3 Loom buildscript
        └── gradle.properties                # 26.3 Dependency properties
```

---

## 5. Addon Hook Integration Example

To register custom stack size overrides in your own mod using Stack Size Adjuster's API:
```java
// Register custom override in your ModInitializer
net.instantgratification.stacksizeadjuster.util.StackSizeManager.registerOverride(
    (item, originalSize) -> {
        if (item == net.minecraft.world.item.Items.MUSHROOM_STEW) {
            return 32; // Custom override
        }
        return -1; // Fallback to default
    }
);
```

---

## 6. Related Documentation Links
* Return to the [[Main Wiki Portal|Home]].
* Inspect [[26.2 Developer Setup & Toolchain|26.2-Developer-Setup-and-Building]].
* Inspect [[26.3 Developer Setup & Toolchain|26.3-Developer-Setup-and-Building]].
* Review the [[Version Compatibility Matrix|Version-Compatibility]].
