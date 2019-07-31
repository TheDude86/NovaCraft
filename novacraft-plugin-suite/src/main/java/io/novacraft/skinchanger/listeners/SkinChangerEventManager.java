package io.novacraft.skinchanger.listeners;

import io.novacraft.core.EventManager;
import io.novacraft.skinchanger.SkinChangerModel;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;

public class SkinChangerEventManager extends EventManager<SkinChangerModel> {

    public SkinChangerEventManager(SkinChangerModel model) {
        super(model);
    }

    @Override
    public void initListeners(JavaPlugin plugin) {
        getServer().getPluginManager().registerEvents(new OnPlayerJoinListener(this.model), plugin);
        getServer().getPluginManager().registerEvents(new OnPlayerQuitListener(this.model), plugin);
    }
}
