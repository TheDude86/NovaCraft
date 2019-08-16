package io.novacraft.core;

import io.novacraft.bloodmoon.BloodMoonProduct;
import io.novacraft.core.logging.L;
import io.novacraft.custommining.CustomMiningProduct;
import io.novacraft.randomtp.RandomTPProduct;
import io.novacraft.skinchanger.SkinChangerProduct;
import io.novacraft.staffchat.StaffChatProduct;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class ProductManager {
    ArrayList<NovacraftBaseProduct> products = new ArrayList<>();

    public ProductManager(JavaPlugin plugin) {
        products.add(new RandomTPProduct(plugin));
        products.add(new SkinChangerProduct(plugin));
        products.add(new StaffChatProduct(plugin));
        products.add(new BloodMoonProduct(plugin));
        products.add(new CustomMiningProduct(plugin));
    }

    public void createProducts() {
        L.v("Running onCreate for all products");

        for (NovacraftBaseProduct product: products) {
            product.onCreate();
        }
    }

    public void startProducts(Config config) {
        L.v("Running onStart for all products");

        for (NovacraftBaseProduct product: products) {
            product.onStart(config);
        }
    }

    public void reloadProducts(Config config) {
        for (NovacraftBaseProduct product: products) {
            product.onReload(config);
        }
    }
}
