# Player Guide: Stew Stacker Addon

**Stew Stacker Addon** makes stews and soups stackable in Minecraft, freeing up inventory space for food resources.

---

## ✨ Features

- **Stackable Stews & Soups**: Mushroom Stew, Rabbit Stew, Beetroot Soup, and Suspicious Stew.
- **Custom Limits**: Stack limit configurable from `1` up to `2,147,483,647` (Default: `16`).
- **Dynamic GameRules**: Settings apply live on servers without requiring game restarts.

---

## ⚙️ Configuration

### GameRules (`/gamerule`)

| GameRule | Default | Description |
| :--- | :--- | :--- |
| `stew-stacker-addon:stew_limit` | `16` | Maximum stack size for stews and soups. |

> [!IMPORTANT]
> Config files set defaults for **newly created worlds**. For existing worlds, change settings in-game via `/gamerule` or the GameRules edit GUI screen.

### Optional GUI Configuration
If **YetAnotherConfigLib (YACL)** and **ModMenu** are installed, configure settings via `Mods -> Stew Stacker Addon -> Config`.

---

## ⚠️ Overflow Protection Warning

Setting stack limits above `39,768,215` can cause container total item counts to overflow signed 32-bit integer limits (2.14 billion) inside Large Chests, leading to item deletion. Keep settings at or below `39,768,215`.
