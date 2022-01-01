package de.illegalacces.whynot.commands;

import de.illegalacces.whynot.Whynot;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class RealnameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length == 0){
                for (Player target : Bukkit.getOnlinePlayers()){
                    if (target.getPersistentDataContainer().has(new NamespacedKey(Whynot.getPlugin(), "nick"), PersistentDataType.STRING)){
                        if (target.getPersistentDataContainer().get(new NamespacedKey(Whynot.getPlugin(), "nick"), PersistentDataType.STRING).equals(args[0])){
                            player.sendMessage(target.getName() + " Er ist " + args[0]);
                        }
                    }
                }
            }else if (args.length >= 1){
                for (Player target : Bukkit.getOnlinePlayers()){
                    if (target.getPersistentDataContainer().has(new NamespacedKey(Whynot.getPlugin(), "nick"), PersistentDataType.STRING)){
                        String name = "";
                        for (int i=0; i < args.length; i++){
                            if (name == ""){
                                name = args[i].replace("&", "§");
                            } else {
                                name = name + " " + args[i].replace("&", "§");
                            }
                        }
                        if (target.getPersistentDataContainer().get(new NamespacedKey(Whynot.getPlugin(), "nick"), PersistentDataType.STRING).equals(name)){
                            player.sendMessage("§f§l" +target.getName() + "§7 ist " + name);
                        }
                    }
                }
            }

        }
        return false;
    }
}
