package de.illegalacces.whynot.listeners;

import de.illegalacces.whynot.Items;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class DonttDropItListener implements Listener {
    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void onMove(InventoryClickEvent event){
        if (event.getWhoClicked() instanceof Player){
            Player player = (Player) event.getWhoClicked();
            if (event.getInventory().getType() == InventoryType.PLAYER && event.getCurrentItem() != null){
                if (event.getCurrentItem().equals(Items.SPAWN_ITEM.getItemStack())) {
                    event.setCancelled(true);
                } else if (event.getCurrentItem().equals(Items.SHOP_ITEM.getItemStack())) {
                    event.setCancelled(true);
                } else if (event.getCurrentItem().equals(Items.FRIENDS_ITEM.getItemStack())) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
