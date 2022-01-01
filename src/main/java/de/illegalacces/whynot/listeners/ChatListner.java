package de.illegalacces.whynot.listeners;

import de.illegalacces.whynot.AddOns;
import de.illegalacces.whynot.Whynot;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.awt.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ChatListner implements Listener {
    @EventHandler
    public void onChat(PlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        if (message.startsWith("?")){
            for (Player target : Bukkit.getOnlinePlayers()){
                player.setGlowing(false);
                player.setInvisible(false);
                if (target.hasPermission("server.admin")){
                    if (!message.replace("?", "").equalsIgnoreCase("")){
                        target.spigot().sendMessage(new TextComponent("§8[§4Reports§8] "+player.getDisplayName()+" | " +message.replace("?", "")));
                        event.setCancelled(true);
                    }

                }
            }

        } else if (message.startsWith("@")){
            for (Player player1 : Bukkit.getOnlinePlayers()){
                if (message.startsWith("@"+ player1.getName())){
                    player1.sendMessage("§8[§4TESTI§8] "+player.getDisplayName()+" | " +"§l§4@"+ player1.getName()+" §7| " + message.replace("@" + player1.getName(), ""));
                } else {
                    player1.sendMessage("§8[§4TESTI§8] "+player.getDisplayName()+" | " +message.replace("@", ""));
                }
                event.setCancelled(true);
            }
        } else if (message.startsWith("!!!")){
            player.getInventory().addItem(AddOns.LASERPOINTER.getItemStack());
            player.getInventory().addItem(AddOns.SCOPE.getItemStack());
            player.getInventory().addItem(AddOns.SCHALLDÄMPFER.getItemStack());
            player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
        } else {
            event.setCancelled(true);
            for (Player target : Bukkit.getOnlinePlayers()){
                if (player.getPersistentDataContainer().has(new NamespacedKey(Whynot.getPlugin(), "nick"), PersistentDataType.STRING)){
                    String nickname = player.getPersistentDataContainer().get(new NamespacedKey(Whynot.getPlugin(), "nick"), PersistentDataType.STRING);
                    target.sendMessage("§8"+ nickname + "§7 | " + message);
                } else {
                    target.sendMessage("§8"+ player.getName() + "§7 | " + message);
                }

            }
        }
    }
}
