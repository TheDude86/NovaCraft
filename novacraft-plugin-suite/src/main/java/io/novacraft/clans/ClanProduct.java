package io.novacraft.clans;

public class ClanProduct extends NovacraftBaseProduct<ClanModel> {

    public ClanProduct(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void onCreate() {
        new GenerateFile("Clans", "ClanList.yml");
        setCommandmanager(new ClanCommandManager(this.model));
        setEventManager(new ClanEventManager(this.model));
    }
    
}