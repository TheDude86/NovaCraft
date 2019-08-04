package io.novacraft.clans;

import io.novacraft.clans.PlayerClanCommands.GenerateFile;
import io.novacraft.core.NovacraftBaseProduct;
import org.bukkit.plugin.java.JavaPlugin;

public class ClanProduct extends NovacraftBaseProduct<ClanModel> {

    public ClanProduct(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void onCreate() {
        new GenerateFile("Clans", "ClanList.yml");
        setCommandManager(new ClanCommandManager(this.model));
        setEventManager(new ClanEventManager(this.model));
    }
    
}