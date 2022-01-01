package de.illegalacces.whynot.commands;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.map.MapView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class YouAreALosserCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("whynot.youarealosser")){
                if (args.length >= 2){
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null){
                        if (args[1].equals("sneaking")){
                            target.setSneaking(true);
                        }else
                            target.setSprinting(true);
                        target.sendBlockChange(target.getLocation(), Material.RED_TERRACOTTA, (byte) 0);
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List< String > onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("whynot.youarealosser")) {
                if (args.length == 1) {
                    List< String > complete = new ArrayList<>();
                    complete.add("sneaking");
                    return complete;
                }
            }
        }
        return new ArrayList<>();
    }
}