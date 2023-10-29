package me.amir.commands.allCommands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import me.amir.commands.utils.BowUtil;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.awt.*;

@CommandAlias("bow")
public class TeleportBowCommand extends BaseCommand {
    @Default
    @Subcommand("common")
    public boolean onBow(CommandSender sender, String bowType){
        if (sender instanceof Player player) {
            if (player.hasPermission("tpbow.givebow") & bowType.isEmpty()) {



                ItemStack teleportBow = BowUtil.createTeleportBow();
                player.getInventory().addItem(teleportBow);
                player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                player.sendMessage(Component.text(Color.cyan + "телепортирующий лук выдан"));
            }
            else{
                ItemStack commonBow = BowUtil.createCommonBow();
                player.getInventory().addItem(commonBow);
            }

        }
        return true;
    }

//    @Override
//    public boolean onCommand(@NotNull CommandSender sender) {
//        if (sender instanceof Player player) {
//            if (player.hasPermission("tpbow.givebow")) {
//
//
////                Player target = Bukkit.getPlayerExact(player.getName());
//
//                ItemStack bow = BowUtil.createTeleportBow();
//                player.getInventory().addItem(bow);
//                player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
//                player.sendMessage(Component.text(Color.cyan + "телепортирующий лук выдан"));
//            }
//        }
//        return true;
//    }
}
