<p align="center">
  <a href="https://discord.gg/EV99bgAFqb"><img src="https://img.shields.io/badge/Discord-Join_Community-5865F2?style=for-the-badge&logo=discord&logoColor=white" alt="Join Discord"></a>
  <a href="https://modrinth.com/mod/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
  <img src="https://img.shields.io/badge/Environment-Server_&_Client-success?style=for-the-badge" alt="Server & Client">
  <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&logo=java" alt="Java 25">
  <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License GPLv3">
  <img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft 26.2+">
</p>

# 🍲 Stew Stacker Addon

> **"Hearty Meals Made Practical. Stack Mushroom Stews, Rabbit Soups, and Suspicious Stews."**

---

## 📖 Introduction

Minecraft features some of the most charming, rich culinary recipes in gaming: hearty Mushroom Stews, protein-packed Rabbit Stews, Beetroot Soups, and enigmatic Suspicious Stews brewed with wild meadow flowers. Yet almost no survival player ever carries them past the first day. Why? Because bowls of stew cannot stack. Carrying 5 bowls of rabbit stew consumes 5 precious inventory slots, whereas carrying 64 Cooked Beef takes only one.

**Stew Stacker Addon** revitalizes Minecraft's cozy culinary dishes under the **Instant Gratification** design philosophy. It enables all stews and soups to stack up to **16** (or **64**) in inventories, chests, and dispensers. Engineered with secret Suspicious Stew effect preservation (`DataComponents.SUSPICIOUS_STEW_EFFECTS`), automatic empty bowl recovery, and dispenser feeding station support, stew becomes a premier survival food source.

> [!NOTE]
> **1 Jar 1 Version Policy:** I build **1 dedicated JAR for each Minecraft version** (e.g. MC 26.2, MC 26.3). Please download the exact build that matches your Minecraft installation.
> 
> **Addon & Standalone Synergy:** Functions as an optional companion addon for **Stack Size Adjuster** or as a 100% self-contained standalone food mod!

Part of the **Instant Gratification Collection** — mods that respect the player's time.

---

## ✨ Features

### 🥣 Full Culinary Stacking (Up to 16 or 64)
- **All Vanilla Stews Supported:** Mushroom Stew, Rabbit Stew, Beetroot Soup, and Suspicious Stew stack seamlessly up to **16** by default (configurable up to **64**).
- **Suspicious Stew Effect Preservation:** Suspicious stews only stack if they possess the exact same underlying potion effects (e.g. Regeneration from Oxeye Daisy stacks with Oxeye Daisy, but not with Night Vision from Poppies). Zero loss or corruption of secret herbal effects!

### 🌲 Smart Empty Bowl Return Mechanics
- **Single-Bowl Decrement:** Eating a stew from a stack consumes 1 bowl, restores your hunger and saturation, and returns an empty wooden bowl directly to your inventory.
- **Auto-Stacking Empty Bowls:** Returned bowls automatically merge into any existing stack of wooden bowls in your bag. If your inventory is full, the empty bowl drops cleanly at your feet.

### 🐄 Mooshroom Milking Ergonomics
- Right-clicking a Mooshroom or Brown Mooshroom with a stack of empty bowls smoothly milks stew, creating stacked stew bowls directly in your hand.
- Feed small flowers to Brown Mooshrooms and harvest stacks of custom Suspicious Stews for early-game exploration!

---

## 📊 Food Efficiency & Nutrition Benchmark

| Dish / Food Item | Hunger Restored | Saturation Value | Vanilla Stack Limit | Modded Stack Limit | Total Hunger per Slot |
| :--- | :---: | :---: | :---: | :---: | :---: |
| **Rabbit Stew** | 10 (🍗🍗🍗🍗🍗) | 12.0 | 1 bowl | **16 bowls** | **160 hunger** |
| **Mushroom Stew** | 6 (🍗🍗🍗) | 7.2 | 1 bowl | **16 bowls** | **96 hunger** |
| **Beetroot Soup** | 6 (🍗🍗🍗) | 7.2 | 1 bowl | **16 bowls** | **96 hunger** |
| **Cooked Beef** | 8 (🍗🍗🍗🍗) | 12.8 | 64 steak | **64 steak** | 512 hunger |

---

## ⚙️ Native GameRules & Configuration

Configure stew stacking rules dynamically in-game:

