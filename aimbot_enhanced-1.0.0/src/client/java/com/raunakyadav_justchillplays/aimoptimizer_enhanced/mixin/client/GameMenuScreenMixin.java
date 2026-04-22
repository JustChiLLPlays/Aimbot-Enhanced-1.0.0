package com.raunakyadav_justchillplays.aimoptimizer_enhanced.mixin.client;

import com.raunakyadav_justchillplays.aimoptimizer_enhanced.client.ModMenuScreen;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public abstract class GameMenuScreenMixin extends Screen {
    protected GameMenuScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("RETURN"))
    private void addAimOptimizerButton(CallbackInfo ci) {
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("AimOptimizer_Enhanced"),
                button -> {
                    if (this.client != null) {
                        this.client.setScreen(new ModMenuScreen(this));
                    }
                })
                .dimensions(this.width - 160, 10, 150, 20)
                .build());
    }
}
