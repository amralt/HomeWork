package me.amir.commands.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

import java.awt.*;
import java.util.Objects;

public class TeleportBowShooted implements Listener {
    @EventHandler
    public void onShootEvent(ProjectileHitEvent event){

        if (event.getEntity().getShooter() instanceof Player p){
            ItemStack itemInMainHand = p.getInventory().getItemInMainHand();

            if (Objects.equals(itemInMainHand.getItemMeta().displayName(), Component.text("teleport bow"))){
                Location location = event.getEntity().getLocation();
                p.teleport(location);
                event.getEntity().remove();
                p.sendMessage(Component.text("you was teleported" + 0x74D51C));
            }
        }

    }


}
