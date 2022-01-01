package de.illegalacces.whynot;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

public enum Portals {
    MAIN_PORTAL("Main", new Location(Bukkit.getWorld("world"), 1726, 76, 342), new Location(Bukkit.getWorld("world"), 1726, 100, 342));
    private Portals(String name, Location location, Location targetLocation) {
        this.name = name;
        this.location = location;
        this.targetLocation = targetLocation;
    }

    private String name;
    private Location location;
    private Location targetLocation;

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
    public Location getTargetLocation() {
        return targetLocation;
    }
}
