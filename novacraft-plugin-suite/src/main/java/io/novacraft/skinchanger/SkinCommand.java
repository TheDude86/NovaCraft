package io.novacraft.skinchanger;

/*
 * Created by snowbud56 on June 25, 2019
 * Do not change or use this code without permission
 */

import com.mojang.authlib.GameProfile;
import io.novacraft.util.TimeUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SkinCommand implements CommandExecutor {

    private Map<UUID, Long> commandCoolDowns = new HashMap<>();
    private static long commandCooldown = 3600000L;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!sender.hasPermission("skinchanger.use")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            return false;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You need to be a player in order to send this command!");
            return false;
        }
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "You need a player name for that! Usage: /skin <player>");
            return false;
        }
        Player player = (Player) sender;
        System.out.println(commandCoolDowns.getOrDefault(player.getUniqueId(), 0L) - System.currentTimeMillis());
        if ((commandCoolDowns.getOrDefault(player.getUniqueId(), 0L) <= System.currentTimeMillis()) || (player.hasPermission("skinchanger.admin")) || player.isOp()) {
            GameProfile gameProfile = SkinManager.setupGameProfile(player, args[0]);
            SkinManager.setPlayerSkinToGameProfile(player, gameProfile);
            sender.sendMessage(ChatColor.GREEN + "You now have the skin of " + ChatColor.RED + args[0] + ChatColor.GREEN + "!");
            commandCoolDowns.put(player.getUniqueId(), System.currentTimeMillis() + commandCooldown);
        } else {
            sender.sendMessage(ChatColor.RED + "You cannot change your skin for another " + ChatColor.DARK_RED + TimeUtil.convertmstoTime(commandCoolDowns.get(player.getUniqueId()) - System.currentTimeMillis()));
        }
        return true;
    }
}
