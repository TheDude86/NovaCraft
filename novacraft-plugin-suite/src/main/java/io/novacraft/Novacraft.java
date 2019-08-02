package io.novacraft;

import io.novacraft.core.Config;
import io.novacraft.core.InitialConfigParser;
import io.novacraft.core.ProductManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Novacraft extends JavaPlugin {

    private static Novacraft instance;

    @Override
    public void onEnable() {
        instance = this;
        System.out.println("Joe was here");
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        ProductManager productManager = new ProductManager(this);
        productManager.createProducts();

        InitialConfigParser parser = new InitialConfigParser();
        Config config = parser.parse(getConfig());

        productManager.startProducts(config);

    }

    public static Novacraft getInstance() {
        return instance;
    }

}
