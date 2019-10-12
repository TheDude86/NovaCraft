package io.novacraft.core;

import org.bukkit.configuration.file.FileConfiguration;

public class InitialConfigParser {
    public Config parse(FileConfiguration config) {
        Config configModel = new Config();
        configModel.portal_enabled = config.getBoolean("portal_enabled");
        configModel.portal_location = config.getString("portal_location");
        configModel.x_max = config.getInt("x_max");
        configModel.x_min = config.getInt("x_min");
        configModel.z_max = config.getInt("z_max");
        configModel.z_min = config.getInt("z_min");
        configModel.portal_world = config.getString("portal_world");
        configModel.survival_world = config.getString("survival_world");
        return configModel;
    }
}
