# AimOptimizer_Enhanced Documentation

## Overview
`AimOptimizer_Enhanced` is a client-side Minecraft mod designed to enhance player aiming capabilities. It provides an automated aim-locking mechanism that helps players target entities (players and mobs) more precisely.

## Core Features
- **Aim Assistance**: Automatically locks or nudges the player's crosshair towards the nearest entity within range and field of view.
- **Two Modes**: 
    - **Normal**: Subtle assistance with moderate locking strength.
    - **Enhanced**: Stronger assistance for more precise and aggressive aiming.
- **Easy Access**: A custom button in the Pause Menu allows for quick access to the mod's configuration.
- **Command Support**: Full control via chat commands.

## Components

### Java Classes
- [AimOptimizer_Enhanced.java](file:///c:/Users/USER/Documents/Mod%20Making/Mods/Aim_Optimizer/aimoptimizer_enhanced-template-1.21.4/src/main/java/com/raunakyadav_justchillplays/aimoptimizer_enhanced/AimOptimizer_Enhanced.java): Main entry point for the mod.
- [ModState.java](file:///c:/Users/USER/Documents/Mod%20Making/Mods/Aim_Optimizer/aimoptimizer_enhanced-template-1.21.4/src/main/java/com/raunakyadav_justchillplays/aimoptimizer_enhanced/ModState.java): Manages the mod's configuration state (enabled/disabled, aim mode).
- [AimOptimizer_EnhancedClient.java](file:///c:/Users/USER/Documents/Mod%20Making/Mods/Aim_Optimizer/aimoptimizer_enhanced-template-1.21.4/src/main/java/com/raunakyadav_justchillplays/aimoptimizer_enhanced/client/AimOptimizer_EnhancedClient.java): Client-side initializer that registers events and commands.
- [AimOptimizer.java](file:///c:/Users/USER/Documents/Mod%20Making/Mods/Aim_Optimizer/aimoptimizer_enhanced-template-1.21.4/src/main/java/com/raunakyadav_justchillplays/aimoptimizer_enhanced/client/AimOptimizer.java): Contains the core mathematical logic for target finding and aim smoothing.
- [ModMenuScreen.java](file:///c:/Users/USER/Documents/Mod%20Making/Mods/Aim_Optimizer/aimoptimizer_enhanced-template-1.21.4/src/main/java/com/raunakyadav_justchillplays/aimoptimizer_enhanced/client/ModMenuScreen.java): Implements the GUI for the mod's settings, including "About" and "Help" dialogs.
- [ModCommands.java](file:///c:/Users/USER/Documents/Mod%20Making/Mods/Aim_Optimizer/aimoptimizer_enhanced-template-1.21.4/src/main/java/com/raunakyadav_justchillplays/aimoptimizer_enhanced/client/ModCommands.java): Registers the `/aimoptimizer` command and its subcommands.
- [GameMenuScreenMixin.java](file:///c:/Users/USER/Documents/Mod%20Making/Mods/Aim_Optimizer/aimoptimizer_enhanced-template-1.21.4/src/main/java/com/raunakyadav_justchillplays/aimoptimizer_enhanced/mixin/client/GameMenuScreenMixin.java): Injects the "AimOptimizer_Enhanced" button into the vanilla Pause Menu.

### Assets & Configs
- [fabric.mod.json](file:///c:/Users/USER/Documents/Mod%20Making/Mods/Aim_Optimizer/aimoptimizer_enhanced-template-1.21.4/src/main/resources/fabric.mod.json): Mod metadata and entrypoint registration.
- [aimoptimizer_enhanced.client.mixins.json](file:///c:/Users/USER/Documents/Mod%20Making/Mods/Aim_Optimizer/aimoptimizer_enhanced-template-1.21.4/src/main/resources/aimoptimizer_enhanced.client.mixins.json): Mixin configuration for client-side injections.
- [en_us.json](file:///c:/Users/USER/Documents/Mod%20Making/Mods/Aim_Optimizer/aimoptimizer_enhanced-template-1.21.4/src/main/resources/assets/aimoptimizer_enhanced/lang/en_us.json): Language file for localization strings.
- `icon.png`: The mod's icon displayed in the Fabric mod list.

## Usage

### Menu Access
Press `ESC` to open the Pause Menu. In the top right corner, click the **AimOptimizer_Enhanced** button to open the mod's configuration menu.

### Commands
- `/aimoptimizer enable`: Activates the aim optimization features.
- `/aimoptimizer disable`: Deactivates the aim optimization features.
- `/aimoptimizer help`: Displays a help message with all available commands.
- `/aimoptimizer about`: Shows information about the mod.
- `/aimoptimizer Developer`: Displays the developer's name.

## Disclaimer
This mod is intended for educational purposes and single-player use. It provides features that are considered unfair in competitive multiplayer environments. Use responsibly.
