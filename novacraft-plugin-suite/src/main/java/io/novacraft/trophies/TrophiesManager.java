package io.novacraft.trophies;

/*
 * Created by snowbud56 on August 12, 2019
 * Do not change or use this code without permission
 */

import io.novacraft.Novacraft;
import io.novacraft.core.logging.L;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.IOException;

public class TrophiesManager {
    TrophiesModel model;
    private static File trophiesFile = new File(Novacraft.getInstance().getDataFolder(), "trophies.yml");

    public TrophiesManager(TrophiesModel model) {
        this.model = model;
    }

    public void loadTrophies() {
        try {
            if (!trophiesFile.exists()) trophiesFile.createNewFile();

        } catch (IOException ex) {
            L.e("Unable to create trophies file. Exception: " + ex);
            return;
        }
        YamlConfiguration configFile = YamlConfiguration.loadConfiguration(trophiesFile);
        if (configFile.getConfigurationSection("trophies") != null) {
            for (String name : configFile.getConfigurationSection("trophies").getKeys(false)) {
                Trophy trophy = new Trophy();
                Vector headPos = vectorFromString(configFile.getString("trophies." + name + ".poses.Head"));
                Vector leftArmPos = vectorFromString(configFile.getString("trophies." + name + ".poses.LeftArm"));
                Vector rightArmPos = vectorFromString(configFile.getString("trophies." + name + ".poses.RightArm"));
                Vector leftLegPos = vectorFromString(configFile.getString("trophies." + name + ".poses.LeftLeg"));
                Vector rightLegPos = vectorFromString(configFile.getString("trophies." + name + ".poses.RightLeg"));
                if (headPos == null || leftArmPos == null || rightArmPos == null || leftLegPos == null || rightLegPos == null) {
                    L.a("Unable to setup trophy '" + name + "', one of the positions aren't setup correctly.");
                    continue;
                } else {
                    //Strings: leftArm, rightArm, leftLeg, rightLeg, head
                    trophy.positions.put("head", headPos);
                    trophy.positions.put("leftArm", leftArmPos);
                    trophy.positions.put("rightArm", rightArmPos);
                    trophy.positions.put("leftLeg", leftLegPos);
                    trophy.positions.put("rightLeg", rightLegPos);
                }
                //TODO setup armor stuff and things
            }
        }
    }

    private Vector vectorFromString(String string) {
        Vector vector = new Vector();
        try {
            String[] coords = string.split(",");
            if (coords.length == 3) {
                vector.setX(Double.parseDouble(coords[0].split(":")[1]));
                vector.setY(Double.parseDouble(coords[1].split(":")[1]));
                vector.setZ(Double.parseDouble(coords[2].split(":")[1]));
            } else {
                return null;
            }
        } catch (NumberFormatException ex) {
            return null;
        }
        return vector;
    }

    //trophies:
    //  <name>:
    //  item:
    //      material: PLAYER_SKULL
    //      owner: "snowbud56"
    //  poses:
    //      Head: x:15, y:65, z:54
    //      LeftArm: x:15, y:65, z:54
    //      RightArm: x:15, y:65, z:54
    //      LeftLeg: x:15, y:65, z:54
    //      RightLeg: x:15, y:65, z:54
    //  armor:
    //      helmet:
    //          material: DIAMOND_SWORD
    //          owner: "The_Dude___"
    //          enchanted: false
    //      chestplate:
    //          material: LEATHER_CHESTPLATE
    //          enchanted: true
    //      pants:
    //          material: LEATHER_PANTS
    //          enchanted: false
    //      boots:
    //          material: LEATHER_BOOTS
    //          enchanted: false
}
