package io.novacraft.clans;

public class ClanEventManager extends EventManager<ClanModel> {

    public ClanEventManager(ClanModel clanModel) {
        super(clanModel);
    }

    @Override
    public void initListeners(JavaPlugin plugin) {
        getServer().getPluginManager().registerEvents(new PlayerChat(), plugin);
    }

}