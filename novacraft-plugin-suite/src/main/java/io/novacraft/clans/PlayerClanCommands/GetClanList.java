package io.novacraft.clans.PlayerClanCommands;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;

import static io.novacraft.clans.PlayerClanCommands.GenerateFile.getFilePath;

public class GetClanList {

    private File file = new File(getFilePath());
    private YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

    public List<String> getClanList() {
        if (yamlConfiguration.getStringList("list").size() != 0) {
            return yamlConfiguration.getStringList("list");
        } else {
            return null;
        }
    }
}
