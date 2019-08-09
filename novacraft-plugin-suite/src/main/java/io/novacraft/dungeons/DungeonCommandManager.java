package io.novacraft.dungeons;

import io.novacraft.core.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DungeonCommandManager extends CommandManager<DungeonModel> {

    public DungeonCommandManager(DungeonModel dungeonModel) {
        super (dungeonModel);
    }

    @Override
    public void addCommands(JavaPlugin plugin) {
        super.addCommands(plugin);
        bindCommand("dungeons", new DungeonCommands());
        bindCommand("opdungeons", new AdminCommand());
    }

}
