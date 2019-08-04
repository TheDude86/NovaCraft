package io.novacraft.clans;

import io.novacraft.clans.OperatorClanCommands.OperatorClanCommands;
import io.novacraft.clans.PlayerClanCommands.PlayerClanCommands;
import io.novacraft.core.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ClanCommandManager extends CommandManager<ClanModel> {

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