package io.novacraft.clans.PlayerClanCommands;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

import static io.novacraft.clans.PlayerClanCommands.GenerateFile.getFilePath;

class SetPrefix {

    File file = new File(getFilePath());
    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
    ChatColor color1;
    ChatColor color2;

    SetPrefix(Player player, String prefix, String color1, String color2) {
        if (checkIfClanExists(getClan(player))) {
            if (getPermission(player)) {
                if (prefix.length() <= 5) {
                    yamlConfiguration.set("clans." + getClan(player) + ".prefix", prefix);
                    yamlConfiguration.set("clans." + getClan(player) + ".prefixcolor1", color1);
                    yamlConfiguration.set("clans." + getClan(player) + ".prefixcolor2", color2);
                    save();
                } else {
                    player.sendMessage(ChatColor.RED + "Prefixes can be a max of 5 characters!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You are not the leader of this clan!");
            }
        } else {
            player.sendMessage(ChatColor.RED + "You are not in a clan!");
        }
    }

    private String getClan(Player player) {
        return (String) yamlConfiguration.get("players." + player.getName() + ".clan");
    }

    private boolean checkIfClanExists(String clan) {
        return yamlConfiguration.get("clans." + clan) != null;
    }

    private boolean getPermission(Player player) {
        return yamlConfiguration.get("players." + player.getName() + ".Player_Permissions").equals("LEADER");
    }

    private void save() {
        try {
            yamlConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}