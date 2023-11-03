package commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Private;
import dev.triumphteam.gui.guis.Gui;
import me.amir.shop.Shop;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

import static   intarfaces.ShopInterface.createShop;

@CommandAlias("shop")
public class ShopCommand extends BaseCommand {
    private final Shop plugin;

    public ShopCommand(Shop plugin) {
        this.plugin = plugin;
    }

    @Default
    public void onShop(Player player){
        @NotNull List<Map<?, ?>> itemsGoods = plugin.getConfig().getMapList("items");
        createShop(plugin, player);
//        gui.open(player);

    }
}
