# Stew Stacker Addon Concept & Specifications

## Overview
**Stew Stacker Addon** is a standalone Fabric addon mod for Stack Size Adjuster. It provides independent stacking configurations specifically for stews and soups, keeping potions, weapons, armor, and beds completely unaffected.

## Mechanics
- Overrides maximum stack size of stews and soups (`MUSHROOM_STEW`, `RABBIT_STEW`, `BEETROOT_SOUP`, and `SUSPICIOUS_STEW`).
- Configurable limits via:
  - `/gamerule stew-stacker-addon:stew_limit` (default: 16)
- Supports dynamic syncing from server to client.
