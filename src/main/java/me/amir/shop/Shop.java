package me.amir.shop;

import co.aikar.commands.BukkitCommandManager;
import commands.GetMoney;
import commands.ShopCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class Shop extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(this.getConfig().getMapList("items"));

        BukkitCommandManager bukkitCommandManager = new BukkitCommandManager(this);

        bukkitCommandManager.registerCommand(new ShopCommand(this));
        bukkitCommandManager.registerCommand(new GetMoney());
        System.out.println("hii");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
