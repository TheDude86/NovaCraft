package io.novacraft.trophies;


import io.novacraft.core.NovacraftBaseProduct;
import io.novacraft.trophies.command.TrophiesCommandManager;
import io.novacraft.trophies.listeners.TrophiesEventManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TrophiesProduct extends NovacraftBaseProduct<TrophiesModel> {

    public TrophiesProduct(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void onCreate() {
        setCommandManager(new TrophiesCommandManager(model));
        setEventManager(new TrophiesEventManager(model));
    }

    @Override
    public TrophiesModel getInitialModel() {
        return new TrophiesModel();
    }
}
