package me.amir.commands.allCommands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import me.amir.commands.utils.BowUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.Objects;

@CommandAlias("bow")
public class TeleportBowCommand extends BaseCommand {
    @Default
    public boolean onBow(CommandSender sender, String[] bowType){
        if (sender instanceof Player player) {
            if (bowType[0].isEmpty() || bowType[0].equals("teleport")) {

                ItemStack teleportBow = BowUtil.createTeleportBow();
                player.getInventory().addItem(teleportBow);
                player.getInventory().addItem(new ItemStack(Material.ARROW, 1));

//                player.sendMessage(Component.text( "телепортирующий лук выдан" + TextColor.color(0xF211FF)));
                player.sendMessage(Component.text("телепортирующий лук выдан" + 0xF211FF));
            }

            else if(bowType[0].equals("common")){
                player.getInventory().addItem(new ItemStack(Material.BOW,1));
                player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
            }

        }
        return true;
    }
}
