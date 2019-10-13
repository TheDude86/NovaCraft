package io.novacraft.skinchanger;

/*
 * Created by snowbud56 on October 12, 2019
 * Do not change or use this code without permission
 */

import com.mojang.authlib.GameProfile;
import io.novacraft.util.Chat;
import io.novacraft.util.TimeUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CooldownResetCommand implements CommandExecutor {

    private SkinChangerModel model;

    public CooldownResetCommand(SkinChangerModel model) {
        this.model = model;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!sender.hasPermission("skinchanger.admin")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            return false;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You need to be a player in order to send this command!");
            return false;
        }
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "You need a player name for that! Usage: /resetcooldown <player>");
            return false;
        }
        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);
        if (model.commandCoolDowns.containsKey(target.getUniqueId())) {
            model.commandCoolDowns.clear();target.getUniqueId();
        }
        player.sendMessage(Chat.cGreen + target.getName() + "'s skin cooldown has been reset!");
        return true;
    }
}
