# 🍲 Minecraft 26.3 Documentation Portal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Pernyataan Sumber Repositori**: Dokumentasi dalam Wiki ini mencerminkan **status kode sumber saat ini di repositori**, yang mungkin mencakup komit terbaru yang belum dirilis atau fitur dalam tahap pengembangan mendahului build rilis publik di CurseForge dan Modrinth.

Selamat datang di portal dokumentasi teknis **Instant Gratification: Stew Stacker Addon** untuk **Minecraft 26.3** (menargetkan `MC 26.3-snapshot-6 / 26.3`). Seluruh dokumentasi mencerminkan pemetaan bytecode, dependensi Loom, dan spesifikasi fitur yang tepat untuk rilis snapshot ini.

---

## 🧭 Matriks Navigasi Minecraft 26.3

| Fitur / Subsistem | Deskripsi | Halaman Wiki Khusus |
| :--- | :--- | :--- |
| **Penumpukan Rebusan & Ergonomi Konsumsi** | Mekanika penumpukan rebusan, logika pengembalian mangkuk, kompresi penyimpanan | [[26.3 Penumpukan Rebusan & Ergonomi Konsumsi|id_id-26.3-Stew-Stacking-and-Consumption-Ergonomics]] |
| **Sinkronisasi Jaringan & Muatan Data** | Siklus hidup payload S2C, paket jabat tangan, pembaruan menu dinamis | [[26.3 Sinkronisasi Jaringan & Muatan Data|id_id-26.3-Network-Synchronization-and-Payloads]] |
| **Konfigurasi & GameRules Dinamis** | Matriks referensi lengkap semua GameRule dan opsi YACL v3 | [[26.3 Konfigurasi & GameRules Dinamis|id_id-26.3-Configuration-and-GameRules]] |
| **Arsitektur & Kait Ekstensi Addon** | Arsitektur paket, nol mixin, callback CustomStackSizeOverride | [[26.3 Arsitektur & Kait Ekstensi Addon|id_id-26.3-Architecture-and-Addon-Hooks]] |
| **Pengaturan Pengembang & Toolchain** | Lingkungan JDK 25, perintah build Gradle 9.3+, konfigurasi Loom | [[26.3 Pengaturan Pengembang & Toolchain|id_id-26.3-Developer-Setup-and-Building]] |

---

## 📊 Kotak Info Spesifikasi Teknis

| Parameter | Spesifikasi Versi |
| :--- | :--- |
| **Minecraft Release Target** | `MC 26.3-snapshot-6 / 26.3` |
| **Mod SemVer Release** | `1.0.2+26.3` |
| **Fabric Loader Requirement** | `>=0.19.3` |
| **Java Platform** | OpenJDK 25 (Hotspot 64-bit) |
| **Fabric API Dependency** | `0.156.1+26.3` |
| **DasikLibrary Dependency** | `>=1.8.36` |
| **Stack Size Adjuster Dependency** | `>=1.4.18` |
| **Mixin Footprint** | 0 Mixins (Pure Callback Delegation) |
| **Primary Network Payload** | `stew-stacker:sync_limit` |

---

## 🍲 Sorotan Subsistem Utama

1. **Dukungan Penuh Rebusan & Sup**: Sup Jamur, Sup Kelinci, Sup Bit, dan Sup Mencurigakan mendukung batas tumpukan 1 hingga 2.147.483.647 (default: 16).
2. **Pengembalian Mangkuk Intuitif**: Saat memakan tumpukan rebusan, mangkuk kayu kosong kembali ke inventaris atau jatuh aman di kaki tanpa hilang.
3. **GameRules Dinamis**: Modifikasi dalam game tanpa restart melalui `stew-stacker-addon:stew_limit`.
4. **Otoritas Eksklusif**: Saat terpasang bersama `potion-stacker-addon`, mod ini memegang otoritas penuh atas rebusan tanpa konflik.

---

## 🔗 Tautan Global & Eksternal
* [[🏠 Kembali ke Beranda Utama Wiki|id_id-Home]]
* [[📊 Tinjau Matriks Kompatibilitas Versi|id_id-Version-Compatibility]]
* [[🔧 Konsultasikan Panduan Pemecahan Masalah & FAQ|id_id-Troubleshooting-and-FAQ]]
