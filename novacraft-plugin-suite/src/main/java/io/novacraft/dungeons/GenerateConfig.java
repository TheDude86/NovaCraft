package io.novacraft.dungeons;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GenerateConfig {

    String path = "plugins/Dungeons";
    String fileName = path + "/DungeonGUI.yml";
    ArrayList<String> info = new ArrayList<>();

    GenerateConfig() {
        try {
            info.add("");
            File file1 = new File(path);
            if (file1.exists()) {
            } else {
                file1.mkdir();
            }
            File file = new File(fileName);
            if (file.createNewFile()) {
                YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
