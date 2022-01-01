package de.illegalacces.whynot;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public enum Items {

    SPAWN_ITEM(new itemBuilder(Material.NETHER_STAR).displayname("§b» Spawn").glow().build()),
    SHOP_ITEM(new itemBuilder(Material.CHEST).displayname("§c» Shop").glow().build()),
    FRIENDS_ITEM(new itemBuilder(Material.PLAYER_HEAD).displayname("§e» Freunde").glow().build()),
    DATENSCHUTZ_ITEM(new itemBuilder(Material.BOOK).displayname("§7» Datenschutz").build()),
    ADMIN_TOOL_ITEM(new itemBuilder(Material.END_CRYSTAL).displayname("§7» §4ADMIN TOOL").build());

    private Items(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    private ItemStack itemStack;

    public ItemStack getItemStack() {
        return itemStack;
    }
}
