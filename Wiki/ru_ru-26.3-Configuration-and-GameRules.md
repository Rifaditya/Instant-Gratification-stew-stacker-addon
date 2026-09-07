# ⚙️ Конфигурация и игровые правила (Minecraft 26.3)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Отказ от ответственности за источник репозитория**: Документация в этой вики отражает **текущее состояние исходного кода в репозитории**, которое может включать недавние невыпущенные коммиты или разрабатываемые функции, опережающие общедоступные сборки на CurseForge и Modrinth.

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

## 6. Глобальная навигация
* [[🍲 Вернуться к порталу Minecraft 26.3|ru_ru-26.3-Home]]
* [[🍲 Читать: 26.3 Стаки рагу и эргономика питания|ru_ru-26.3-Stew-Stacking-and-Consumption-Ergonomics]]
* [[📡 Читать: 26.3 Сетевая синхронизация и пакеты данных|ru_ru-26.3-Network-Synchronization-and-Payloads]]
* [[🏛️ Читать: 26.3 Архитектура и хуки аддонов|ru_ru-26.3-Architecture-and-Addon-Hooks]]
