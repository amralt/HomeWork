package me.amir.commands.utils;

import net.kyori.adventure.text.Component;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import java.awt.*;
import java.util.*;
import java.util.List;

public class BowUtil {
    public static ItemStack createTeleportBow(){
        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.displayName(Component.text("teleport bow"));
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("это лук для телепортации." + Color.ORANGE));
        lore.add(Component.text("выстрели в любое место, лук телепортирует тебя туда." + Color.ORANGE));
        bowMeta.lore(lore);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        bow.setItemMeta(bowMeta);

        return bow;
    }

}
