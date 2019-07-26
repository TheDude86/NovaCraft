package io.novacraft;

import io.novacraft.randomtp.RandomTP;
import io.novacraft.randomtp.command.WarpCommand;
import io.novacraft.randomtp.portals.PortalManager;
import io.novacraft.skinchanger.SkinCommand;
import io.novacraft.skinchanger.SkinManager;
import io.novacraft.staffchat.StaffChatCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Novacraft extends JavaPlugin {

    private static Novacraft instance;

    @Override
    public void onEnable() {
        instance = this;
        System.out.println("Joe was here");
        RandomTP.setUpVariables();
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        Objects.requireNonNull(getCommand("rtp")).setExecutor(new WarpCommand());
        Objects.requireNonNull(getServer().getPluginCommand("skin")).setExecutor(new SkinCommand());
        Objects.requireNonNull(getServer().getPluginCommand("sc")).setExecutor(new StaffChatCommand());
        getServer().getPluginManager().registerEvents(new SkinManager(), this);
        getServer().getPluginManager().registerEvents(new WarpCommand(), this);
        getServer().getPluginManager().registerEvents(new PortalManager(), this);
    }

    public static Novacraft getInstance() {
        return instance;
    }

}
