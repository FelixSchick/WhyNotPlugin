package de.illegalacces.whynot.utils;

import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.*;
import java.util.logging.Logger;

public abstract class TESTInventoryProvider implements InventoryProvider {
    public SmartInventory INVENTORY;
    public final Logger LOGGER = Logger.getLogger("WeaponInventoryLogger");


    public enum SkullType {
        ZERO("http://textures.minecraft.net/texture/a3a487b1f81c9ecc6e18857c6566529e7efa23eef59814fe57d64df8e2cf1",
                UUID.fromString("15f49744-9b61-46af-b1c3-71c6261a0d0e")),
        ONE("http://textures.minecraft.net/texture/bf61269735f1e446becff25f9cb3c823679719a15f7f0fbc9a03911a692bdd",
                UUID.fromString("15f49744-9b61-46af-b1c2-71c6261a0d0e")),
        TWO("http://textures.minecraft.net/texture/7d81a32d978f933deb7ea26aa326e4174697595a426eaa9f2ae5f9c2e661290",
                UUID.fromString("15f49744-9b61-46af-b1c1-71c6261a0d0e")),
        THREE("http://textures.minecraft.net/texture/ceadaded81563f1c87769d6c04689dcdb9e8ca01da35281cd8fe251728d2d",
                UUID.fromString("15f49744-9b61-46af-b1c0-71c6261a0d0e")),
        FOUR("http://textures.minecraft.net/texture/6c608c2db525d6d77f7de4b961d67e53e9d7bacdaff31d4ca10fbbf92d66",
                UUID.fromString("15f49744-9b61-46af-b1c9-71c6261a0d0e")),
        FIVE("http://textures.minecraft.net/texture/1144c5193435199c135bd47d166ef1b4e2d3218383df9d34e3bb20d9f8e593",
                UUID.fromString("15f49744-9b61-46af-b1c8-71c6261a0d0e")),
        SIX("http://textures.minecraft.net/texture/f61f7e38556856eae5566ef1c44a8cc64af8f3a58162b1dd8016a8778c71c",
                UUID.fromString("15f49744-9b61-46af-b1c7-71c6261a0d0e")),
        SEVEN("http://textures.minecraft.net/texture/6e1cf31c49a24a8f37849fc3c5463ab64cc9bceb6f276a5c44aedd34fdf520",
                UUID.fromString("15f49744-9b61-46af-b1c6-71c6261a0d0e")),
        EIGHT("http://textures.minecraft.net/texture/61c9c09d52debc465c32542c68be42bda6f6753fe1deba257327ac5a0c3ad",
                UUID.fromString("15f49744-9b61-46af-b1c5-71c6261a0d0e")),
        NINE("http://textures.minecraft.net/texture/2dcf39f4bcd98484b0b479a7992d9270fe3a59b9b1a806d7a64ffb5b551ad",
                UUID.fromString("15f49744-9b61-46af-b1c3-71c6261a0d0e")),
        TEN("http://textures.minecraft.net/texture/177a56ce415d7c30808706a94cc2bafa897cb7e486287c337a44af42b928c43",
                UUID.fromString("15f49744-9b61-43af-b1c3-71c6261a0d0e")),
        ELEVEN("http://textures.minecraft.net/texture/28c7ca83fda8ce5e7eec8ee7462ca78ab5f80e9f2f51dd61ad4d75cac3958",
                UUID.fromString("15f49744-9b61-46af-b1c3-73c6261a0d0e")),
        TWELVE("http://textures.minecraft.net/texture/7ee55fbb39ebe498d5286d7afa2af8d4aca4e1cf7594990448b97d062aac",
                UUID.fromString("15f49744-9b61-46af-b1c3-31c6261a0d0e")),
        THIRTEEN("http://textures.minecraft.net/texture/4f85ef7984b71b6dd114644eaf7cf8eb7e9c2a9b6c51d945fce3f8c19f0c61f",
                UUID.fromString("15f49744-9b61-46af-b1c3-71c6263a0d0e")),
        FOURTEEN("http://textures.minecraft.net/texture/e99f4b2bf75563f71741f97825206e8461c04eb1e499c4875536b596dd2a27",
                UUID.fromString("15f49744-9b61-46af-b1c3-71c6231a0d0e")),
        FIFTEEN("http://textures.minecraft.net/texture/d83a695a982728c6a67aa9858fd5fd2fedd71b21ecab51604ef30742e819",
                UUID.fromString("15f49744-9b61-46af-b1c3-71c6361a0d0e")),
        NEXT("http://textures.minecraft.net/texture/1b6f1a25b6bc199946472aedb370522584ff6f4e83221e5946bd2e41b5ca13b",
                UUID.fromString("15f49744-9b61-46af-b1c4-71c6261a0d0e")),
        DOWN("http://textures.minecraft.net/texture/2dadd755d08537352bf7a93e3bb7dd4d733121d39f2fb67073cd471f561194dd",
                UUID.fromString("9afa272b-ca4a-4502-8073-c4be1b741ebc")),
        UP("http://textures.minecraft.net/texture/d48b768c623432dfb259fb3c3978e98dec111f79dbd6cd88f21155374b70b3c",
                UUID.fromString("ff1654b0-10f2-48b6-9c05-483b75f6549e")),
        PREVIOUS("http://textures.minecraft.net/texture/3ebf907494a935e955bfcadab81beafb90fb9be49c7026ba97d798d5f1a23",
                UUID.fromString("69b9a08d-4e89-4878-8be8-551caeacbf2a")),
        LOCATIONFINDER("http://textures.minecraft.net/texture/b1dd4fe4a429abd665dfdb3e21321d6efa6a6b5e7b956db9c5d59c9efab25",
                UUID.fromString("c58e9836-a780-4902-8e60-f8f9ff680dc0")),
        MONEY("http://textures.minecraft.net/texture/e36e94f6c34a35465fce4a90f2e25976389eb9709a12273574ff70fd4daa6852",
                UUID.fromString("c58e9836-a780-4902-8e30-f8f9ff680dc0")),
        BACK("http://textures.minecraft.net/texture/edf5c2f893bd3f89ca40703ded3e42dd0fbdba6f6768c8789afdff1fa78bf6",
                UUID.fromString("c58e9836-a780-4902-8e40-f8f9ff680dc0")),
        EXPAND("http://textures.minecraft.net/texture/bf6b85f626444dbd5bddf7a521fe52748fe43564e03fbd35b6b5e797de942d",
                UUID.fromString("c58e9836-a780-4902-8e50-f8f9ff680dc0")),
        INFO("http://textures.minecraft.net/texture/afa7f191cb959002a1fdf2c105e2fa61c2584a8c36be410f53104b9d284f20a2",
                UUID.fromString("c58e9836-a880-4902-8e90-f8f9ff680dc0")),
        CREATE_SUB("http://textures.minecraft.net/texture/5ff31431d64587ff6ef98c0675810681f8c13bf96f51d9cb07ed7852b2ffd1",
                UUID.fromString("c58e9836-a710-4902-8e90-f8f9ff680dc0")),
        FLAGS("http://textures.minecraft.net/texture/3c4c399b5e7522a17d35eb53fe5eb767a3b38ea6e5cd33b4438020fc5a848a",
                UUID.fromString("c58e9836-a710-4902-8e90-f8f9ff680dc1")),
        ACCEPT("http://textures.minecraft.net/texture/a92e31ffb59c90ab08fc9dc1fe26802035a3a47c42fee63423bcdb4262ecb9b6",
                UUID.fromString("034a0e9e-8745-4fc6-8639-84abc48e9f72")),
        CROSS("http://textures.minecraft.net/texture/77f33d3f93873745a3e15e2a3f46287ba6f1457c8b790bb3a98bf56fd59dfbb",
                UUID.fromString("6118730e-3562-406e-a06a-be301944f458")),
        ;


