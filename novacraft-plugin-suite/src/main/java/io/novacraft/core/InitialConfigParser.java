package io.novacraft.core;

import org.bukkit.configuration.file.FileConfiguration;

public class InitialConfigParser {
    public Config parse(FileConfiguration config) {
        Config configModel = new Config();
        configModel.portal_enabled = config.getBoolean("portal_enabled");
        configModel.portal_location = config.getString("portal_location");


        return configModel;
    }
}
