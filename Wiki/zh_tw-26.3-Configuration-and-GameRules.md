# ⚙️ 配置與動態遊戲規則 (Minecraft 26.3)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **程式碼倉庫來源免責聲明**：本維基文件反映了**程式碼倉庫中的當前原始碼狀態**，可能包含領先於 CurseForge 與 Modrinth 平臺公開發布版本的最新未發布提交或開發中功能。

## 1. Official Infobox
| Parameter | Technical Details |
| :--- | :--- |
| **Subsystem Name** | Configuration & Dynamic GameRule System |
| **Config File** | `.minecraft/config/stew-stacker.json` |
| **Config Version** | `1` (`public static final int VERSION = 1;`) |
| **Config Manager** | `StewStackerConfig.java` (backed by `ConfigHelper`) |
| **GUI Provider** | YetAnotherConfigLib v3 (`YaclScreenHelper.java`) |
| **ModMenu Bridge** | `ModMenuIntegration.java` (`GuiHelper.getOptionalYaclFactory`) |
| **GameRule Category** | `stew-stacker-addon:stew-stacker-addon` |
| **Player Freedom Range** | $1 \dots 2{,}147{,}483{,}647$ (`Integer.MAX_VALUE`) |
| **Warning Threshold** | Values $> 39{,}768{,}215$ trigger safe ceiling warning |

---

## 2. Step-by-Step Player & Administrator Workflow

1. **Editing Global Defaults (Title Screen)**:
   * Navigate to **Mods** -> **Stew Stacker Addon** -> **Configure** (or click the gear icon).
   * The YACL interface allows configuring `Stew & Soup Limit`.
   * Global configuration changes saved here define the initial default GameRules for **newly created worlds**.

2. **Configuring Active Worlds via Commands**:
   * To change limits in an existing singleplayer world or dedicated server, run:
     `/gamerule stew-stacker-addon:stew_limit <value>`
   * Changes apply immediately without server restart.

3. **In-Game GameRules GUI**:
   * When creating or editing a world, click **Edit Game Rules**.
   * Scroll to the **Stew Stacker Addon** category.
   * Mutate values directly with full integer validation.

---

## 3. Mathematical Formulas & Range Governance

### The Player Agency & Anti-Nanny Invariant
$$D = \{ x \in \mathbb{Z} \mid 1 \le x \le 2^{31}-1 \}$$

### Large Chest Capacity & Integer Overflow Math
$$S_{\text{safe}} = \left\lfloor \frac{2^{31}-1}{54} \right\rfloor = 39{,}768{,}215$$

---

## 4. JSON Configuration Schema
### File Location: `.minecraft/config/stew-stacker.json`
```json
{
  "configVersion": 1,
  "stewLimit": 16
}
```

---

## 5. Exhaustive Reference Matrix

| Identifier | Type | Default | Range | In-Game Command |
| :--- | :---: | :---: | :---: | :--- |
| `stew-stacker-addon:stew_limit` | Integer | `16` | $1 \dots 2{,}147{,}483{,}647$ | `/gamerule stew-stacker-addon:stew_limit <int>` |

---

## 6. 全域性與外部導航
* [[🍲 返回 Minecraft 26.3 門戶|zh_tw-26.3-Home]]
* [[🍲 閱讀 26.3 燉菜堆疊與食用人體工學|zh_tw-26.3-Stew-Stacking-and-Consumption-Ergonomics]]
* [[📡 閱讀 26.3 網路同步與資料負載|zh_tw-26.3-Network-Synchronization-and-Payloads]]
* [[🏛️ 閱讀 26.3 架構設計與擴充鉤子|zh_tw-26.3-Architecture-and-Addon-Hooks]]
