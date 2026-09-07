# 🍲 Minecraft 26.3 Documentation Portal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 면책 조항**: 본 위키의 문서는 CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 최신 미출시 커밋이나 개발 기능을 포함할 수 있는 **저장소의 현재 소스 코드 상태**를 반영합니다.

**Minecraft 26.3**(`MC 26.3-snapshot-6 / 26.3` 타깃)용 **Instant Gratification: Stew Stacker Addon** 공식 기술 문서 포털에 오신 것을 환영합니다. 이 버전 트리의 모든 문서는 해당 스냅샷의 바이트코드 매핑, Loom 종속성 및 기능 사양을 반영합니다.

---

## 🧭 Minecraft 26.3 내비게이션 매트릭스

| 기능 / 하위 시스템 | 설명 | 전용 위키 페이지 |
| :--- | :--- | :--- |
| **스튜 스태킹 및 섭취 인체공학** | 스튜 스태킹 메커니즘, 빈 그릇 반환 로직, 보관함 압축 계산 | [[26.3 스튜 스태킹 및 섭취 인체공학|ko_kr-26.3-Stew-Stacking-and-Consumption-Ergonomics]] |
| **네트워크 동기화 및 페이로드** | S2C 페이로드 수명 주기, 핸드셰이크 패킷, 메뉴 동적 갱신 | [[26.3 네트워크 동기화 및 페이로드|ko_kr-26.3-Network-Synchronization-and-Payloads]] |
| **구성 및 동적 게임 규칙** | 모든 GameRule 및 YACL v3 옵션의 전체 참조 매트릭스 | [[26.3 구성 및 동적 게임 규칙|ko_kr-26.3-Configuration-and-GameRules]] |
| **아키텍처 및 애드온 확장 훅** | 패키지 아키텍처, 제로 Mixin 설계, CustomStackSizeOverride | [[26.3 아키텍처 및 애드온 확장 훅|ko_kr-26.3-Architecture-and-Addon-Hooks]] |
| **개발자 설정 및 툴체인** | JDK 25 환경, Gradle 9.3+ 빌드 명령, Loom 설정 | [[26.3 개발자 설정 및 툴체인|ko_kr-26.3-Developer-Setup-and-Building]] |

---

## 📊 기술 사양 정보 상자

| 매개변수 | 버전 사양 |
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

## 🍲 핵심 하위 시스템 주요 기능

1. **모든 스튜 및 수프 완벽 지원**: 버섯 스튜, 토끼 스튜, 비트루트 수프, 수상한 스튜 모두 1부터 2,147,483,647까지 스택 크기 지원(기본값: 16).
2. **직관적인 빈 그릇 반환**: 스택에서 섭취 시 빈 나무 그릇이 인벤토리로 자동 반환되며, 인벤토리가 가득 차면 발밑에 안전하게 드롭.
3. **동적 게임 규칙 제어**: `stew-stacker-addon:stew_limit`을 통해 재시작 없이 게임 내 즉각 변경 가능.
4. **독점적 권한과 충돌 제로**: `potion-stacker-addon`과 함께 설치 시 본 모드가 모든 스튜 처리를 독점적으로 제어하여 충돌 방지.

---

## 🔗 전역 및 외부 내비게이션
* [[🏠 위키 메인 포털로 돌아가기|ko_kr-Home]]
* [[📊 전역 버전 호환성 매트릭스 확인|ko_kr-Version-Compatibility]]
* [[🔧 문제 해결 및 FAQ 가이드 확인|ko_kr-Troubleshooting-and-FAQ]]
