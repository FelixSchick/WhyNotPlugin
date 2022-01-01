package de.illegalacces.whynot.listeners;

import de.illegalacces.whynot.Items;
import de.illegalacces.whynot.Whynot;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class JoinListner implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        for (Player all : Whynot.plugin.getServer().getOnlinePlayers()){
            if (player.hasPlayedBefore()){
                event.setJoinMessage("");
                TextComponent textComponent = new TextComponent("§b[System] §7| §e " + player.getDisplayName() + " ist grade gejoint.");
                textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "Hi"));

                all.spigot().sendMessage(textComponent);
            } else {
                event.setJoinMessage("");
                TextComponent textComponent = new TextComponent("§b[System] §7| §e " + player.getDisplayName() + " ist neu gejoin. Helft ihn wenn er fragen hat.");
                textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "Hi wie kann ich helfen?"));

                all.spigot().sendMessage(textComponent);
                //event.setJoinMessage("§b[System] §7| §e " + player.getDisplayName() + " ist neu gejoin. Helft ihn wenn er fragen hat.");
            }
        }



        if (player.getPersistentDataContainer().has(new NamespacedKey(Whynot.getPlugin(), "nick"), PersistentDataType.STRING)){
            String nickname = player.getPersistentDataContainer().get(new NamespacedKey(Whynot.getPlugin(), "nick"), PersistentDataType.STRING);
            player.setPlayerListName(nickname);
            player.setDisplayName(nickname);
            player.setCustomName(nickname);
            player.setCustomNameVisible(true);
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            player.setPlayerListHeaderFooter("§bWilkommen auf \n §4"+Bukkit.getServer().getName() , "§b" + formatter.format(date));

        } else {
            player.setPlayerListName(player.getName());
            player.setDisplayName(player.getName());
            player.setCustomName(player.getName());
            player.setCustomNameVisible(true);
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            player.setPlayerListHeaderFooter("§bWilkommen auf \n §4"+Bukkit.getServer().getName() , "§b" + formatter.format(date));
        }

        Player randomPlayer = Bukkit.getOnlinePlayers().stream().findAny().get();
        if (randomPlayer != player){
            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) head.getItemMeta();
            meta.setDisplayName("§4 Head by " + randomPlayer.getDisplayName());
            meta.setOwner(randomPlayer.getName());
            head.setItemMeta(meta);

            player.getInventory().setItem(39, head);
        }

        player.getInventory().clear();
        player.getInventory().setItem(0, Items.SPAWN_ITEM.getItemStack());
        player.getInventory().setItem(4, Items.SHOP_ITEM.getItemStack());
        player.getInventory().setItem(7, Items.DATENSCHUTZ_ITEM.getItemStack());
        player.getInventory().setItem(8, Items.FRIENDS_ITEM.getItemStack());

        if (player.hasPermission("system.admin"))
            player.getInventory().setItem(2, Items.ADMIN_TOOL_ITEM.getItemStack());
    }
}
