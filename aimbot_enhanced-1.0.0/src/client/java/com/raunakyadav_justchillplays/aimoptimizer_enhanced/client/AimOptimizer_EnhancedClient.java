package com.raunakyadav_justchillplays.aimoptimizer_enhanced.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class AimOptimizer_EnhancedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(AimOptimizer::tick);
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> ModCommands.register(dispatcher));
    }
}
