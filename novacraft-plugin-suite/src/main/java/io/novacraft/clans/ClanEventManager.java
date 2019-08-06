package io.novacraft.clans;

import io.novacraft.clans.PlayerClanCommands.PlayerChat;
import io.novacraft.core.EventManager;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;

public class ClanEventManager extends EventManager<ClanModel> {

    public ClanEventManager(ClanModel clanModel) {
        super(clanModel);
    }

    @Override
    public void initListeners(JavaPlugin plugin) {
        getServer().getPluginManager().registerEvents(new PlayerChat(), plugin);
    }

}