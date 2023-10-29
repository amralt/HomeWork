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
            if (bowType.isEmpty() || bouType.isEqual("teleport") {

                ItemStack teleportBow = BowUtil.createTeleportBow();
                player.getInventory().addItem(teleportBow);
                player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                layer.sendMessage(Component.text("телепортирующий лук выдан").color(TextColor.color(0xF211FF)));
            }
            else if(Objects.equals(bowType, "common")){
                player.getInventory().addItem(new ItemStack(Material.BOW,1));
                player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
            }

        }
        return true;
    }

}
