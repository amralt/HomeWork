package me.amir.commands.allCommands;


import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CatchUnknown;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import me.amir.commands.Commands;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.CommandSender;

@CommandAlias("Food")
public class FoodCommand extends BaseCommand {
    private final Commands plugin;

    public FoodCommand(Commands plugin) {
        this.plugin = plugin;
    }

    @Subcommand("food")
    @CatchUnknown
    @Default
    public void setFood(CommandSender player, String[] userFood) {
        if (userFood.length != 0) {
            this.plugin.getConfig().set("food", userFood[0]);
            this.plugin.saveConfig();
        }
        String currentFood = this.plugin.getConfig().getString("food");
        System.out.println(currentFood);
        TextComponent textComponent = (TextComponent)Component.text("" + currentFood).color(TextColor.color(16776960));
        player.sendMessage((Component)textComponent);
    }
}