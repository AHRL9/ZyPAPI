package de.zyfy.zypapi.commandTypes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerCommand implements CommandExecutor {
	private String notAPlayerMessage = "You have to be a player to use this command!";
	private TextColor notAPlayerMessageColor = TextColor.color(255, 127, 127);

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if(sender instanceof Player) {
			onPlayerCommand(sender, command, label, args);
			return true;
		} else {
			sender.sendMessage(Component.text(notAPlayerMessage).color(notAPlayerMessageColor));
			return false;
		}
	}

	public void onPlayerCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {}

	public PlayerCommand setNotAPlayerMessage(String notAPlayerMessage) {
		this.notAPlayerMessage = notAPlayerMessage;
		return this;
	}

	public PlayerCommand setNotAPlayerMessage(String message, TextColor color) {
		notAPlayerMessage = message;
		notAPlayerMessageColor = color;
		return this;
	}
}
