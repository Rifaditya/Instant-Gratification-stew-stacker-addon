# 🍲 Instant Gratification: Stew Stacker Addon Wiki

🌐 **Languages**: [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]]

> 📌 **Aviso sobre la fuente del repositorio**: La documentación de esta Wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes aún no publicadas en CurseForge o Modrinth.

Bienvenido a la documentación técnica oficial de **Instant Gratification: Stew Stacker Addon**. Diseñado para Minecraft Fabric como una expansión especializada para **Stack Size Adjuster**, este mod libera a los jugadores del desorden en el inventario permitiendo apilar estofados de champiñones, estofados de conejo, sopas de remolacha y estofados sospechosos.

---

## 🧭 Portales de Documentación Multiversión

| Versión de Minecraft | Versión del Mod | Fabric Loader | Enlace al Portal |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.0.2+26.2` | `>=0.19.1` | [[🏠 Inicio de la Wiki|es_es-Home]] |
| **Minecraft 26.3** | `1.0.2+26.3` | `>=0.19.3` | [[🏠 Inicio de la Wiki|es_es-Home]] |

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

* [[📊 Matriz de Compatibilidad de Versiones|es_es-Version-Compatibility]]
* [[🔧 Solución de Problemas y FAQ|es_es-Troubleshooting-and-FAQ]]
* [[🛠️ Configuración de Desarrollador y Compilación|es_es-Developer-Setup-and-Building]]
* [[🏠 Inicio de la Wiki|es_es-Home]]
