# 🔧 トラブルシューティング & よくある質問

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **リポジトリソース免責事項**：本 Wiki ドキュメントは**リポジトリ内の現在のソースコード状態**を反映しており、CurseForge および Modrinth での公開ビルドに先駆けた最新の未リリースコミットや開発中の機能を含む場合があります。

## 1. Bowl Return Behavior & Full Inventory Handling
When consuming stews from a stack:
1. **Stack Size > 1**: The stack count decrements by 1, and an empty wooden bowl (`minecraft:bowl`) is deposited into your inventory.
2. **Full Inventory Safety**: If your inventory has zero free slots, the empty bowl is safely dropped at your feet, preventing item deletion.
3. **Last Stew in Stack (Count = 1)**: Consuming the final stew replaces the item in your active hand with the empty bowl.

---

## 2. Coexistence with Potion Stacker Addon
* **Priority Delegation**: Potion Stacker Addon explicitly checks if `stew-stacker-addon` is present:
  ```java
  if (FabricLoader.getInstance().isModLoaded("stew-stacker-addon")) {
      return -1; // Defers stew logic
  }
  ```
* When Stew Stacker Addon is loaded, it takes exclusive, authoritative control over all soup and stew stacking calculations.

---

## 3. Ghost Items & Desynchronization Prevention
When GameRule limits change on a server:
1. **Network Sync Packet**: Server broadcasts `StewLimitSyncPayload` to all connected clients.
2. **Dynamic Menu Refresh**: Server invokes `broadcastFullState()` on container and inventory menus.

```java
if (player.containerMenu != null) {
    player.containerMenu.broadcastFullState();
}
if (player.inventoryMenu != null && player.containerMenu != player.inventoryMenu) {
    player.inventoryMenu.broadcastFullState();
}
```

---

## 4. Maximum Stack Limits & Integer Safety
Under the **Player Agency & Anti-Nanny Invariant**, players and server owners are given total freedom to set stack limits up to `Integer.MAX_VALUE` (2,147,483,647).
* A standard Large Chest has 54 inventory slots.
* If every slot contains 39,768,215 items:
  $$\text{Total Items} = 54 \times 39{,}768{,}215 = 2{,}147{,}483{,}610 \le 2{,}147{,}483{,}647$$
* Setting values greater than 39,768,215 can cause vanilla integer overflow in 32-bit container math. Values below 39,768,215 are 100% mathematically safe across all vanilla containers.

---

## 5. ASCII Diagnostic Decision Tree

```
[ Player Encounters Stew Stacking Issue ]
                     |
                     v
          Is item a Stew or Soup?
         /                       \
       YES                        NO
       /                           \
Check GameRule:             Handled by Vanilla
stew-stacker:stew_limit     or other overrides
  (Default: 16)
```

---

## 6. グローバルリンク
* [[🏠 メインポータルへ戻る|ja_jp-Home]]
* [[📊 バージョン互換性マトリクスを確認|ja_jp-Version-Compatibility]]
* [[⚙️ 26.2 設定と動的ゲームルールを読む|ja_jp-26.2-Configuration-and-GameRules]]
* [[⚙️ 26.3 設定と動的ゲームルールを読む|ja_jp-26.3-Configuration-and-GameRules]]