        private String url;
        private UUID uuid;

        SkullType(String url, UUID uuid) {
            this.url = url;
            this.uuid = uuid;
        }
    }


    protected abstract void buildInventory(Player player, SmartInventory parent);

    protected ItemStack displayItem(ItemStack itemStack, List<String> additionalLore) {
        ItemStack displayItem = itemStack.clone();
        ItemMeta itemMeta = displayItem.getItemMeta();
        List<String> lore = itemMeta.getLore();
        if (lore == null) {
            lore = new ArrayList<>();
        }
        lore.addAll(additionalLore);
        itemMeta.setLore(lore);
        displayItem.setItemMeta(itemMeta);
        return displayItem;
    }

    public ItemStack makeItemStack(Material material, String name, List<String> lore, boolean enchanted) {
        return makeItemStack(material, 1, name, lore, enchanted);
    }

    public ItemStack makeItemStack(Material material, String name, List<String> lore) {
        return makeItemStack(material, 1, name, lore, false);
    }

    public ItemStack makeItemStack(Material material, String name) {
        return makeItemStack(material, 1, name, new ArrayList<>(), false);
    }

    public ItemStack makeItemStack(SkullType skullType, String name) {
        return makeItemStack(skullType, name, new ArrayList<>());
    }

    public ItemStack makeItemStack(SkullType skullType, String name, List<String> lore) {
        ItemStack itemStack = makeItemStack(Material.PLAYER_HEAD, name, lore);

        SkullMeta headMeta = (SkullMeta) itemStack.getItemMeta();
        PlayerProfile playerProfile = Bukkit.createProfile(skullType.uuid);
        playerProfile.clearProperties();
        byte[] encodedData = Base64.getEncoder().withoutPadding().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", skullType.url).getBytes());
        playerProfile.getProperties().add(new ProfileProperty("textures", new String(encodedData)));

        headMeta.setPlayerProfile(playerProfile);
        itemStack.setItemMeta(headMeta);
        return itemStack;
    }

