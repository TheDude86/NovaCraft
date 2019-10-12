package io.novacraft.trophies.command;

/*
 * Created by snowbud56 on August 08, 2019
 * Do not change or use this code without permission
 */

import io.novacraft.trophies.TrophiesModel;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TrophyCommand implements CommandExecutor {
    TrophiesModel model;

    TrophyCommand(TrophiesModel model) {
        this.model = model;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
}
