package de.illegalacces.whynot.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class CreeperOhhhhMannnListener implements Listener {
    /*@EventHandler
    public void onCreeperExplosion(EntityExplodeEvent event){
        if (event.getEntityType() == EntityType.CREEPER){
            for (Player player : Bukkit.getOnlinePlayers()){
                if (!(event.getLocation().distance(player.getLocation()) <= 10)) {
                    event.setCancelled(true);
                } else {
                    event.getEntity().addPassenger(player);
                    player.sendMessage("Run");
                }
            }
        }
    }*/
    @EventHandler
    public void onEntityInterect(PlayerInteractAtEntityEvent event){
        if (event.getRightClicked().getType() == EntityType.CREEPER) {
            event.getRightClicked().setFreezeTicks(20 * 4);
        } else {
            event.getRightClicked().addPassenger(event.getPlayer());
            event.setCancelled(true);
            event.getRightClicked().setGlowing(true);
        }
    }

}
