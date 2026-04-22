package com.raunakyadav_justchillplays.aimoptimizer_enhanced.client;

import com.mojang.brigadier.CommandDispatcher;
import com.raunakyadav_justchillplays.aimoptimizer_enhanced.ModState;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ModCommands {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("aimoptimizer")
            .then(ClientCommandManager.literal("enable").executes(context -> {
                ModState.setEnabled(true);
                context.getSource().sendFeedback(Text.literal("AimOptimizer_Enhanced ENABLED").formatted(Formatting.GREEN));
                return 1;
            }))
            .then(ClientCommandManager.literal("disable").executes(context -> {
                ModState.setEnabled(false);
                context.getSource().sendFeedback(Text.literal("AimOptimizer_Enhanced DISABLED").formatted(Formatting.RED));
                return 1;
            }))
            .then(ClientCommandManager.literal("help").executes(context -> {
                context.getSource().sendFeedback(Text.literal("=== AimOptimizer_Enhanced Help ===").formatted(Formatting.YELLOW));
                context.getSource().sendFeedback(Text.literal("/aimoptimizer enable - Enable the mod"));
                context.getSource().sendFeedback(Text.literal("/aimoptimizer disable - Disable the mod"));
                context.getSource().sendFeedback(Text.literal("/aimoptimizer help - Show this message"));
                context.getSource().sendFeedback(Text.literal("/aimoptimizer about - About the mod"));
                context.getSource().sendFeedback(Text.literal("/aimoptimizer Developer - Show developer info"));
                return 1;
            }))
            .then(ClientCommandManager.literal("about").executes(context -> {
                context.getSource().sendFeedback(Text.literal("AimOptimizer_Enhanced: A TRUE UNFAIR CHEAT.").formatted(Formatting.RED, Formatting.BOLD));
                return 1;
            }))
            .then(ClientCommandManager.literal("Developer").executes(context -> {
                context.getSource().sendFeedback(Text.literal("Developer: RaunakAkaJustChiLL").formatted(Formatting.AQUA));
                return 1;
            }))
        );
    }
}
