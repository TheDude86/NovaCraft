package io.novacraft.dungeons;

import io.novacraft.core.EventManager;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;

public class DungeonEventManager extends EventManager<DungeonModel> {

    public DungeonEventManager(DungeonModel dungeonModel) {
        super(dungeonModel);
    }

    @Override
    public void initListeners(JavaPlugin plugin) {
        getServer().getPluginManager().registerEvents(new GUIListener(), plugin);
    }
}
