package de.illegalacces.whynot.commands;

import de.illegalacces.whynot.itemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class TheGodModeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("server.god")){
                player.getInventory().addItem(new itemBuilder(Material.DIAMOND_PICKAXE).lore("§7» §43x3").displayname("§7» §43x3").build());
            }
        }
        return false;
    }
}