package io.novacraft.trophies.listeners;

import io.novacraft.core.EventManager;
import io.novacraft.trophies.TrophiesModel;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;

public class TrophiesEventManager extends EventManager<TrophiesModel> {

    public TrophiesEventManager(TrophiesModel trophiesModel) {
        super(trophiesModel);
    }

    @Override
    public void initListeners(JavaPlugin plugin) {
        getServer().getPluginManager().registerEvents(new TrophyPlaceEvent(this.model), plugin);
        getServer().getPluginManager().registerEvents(new TrophyBreakEvent(this.model), plugin);
    }
}
