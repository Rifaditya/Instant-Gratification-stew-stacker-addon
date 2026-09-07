# 🍲 스튜 스태킹 및 섭취 인체공학 (Minecraft 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 면책 조항**: 본 위키의 문서는 CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 최신 미출시 커밋이나 개발 기능을 포함할 수 있는 **저장소의 현재 소스 코드 상태**를 반영합니다.

## 1. Official Infobox
| Parameter | Technical Details |
| :--- | :--- |
| **Subsystem Name** | Stew Stacking & Consumption Ergonomics Engine |
| **Implementation Class** | `StewStackerManager.java` (`getModifiedStackSize`) |
| **Registration Interface** | `CustomStackSizeOverride` (Stack Size Adjuster API) |
| **Target Item Types** | `MUSHROOM_STEW`, `RABBIT_STEW`, `BEETROOT_SOUP`, `SUSPICIOUS_STEW` |
| **Controlling GameRule** | `stew-stacker-addon:stew_limit` (Default: `16`) |
| **Upper Bound Limit** | `Integer.MAX_VALUE` (2,147,483,647) |
| **Recommended Safe Ceiling** | `39,768,215` (prevents Large Chest 32-bit integer overflow) |
| **Bowl Return Item** | `minecraft:bowl` (Wooden Bowl) |

---

## 2. Step-by-Step Player Survival Workflow

1. **Acquiring & Crafting Stews**:
   Craft or gather Mushroom Stew, Rabbit Stew, Beetroot Soup, or Suspicious Stew. As stews enter your inventory, identical items automatically coalesce into stacks up to the active `stewLimit` (default: 16).

2. **Eating Stews in Survival**:
   Hold the stacked stew item in your main hand or off-hand and hold right-click to eat.
   * **Consumption Phase**: The stack count decrements by 1.
   * **Bowl Return Phase**: The empty wooden bowl (`minecraft:bowl`) is immediately deposited into your inventory.
   * **Inventory Overflow Safety**: If your inventory is completely packed, the empty bowl cleanly spawns into the world at your feet with zero item deletion.
   * **Final Item Consumption**: When you consume the last remaining stew (count $= 1$), the empty bowl remains in your active hand.

3. **Storage & Chest Management**:
   Stews can be sorted, moved, and deposited into chests, barrels, hoppers, and shulker boxes in full stacks up to the configured limit.

---

## 3. Mathematical Formulas & Storage Density

### Storage Compression Multiplier ($C$)
$$C = \frac{S_{\text{limit}}}{S_{\text{vanilla}}} = S_{\text{limit}}$$

For default settings ($S_{\text{limit}} = 16$):
$$C = 16\times \text{ more food per inventory slot}$$

### Container Storage Capacities
$$\text{Capacity}_{\text{chest}} = 27 \times S_{\text{limit}}$$
$$\text{Capacity}_{\text{double\_chest}} = 54 \times S_{\text{limit}}$$
$$\text{Capacity}_{\text{player\_inventory}} = 36 \times S_{\text{limit}}$$

| Container Type | Slots | Vanilla Capacity ($S=1$) | Modded Default ($S=16$) | Storage Gain |
| :--- | :---: | :---: | :---: | :---: |
| **Player Hotbar** | 9 | 9 stews | 144 stews | $+135$ stews |
| **Main Inventory** | 27 | 27 stews | 432 stews | $+405$ stews |
| **Single Chest / Barrel** | 27 | 27 stews | 432 stews | $+405$ stews |
| **Large Double Chest** | 54 | 54 stews | 864 stews | $+810$ stews |
| **Shulker Box** | 27 | 27 stews | 432 stews | $+405$ stews |

### The 32-Bit Integer Safe Ceiling ($S_{\text{safe}}$)
$$S_{\text{safe}} = \left\lfloor \frac{2^{31} - 1}{54} \right\rfloor = 39{,}768{,}215$$

---

## 4. Visual ASCII Diagrams & State Machine

```
       [ Item Stack Size Query: getModifiedStackSize(item, original) ]
                                     |
                                     v
                             Is original <= 0?
                            /                 \
                          YES                  NO
                          /                     \
                    Return original        Is item a Stew or Soup?
                                           /                     \
                                         YES                      NO
                                         /                         \
                                Return stewLimit                Return -1
                                  (Default: 16)             (Continue chain)
```

---

## 5. 전역 및 외부 내비게이션
* [[🍲 Minecraft 26.2 포털로 돌아가기|ko_kr-26.2-Home]]
* [[📡 26.2 네트워크 동기화 및 페이로드 읽기|ko_kr-26.2-Network-Synchronization-and-Payloads]]
* [[⚙️ 26.2 구성 및 동적 게임 규칙 읽기|ko_kr-26.2-Configuration-and-GameRules]]
* [[🏛️ 26.2 아키텍처 및 애드온 확장 훅 읽기|ko_kr-26.2-Architecture-and-Addon-Hooks]]
