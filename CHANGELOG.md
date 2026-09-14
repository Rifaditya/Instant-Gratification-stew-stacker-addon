# Changelog

## [1.0.2+26.3] - 2026-09-14

### Added
- **Minecraft 26.3 Port**: Initial release supporting Minecraft 26.3 snapshot-6.
- **Dependency Upgrades**: Compiled against Fabric Loader 0.19.3, Fabric API 0.156.1+26.3, DasikLibrary 1.8.39, and Stack Size Adjuster 1.4.18+26.3.
- **Java 25 Baseline**: Upgraded toolchain and execution target to Java 25.

## [1.0.2+26.2] - 2026-08-10

### Fixed
- **CustomStackSizeOverride Registration**: Explicit registration with CustomStackSizeOverride to prevent legacy BiFunction fallback issues.

## [1.0.1+26.2] - 2026-08-10

### Fixed
- **Stack Size Adjuster Override Alignment**: Updated manager override contract to signal explicit handling and prevent fallback to general item stack limits.

## [1.0.0+26.2] - 2026-07-15

### Added
- **Stew Stacker Addon Initial Release**: Initial release of Stew Stacker Addon mod with independent custom stack limits for stews/soups configurable via YACL and GameRules.
