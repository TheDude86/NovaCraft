//package io.novacraft.staffchat;
//
///*
// * Created by snowbud56 on July 24, 2019
// * Do not change or use this code without permission
// */
//
//import io.novacraft.util.Chat;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
//
//public class StaffChatCommand implements CommandExecutor {
//    @Override
//    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
//        if (!(sender instanceof Player)) {
//            sender.sendMessage(Chat.cRed + "This command can only be executed as a player!");
//            return false;
//        }
//        Player p = (Player) sender;
//        if (!p.hasPermission("staffchat.use")) {
//            p.sendMessage(Chat.cRed + "You don't have permission to execute this command!");
//            return false;
//        }
//        if (args.length == 0) {
//            p.sendMessage(Chat.cRed + "Usage: /" + cmd.getName() + " <msg>");
//            return false;
//        }
//        StringBuilder msg = new StringBuilder();
//        for (String arg : args)
//            msg.append(arg).append(" ");
//        Chat.messagePermission(Chat.cDRed + "STAFF> " + Chat.cRed + p.getName() + ": " + Chat.cAqua + msg.toString(), "staffchat.use");
//        return true;
//    }
//}
