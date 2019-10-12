package io.novacraft.staffchat.command;

/*
 * Created by snowbud56 on July 24, 2019
 * Do not change or use this code without permission
 */

import io.novacraft.staffchat.StaffChatUtil;
import io.novacraft.util.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Chat.cRed + "This command can only be executed as a player!");
            return false;
        }
        Player p = (Player) sender;
        if (args.length == 0) {
            p.sendMessage(Chat.cRed + "Usage: /" + cmd.getName() + " <msg>");
            return false;
        }
        StringBuilder msg = new StringBuilder(args[0]);
        for (int i = 1; i < args.length; i++)
            msg.append(" ").append(args[i]);
        StaffChatUtil.generalMessage(p, msg.toString());
        return true;
    }
}
