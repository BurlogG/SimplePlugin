package com.spongeapi.tutorial.simpleplugin;

import org.slf4j.Logger;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import javax.inject.Inject;

@Plugin(id = "simpleplugin",
        name = "Simple Plugin",
        version = "0.1-SNAPSHOT",
        description = "Тест-плагин!",
        url = "https://spongeapi.com",
        authors = "BurlogG")
public class SimplePlugin {

    @Inject
    private Logger logger;

    @Listener
    public void onGameInit(GameInitializationEvent event) {
        logger.info("Всем привет!");
    }

    @Listener
    public void onPlayerJoin(ClientConnectionEvent.Join event, @Root Player player) {
        String msg = "Привет, " + player.getName();
        player.sendMessage(Text.builder(msg).color(TextColors.WHITE).build());
    }
}
