package io.novacraft.staffchat.command;

/*
 * Created by snowbud56 on October 08, 2019
 * Do not change or use this code without permission
 */

import io.novacraft.staffchat.StaffChatModel;
import io.novacraft.staffchat.StaffChatUtil;
import io.novacraft.util.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChatMessageCommand implements CommandExecutor {
    private StaffChatModel model;

    public StaffChatMessageCommand(StaffChatModel model) {
        this.model = model;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Chat.cRed + "This command can only be executed as a player!");
            return false;
        }
        Player p = (Player) sender;
        if (!(p.hasPermission("staffchat.owner") || p.hasPermission("staffchat.admin") || p.hasPermission("staffchat.mod"))) {
            p.sendMessage(Chat.cRed + "You don't have permission to execute this command!");
            return false;
        }
        if (args.length == 0) {
            p.sendMessage(Chat.cRed + "Usage: /" + cmd.getName() + " <player> <msg>");
            return false;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            p.sendMessage(Chat.cRed + "That player isn't online or doesn't exist!");
            return false;
        }
        StringBuilder msg = new StringBuilder(args[1]);
        for (int i = 2; i < args.length; i++)
            msg.append(" ").append(args[i]);
        StaffChatUtil.respondMessage(p, target, msg.toString());
        model.lastMessaged.put(p.getUniqueId(), target);
        return true;
    }
}
