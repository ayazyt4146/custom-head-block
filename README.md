# Custom Head Block

Fabric mod for Minecraft Java 26.2.

## Current implementation
- Registers one placeable **Custom Head Block** and adds it to the Functional Blocks creative tab.
- Adds a block entity with persistent player-name and skin-URL fields.
- Adds the block model, item model, blockstate, and English name.

## Planned / not yet complete
- Right-click configuration screen with player-name and Nova Skin URL tabs.
- Resolve a Minecraft player profile or Nova Skin shared skin URL into a skin texture.
- Render the configured head in-world.
- Preserve the configured profile when using pick-block and placing the copied block item.

## Build
The GitHub Actions workflow builds with Java 25 and Gradle 9.6.1 and uploads the JAR as a workflow artifact.

**Important:** this is an in-progress implementation, not yet a finished playable mod. A successful Actions build and in-game test are still required before the JAR can be called ready.

## Target
- Minecraft Java 26.2
- Fabric Loader 0.19.3
- Fabric API 0.156.0+26.2
