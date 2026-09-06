# 🔧 Troubleshooting & Frequently Asked Questions

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## 1. Bowl Return Logistics Upon Consumption

### Q: What happens to the empty wooden bowl when I eat from a stack of stews?
**A:** In vanilla Minecraft, stews are unstackable, so consuming a stew simply replaces the item in your hand with an empty bowl. With Stew Stacker Addon:
1. **Stack Count Greater Than 1**: When consuming 1 stew from a stack (e.g., $16 \to 15$), the stew stack count decrements by 1 in your hand, and 1 empty wooden bowl (`minecraft:bowl`) is automatically added to your inventory.
2. **Full Inventory Handling**: If all 36 inventory slots are completely occupied and no empty bowl stack can absorb the item, the wooden bowl is cleanly and safely spawned into the game world at the player's feet. Zero bowls are ever lost or deleted.
3. **Consuming the Final Stew**: When consuming the last remaining stew in a stack (count $= 1$), the empty wooden bowl replaces the consumed stew directly in the player's active hand.

---

## 2. Container Menu Syncing & Eliminating Ghost Items

### Q: What prevents ghost items when GameRules change on a dedicated server?
**A:** In vanilla Minecraft, mutating item stack limits dynamically while players have inventories or containers open can cause "ghost items" (the client calculates slots based on stale limits, causing items to rubber-band or split erratically). Stew Stacker Addon completely resolves this via two guarantees in `StewStackerManager.java`:
1. **Network Sync Packet**: Whenever `stew_limit` changes, the server broadcasts a `StewLimitSyncPayload` to all connected players.
2. **Dynamic Full Menu Refresh**: The server immediately invokes `broadcastFullState()` on both the player's active `containerMenu` and `inventoryMenu`:
```java
if (player.containerMenu != null) {
    player.containerMenu.broadcastFullState();
}
if (player.inventoryMenu != null && player.containerMenu != player.inventoryMenu) {
    player.inventoryMenu.broadcastFullState();
}
```
This forces all client slot caches to refresh synchronously with zero client desync.

---

## 3. Interaction & Coexistence with Potion Stacker Addon

### Q: Both Potion Stacker Addon and Stew Stacker Addon mention stews. How do they work together?
**A:** There is zero conflict between the two addons:
* **Dedicated Authority**: `stew-stacker-addon` is the dedicated, authoritative mod for Mushroom Stew, Rabbit Stew, Beetroot Soup, and Suspicious Stew.
* **Automatic Deference**: When `potion-stacker-addon` is installed alongside `stew-stacker-addon`, Potion Stacker Addon detects Stew Stacker via `FabricLoader.getInstance().isModLoaded("stew-stacker-addon")` and returns `-1` for all stews, cleanly delegating 100% of stew calculations to Stew Stacker Addon.
* **Fallback Role**: Potion Stacker Addon's stew rule only acts as a temporary fallback when Stew Stacker Addon is absent.

---

## 4. Maximum Stack Limits & Integer Safety

### Q: Why does the configuration GUI show a warning at 39,768,215?
**A:** Under the **Player Agency & Anti-Nanny Invariant**, players and server owners are given total freedom to set stack limits up to `Integer.MAX_VALUE` (2,147,483,647).
* However, a standard Large Chest has 54 inventory slots.
* If every slot contains 39,768,215 items:
  $$\text{Total Items} = 54 \times 39{,}768{,}215 = 2{,}147{,}483{,}610 \le 2{,}147{,}483{,}647$$
* Setting values greater than 39,768,215 means a completely full Large Chest can exceed the signed 32-bit integer ceiling ($2^{31}-1$), which can cause vanilla integer overflow, inventory desync, or item deletion in poorly coded container mods. Values below 39,768,215 are 100% mathematically safe across all vanilla containers.

---

## 5. ASCII Diagnostic Decision Tree

```
[ Player Encounters Stew / Soup Stacking ]
                    |
                    v
         Is item a Stew or Soup?
       (Mushroom, Rabbit, Beetroot, Suspicious)
                  /          \
                YES           NO
                /              \
     Query StewStackerManager   Handled by Vanilla
                |              or other overrides
                v
       Return stewLimit
        (Default: 16)
                |
                v
       Player Consumes Stew
        /               \
  Stack > 1           Stack == 1
     /                     \
Decrements stack       Active hand becomes
Bowl to inventory      empty wooden bowl
(or drops if full)
```

---

## 6. Related Documentation Links
* Return to the [[Main Wiki Portal|Home]].
* Inspect the [[Version Compatibility Matrix|Version-Compatibility]].
* Review [[26.2 Configuration & GameRules|26.2-Configuration-and-GameRules]].
* Review [[26.3 Configuration & GameRules|26.3-Configuration-and-GameRules]].
