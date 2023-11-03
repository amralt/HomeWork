package intarfaces;


import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.components.GuiType;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dev.triumphteam.gui.guis.PaginatedGui;
import me.amir.shop.Shop;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.*;
import java.util.List;

public class ShopInterface {

    static int userCount =0;
    private static NewConfig createPayBox(String itemName, int itemPrice, int itemCount, Player player){
        userCount =1;

//        int playersMoney = player.getInventory().getContents();
//        TODO как узнать кол-во денег?


        Gui guiPayBox = Gui.gui()
                .title(Component.text("You want to bay?"))
                .type(GuiType.HOPPER)
                .rows(4)
                .create();
        GuiItem closePayBox = ItemBuilder.from(new ItemStack(Material.RED_BANNER)).asGuiItem(event -> {
            event.setCancelled(true);
            guiPayBox.close(player);
        });
        guiPayBox.addItem(closePayBox);

        ItemStack countBlock = new ItemStack(Material.PAPER);
        ItemMeta countBlockItemMeta = countBlock.getItemMeta();
        countBlockItemMeta.displayName(Component.text("plus").color(TextColor.color(0xFFFA1C)));
        countBlock.setItemMeta(countBlockItemMeta);
        GuiItem plusItem = ItemBuilder.from(countBlock).asGuiItem(event -> {
            event.setCancelled(true);
            event.getCursor().displayName();
            if (event.getClick().isMouseClick()){
                if ((userCount < itemCount)){
                    userCount++;
                }
            }
        });
        guiPayBox.addItem(plusItem);
//        guiPayBox.setItem(5,2, ItemBuilder.from(Material.PAPER).setNbt("hola",true).asGuiItem());

        ItemStack currentItem = new ItemStack(Material.valueOf(itemName));
        GuiItem guiItem = ItemBuilder.from(currentItem).asGuiItem(event -> {
            event.setCancelled(true);
        });
        guiPayBox.addItem(guiItem);

        //        кнопка с согласием
        ItemStack bayBlock = new ItemStack(Material.GREEN_BANNER);
        ItemMeta bayBlockMeta = bayBlock.getItemMeta();
        bayBlockMeta.displayName(Component.text("Bay").color(TextColor.color(0x1BFF04)));
        bayBlock.setItemMeta(bayBlockMeta);

        GuiItem acceptBay = ItemBuilder.from(bayBlock).asGuiItem(event -> {
            event.setCancelled(true);
            event.getCursor().displayName();
            if (event.getClick().isMouseClick()) {
                ItemStack cost = new ItemStack(Material.GOLD_INGOT, itemPrice*userCount);
                player.getInventory().remove(cost);
                player.getInventory().addItem(new ItemStack(Material.valueOf(itemName), userCount));
                guiPayBox.close(player);
            }
        });
        guiPayBox.addItem(acceptBay);


        System.out.println("all is good");
        guiPayBox.open(player);
//        TODO сделать иконки с выбором кол-ва и стоимостью, а также кнопкой "купить"

        return new NewConfig(itemName,itemCount);
    }
    public static void createShop(Shop plugin, Player player) {

        @NotNull PaginatedGui gui = Gui.paginated()
                .title(Component.text("first shop" + Color.ORANGE))
                .rows(6)
                .pageSize(10)
                .create();
        gui.setItem(6, 1, ItemBuilder.from(Material.PAPER).setName("Previous").asGuiItem(event -> {
            gui.previous();
            event.setCancelled(true);
        }));
        gui.setItem(6, 10, ItemBuilder.from(Material.PAPER).setName("Next").asGuiItem(event -> {
            gui.next();
            event.setCancelled(true);
        }));
        //TODO здесь будет обработка конфигов.
        List<Map<?, ?>> itemsGoods = plugin.getConfig().getMapList("items");
        for (Map<?,?> mapGoods : itemsGoods) {
            String itemName = String.valueOf(mapGoods.get("material"));
//            System.out.println(itemName);
            String itemPrice = String.valueOf(mapGoods.get("price"));
//            System.out.println(itemPrice);
            String itemCount = String.valueOf(mapGoods.get("count"));

            ItemStack currentItem = new ItemStack(Material.valueOf(itemName));
            ItemMeta itemMeta = currentItem.getItemMeta();
            itemMeta.displayName(Component.text(itemName).color(TextColor.color(0xFFFFF))
                    .append(Component.text(" price: " + itemPrice).color(TextColor.color(0xFFFFF)))
                    .append(Component.text(" count " + itemCount).color(TextColor.color(0xFFFFF))));
            currentItem.setItemMeta(itemMeta);

            int priceCurrentItem = Integer.parseInt(itemPrice);
            int countCurrentItem = Integer.parseInt(itemCount);
            GuiItem guiItem = ItemBuilder.from(currentItem).asGuiItem(event ->{
                event.setCancelled(true);
                event.getCursor().displayName();
                NewConfig newConfig = createPayBox(itemName, priceCurrentItem, countCurrentItem, player);
                plugin.getConfig().set("items." + newConfig.name() +".count", countCurrentItem - newConfig.count());
                System.out.println("items." + newConfig.name() +".count");
            });
//            TODO сделать вывод еще мини-окна с выбором кол-ва и покупкой предмета


            gui.addItem(guiItem);
        }


        gui.open(player);
    }
}
