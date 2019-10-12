package io.novacraft.trophies.command;

import io.novacraft.core.CommandManager;
import io.novacraft.trophies.TrophiesModel;
import org.bukkit.plugin.java.JavaPlugin;

public class TrophiesCommandManager extends CommandManager<TrophiesModel> {

    public TrophiesCommandManager(TrophiesModel trophiesModel) {
        super(trophiesModel);
    }

    @Override
    public void addCommands(JavaPlugin plugin) {
        super.addCommands(plugin);
        bindCommand("trophy", new TrophyCommand(model));
    }
}
