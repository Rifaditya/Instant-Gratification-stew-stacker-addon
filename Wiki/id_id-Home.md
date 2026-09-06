# 🍲 Instant Gratification: Stew Stacker Addon Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Pernyataan Sumber Repositori**: Dokumentasi dalam Wiki ini mencerminkan **kondisi kode sumber terkini dalam repositori**, yang mungkin mencakup komit terbaru yang belum dirilis pada CurseForge dan Modrinth.

Selamat datang di dokumentasi teknis resmi untuk **Instant Gratification: Stew Stacker Addon**. Diciptakan untuk Minecraft Fabric sebagai ekspansi khusus berperforma tinggi untuk **Stack Size Adjuster**, mod ini membebaskan pemain dari keterbatasan inventaris dengan mengizinkan penumpukan sup dan rebusan (Sup Jamur, Rebusan Kelinci, Sup Bit, dan Rebusan Misterius).

---

## 🧭 Portal Dokumentasi Multi-Versi

| Versi Minecraft | Versi Mod | Fabric Loader | Tautan Portal |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.0.2+26.2` | `>=0.19.1` | [[👉 Enter Minecraft 26.2 Documentation Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.0.2+26.3` | `>=0.19.3` | [[👉 Enter Minecraft 26.3 Documentation Portal|26.3-Home]] |

---

## ⚡ Filosofi Utama & Pilar Arsitektur

1. **Pembebasan Ruang Inventaris**: Batas tumpukan bawaan ditingkatkan ke 16 (dengan kebebasan penuh hingga 2.147.483.647).
2. **Logistik Pengembalian Mangkuk yang Rapi**: Saat memakan sup dari tumpukan, mangkuk kayu kosong kembali ke inventaris pemain (atau terjatuh aman ke tanah jika penuh).
3. **Sinkronisasi Jaringan Real-Time**: `StewLimitSyncPayload` dan `broadcastFullState()` mencegah item hantu (ghost items).
4. **Koordinasi Addon Otomatis**: Jika dipasang bersama `potion-stacker-addon`, addon ramuan secara otomatis menyerahkan kendali sup ke mod ini.
5. **Bebas Beban Mixin**: Desain murni berbasis API melalui `StackSizeManager.registerOverride`.

---

## 📊 Matriks GameRule Bawaan

| Pengenal GameRule | Tipe | Nilai Bawaan | Rentang Nilai | Item Target |
| :--- | :---: | :---: | :---: | :--- |
| `stew-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2.147.483.647 | Sup Jamur, Rebusan Kelinci, Sup Bit, Rebusan Misterius |

---

## 📚 Pusat Dokumentasi Penting

* [[📊 Version Compatibility Matrix|Version-Compatibility]]
* [[🔧 Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]]
* [[🛠️ Developer Setup & Build Guide|Developer-Setup-and-Building]]
* [[🏠 Return to Main Home Portal|Home]]
