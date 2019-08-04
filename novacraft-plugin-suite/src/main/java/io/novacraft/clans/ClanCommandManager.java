package io.novacraft.clans;

public class ClanCommandManager extends CommandManager<ClanModel>{

    public ClanCommandManager(ClanModel clanModel) {
        super(clanModel);
    }

    @Override
    public void addCommands(JavaPlugin plugin) {
        super.addCommands(plugin);
        bindCommand("clans", new PlayerClanCommands());
        bindCommand("opclans", new OperatorClanCommands());
    }

}