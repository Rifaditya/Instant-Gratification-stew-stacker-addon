# 🍲 Instant Gratification: Stew Stacker Addon Wiki

🌐 **Languages**: [[🏠 Wiki ホーム|ja_jp-Home]] | [[🏠 Wiki ホーム|ja_jp-Home]] | [[🏠 Wiki ホーム|ja_jp-Home]] | [[🏠 Wiki ホーム|ja_jp-Home]] | [[🏠 Wiki ホーム|ja_jp-Home]] | [[🏠 Wiki ホーム|ja_jp-Home]] | [[🏠 Wiki ホーム|ja_jp-Home]] | [[🏠 Wiki ホーム|ja_jp-Home]] | [[🏠 Wiki ホーム|ja_jp-Home]] | [[🏠 Wiki ホーム|ja_jp-Home]] | [[🏠 Wiki ホーム|ja_jp-Home]]

> 📌 **リポジトリソース免責事項**: 本 Wiki の技術ドキュメントは、**リポジトリ内の最新ソースコード状態**を反映しており、CurseForge や Modrinth での公開リリース前の最新コミットや開発中の機能が含まれている場合があります。

**Instant Gratification: Stew Stacker Addon** の公式技術ドキュメントへようこそ。Minecraft Fabric 向けに **Stack Size Adjuster** の専用拡張アドオンとして開発された本 Mod は、キノコシチュー、ウサギシチュー、ビートルートスープ、あやしいシチューをスタック可能にし、インベントリの空きスロットを劇的に解放します。

---

## 🧭 バージョン別ドキュメントポータル

| 対象 Minecraft バージョン | Mod バージョン | Fabric Loader | ポータルリンク |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.0.2+26.2` | `>=0.19.1` | [[🏠 Wiki ホーム|ja_jp-Home]] |
| **Minecraft 26.3** | `1.0.2+26.3` | `>=0.19.3` | [[🏠 Wiki ホーム|ja_jp-Home]] |

---

## ⚡ コア理念と技術的特徴

1. **インベントリの圧迫を解消**: デフォルトでスタック数を 16 に拡張（最大 2,147,483,647 まで自由に設定可能）。
2. **自然なボウル返還ロジック**: スタックから食べた際、空の木のお椀がインベントリへ戻ります（満杯時は足元に安全にドロップ）。
3. **リアルタイムネットワーク同期**: `StewLimitSyncPayload` と `broadcastFullState()` により、ゴーストアイテムの発生を完全に防止。
4. **他アドオンとの円滑な連携**: `potion-stacker-addon` と併用した場合、ポーション側がシチュー処理を自動的に譲渡します。
5. **Mixin オーバーヘッドゼロ**: `StackSizeManager.registerOverride` による純粋な API 連携。

---

## 📊 デフォルト GameRule リファレンス

| GameRule 識別子 | タイプ | デフォルト値 | 設定範囲 | 対象アイテム |
| :--- | :---: | :---: | :---: | :--- |
| `stew-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2,147,483,647 | キノコシチュー、ウサギシチュー、ビートルートスープ、あやしいシチュー |

---

## 📚 関連ドキュメントリンク

* [[📊 バージョン互換性マトリクス|ja_jp-Version-Compatibility]]
* [[🔧 トラブルシューティング & FAQ|ja_jp-Troubleshooting-and-FAQ]]
* [[🛠️ 開発環境セットアップ & 統合ビルドガイド|ja_jp-Developer-Setup-and-Building]]
* [[🏠 Wiki ホーム|ja_jp-Home]]
