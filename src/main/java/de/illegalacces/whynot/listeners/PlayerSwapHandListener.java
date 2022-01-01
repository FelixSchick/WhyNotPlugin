package de.illegalacces.whynot.listeners;

import de.illegalacces.whynot.invs.MainGUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class PlayerSwapHandListener implements Listener {
    @EventHandler
    public void onSwapHand(PlayerSwapHandItemsEvent event){
        MainGUI.createMainInventory(event.getPlayer());
        event.getPlayer().openInventory(MainGUI.inventory);
        event.setCancelled(true);
    }
}
