package io.novacraft;

import io.novacraft.core.Config;
import io.novacraft.core.InitialConfigParser;
import io.novacraft.core.ProductManager;
import io.novacraft.randomtp.RandomTP;
import org.bukkit.plugin.java.JavaPlugin;

public class Novacraft extends JavaPlugin {

    private static Novacraft instance;

    @Override
    public void onEnable() {
        instance = this;
        System.out.println("Joe was here");
        RandomTP.setUpVariables();
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        InitialConfigParser parser = new InitialConfigParser();
        Config config = parser.parse(getConfig());

        ProductManager productManager = new ProductManager(this);
        productManager.initializeProducts(config);

    }

    public static Novacraft getInstance() {
        return instance;
    }

}
