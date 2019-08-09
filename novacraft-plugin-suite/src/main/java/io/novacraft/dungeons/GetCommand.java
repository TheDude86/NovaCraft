package io.novacraft.dungeons;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class GetCommand {

    File file = new File(    "plugins/Dungeons/DungeonGUI.yml");
    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

    public String getCommand(int index) {
        return (String) yamlConfiguration.get(index + ".command");
    }
}
