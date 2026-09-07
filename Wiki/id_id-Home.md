# 🍲 Instant Gratification: Stew Stacker Addon Wiki

🌐 **Languages**: [[🏠 Beranda Wiki|id_id-Home]] | [[🏠 Beranda Wiki|id_id-Home]] | [[🏠 Beranda Wiki|id_id-Home]] | [[🏠 Beranda Wiki|id_id-Home]] | [[🏠 Beranda Wiki|id_id-Home]] | [[🏠 Beranda Wiki|id_id-Home]] | [[🏠 Beranda Wiki|id_id-Home]] | [[🏠 Beranda Wiki|id_id-Home]] | [[🏠 Beranda Wiki|id_id-Home]] | [[🏠 Beranda Wiki|id_id-Home]] | [[🏠 Beranda Wiki|id_id-Home]]

> 📌 **Pernyataan Sumber Repositori**: Dokumentasi dalam Wiki ini mencerminkan **kondisi kode sumber terkini dalam repositori**, yang mungkin mencakup komit terbaru yang belum dirilis pada CurseForge dan Modrinth.

Selamat datang di dokumentasi teknis resmi untuk **Instant Gratification: Stew Stacker Addon**. Diciptakan untuk Minecraft Fabric sebagai ekspansi khusus berperforma tinggi untuk **Stack Size Adjuster**, mod ini membebaskan pemain dari keterbatasan inventaris dengan mengizinkan penumpukan sup dan rebusan (Sup Jamur, Rebusan Kelinci, Sup Bit, dan Rebusan Misterius).

---

## 🧭 Portal Dokumentasi Multi-Versi

| Versi Minecraft | Versi Mod | Fabric Loader | Tautan Portal |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.0.2+26.2` | `>=0.19.1` | [[🏠 Beranda Wiki|id_id-Home]] |
| **Minecraft 26.3** | `1.0.2+26.3` | `>=0.19.3` | [[🏠 Beranda Wiki|id_id-Home]] |

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

* [[📊 Matriks Kompatibilitas Versi|id_id-Version-Compatibility]]
* [[🔧 Panduan Pemecahan Masalah & FAQ|id_id-Troubleshooting-and-FAQ]]
* [[🛠️ Pengaturan Pengembang & Panduan Build Terpadu|id_id-Developer-Setup-and-Building]]
* [[🏠 Beranda Wiki|id_id-Home]]
