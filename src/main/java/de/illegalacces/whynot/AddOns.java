package de.illegalacces.whynot;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum AddOns { //Material.SPYGLASS
    SCOPE("Ziehlrohr", new ItemStack(Material.SPYGLASS), "addonScope"),
    LASERPOINTER("Laser Pointer", new ItemStack(Material.REDSTONE_TORCH), "addonLaserpointer"),
    SCHALLDÄMPFER("Schalldämpfer", new ItemStack(Material.LIGHTNING_ROD), "addonSchalldämpfer");

    private AddOns(String name, ItemStack itemStack, String key) {
        this.name = name;
        this.itemStack = itemStack;
        this.key = key;
    }

    private String name;
    private ItemStack itemStack;
    private String key;

    public String getName() {
        return name;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
    public String getKey() {
        return key;
    }
}
