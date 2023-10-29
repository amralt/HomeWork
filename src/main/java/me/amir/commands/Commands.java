package me.amir.commands;

import co.aikar.commands.BukkitCommandManager;
import me.amir.commands.allCommands.TeleportBowCommand;
import me.amir.commands.allCommands.FoodCommand;
import me.amir.commands.allCommands.HelloCommand;
import me.amir.commands.listeners.TeleportBowShooted;
import org.bukkit.plugin.java.JavaPlugin;
public final class Commands extends JavaPlugin {



    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("HIIIII");

        BukkitCommandManager manager = new BukkitCommandManager(this);
        manager.registerCommand(new HelloCommand());
        manager.registerCommand(new FoodCommand(this));
        manager.registerCommand(new TeleportBowCommand());

        getServer().getPluginManager().registerEvents(new TeleportBowShooted(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}