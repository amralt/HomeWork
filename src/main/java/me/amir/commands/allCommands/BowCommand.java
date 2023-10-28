package me.amir.commands.allCommands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import me.amir.commands.utils.BowUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandAlias("bow")
public class BowCommand extends BaseCommand {
//    @Override
    public boolean onBowCommand(CommandSender sender, Command command){
        if (sender instanceof Player player){
            Player target = Bukkit.getPlayerExact(player.getName());

            ItemStack bow = BowUtil.createTeleportBow();
            assert target != null;
            target.getInventory().addItem(bow);
            target.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }

        return true;
    }
}
