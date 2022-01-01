package de.illegalacces.whynot.listeners;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equalsIgnoreCase("§7» §eFriends")) {
            if (event.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE) {
                event.setCancelled(true);
            } else if (event.getCurrentItem().getType() == Material.BARRIER) {
                player.closeInventory();
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§7» §4Inventory closed."));
            } else if (event.getCurrentItem().getType() == Material.NETHER_STAR) {
                event.setCancelled(true);
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1F);
            }
        } else if (event.getView().getTitle().equalsIgnoreCase("§7» §bMain")) {
            if (event.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE) {
                event.setCancelled(true);
            } else if (event.getCurrentItem().getType() == Material.BARRIER) {
                player.closeInventory();
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§7» §4Inventory closed."));
            }
        } else {
            event.setCancelled(true);
        }
    }
}
