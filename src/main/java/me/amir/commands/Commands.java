package me.amir.commands;

import co.aikar.commands.BukkitCommandManager;
import me.amir.commands.allCommands.BowCommand;
import me.amir.commands.allCommands.FoodCommand;
import me.amir.commands.allCommands.HelloCommand;
import org.bukkit.plugin.java.JavaPlugin;
public final class Commands extends JavaPlugin {

    private final Commands plugin;

    public Commands(Commands plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.plugin.getConfig();

        System.out.println("HIIIII");

        BukkitCommandManager manager = new BukkitCommandManager(this);
        manager.registerCommand(new HelloCommand());
        manager.registerCommand(new FoodCommand(this));
        manager.registerCommand(new BowCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}