| GameRule Key | Type | Default | Valid Range | Description |
| :--- | :---: | :---: | :---: | :--- |
| `stew_stacker:max_stew_stack` | `Integer` | `16` | `1 – 64` | Maximum stack size for bowls of stew and soup. |
| `stew_stacker:preserve_suspicious_effects` | `Boolean` | `true` | `true / false` | Enforces matching potion effects before allowing suspicious stews to stack. |
| `stew_stacker:bowl_return_behavior` | `Enum` | `INVENTORY_OR_DROP` | `INVENTORY / DROP / VOID` | Handling of empty wooden bowls after eating. |

---

## 📖 In-Depth How-To & Gameplay Playbook

### Step 1: Installation & Setup
1. Install **Fabric Loader** and **Fabric API** for Minecraft 26.2+ / 26.3+.
2. Place `stew-stacker-addon-x.y.z+<version>.jar` into your `mods/` directory.
3. Launch Minecraft. Bowls of stew in chests and inventories now stack automatically!

### Step 2: Creating Suspicious Stew Kits
- Find a Brown Mooshroom and feed it an **Oxeye Daisy** (for Regeneration) or **Cornflower** (for Jump Boost).
- Milk it with a stack of empty bowls: you now have a stack of compact, instant-healing meals that rival Golden Apples in the early game!

---

## ☕ Support & Creator Community

I am an independent solo developer creating lightweight, vanilla-enhancing mods that respect your time and game performance. If Stew Stacker Addon warms your campfires, consider supporting future development:

<p align="center">
  <a href="https://ko-fi.com/rifaditya"><img src="https://img.shields.io/badge/Ko--fi-Support_on_Ko--fi-F16061?style=for-the-badge&logo=ko-fi&logoColor=white" alt="Support on Ko-fi"></a>
  <a href="https://sociabuzz.com/rifaditya"><img src="https://img.shields.io/badge/SocioBuzz-Support_Creator-00A651?style=for-the-badge" alt="Support on SocioBuzz"></a>
  <a href="https://saweria.co/rifaditya"><img src="https://img.shields.io/badge/Saweria-Support_Local-FFA500?style=for-the-badge" alt="Support on Saweria"></a>
</p>

> [!TIP]
> **🇮🇩 Indonesian Local Payment Note:** Indonesian supporters can also support my development work directly using local payment options (**GoPay, OVO, Dana, QRIS, LinkAja**) via **Saweria** or **SocioBuzz**!

Join our official Discord community for live development updates, early test builds, and friendly support:
- 💬 **Discord Community:** [https://discord.gg/EV99bgAFqb](https://discord.gg/EV99bgAFqb)

---

## 📜 Metadata & Permissions

| Property | Value |
| :--- | :--- |
| **Mod Name** | Stew Stacker Addon |
| **Namespace / Mod ID** | `stew_stacker` |
| **License** | GNU General Public License v3.0 (GPLv3) |
| **Side Safety** | Server & Client (Synchronized) |
| **Source Code** | [GitHub Repository](https://github.com/Rifaditya/Instant-Gratification-stew-stacker-addon) |
| **Issue Tracker** | [GitHub Issues](https://github.com/Rifaditya/Instant-Gratification-stew-stacker-addon/issues) |

> [!IMPORTANT]
> **📦 Modpack Permissions & Distribution:**<br>
> You are fully welcome to include this mod in any modpack on any platform! However, the mod file must be downloaded directly through official distribution channels (**Modrinth** or **CurseForge**). Re-uploading, mirroring, or redistributing the original mod JAR to third-party mirror sites, scraper portals, or unauthorized launchers is strictly prohibited.
> <br><br>
> **⚖️ License & Fork Guidelines (No Zero-Change Re-uploads):**<br>
> This project is open-source under the **GNU GPLv3**. You are fully encouraged to inspect the code, learn from it, and fork the repository to create genuine modifications, substantial feature expansions, or community ports—provided your project remains open-source under GPLv3 with proper attribution.<br>
> **However, straight 1:1 re-uploads, clone forks with no meaningful functional changes, or re-publishing identical builds under different project names (e.g. to farm downloads or rewards) are strictly forbidden.**

---

<div align="center">

**Made with ❤️ for the Minecraft community**

*Part of the Instant Gratification Collection*

</div>
