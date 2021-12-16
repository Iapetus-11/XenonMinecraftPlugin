package me.iapetus11;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShrugCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to execute this command.");
            return true;
        }

        var message = new StringBuilder();
        for (String arg : args) {
            message.append(arg);
            message.append(" ");
        }

        ((Player) sender).chat(message + "¯\\\\_(ツ)_/¯\n");

        return true;
    }
}
