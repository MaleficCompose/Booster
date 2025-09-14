# Booster - Kotlin Multiplatform Compose Library

Always reference these instructions first and fallback to search or bash commands only when you encounter unexpected information that does not match the info here.

## Overview

Booster is a Kotlin Multiplatform library that provides an object-oriented and grid-based wrapper for Jetpack Compose. It targets JVM, Android, iOS, JavaScript, and WebAssembly platforms. The project is a library template built with modern development tools and Maven Central publishing capabilities.

## Working Effectively

### Prerequisites and Setup
- Requires JDK 17 or higher (project uses JDK 17)
- Uses Gradle 9.0.0 with configuration cache enabled
- Git must be available for version control operations
- For iOS development: Xcode required (macOS only)

### Essential Commands

#### Build and Validation
- `./gradlew build` -- NEVER CANCEL: Takes 11 seconds for clean build, up to 4 minutes with dependencies. Set timeout to 5+ minutes.
- `./gradlew clean build` -- NEVER CANCEL: Takes 11 seconds for full clean build. Set timeout to 5+ minutes for safety.
- `./gradlew allTests` -- Takes 3 seconds for all platform tests. NEVER CANCEL: Set timeout to 2+ minutes.
- `./gradlew check` -- Takes 8 seconds. Runs all verification tasks including tests and linting.

#### Code Quality and Formatting
- `./gradlew lintKotlin` -- Takes 1.5 seconds. Runs Kotlin code linting.
- `./gradlew formatKotlin` -- Takes 4.5 seconds. Formats Kotlin code automatically.
- ALWAYS run `./gradlew formatKotlin` and `./gradlew lintKotlin` before committing or the CI (.github/workflows/gradle.yml) will fail.

#### Documentation
- `./gradlew dokkaGenerate` -- NEVER CANCEL: Takes 28 seconds. Generates API documentation. Set timeout to 2+ minutes.

#### Platform-Specific Testing
- `./gradlew jvmTest` -- Takes 1.5 seconds. Runs JVM-specific tests.
- `./gradlew jsTest` -- Runs JavaScript tests (requires Chromium for Karma).
- `./gradlew wasmJsTest` -- Runs WebAssembly tests.
- `./gradlew iosSimulatorArm64Test` -- Runs iOS simulator tests (macOS only).

#### Publishing (Requires Secrets)
- `./gradlew publishToMavenLocal` -- Publishes to local Maven repository for testing.
- `./gradlew publishToMavenCentral` -- Publishes to Maven Central (requires GPG keys and Sonatype credentials).
- Publishing commands will FAIL without proper GPG_KEY_ID, GPG_PASSPHRASE, GPG_PRIVATE_KEY, and SONATYPE_TOKEN_XML secrets configured.

## Project Structure

### Key Directories
- `/library/` -- Main library module containing all source code
- `/library/src/commonMain/kotlin/` -- Common multiplatform code
  - `container/` -- Grid-based layout containers (GridContainer, ColumnContainer, etc.)
  - `node/` -- UI components (ButtonNode, TextNode, ImageNode, etc.)
  - `modifier/` -- Styling and modifier system (UIModifier, Styles)
  - `grid/` -- Grid positioning system (GridConfig, GridPosition)
  - `util/` -- Utility classes and helpers
- `.github/workflows/` -- CI/CD pipelines for testing, documentation, and publishing
- `gradle/libs.versions.toml` -- Centralized dependency version management

### Configuration Files
- `gradle.properties` -- Project configuration (developer info, Maven coordinates, versions)
- `build.gradle.kts` -- Root build configuration
- `library/build.gradle.kts` -- Library-specific build configuration with multiplatform targets
- `settings.gradle.kts` -- Gradle project settings

## Development Workflow

### Making Changes
1. ALWAYS run the baseline commands first to understand the current state:
   ```bash
   ./gradlew build
   ./gradlew allTests
   ```

