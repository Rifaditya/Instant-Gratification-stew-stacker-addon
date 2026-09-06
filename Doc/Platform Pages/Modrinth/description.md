<p align="center">
  <a href="https://modrinth.com/mod/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
  <a href="https://modrinth.com/mod/dasik-library"><img src="https://img.shields.io/badge/Requires-Dasik_Library-8A2BE2?style=for-the-badge" alt="Requires Dasik Library"></a>
  <a href="https://modrinth.com/mod/ig-stack-size-adjuster"><img src="https://img.shields.io/badge/Requires-Stack_Size_Adjuster-blue?style=for-the-badge" alt="Requires Stack Size Adjuster"></a>
  <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&logo=java" alt="Java 25">
  <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License GPLv3">
  <img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft 26.2+">
</p>

# 🍲 Stew Stacker Addon

> **"Reclaim Your Hotbar. Nourishing Stews, Finally Stackable."**

> [!NOTE]
> **1 Jar 1 Version Policy:** I build **1 dedicated JAR for each Minecraft version** (e.g. MC 26.2, MC 26.3). Please download the exact build that matches your Minecraft installation.
> <br><br>
> **Dependency Requirement:** For modern Minecraft 26.x releases (26.2, 26.3+), this mod requires **Fabric API**, **Dasik Library** (`v1.8.2+`), and **[Stack Size Adjuster](https://modrinth.com/mod/ig-stack-size-adjuster)** (`v1.4.10+26.2`).

Stews and soups in vanilla Minecraft provide exceptional food points and hunger saturation—especially Rabbit Stew, Beetroot Soup, and Suspicious Stew. Yet they are almost entirely ignored by players simply because each bowl consumes an entire inventory slot! Who wants to fill half their backpack with unstackable bowls of soup on an epic adventure?

**Stew Stacker Addon** fixes Minecraft's culinary dilemma permanently. As an official companion addon for **Stack Size Adjuster**, it unlocks clean stackability for Mushroom Stew, Rabbit Stew, Beetroot Soup, and Suspicious Stew up to 16, 64, or any custom value—complete with safe empty wooden bowl returns!

Part of the **Instant Gratification Collection** — mods that respect the player's time.

---

## ✨ Features

### 🍲 Universal Stew & Soup Stacking
Stack hearty meals neatly in your hotbar and food barrels:
- **Mushroom Stew**: The classic mushroom biome comfort food, now stackable for compact expedition rations.
- **Rabbit Stew**: Minecraft's highest-tier nutritional meal (10 hunger points & 12 saturation points) is finally viable for everyday exploration!
- **Beetroot Soup**: Turn neglected beetroot harvests into portable survival staples.
- **Suspicious Stew**: Stack secret concoctions (Regeneration, Saturation, Night Vision, Jump Boost) for quick tactical buffs!

### 🥣 Flawless Wooden Bowl Return Handling
- Consuming a stew from a stack decrements the stack count by 1 and immediately adds an empty wooden bowl (`Items.BOWL`) back into your inventory.
- If your inventory is completely full, the empty wooden bowl drops gently at your feet rather than voiding or deleting items.

### 🔨 Crafting Table & Mooshroom Parity
- Crafting stews with stacked ingredients in crafting tables respects active limits and creates clean stacked outputs.
- Milking Mooshroom cows with wooden bowls stacks freshly harvested stew smoothly without messy inventory overflow!

### 🛡️ 32-Bit Signed Integer Overflow Guard
- Stacking limits can be customized from `1` up to `2,147,483,647`.
- Features an automated safety ceiling warning above `39,768,215` to protect Double Chest save files from signed 32-bit integer overflow deletion bugs.

### 📡 Real-Time Client Inventory Sync
- Automatically broadcasts configured limits to connecting players via `StewLimitSyncPayload`.
- Updates all open container and player inventory screens instantly when GameRules change in-game with zero world reload!

---

## 📊 Quick Reference & Mechanics Matrix

| Food Item | Nutrition & Saturation | Default Stack Limit | Maximum Safe Limit | Tuning GameRule |
| :--- | :---: | :---: | :---: | :--- |
| **Rabbit Stew** | 10 Food / 12 Saturation | **`16`** | `39,768,215` | `stew-stacker-addon:stew_limit` |
| **Mushroom Stew** | 6 Food / 7.2 Saturation | **`16`** | `39,768,215` | `stew-stacker-addon:stew_limit` |
| **Beetroot Soup** | 6 Food / 7.2 Saturation | **`16`** | `39,768,215` | `stew-stacker-addon:stew_limit` |
| **Suspicious Stew** | Variable Effect / High Saturation | **`16`** | `39,768,215` | `stew-stacker-addon:stew_limit` |

---

## 🚀 In-Game Commands & Quick Start

Stew Stacker Addon uses native Minecraft `/gamerule` commands with tab completion:

```text
/gamerule stew-stacker-addon:stew_limit <stack_size>   → Set maximum stack limit for stews & soups (e.g. 16, 64)
```

---

## ⚙️ Configuration (Native GameRules)

> [!IMPORTANT]
> **💡 Config vs. In-Game GameRules:** The global configuration file (`config/stew-stacker-addon.json`) only defines default values for newly created worlds. In existing worlds, change settings in-game via the **Edit Game Rules** UI screen or the `/gamerule` command.

| GameRule Name | Type | Default | Valid Range | Description |
| :--- | :---: | :---: | :---: | :--- |
| `stew-stacker-addon:stew_limit` | `Integer` | `16` | `1` to `2147483647` | Maximum stack size for all stews (mushroom, rabbit, beetroot, suspicious stew). |

---

## 📖 In-Depth How-To & Culinary Playbook

### 1. Drop-In Setup & Requirements
1. Ensure **Stack Size Adjuster** (`v1.4.10+26.2`), **Fabric API**, and **Dasik Library** are installed in your `mods` folder.
2. Drop `stew-stacker-addon-*.jar` into `mods/` and launch Minecraft.
3. Your stews in inventory and chests immediately stack up to 16!

### 2. Live In-Game Tuning vs. Global Baseline
- **For New Worlds**: Edit `config/stew-stacker-addon.json` or configure options in ModMenu + YACL.
- **For Existing Worlds**: Open your world and type `/gamerule stew-stacker-addon:stew_limit 64`. Your inventory and containers refresh dynamically with full 64-stew stacks!

### 3. Making Rabbit Stew Your Primary Rations
- With stackable stews, Rabbit Stew becomes one of the most overpowered survival rations in Minecraft.
- Keep a stack of 16 or 64 Rabbit Stew in your offhand or hotbar for extreme hunger recovery during extensive mining or boss encounters.

### 4. Mooshroom Farm Logistics
- Bring a single stack of 64 wooden bowls to a red or brown Mooshroom cow.
- Right-click repeatedly to milk the cow into a compact, stacked supply of ready-to-eat Mushroom Stew without scattering bowls across your floor.

### 5. Managing Empty Wooden Bowl Recycling
- Eating from a stew stack returns an empty wooden bowl into your inventory.
- Carry a bowl container or feed empty bowls back into your campfire soup stations to cook fresh batches effortlessly!

---

## 🧩 Recommended Sister Mods

If you enjoy **Stew Stacker Addon**, these companion mods from the **Instant Gratification Collection** plug in seamlessly:

* 📦 [**Stack Size Adjuster**](https://modrinth.com/mod/ig-stack-size-adjuster): The foundational mod that enables custom stack sizes across all item categories.
* 🧪 [**Potion Stacker Addon**](https://modrinth.com/mod/ig-potion-stacker-addon): Stack all drinkable, splash, and lingering potions up to 16 or 64.
* 🗃️ [**Item Clumps**](https://modrinth.com/mod/ig-item-clumps): Clusters ground item entities into single lightweight clumps to preserve 60 FPS performance.

> 🌟 *Explore the full [**Instant Gratification Collection**](https://modrinth.com/collection/instant-gratification) for more high-convenience enhancements.*

---

## ☕ Support

If you enjoy the **Instant Gratification Collection**, consider fueling future development!

<p align="center">
  <a href="https://ko-fi.com/dasikigaijin/tip"><img src="https://img.shields.io/badge/Ko--fi-Support%20Me-FF5E5B?style=for-the-badge&logo=ko-fi&logoColor=white" alt="Ko-fi"></a>
  <a href="https://sociabuzz.com/dasikigaijin/tribe"><img src="https://img.shields.io/badge/SocioBuzz-Local_Support-7BB32E?style=for-the-badge" alt="SocioBuzz"></a>
  <a href="https://saweria.co/DasikIgaijinn"><img src="https://img.shields.io/badge/Saweria-Local_Support-FFA500?style=for-the-badge" alt="Saweria"></a>
</p>

> [!NOTE]
> **🇮🇩 Indonesian Users:** SocioBuzz and Saweria support local payment methods (Gopay, OVO, Dana, etc.) if you want to support me without using PayPal/Ko-fi!

> [!TIP]
> **Dedicated Server Hosting Partner:**
> Looking for a reliable server to play with friends? Check out **BisectHosting** for 1-click modpack installations, automated backups, and 24/7 dedicated customer support.

---

## 📜 Credits & Modpack Permissions

| Property | Information |
| :--- | :--- |
| **Creator / Author** | **Dasik** (Rifaditya) |
| **Collection** | Instant Gratification Collection |
| **License** | [GNU General Public License v3.0 (GPLv3)](https://www.gnu.org/licenses/gpl-3.0.html) |
| **Source Code** | [GitHub - Rifaditya/Instant-Gratification-stew-stacker-addon](https://github.com/Rifaditya/Instant-Gratification-stew-stacker-addon) |
| **Issue Tracker** | [GitHub Issues](https://github.com/Rifaditya/Instant-Gratification-stew-stacker-addon/issues) |
| **Documentation / Wiki** | [GitHub Wiki](https://github.com/Rifaditya/Instant-Gratification-stew-stacker-addon/wiki) |

> [!IMPORTANT]
> **📦 Modpack Permissions & Distribution:**<br>
> You are fully welcome to include this mod in any modpack on any platform! However, the mod file must be downloaded directly through official distribution channels (**Modrinth** or **CurseForge**). Re-uploading, mirroring, or redistributing the original mod JAR to third-party mirror sites, scraper portals, or unauthorized launchers is strictly prohibited.
> <br><br>
> **⚖️ License & Fork Guidelines (No Zero-Change Re-uploads):**<br>
> This project is open-source under the **GNU GPLv3**. You are fully encouraged to inspect the code, learn from it, and fork the repository to create genuine modifications, substantial feature expansions, or community ports—provided your project remains open-source under GPLv3 with proper attribution.<br>
> **However, straight 1:1 re-uploads, clone forks with no meaningful functional changes, or re-publishing identical builds under different project names (e.g. to farm downloads or rewards) are strictly forbidden.**

---

<p align="center">
  <strong>Made with ❤️ for the Minecraft community</strong><br>
  <em>Part of the Instant Gratification Collection</em>
</p>
