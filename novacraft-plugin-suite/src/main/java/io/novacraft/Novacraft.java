package io.novacraft;

import io.novacraft.core.Config;
import io.novacraft.core.InitialConfigParser;
import io.novacraft.core.ProductManager;
import io.novacraft.core.logging.L;
import org.bukkit.plugin.java.JavaPlugin;

public class Novacraft extends JavaPlugin {

    private static Novacraft instance;

    @Override
    public void onEnable() {
        instance = this;
        L.v("The Novacraft plugin suite is enabled");
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        ProductManager productManager = new ProductManager(this);
        productManager.createProducts();

        InitialConfigParser parser = new InitialConfigParser();
        Config config = parser.parse(getConfig());

        productManager.startProducts(config);

    }

    @Override
    public void onDisable() {
        super.onDisable();
        L.v("The Novacraft plugin suite is disabled");
    }

    public static Novacraft getInstance() {
        return instance;
    }

}
