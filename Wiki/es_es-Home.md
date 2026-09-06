# 🍲 Instant Gratification: Stew Stacker Addon Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Aviso sobre la fuente del repositorio**: La documentación de esta Wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes aún no publicadas en CurseForge o Modrinth.

Bienvenido a la documentación técnica oficial de **Instant Gratification: Stew Stacker Addon**. Diseñado para Minecraft Fabric como una expansión especializada para **Stack Size Adjuster**, este mod libera a los jugadores del desorden en el inventario permitiendo apilar estofados de champiñones, estofados de conejo, sopas de remolacha y estofados sospechosos.

---

## 🧭 Portales de Documentación Multiversión

| Versión de Minecraft | Versión del Mod | Fabric Loader | Enlace al Portal |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.0.2+26.2` | `>=0.19.1` | [[👉 Enter Minecraft 26.2 Documentation Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.0.2+26.3` | `>=0.19.3` | [[👉 Enter Minecraft 26.3 Documentation Portal|26.3-Home]] |

---

## ⚡ Filosofía Central y Pilares Arquitectónicos

1. **Liberación del Inventario**: Tamaño de pila por defecto aumentado a 16 (con libertad total hasta 2.147.483.647).
2. **Logística Ergonómica de Cuencos**: Al comer de una pila, el cuenco vacío vuelve al inventario (o cae al suelo si está lleno).
3. **Sincronización de Red en Tiempo Real**: `StewLimitSyncPayload` y `broadcastFullState()` eliminan por completo los objetos fantasma.
4. **Coexistencia Inteligente**: Si se instala junto a `potion-stacker-addon`, el complemento de pociones cede automáticamente el control de los estofados a este mod.
5. **Cero Impacto de Mixins**: Arquitectura orientada a API mediante `StackSizeManager.registerOverride`.

---

## 📊 Matriz de GameRules por Defecto

| Identificador GameRule | Tipo | Valor | Rango | Ítems afectados |
| :--- | :---: | :---: | :---: | :--- |
| `stew-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2.147.483.647 | Estofado de champiñones, conejo, sopa de remolacha, sospechoso |

---

## 📚 Enlaces Esenciales de Documentación

* [[📊 Version Compatibility Matrix|Version-Compatibility]]
* [[🔧 Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]]
* [[🛠️ Developer Setup & Build Guide|Developer-Setup-and-Building]]
* [[🏠 Return to Main Home Portal|Home]]
