<p align="center">
    <a href="https://modrinth.com/mod/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
    <a href="https://modrinth.com/mod/stack-size-adjuster"><img src="https://img.shields.io/badge/Requires-Stack_Size_Adjuster-blue?style=for-the-badge" alt="Requires Stack Size Adjuster"></a>
    <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&logo=java" alt="Java 25">
    <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License">
    <img src="https://img.shields.io/badge/Minecraft-26.+-brightgreen?style=for-the-badge" alt="Minecraft 26.+">
</p>

# 🍲 Stew Stacker Addon

**No Backports:** This mod targets **Minecraft 26.+**. Older versions are unsupported.

> **Stack your stews. Consolidate your inventory.**

Tired of stews and soups cluttering your inventory slots and taking up valuable backpack space? **Stew Stacker Addon** is a dedicated addon for **[Stack Size Adjuster](https://modrinth.com/mod/stack-size-adjuster)** that allows mushroom stews, rabbit stews, beetroot soups, and suspicious stews to stack up to a customizable limit. Keep your food resources compact and ready for adventure.

Part of the **Instant Gratification Collection** — mods that respect the player's time.

---

## ✨ Features

### 🍲 Stackable Stews & Soups
Overridden default stack limits specifically for:
- Mushroom Stew
- Rabbit Stew
- Beetroot Soup
- Suspicious Stew

### 🎚️ Customizable Stack Limit
No hardcoded values! Adjust limits dynamically via `/gamerule` or config menus from `1` up to `2,147,483,647`. Default limit: `16`.
- **Overflow Protection Warning**: Features a warning if set above `39,768,215` to prevent container-level signed 32-bit integer overflow deletion bugs.

### 📡 Dynamic GameRules (No Restarts Required)
Configure limits on-the-fly inside dynamic worlds. Server settings automatically sync with connecting client inventories.

---

## ⚙️ Configuration (Native Game Rules)

> [!IMPORTANT]
> **Config vs. In-Game GameRules:**
> The global configuration file only defines **default values for new worlds** at creation time.
> If you have **already created/opened a world**, changing the config file will have no effect. You must change the settings in-game using the **Edit Game Rules** UI screen or the `/gamerule` command.

Configure option in-game using `/gamerule` or via the integrated YACL config GUI:
- `stew-stacker-addon:stew_limit`

---

## 📦 Installation

1. Install **Fabric API**.
2. Install **[Stack Size Adjuster](https://modrinth.com/mod/stack-size-adjuster)** (Required).
3. Download the mod jar and place it in your `mods` folder.
4. Launch the game.

---

## ☕ Support

If you enjoy the **Instant Gratification** collection, consider supporting development!

<p align="center">

[![Ko-fi](https://img.shields.io/badge/Ko--fi-Support%20Me-FF5E5B?style=for-the-badge&logo=ko-fi&logoColor=white)](https://ko-fi.com/dasikigaijin/tip)
[![SocioBuzz](https://img.shields.io/badge/SocioBuzz-Local_Support-7BB32E?style=for-the-badge)](https://sociabuzz.com/dasikigaijin/tribe)
[![Saweria](https://img.shields.io/badge/Saweria-Local_Support-FFA500?style=for-the-badge)](https://saweria.co/DasikIgaijinn)

</p>

> [!NOTE]
> **Indonesian Users:** SocioBuzz and Saweria support local payment methods (Gopay, OVO, Dana, etc.) if you want to support me without using PayPal/Ko-fi!

---

> [!IMPORTANT]
> **📦 Modpack Permissions & Distribution:** You are free to include this mod in any modpack on any platform. However, the mod itself must be downloaded from its official distribution pages on **Modrinth** or **CurseForge**. Re-uploading or redistributing the mod jar file to third-party sites is strictly prohibited unless explicitly permitted by the creator.
> 
> **License & Forks:** Since the source code is licensed under **GNU GPLv3**, you are fully permitted to fork the repository, make modifications, build your own versions, and distribute them under the terms of the GPLv3. The prohibition on third-party redistribution applies exclusively to the official compiled releases/jars published by the original creator (Dasik/Rifaditya). Forks must be published as distinct projects, not direct re-uploads of official builds.

---

## 📜 Credits

| Role | Author |
| :--- | :--- |
| **Creator** | **Dasik (Rifaditya)** |
| **Collection** | Instant Gratification |
| **License** | GPLv3 |

---

<div align="center">

**Made with ❤️ for the Minecraft community**

*Part of the Instant Gratification Collection*

</div>