2. Make your code changes in the appropriate directory under `/library/src/commonMain/kotlin/`

3. ALWAYS validate your changes immediately:
   ```bash
   ./gradlew compileKotlinJvm    # Quick compile check
   ./gradlew formatKotlin        # Format code
   ./gradlew lintKotlin         # Check code style
   ./gradlew build              # Full build
   ./gradlew allTests           # Run tests
   ```

4. For documentation changes:
   ```bash
   ./gradlew dokkaGenerate      # Generate docs
   ```

### Validation Scenarios
Since this is a library template, there are no sample applications to run. However, you can validate functionality by:

1. **Testing Library Compilation**: Create test code that uses the library APIs to ensure they compile correctly:
   ```kotlin
   // Example validation code (don't commit):
   val container = GridContainer()
   container.build {
       grid(rows = 3, columns = 3)
       text("Hello", at = GridPosition(0, 0))
       button("Click", at = GridPosition(1, 0), onClick = { println("Clicked!") })
   }
   ```

2. **Platform Compilation**: Test that the library compiles for all supported platforms:
   ```bash
   ./gradlew compileKotlinJvm
   ./gradlew compileKotlinJs
   ./gradlew compileKotlinAndroid
   ./gradlew compileKotlinIosSimulatorArm64  # macOS only
   ```

3. **Publishing Test**: Verify local publishing works:
   ```bash
   ./gradlew publishToMavenLocal
   ```

## Library Usage Patterns

### Core Components
- **GridContainer**: Main layout container with grid-based positioning
- **UINode**: Base class for all UI components
- **UIModifier**: Styling and modification system
- **GridPosition**: Defines position and span within a grid

### Example API Usage
```kotlin
val container = GridContainer()
container.build {
    grid(rows = 10, columns = 10)
    
    text("Title", at = GridPosition(0, 0))
    button("Submit", at = GridPosition(1, 0), onClick = { /* action */ })
    input("Enter text", at = GridPosition(2, 0), onValueChange = { /* handle */ })
}
```

## Common Issues and Solutions

### Build Issues
- **"Cannot perform signing task"**: This is expected for local development. Publishing requires GPG secrets.
- **"Configuration was resolved during configuration time"**: Performance warning that can be ignored during development.
- **Long build times**: First build downloads dependencies. Subsequent builds use Gradle cache and are much faster.

### Platform-Specific Issues
- **iOS targets fail**: Requires macOS with Xcode installed
- **JavaScript tests fail**: Requires Chromium browser for Karma test runner
- **WebAssembly compilation issues**: Ensure all Kotlin/JS dependencies are WASM-compatible

### CI/CD Integration
- CI runs on multiple platforms: Ubuntu (JVM, JS, WASM, Android) and macOS (iOS)
- All matrix targets must pass: `jvmTest`, `jsTest`, `wasmJsTest`, `iosSimulatorArm64Test`, `testDebugUnitTest`, `testReleaseUnitTest`
- Automatic publishing triggers on workflow_dispatch or new releases

## Time Expectations (Using Configuration Cache)

- **Quick feedback loop**: `./gradlew compileKotlinJvm` - 1 second
- **Code formatting**: `./gradlew formatKotlin` - 3 seconds  
- **Code linting**: `./gradlew lintKotlin` - 1 second
- **All tests**: `./gradlew allTests` - 1 second (with cache)
- **Check task**: `./gradlew check` - 1 second (with cache)
- **Documentation**: `./gradlew dokkaGenerate` - 1 second (with cache), 28 seconds initial generation
- **Full build**: `./gradlew build` - 11 seconds clean, 4 minutes with fresh dependencies
- **CI pipeline**: Full matrix test suite takes ~10-15 minutes across all platforms

NEVER CANCEL long-running commands. If a build appears to hang, wait at least 5 minutes for builds and 2 minutes for tests before investigating alternatives.