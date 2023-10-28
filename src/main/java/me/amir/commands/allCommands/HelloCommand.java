package me.amir.commands.allCommands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Color;
import org.bukkit.entity.Player;



@CommandAlias("Hello")
public class HelloCommand extends BaseCommand {

    @Default
    public void onHello(Player player) {
        if (player.hasPermission("op")){
            TextComponent textComponent = Component.text("Hello " + player.getName()).color(TextColor.color(0x443344));//цвет добавил после записи видео
            player.sendMessage(textComponent);
        }
    }

}