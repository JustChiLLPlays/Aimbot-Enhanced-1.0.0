package com.raunakyadav_justchillplays.aimoptimizer_enhanced.client;

import com.raunakyadav_justchillplays.aimoptimizer_enhanced.ModState;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ModMenuScreen extends Screen {
    private final Screen parent;

    public ModMenuScreen(Screen parent) {
        super(Text.literal("AimOptimizer_Enhanced Menu"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int startY = 60;
        int buttonWidth = 200;
        int buttonHeight = 20;
        int spacing = 24;

        // Enable/Disable Toggle
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal(ModState.isEnabled() ? "Disable" : "Enable"),
                button -> {
                    ModState.setEnabled(!ModState.isEnabled());
                    this.clearAndInit();
                })
                .dimensions(centerX - buttonWidth / 2, startY, buttonWidth, buttonHeight)
                .build());

        // Normal Aim
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Normal Aim").formatted(ModState.getMode() == ModState.AimMode.NORMAL ? Formatting.YELLOW : Formatting.WHITE),
                button -> {
                    ModState.setMode(ModState.AimMode.NORMAL);
                    this.clearAndInit();
                })
                .dimensions(centerX - buttonWidth / 2, startY + spacing, buttonWidth, buttonHeight)
                .build());

        // Enhanced Aim
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Enhanced Aim").formatted(ModState.getMode() == ModState.AimMode.ENHANCED ? Formatting.YELLOW : Formatting.WHITE),
                button -> {
                    ModState.setMode(ModState.AimMode.ENHANCED);
                    this.clearAndInit();
                })
                .dimensions(centerX - buttonWidth / 2, startY + spacing * 2, buttonWidth, buttonHeight)
                .build());

        // About Mod
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("About Mod"),
                button -> {
                    if (this.client != null) {
                        this.client.setScreen(new AboutModScreen(this));
                    }
                })
                .dimensions(centerX - buttonWidth / 2, startY + spacing * 3, buttonWidth, buttonHeight)
                .build());

        // Show Help
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Show Help"),
                button -> {
                    if (this.client != null) {
                        this.client.setScreen(new HelpScreen(this));
                    }
                })
                .dimensions(centerX - buttonWidth / 2, startY + spacing * 4, buttonWidth, buttonHeight)
                .build());

        // Close Menu
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Close Menu"),
                button -> this.close())
                .dimensions(centerX - buttonWidth / 2, startY + spacing * 5, buttonWidth, buttonHeight)
                .build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
    }

    @Override
    public void close() {
        if (this.client != null) {
            this.client.setScreen(this.parent);
        }
    }

    // Simple Help Screen
    public static class HelpScreen extends Screen {
        private final Screen parent;

        public HelpScreen(Screen parent) {
            super(Text.literal("Help"));
            this.parent = parent;
        }

        @Override
        protected void init() {
            this.addDrawableChild(ButtonWidget.builder(Text.literal("Back"), button -> this.close())
                .dimensions(this.width / 2 - 100, this.height - 40, 200, 20)
                .build());
        }

        @Override
        public void render(DrawContext context, int mouseX, int mouseY, float delta) {
            super.render(context, mouseX, mouseY, delta);
            context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
            int y = 50;
            context.drawCenteredTextWithShadow(this.textRenderer, "1. Enable the mod to start optimizing your aim.", this.width / 2, y, 0xAAAAAA);
            context.drawCenteredTextWithShadow(this.textRenderer, "2. Choose between Normal and Enhanced mode.", this.width / 2, y + 15, 0xAAAAAA);
            context.drawCenteredTextWithShadow(this.textRenderer, "3. Enhanced mode has stronger lock strength.", this.width / 2, y + 30, 0xAAAAAA);
        }

        @Override
        public void close() {
            if (this.client != null) this.client.setScreen(parent);
        }
    }

    // Simple About Mod Screen
    public static class AboutModScreen extends Screen {
        private final Screen parent;

        public AboutModScreen(Screen parent) {
            super(Text.literal("About Mod"));
            this.parent = parent;
        }

        @Override
        protected void init() {
            this.addDrawableChild(ButtonWidget.builder(Text.literal("Back"), button -> this.close())
                .dimensions(this.width / 2 - 100, this.height - 40, 200, 20)
                .build());
        }

        @Override
        public void render(DrawContext context, int mouseX, int mouseY, float delta) {
            super.render(context, mouseX, mouseY, delta);
            context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
            int y = 50;
            context.drawCenteredTextWithShadow(this.textRenderer, "AimOptimizer_Enhanced", this.width / 2, y, 0xFF5555);
            context.drawCenteredTextWithShadow(this.textRenderer, "This mod is a TRUE UNFAIR CHEAT.", this.width / 2, y + 20, 0xFF0000);
            context.drawCenteredTextWithShadow(this.textRenderer, "Use it at your own risk!", this.width / 2, y + 40, 0xFF0000);
            context.drawCenteredTextWithShadow(this.textRenderer, "Developer: RaunakAkaJustChiLL", this.width / 2, y + 70, 0x55FFFF);
        }

        @Override
        public void close() {
            if (this.client != null) this.client.setScreen(parent);
        }
    }
}
