package com.raunakyadav_justchillplays.aimoptimizer_enhanced;

public class ModState {
    public static boolean enabled = false;
    public static AimMode mode = AimMode.NORMAL;

    public enum AimMode {
        NORMAL,
        ENHANCED
    }

    public static void setEnabled(boolean enabled) {
        ModState.enabled = enabled;
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setMode(AimMode mode) {
        ModState.mode = mode;
    }

    public static AimMode getMode() {
        return mode;
    }
}
