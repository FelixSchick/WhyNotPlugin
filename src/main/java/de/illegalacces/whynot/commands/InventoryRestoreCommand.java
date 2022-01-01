package de.illegalacces.whynot.commands;

import de.illegalacces.whynot.utils.PlayerInventorySaver;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

import java.io.IOException;

public class InventoryRestoreCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("system.InvRestore")) {
                if (args.length >= 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    PlayerInventorySaver playerInventorySaver = new PlayerInventorySaver();
                    try {
                        playerInventorySaver.restoreInventory(target);
                        player.sendMessage("§7[§b§lSystem§7] | §cInventory restore successful.");
                    } catch (IOException e) {
                        player.sendMessage("§7[§b§lSystem§7] | §cInventory restore failed.");
                    }
                } else {
                    player.sendMessage("nö");
                }
            }
        }
        return false;
    }
}