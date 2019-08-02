package io.novacraft.bloodmoon;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BloodMoonCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            World world = player.getWorld();
            player.sendMessage("" + GetMoonPhase.getMoonPhase(world));
        }

        return false;
    }
}