    public ItemStack makeItemStack(Material material, int amount, String name, List<String> lore, boolean enchanted) {
        return makeItemStack(material, amount, name, lore, enchanted, null);
    }

    public ItemStack makeItemStack(Material material, int amount, String name, List<String> lore, boolean enchanted, Integer customModeldata) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.setCustomModelData(customModeldata);
        }
        itemStack.setItemMeta(meta);
        if (enchanted) {
            itemStack.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        return itemStack;
    }


    public ItemStack makeLeatherAmor(String name, Color color) {
        return makeLeatherAmor(1, name, new ArrayList<>(), false, color);
    }

    public ItemStack makeLeatherAmor(int amount, String name, Color color) {
        return makeLeatherAmor(amount, name, new ArrayList<>(), false, color);
    }

    public ItemStack makeLeatherAmor(String name, List<String> lore, boolean enchanted, Color color) {
        return makeLeatherAmor(1, name, lore, enchanted, color);
    }

    public ItemStack makeLeatherAmor(int amount, String name, List<String> lore, boolean enchanted, Color color) {
        ItemStack itemStack = makeItemStack(Material.LEATHER_CHESTPLATE, amount, name, lore, enchanted);
        updateColor(itemStack, color);
        return itemStack;
    }

    public ItemStack makeBanner(String name, List<String> lore, boolean enchanted, DyeColor dyeColor) {
        return makeBanner(1, name, lore, enchanted, dyeColor);
    }

    public ItemStack makeBanner(int amount, String name, List<String> lore, boolean enchanted, DyeColor dyeColor) {
        ItemStack itemStack = makeItemStack(Material.WHITE_BANNER, amount, name, lore, enchanted);
        updateColor(itemStack, dyeColor);
        return itemStack;
    }

    public void updateColor(ItemStack itemStack, Color color) {
        setMeta(itemStack, LeatherArmorMeta.class, leatherArmorMeta -> leatherArmorMeta.setColor(color));
    }

    public void updateColor(ItemStack itemStack, DyeColor dyeColor) {
        setMeta(itemStack, BannerMeta.class, bannerMeta -> bannerMeta.setPattern(0, new Pattern(dyeColor, PatternType.BASE)));
    }


    protected <T extends ItemMeta > void setMeta(ItemStack itemStack, Class<T> tClass, Consumer<T> consumer) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (tClass.isInstance(itemMeta)) {
            T castedMeta = tClass.cast(itemMeta);
            consumer.accept(castedMeta);
            itemStack.setItemMeta(castedMeta);
        }
    }

    protected <T extends ItemMeta> Optional<T> getMetaOf(ItemStack itemStack, Class<T> tClass) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (tClass.isInstance(itemMeta)) {
            return Optional.of(tClass.cast(itemMeta));
        }
        return Optional.empty();
    }


}

