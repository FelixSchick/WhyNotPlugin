package de.illegalacces.whynot.commands;

import de.illegalacces.whynot.Whynot;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

import javax.swing.text.PlainDocument;

public class NicknameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length == 0){
                player.getPersistentDataContainer().set(new NamespacedKey(Whynot.getPlugin(), "nick"), PersistentDataType.STRING, args[0]);
                String nickname = player.getPersistentDataContainer().get(new NamespacedKey(Whynot.getPlugin(), "nick"), PersistentDataType.STRING);
                player.setPlayerListName(nickname);
                player.sendMessage("§7Dein nick name ist jetzt: "+ args[0]);
            } else if (player.hasPermission("nickname.premium")){
                String name = "";
                for (int i=0; i < args.length; i++){
                    if (name == ""){
                        name = args[i].replace("&", "§");
                    } else {
                        name = name + " " + args[i].replace("&", "§");
                    }
                }
                player.getPersistentDataContainer().set(new NamespacedKey(Whynot.getPlugin(), "nick"), PersistentDataType.STRING, name);
                String nickname = player.getPersistentDataContainer().get(new NamespacedKey(Whynot.getPlugin(), "nick"), PersistentDataType.STRING);
                player.setPlayerListName(nickname);
                player.sendMessage("§7Dein nick name ist jetzt: "+ name.replace("&", "§"));
            }


        }
        return false;
    }
}