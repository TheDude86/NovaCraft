package io.novacraft.clans.PlayerClanCommands;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static io.novacraft.clans.PlayerClanCommands.GenerateFile.getFilePath;

class GetPrefix {

    File file = new File(getFilePath());
    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
    static List<String> colorPossibilites = Arrays.asList("red", "darkred", "green", "darkgreen", "blue", "darkblue", "aqua", "darkaqua", "gray", "darkgray", "lightpurple", "darkpurple");

    GetPrefix(AsyncPlayerChatEvent event) {
        String prefix = getPrefix(event.getPlayer().getName());
        String newPrefix =  getColor(getColor2(event.getPlayer().getName())) + "[" + getColor(getColor1(event.getPlayer().getName())) +  prefix + getColor(getColor2(event.getPlayer().getName())) + "]";
        String prevFormat = event.getFormat();
        String newFormat = newPrefix + ChatColor.RESET + prevFormat;
        try {
            if (prefix.equals("null")) {
                event.setFormat(prevFormat);
            } else {
                event.setFormat(newFormat);
            }
        } catch (NullPointerException e) {
            System.out.println("player prefix is null");
        }
    }

    private String getClan(String playerName) {
        return (String) yamlConfiguration.get("players." + playerName + ".clan");
    }

    private String getPrefix(String playerName) {
        return (String) yamlConfiguration.get("clans." + getClan(playerName) + ".prefix");
    }

    private String getColor1(String playerName) {
        return (String) yamlConfiguration.get("clans." + getClan(playerName) + ".prefixcolor1");
    }

    private String getColor2(String playerName) {
        return (String) yamlConfiguration.get("clans." + getClan(playerName) + ".prefixcolor2");
    }

    public ChatColor getColor(String color) {
        if (color.equalsIgnoreCase("red")) {
            return ChatColor.RED;
        } else if (color.equalsIgnoreCase("darkred")) {
            return ChatColor.DARK_RED;
        } else if (color.equalsIgnoreCase("green")) {
            return ChatColor.GREEN;
        } else if (color.equalsIgnoreCase("darkgreen")) {
            return ChatColor.DARK_GREEN;
        } else if (color.equalsIgnoreCase("blue")) {
            return ChatColor.BLUE;
        } else if (color.equalsIgnoreCase("darkblue")) {
            return ChatColor.DARK_BLUE;
        } else if (color.equalsIgnoreCase("aqua")) {
            return ChatColor.AQUA;
        } else if (color.equalsIgnoreCase("darkaqua")) {
            return ChatColor.DARK_AQUA;
        } else if (color.equalsIgnoreCase("gray")) {
            return ChatColor.GRAY;
        } else if (color.equalsIgnoreCase("darkgray")) {
            return ChatColor.DARK_GRAY;
        } else if (color.equalsIgnoreCase("lightpurple")) {
            return ChatColor.LIGHT_PURPLE;
        } else if (color.equalsIgnoreCase("darkpurple")) {
            return ChatColor.DARK_PURPLE;
        } else {
            return ChatColor.RESET;
        }
    }
}