# 🍲 Minecraft 26.2 Documentation Portal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **リポジトリソース免責事項**：本 Wiki ドキュメントは**リポジトリ内の現在のソースコード状態**を反映しており、CurseForge および Modrinth での公開ビルドに先駆けた最新の未リリースコミットや開発中の機能を含む場合があります。

**Instant Gratification: Stew Stacker Addon** の **Minecraft 26.2**（対象：`MC 26.1.2 / 26.2`）向け技術ドキュメントポータルへようこそ。このツリー内のすべてのドキュメントは、このリリース向けの正確なバイトコードマッピング、Loom 依存関係、および仕様を反映しています。

---

## 🧭 Minecraft 26.2 ナビゲーションマトリクス

| 機能 / サブシステム | 説明 | 専用 Wiki ページ |
| :--- | :--- | :--- |
| **シチューのスタックと消費人間工学** | シチュースタック仕様、空のボウル返還ロジック、インベントリ圧縮計算 | [[26.2 シチューのスタックと消費人間工学|ja_jp-26.2-Stew-Stacking-and-Consumption-Ergonomics]] |
| **ネットワーク同期とペイロード** | S2C ペイロードライフサイクル、ハンドシェイクパケット、動的メニュー更新 | [[26.2 ネットワーク同期とペイロード|ja_jp-26.2-Network-Synchronization-and-Payloads]] |
| **設定と動的ゲームルール** | 全 GameRule と YACL v3 オプションの完全リファレンス | [[26.2 設定と動的ゲームルール|ja_jp-26.2-Configuration-and-GameRules]] |
| **アーキテクチャ設計と拡張フック** | パッケージアーキテクチャ、ゼロ Mixin 設計、CustomStackSizeOverride | [[26.2 アーキテクチャ設計と拡張フック|ja_jp-26.2-Architecture-and-Addon-Hooks]] |
| **開発環境セットアップとツールチェーン** | JDK 25 開発環境、Gradle 9.3+ ビルドコマンド、Loom 構成 | [[26.2 開発環境セットアップとツールチェーン|ja_jp-26.2-Developer-Setup-and-Building]] |

---

## 📊 技術仕様情報ボックス

| パラメータ | バージョン仕様 |
| :--- | :--- |
| **Minecraft Release Target** | `MC 26.1.2 / 26.2` |
| **Mod SemVer Release** | `1.0.2+26.2` |
| **Fabric Loader Requirement** | `>=0.19.1` |
| **Java Platform** | OpenJDK 25 (Hotspot 64-bit) |
| **Fabric API Dependency** | `0.150.1+26.2` |
| **DasikLibrary Dependency** | `>=1.8.3` |
| **Stack Size Adjuster Dependency** | `>=1.4.10+26.2` |
| **Mixin Footprint** | 0 Mixins (Pure Callback Delegation) |
| **Primary Network Payload** | `stew-stacker:sync_limit` |

---

## 🍲 コアサブシステムのハイライト

1. **すべてのシチューとスープに対応**：キノコシチュー、ウサギシチュー、ビートルートスープ、怪しいシチューすべてに 1 から 2,147,483,647（初期値: 16）のスタックを適用。
2. **直感的なボウル返還**：スタックから飲食時、空のボウルは自動的にインベントリに入り、満杯の場合は安全に足元へドロップ。
3. **動的ゲームルール連携**：`stew-stacker-addon:stew_limit` により、再起動なしでゲーム内で即時変更可能。
4. **排他的権威と共存**：`potion-stacker-addon` と共存時、本アドオンがシチューの全制御を排他的に担当し競合ゼロ。

---

## 🔗 グローバルリンク
* [[🏠 メインポータルへ戻る|ja_jp-Home]]
* [[📊 バージョン互換性マトリクスを確認|ja_jp-Version-Compatibility]]
* [[🔧 トラブルシューティング & FAQ ガイドを参照|ja_jp-Troubleshooting-and-FAQ]]
