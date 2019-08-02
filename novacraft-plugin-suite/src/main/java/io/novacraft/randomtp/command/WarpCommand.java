package io.novacraft.randomtp.command;

import io.novacraft.randomtp.RandomTPModel;
import io.novacraft.randomtp.TPManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {
    private RandomTPModel model;

    public WarpCommand(RandomTPModel model) {
        this.model = model;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "Only players can execute this command!");
            return false;
        }
        TPManager.teleportPlayer((Player) commandSender, model);
        return true;
    }
}
