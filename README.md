# Custom Head Block

Fabric mod project targeting Minecraft Java 26.2.

## Planned features
- One placeable custom head block.
- Right-click configuration screen.
- Player name or Nova Skin shared URL input.
- Saved skin data stored with the block and preserved by pick-block / block item copying.

## Build
The GitHub Actions workflow in `.github/workflows/build.yml` builds the project with Java 25 and Gradle 9.6.1 and uploads the resulting JAR as a workflow artifact.

**Status:** project/build scaffold is committed. The gameplay implementation and an in-game verification pass are still in progress; this repository does not yet contain a finished mod JAR.

## Target
- Minecraft Java 26.2
- Fabric Loader 0.19.3
- Fabric API 0.156.0+26.2
