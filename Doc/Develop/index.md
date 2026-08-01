# Developer Documentation

Welcome to the **Stew Stacker Addon** developer guide.

## 📁 System Overview

- **[Getting Started](Getting-Started/index.md)**: Environment setup and Gradle build instructions.
- **[Architecture](Architecture/Architecture.md)**: Architectural breakdown and override registration flow.
- **[Concept](Concept/concept_stew_stacker_addon.md)**: Design philosophy and mechanics specifications.

## 🔗 Key Integrations

- **[Stack Size Adjuster](https://github.com/Rifaditya/Instant-Gratification-stack-size-adjuster)**: Base mod providing stack size modification hooks (`StackSizeManager.registerOverride`).
- **[DasikLibrary](https://github.com/Rifaditya/DasikLibrary)**: Dynamic GameRule registration (`DynamicGameRuleManager`) and config loading (`ConfigHelper`).
