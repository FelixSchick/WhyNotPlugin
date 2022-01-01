package de.illegalacces.whynot.listeners;

import de.illegalacces.whynot.Portals;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEnterEvent;

public class PortalListner implements Listener {
    @EventHandler
    public void onEnterPortal(EntityPortalEnterEvent event){
        if (event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if (event.getLocation().distance(Portals.MAIN_PORTAL.getLocation()) <= 6){
                player.teleport(Portals.MAIN_PORTAL.getTargetLocation());
                player.sendMessage("§4upssss!!!");
            }
        }

    }
}
