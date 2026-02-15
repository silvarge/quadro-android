# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Quadro is a to-do application for Android built with Kotlin and Jetpack Compose. The project uses modern Android development practices with Gradle version catalogs for dependency management.

**Application ID**: `com.todo.quadro`
**Min SDK**: 24 (Android 7.0)
**Target SDK**: 36
**Compile SDK**: 36.1

## Build Commands

### Building the Project
```bash
./gradlew build
```

### Running Tests
```bash
# Run unit tests
./gradlew test

# Run instrumented tests (requires connected device/emulator)
./gradlew connectedAndroidTest

# Run specific test class
./gradlew test --tests com.todo.quadro.ExampleUnitTest
```

### Installing the App
```bash
# Install debug build
./gradlew installDebug

# Install and run
./gradlew installDebug && adb shell am start -n com.todo.quadro/.MainActivity
```

### Cleaning the Project
```bash
./gradlew clean
```

## Project Architecture

### Technology Stack
- **UI Framework**: Jetpack Compose with Material3
- **Language**: Kotlin 2.0.21
- **Build System**: Gradle 9.0.1 with Kotlin DSL
- **Dependency Management**: Gradle Version Catalogs (gradle/libs.versions.toml)

### Source Structure
```
app/src/
├── main/java/com/todo/quadro/
│   ├── MainActivity.kt          # Main entry point with Compose setup
│   └── ui/theme/                # Theme configuration
│       ├── Color.kt             # Color definitions
│       ├── Theme.kt             # Material3 theme with dynamic color support
│       └── Type.kt              # Typography configuration
├── test/                        # Unit tests
└── androidTest/                 # Instrumented tests
```

### Key Architectural Details

**Compose UI**: The app uses Jetpack Compose for all UI with `enableEdgeToEdge()` for modern edge-to-edge display.

**Theme System**: `QuadroTheme` in ui/theme/Theme.kt supports:
- Light and dark themes via `isSystemInDarkTheme()`
- Dynamic color on Android 12+ (API 31+)
- Material3 color schemes

**MainActivity**: Uses `ComponentActivity` with `setContent` to host the Compose UI hierarchy. All composables should be wrapped in `QuadroTheme`.

### Dependency Management

All dependencies are managed through the version catalog at `gradle/libs.versions.toml`. To add new dependencies:

1. Add version in `[versions]` section
2. Add library in `[libraries]` section
3. Reference in `app/build.gradle.kts` using `libs.` prefix

Example: `implementation(libs.androidx.core.ktx)`

## Development Notes

### Compose Best Practices
- Use `@Preview` annotations for composable previews
- Leverage `Modifier` parameters for flexible layouts
- Material3 components are available through the BOM dependency

### Testing
- Unit tests go in `app/src/test/`
- Instrumented tests go in `app/src/androidTest/`
- Test runner: AndroidJUnitRunner for instrumented tests

### Build Configuration
- ProGuard is disabled for release builds (set `isMinifyEnabled = false`)
- Java compatibility: Java 11
- Compose is enabled via `buildFeatures { compose = true }`
