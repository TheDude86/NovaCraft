package io.novacraft.randomtp.Listeners;

import io.novacraft.core.EventManager;
import io.novacraft.randomtp.RandomTPModel;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;

public class RandomTPEventManager extends EventManager<RandomTPModel> {

    public RandomTPEventManager(RandomTPModel randomTPModel) {
        super(randomTPModel);
    }

    @Override
    public void initListeners(JavaPlugin plugin) {
        getServer().getPluginManager().registerEvents(new PlayerPortalEnterListener(this.model), plugin);
    }
}
