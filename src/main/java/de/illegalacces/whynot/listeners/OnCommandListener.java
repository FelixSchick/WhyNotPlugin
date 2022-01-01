package de.illegalacces.whynot.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class OnCommandListener implements Listener {
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (event.getMessage().equals("/plugin") || event.getMessage().equals("/pl")) {
            event.getPlayer().sendMessage("Nö");
            event.setCancelled(true);
        }
    }
}
