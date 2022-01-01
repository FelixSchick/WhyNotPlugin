package de.illegalacces.whynot.invs;

import de.illegalacces.whynot.itemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class FriendsGUI {
    public static Inventory inventory;

    public static void createInventory(Player player) {
        inventory = Bukkit.createInventory(player, 3 * 9, "§7» §eFriends");
        for (int i=0; i < 3*9; i++){
            inventory.setItem(i, new itemBuilder(Material.BLACK_STAINED_GLASS_PANE).displayname(" ").build());
        }
        inventory.setItem(4, new itemBuilder(Material.NETHER_STAR).displayname("§7» §2Friends").build());
        inventory.setItem(26, new itemBuilder(Material.BARRIER).displayname("§7» §4§lExit").build());
    }


} 