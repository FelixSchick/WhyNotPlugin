package de.illegalacces.whynot.listeners;

import de.illegalacces.whynot.Items;
import de.illegalacces.whynot.invs.FriendsGUI;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK ||event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem().equals(Items.SPAWN_ITEM.getItemStack())){
                event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§b[System] §7| §b Teleportation startet..."));
                //event.getPlayer().sendMessage("§b[System] §7| §b Teleportation startet...");
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 60));
                event.getPlayer().teleport(event.getPlayer().getWorld().getSpawnLocation());
                event.setCancelled(true);
            } else if (event.getItem().equals(Items.SHOP_ITEM.getItemStack())){
                TextComponent shop = new TextComponent("§cClicke §b[HIER] §cum zum shop zu kommen.");
                shop.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://shop.lostify.net/"));
                event.getPlayer().spigot().sendMessage(shop);
                event.setCancelled(true);
            } else if (event.getItem().equals(Items.FRIENDS_ITEM.getItemStack())){
                FriendsGUI.createInventory(event.getPlayer());
                event.getPlayer().openInventory(FriendsGUI.inventory);
                event.setCancelled(true);
            } else if (event.getItem().equals(Items.DATENSCHUTZ_ITEM.getItemStack())){
                TextComponent main = new TextComponent("§7Clicke ");
                TextComponent part2 = new TextComponent("§b[HIER]");
                part2.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://www.felix-photografik.de/"));
                TextComponent part3 = new TextComponent(" §7um zum Impressum/dem Datenschutz zu kommen.");
                main.addExtra(part2);
                main.addExtra(part3);
                event.getPlayer().spigot().sendMessage(main);
                event.setCancelled(true);
            } else if (event.getItem().equals(Items.ADMIN_TOOL_ITEM.getItemStack())) {
                event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§cJAAA"));
            }
        }
    }
}
