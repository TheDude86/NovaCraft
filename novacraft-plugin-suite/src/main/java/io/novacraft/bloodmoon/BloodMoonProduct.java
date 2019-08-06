package io.novacraft.bloodmoon;

import io.novacraft.core.NovacraftBaseProduct;
import org.bukkit.plugin.java.JavaPlugin;

public class BloodMoonProduct extends NovacraftBaseProduct<BloodMoonModel> {
    public BloodMoonProduct(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setCommandManager(new BloodMoonCommandManager(model));
    }

    @Override
    public BloodMoonModel getInitialModel() {
        return new BloodMoonModel();
    }
}
