package commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandAlias("getMoney")
public class GetMoney extends BaseCommand {
    public void getMoney(Player player){
        player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 64));
        System.out.println(player.getName() + " got moneys");
    }

}
