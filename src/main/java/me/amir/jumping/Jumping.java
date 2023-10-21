package me.amir.jumping;


import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Jumping extends JavaPlugin{

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JumpEvent(), this);
        System.out.println("HI");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Logger.getLogger("BYEE!!!!!!");
    }


}

