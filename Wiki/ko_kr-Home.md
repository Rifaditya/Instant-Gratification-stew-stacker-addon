# 🍲 Instant Gratification: Stew Stacker Addon Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 안내문**: 본 위키의 기술 문서는 **저장소 내의 최신 소스 코드 상태**를 반영하고 있으며, CurseForge 및 Modrinth의 공개 빌드 이전의 최신 커밋 또는 개발 중인 기능을 포함할 수 있습니다.

**Instant Gratification: Stew Stacker Addon**의 공식 기술 문서에 오신 것을 환영합니다. Minecraft Fabric 환경을 위해 **Stack Size Adjuster**의 전용 고성능 확장 모드로 설계된 이 모드는 버섯 스튜, 토끼 스튜, 비트 수프, 수상한 스튜를 중첩할 수 있도록 하여 인벤토리 슬롯을 극대화합니다.

---

## 🧭 다중 버전 문서 포털

| Minecraft 대상 버전 | 모드 버전 | Fabric Loader | 포털 바로가기 |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.0.2+26.2` | `>=0.19.1` | [[👉 Enter Minecraft 26.2 Documentation Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.0.2+26.3` | `>=0.19.3` | [[👉 Enter Minecraft 26.3 Documentation Portal|26.3-Home]] |

---

## ⚡ 핵심 설계 철학 및 기술 요소

1. **인벤토리 공간 해방**: 기본 스택 크기를 16으로 확장하며 최대 2,147,483,647까지 자유로운 구성 지원.
2. **직관적인 빈 그릇 반환**: 스택에서 스튜를 섭취할 때 빈 나무 그릇이 인벤토리로 안전하게 반환됩니다(인벤토리가 가득 찬 경우 발밑에 안전하게 드롭).
3. **실시간 네트워크 동기화**: `StewLimitSyncPayload` 및 `broadcastFullState()`를 통해 유령 아이템 발생 방지.
4. **원활한 애드온 공존**: `potion-stacker-addon`과 함께 설치 시 포션 애드온이 스튜 처리를 자동으로 양보합니다.
5. **Mixin 오버헤드 0**: `StackSizeManager.registerOverride`를 활용한 순수 API 연동 구조.

---

## 📊 기본 GameRule 매트릭스

| GameRule 식별자 | 타입 | 기본값 | 유효 범위 | 대상 아이템 |
| :--- | :---: | :---: | :---: | :--- |
| `stew-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2,147,483,647 | 버섯 스튜, 토끼 스튜, 비트 수프, 수상한 스튜 |

---

## 📚 필수 문서 허브

* [[📊 Version Compatibility Matrix|Version-Compatibility]]
* [[🔧 Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]]
* [[🛠️ Developer Setup & Build Guide|Developer-Setup-and-Building]]
* [[🏠 Return to Main Home Portal|Home]]
