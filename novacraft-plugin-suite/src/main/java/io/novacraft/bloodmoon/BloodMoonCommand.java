package io.novacraft.bloodmoon;

import io.novacraft.util.Chat;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BloodMoonCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Chat.cRed + "This command can only be executed as a player!");
            return false;
        }

        Player p = (Player) sender;
        World w = p.getWorld();

        p.sendMessage("" + getMoonPhase(w));
        return true;
    }
    public static MoonPhase getMoonPhase(World w) {
        int days = (int) (w.getFullTime() / 24000);
        int phase = days % 8;

        System.out.println("Full time: " + w.getFullTime());

        System.out.println("Days: "+ days + "\nPhase: "+ phase);

        switch(phase) {
            case 0:
                return MoonPhase.FULL_MOON;
            case 1:
                return MoonPhase.WANING_GIBBOUS;
            case 2:
                return MoonPhase.LAST_QUARTER;
            case 3:
                return MoonPhase.WANING_CRESCENT;
            case 4:
                return MoonPhase.NEW_MOON;
            case 5:
                return MoonPhase.WAXING_CRESCENT;
            case 6:
                return MoonPhase.FIRST_QUARTER;
            case 7:
                return MoonPhase.WAXING_GIBBOUS;
        }

        return null;
    }
}
