package io.novacraft.dungeons;

import io.novacraft.core.NovacraftBaseProduct;
import org.bukkit.plugin.java.JavaPlugin;

public class DungeonProduct extends NovacraftBaseProduct<DungeonModel> {

    JavaPlugin plugin;

    public DungeonProduct(JavaPlugin plugin) {
        super(plugin);
        this.plugin = plugin;
    }

    @Override
    public void onCreate() {
        setCommandManager(new DungeonCommandManager(this.model));
        setEventManager(new DungeonEventManager(this.model));
        new GenerateConfig();
    }

}
