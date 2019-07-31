package io.novacraft.skinchanger;

import io.novacraft.core.NovacraftBaseProduct;
import io.novacraft.skinchanger.listeners.SkinChangerEventManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SkinChangerProduct extends NovacraftBaseProduct<SkinChangerModel> {
    public SkinChangerProduct(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public NovacraftBaseProduct build() {
        this.commandManager = new SkinChangerCommandManager(this.model);
        this.eventManager = new SkinChangerEventManager(this.model);
        this.configMapper = new SkinChangerConfigMapper();
        return this;
    }
}
