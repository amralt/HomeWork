package me.amir.shop;

import co.aikar.commands.BukkitCommandManager;
import commands.GetMoney;
import commands.ShopCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Shop extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();

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
