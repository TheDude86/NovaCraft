package io.novacraft.clans.OperatorClanCommands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class GetOnlinePlayers {

    public List<String> getOnlinePlayers() {

        List<String> playerList = null;
        for (int i = 0; i < Bukkit.getOnlinePlayers().size(); i ++) {
           Player player = (Player) Bukkit.getOnlinePlayers().toArray()[i];
           playerList.add(player.getName());
        }
        return playerList;
    }
}
