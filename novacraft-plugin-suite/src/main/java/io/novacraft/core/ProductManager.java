package io.novacraft.core;

import io.novacraft.randomtp.RandomTPProduct;
import io.novacraft.skinchanger.SkinChangerProduct;
import io.novacraft.staffchat.StaffChatProduct;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class ProductManager {
    ArrayList<NovacraftBaseProduct> products = new ArrayList<>();

    public ProductManager(JavaPlugin plugin) {
        products.add(new RandomTPProduct(plugin).build());
        products.add(new SkinChangerProduct(plugin).build());
        products.add(new StaffChatProduct(plugin).build());
        products.add(new BloodMoonProduct(plugin).build());
    }

    public void initializeProducts(Config config) {
        for (NovacraftBaseProduct product: products) {
            product.initialize(config);
        }
    }
}
