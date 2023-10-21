package me.amir.jumping;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.logging.Logger;

public class JumpEvent implements Listener {
    @EventHandler
    public void playerJump(PlayerJumpEvent event) {
        String text = "player " + event.getPlayer().getName() + " прыгнул!!!";
        sendMsgToPlayer(text);
        System.out.println("jump");
        System.out.println(text);
    }

    private void sendMsgToPlayer(String text) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(text);
        }
    }
    public static void main(String []args){
        Logger.getLogger("HELLO!!!!!!");
        System.out.println("HOLAA");
    }
}
