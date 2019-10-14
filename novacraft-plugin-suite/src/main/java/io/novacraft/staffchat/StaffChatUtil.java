package io.novacraft.staffchat;

/*
 * Created by snowbud56 on October 08, 2019
 * Do not change or use this code without permission
 */

import io.novacraft.util.Chat;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class StaffChatUtil {

    private static String getPlayerPrefix(Player p) {
        if (p.hasPermission("staffchat.owner")) {
            return Chat.cGold + "Owner " + p.getName();
        } else if (p.hasPermission("staffchat.admin")) {
            return Chat.cRed + "Admin " + p.getName();
        } else if (p.hasPermission("staffchat.mod")) {
            return Chat.cDAqua + "Mod " + p.getName();
        } else if (p.hasPermission("staffchat.vip")) {
            return Chat.cDGreen + "VIP " + p.getName();
        } else if (p.hasPermission("staffchat.member")) {
            return Chat.cGreen + "Member " + p.getName();
        } else {
            return Chat.cGray + "Guest " + p.getName();
        }
    }

    public static void generalMessage(Player p, String message) {
        p.sendMessage(getPlayerPrefix(p) + Chat.cPurple + " " + message);
        for (Player target : Bukkit.getOnlinePlayers()) {
            if (target == p) continue;
            if (target.hasPermission("staffchat.mod") || target.hasPermission("staffchat.admin") || target.hasPermission("staffchat.owner")) {
                target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 100, 2);
                target.sendMessage(getPlayerPrefix(p) + Chat.cPurple + " " + message);
            }
        }
    }

    public static void respondMessage(Player p, Player target, String message) {
        for (Player target1 : Bukkit.getOnlinePlayers()) {
            if (target1 == p || target1 == target) continue;
            if (target1.hasPermission("staffchat.mod") || target1.hasPermission("staffchat.admin") || target1.hasPermission("staffchat.owner")) {
                target1.sendMessage(getPlayerPrefix(p) + Chat.cPurple + " -> " + getPlayerPrefix(target) + Chat.cPurple + " " + message);
            }
        }
        target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 100, 2);
        target.sendMessage(Chat.cPurple + "<- " + getPlayerPrefix(p) + Chat.cPurple + " " + message);
        p.sendMessage(Chat.cPurple + "-> " + getPlayerPrefix(target) + Chat.cPurple + " " + message);
    }
}
