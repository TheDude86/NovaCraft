package io.novacraft.skinchanger;

import io.novacraft.core.NovacraftBaseProduct;
import io.novacraft.skinchanger.listeners.SkinChangerEventManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SkinChangerProduct extends NovacraftBaseProduct<SkinChangerModel> {
    public SkinChangerProduct(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setCommandManager(new SkinChangerCommandManager(this.model));
        setEventManager(new SkinChangerEventManager(this.model));
    }

    @Override
    public SkinChangerModel getInitialModel() {
        return new SkinChangerModel();
    }
}
