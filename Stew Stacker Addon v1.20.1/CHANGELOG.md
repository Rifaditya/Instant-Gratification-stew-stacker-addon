# Changelog - Stew Stacker Addon v1.0.0+1.20.1

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.0.0+1.20.1] - 2026-10-23

### Added
- Initial release of Stew Stacker Addon for Minecraft 1.20.1 (Legacy LTS Anchor, Java 17).
- Dynamic stack size customization for Mushroom Stew, Rabbit Stew, Beetroot Soup, and Suspicious Stew.
- Vanilla 1.20.1 bowl consumption recovery mixin via `BowlFoodItemMixin` and `SuspiciousStewItemMixin` (prevents whole stack deletion upon eating).
- Dynamic `/gamerule stew-stacker-addon:stew_limit` with real-time networking container inventory synchronization.
- Seamless integration with Stack Size Adjuster 1.0.1+1.20.1.
- In-game configuration screen support via ModMenu and Dasik Library UniversalConfigScreen.
