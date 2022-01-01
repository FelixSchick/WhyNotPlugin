package de.illegalacces.whynot;

import de.illegalacces.whynot.commands.*;
import de.illegalacces.whynot.listeners.*;
import de.illegalacces.whynot.utils.PlayerInventorySaver;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Whynot extends JavaPlugin {
    public static Plugin plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getCommand("YouAreaLoser").setExecutor(new YouAreALosserCommand());
        getCommand("TheGod").setExecutor(new TheGodModeCommand());
        getCommand("nickname").setExecutor(new NicknameCommand());
        getCommand("realname").setExecutor(new RealnameCommand());
        getCommand("oneheart").setExecutor(new OneHeartCommand());
        getCommand("unicorn").setExecutor(new UnicornCommand());
        getCommand("invrestore").setExecutor(new InventoryRestoreCommand());
        Bukkit.getPluginManager().registerEvents(new TESTListner(), this);
        Bukkit.getPluginManager().registerEvents(new ChatListner(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListner(), this);
        Bukkit.getPluginManager().registerEvents(new PortalListner(), this);
        Bukkit.getPluginManager().registerEvents(new CreeperOhhhhMannnListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new DonttDropItListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerSwapHandListener(), this);
        Bukkit.getPluginManager().registerEvents(new OnCommandListener(), this);
        update();

    }
    public void update(){
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, () -> {
            for (Player player : Bukkit.getOnlinePlayers()){
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                player.setPlayerListHeaderFooter("§bWilkommen auf \n §4"+Bukkit.getServer().getName() , "§b" + formatter.format(date));
            }
        }, 0, 20);

        Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, () -> {
            for (Player player : Bukkit.getOnlinePlayers()){
                PlayerInventorySaver playerIneventorySaver = new PlayerInventorySaver();
                try {
                    playerIneventorySaver.saveInventory(player);
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent("§7[§b§lSystem§7] | §cInventory saved."));
                } catch (IOException e) {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent("§7[§b§lSystem§7] | §cInventory saving failed."));
                }
            }
        }, 0, 20*60*10);
    }
    public static Plugin getPlugin(){
        return plugin;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
