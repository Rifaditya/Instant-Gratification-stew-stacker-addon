# 🍲 Instant Gratification: Stew Stacker Addon Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Заявление об исходном коде репозитория**: Документация в этой Wiki отражает **текущее состояние исходного кода в репозитории**, которое может включать недавние невыпущенные коммиты или разрабатываемые функции до официальных релизов на CurseForge и Modrinth.

Добро пожаловать в официальную документацию **Instant Gratification: Stew Stacker Addon**. Созданный для платформы Minecraft Fabric как высокопроизводительное дополнение для **Stack Size Adjuster**, этот мод избавляет игроков от захламления инвентаря несккладывающимися мисками с супами и рагу, позволяя настраивать стаки для тушёных грибов, тушёного кролика, свекольного супа и подозрительного рагу.

---

## 🧭 Порталы по версиям игры

| Версия Minecraft | Версия мода | Fabric Loader | Ссылка на портал |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.0.2+26.2` | `>=0.19.1` | [[👉 Enter Minecraft 26.2 Documentation Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.0.2+26.3` | `>=0.19.3` | [[👉 Enter Minecraft 26.3 Documentation Portal|26.3-Home]] |

---

## ⚡ Ключевые принципы и архитектура

1. **Освобождение инвентаря**: Лимит стака супов по умолчанию увеличен до 16 с возможностью настройки вплоть до 2 147 483 647.
2. **Удобная логистика возврата мисок**: При употреблении рагу из стака пустая деревянная миска возвращается в инвентарь (или падает под ноги, если инвентарь полон).
3. **Синхронизация по сети без перезагрузок**: `StewLimitSyncPayload` и вызов `broadcastFullState()` предотвращают появление фантомных предметов при смене GameRule.
4. **Сосуществование с другими аддонами**: При совместной установке с `potion-stacker-addon` аддон зелий автоматически передаёт полный контроль над супами Stew Stacker Addon.
5. **Нулевой оверхед (0 миксинов)**: Чистая регистрация через `StackSizeManager.registerOverride`.

---

## 📊 Матрица GameRules по умолчанию

| Идентификатор GameRule | Тип | Значение | Диапазон | Целевые предметы |
| :--- | :---: | :---: | :---: | :--- |
| `stew-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2,147,483,647 | Тушёные грибы, кролик, свекольный суп, подозрительное рагу |

---

## 📚 Основные разделы документации

* [[📊 Version Compatibility Matrix|Version-Compatibility]]
* [[🔧 Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]]
* [[🛠️ Developer Setup & Build Guide|Developer-Setup-and-Building]]
* [[🏠 Return to Main Home Portal|Home]]
