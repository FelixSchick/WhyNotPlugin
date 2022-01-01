package de.illegalacces.whynot;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

public class TESTListner implements Listener {
    private ArrayList<String> glowedPlayer = new ArrayList<>();
    @EventHandler
    public void onZoom(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_HOE) {
            event.setCancelled(true);
            if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                if (player.isSneaking()) {
                    final PersistentDataContainer persistentDataContainer = player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer();
                    if (persistentDataContainer.has(new NamespacedKey(Whynot.getPlugin(), "Addons"), PersistentDataType.INTEGER_ARRAY)) {
                        byte addonLaserpointer = persistentDataContainer.get(new NamespacedKey(Whynot.getPlugin(), AddOns.LASERPOINTER.getKey()), PersistentDataType.BYTE);
                        if (addonLaserpointer == 1) {
                            for (Player targets : Bukkit.getOnlinePlayers()) {
                                if (targets != player) {
                                    if (player.canSee(targets) && targets.getLocation().distance(player.getLocation()) <= 15) {
                                        if (!glowedPlayer.contains(targets.getName())) {
                                            targets.setGlowing(true);
                                            glowedPlayer.add(targets.getName());
                                            Bukkit.getScheduler().scheduleSyncDelayedTask(Whynot.getPlugin(), new Runnable() {
                                                @Override
                                                public void run() {
                                                    glowedPlayer.remove(targets.getName());
                                                    targets.setGlowing(false);
                                                }
                                            }, 20 * 15);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    final PersistentDataContainer persistentDataContainer = player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer();
                    if (persistentDataContainer.has(new NamespacedKey(Whynot.getPlugin(), "Addons"), PersistentDataType.INTEGER_ARRAY)) {
                        byte addonScope = persistentDataContainer.get(new NamespacedKey(Whynot.getPlugin(), AddOns.SCOPE.getKey()), PersistentDataType.BYTE);
                        if (addonScope == 1) {
                            if (player.getWalkSpeed() == 0.2F) {
                                player.setWalkSpeed(-1.0F);
                            } else {
                                player.setWalkSpeed(0.2F);
                            }
                        }
                    }
                }
                } else {
                    player.getWorld().dropItem(player.getLocation(), new ItemStack(Material.DARK_OAK_BUTTON));
                }
            }
        }

    @EventHandler
    public void handlePlayerInventory(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();

            if (event.getInventory().getType() == InventoryType.PLAYER) {
                player.sendMessage("0.1");
                // && event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null && event.getCursor().getItemMeta()!= null
                if (event.getCursor() != null){
                    if (event.getCurrentItem() == AddOns.LASERPOINTER.getItemStack()){
                        player.sendMessage("1");
                        if(event.getCursor().getType() == Material.IRON_SWORD){
                            player.sendMessage("2");
                            event.getCursor().getItemMeta().getPersistentDataContainer().set(new NamespacedKey(Whynot.getPlugin(), AddOns.LASERPOINTER.getKey()), PersistentDataType.BYTE, (byte) 1);
                            List<String> lore = event.getCursor().getItemMeta().getLore();
                            if (lore.contains("No Addon added.")){
                                lore.remove("No Addon added.");
                                lore.add("Laser Pointer");
                            } else {
                                lore.add("\n Laser Pointer");
                            }
                            event.getCursor().getItemMeta().setLore(lore);
                        }
                    } else if (event.getCurrentItem() == AddOns.SCOPE.getItemStack()){
                        if(event.getCursor().getType() == Material.IRON_SWORD){
                            event.getCursor().getItemMeta().getPersistentDataContainer().set(new NamespacedKey(Whynot.getPlugin(), AddOns.SCOPE.getKey()), PersistentDataType.BYTE, (byte) 1);
                            List<String> lore = event.getCursor().getItemMeta().getLore();
                            if (lore.contains("No Addon added.")){
                                lore.remove("No Addon added.");
                                lore.add("Ziehlrohr");
                            } else {
                                lore.add("\n Ziehlrohr");
                            }
                            event.getCursor().getItemMeta().setLore(lore);
                        }
                    } else if (event.getCurrentItem() == AddOns.SCHALLDÄMPFER.getItemStack()){
                        if(event.getCursor().getType() == Material.IRON_SWORD){
                            event.getCursor().getItemMeta().getPersistentDataContainer().set(new NamespacedKey(Whynot.getPlugin(), AddOns.SCHALLDÄMPFER.getKey()), PersistentDataType.BYTE, (byte) 1);
                            List<String> lore = event.getCursor().getItemMeta().getLore();
                            if (lore.contains("No Addon added.")){
                                lore.remove("No Addon added.");
                                lore.add("Schalldämpfer");
                            } else {
                                lore.add("\n Schalldämpfer");
                            }
                            event.getCursor().getItemMeta().setLore(lore);
                        }
                    }
                }

            }
        }
    }


    }