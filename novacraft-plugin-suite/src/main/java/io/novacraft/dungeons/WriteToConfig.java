package io.novacraft.dungeons;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WriteToConfig {

    File file = new File(    "plugins/Dungeons/DungeonGUI.yml");
    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

    public void setTeleportX(int index, double xPos) {
        yamlConfiguration.set(index + ".teleport.x", xPos);
        save();
    }

    public void setTeleportY(int index, double yPos) {
        yamlConfiguration.set(index + ".teleport.y", yPos);
        save();
    }

    public void setTeleportZ(int index, double zPos) {
        yamlConfiguration.set(index + ".teleport.z", zPos);
        save();
    }

    public void setWorld(int index, World world) {
        yamlConfiguration.set(index + ".worldname", world.getName());
        save();
    }

    public void setItemName(int index, String name) {
        yamlConfiguration.set(index + ".item.name", name);
        save();
    }

    public void setItemType(int index, Material type) {
        yamlConfiguration.set(index + ".item.type", type.toString());
        save();
    }

    public void clearItemInfo(int index) {
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        yamlConfiguration.set(index + ".item.info", lore.toArray());
        save();
    }

    public void setItemInfo(int index, String info) {
        ArrayList<String> lore = (ArrayList<String>) yamlConfiguration.getStringList(index + ".item.info");
        lore.add(info);
        if (lore.get(0).equals("")) {
            lore.remove(0);
        }
        yamlConfiguration.set(index + ".item.info", lore.toArray());
        save();
    }

    public void setToActive(int index) {
        yamlConfiguration.set(index + ".status", DungeonStatus.ACTIVE.toString());
        save();
    }

    public void setToOpen(int index) {
        yamlConfiguration.set(index + ".status", DungeonStatus.OPEN.toString());
        save();
    }

    public void setToCooldown(int index) {
        yamlConfiguration.set(index + ".status", DungeonStatus.COOLDOWN.toString());
        save();
    }

    public void setTimestamp(int index) {
        yamlConfiguration.set(index + ".timestamp", System.currentTimeMillis());
        save();
    }

    public void setCommand(int index, String command) {
        yamlConfiguration.set(index + ".command", command);
        save();
    }

    public void save() {
        try {
            yamlConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
