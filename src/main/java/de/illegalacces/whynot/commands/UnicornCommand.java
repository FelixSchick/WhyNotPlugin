package de.illegalacces.whynot.commands;

import de.illegalacces.whynot.itemBuilder;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import java.util.List;

public class UnicornCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("system.unicorn")) {
                player.getInventory().setItem(39, new itemBuilder(Material.END_ROD).displayname("§7» Unicorn").build());
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 1);
                player.sendMessage("§b[System] §7| §cYou are a unicorn.");
            }
        }
        return false;
    }
}