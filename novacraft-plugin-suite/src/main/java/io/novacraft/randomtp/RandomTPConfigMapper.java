package io.novacraft.randomtp;

import io.novacraft.Novacraft;
import io.novacraft.core.Config;
import io.novacraft.core.ConfigMapper;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class RandomTPConfigMapper implements ConfigMapper<RandomTPModel> {


    @Override
    public void mapConfigData(RandomTPModel productModel, Config model) {
        productModel.portal_enabled = model.portal_enabled;
        productModel.portal_location = model.portal_location;
        productModel.xMax = model.x_max;
        productModel.xMin = model.x_min;
        productModel.zMax = model.z_max;
        productModel.zMin = model.z_min;

        String portalWorld = model.portal_world == null ? "world" : model.portal_world;
        String survivalWorld = model.survival_world == null ? "world" : model.survival_world;
        productModel.portal_world = Bukkit.getWorld(portalWorld);
        productModel.survival_world = Bukkit.getWorld(survivalWorld);

        if (productModel.portal_enabled) {
            String[] coords = Novacraft.getInstance().getConfig().getString("portal_location").split(",");
            double x, y, z;
            if (coords.length == 3) {
                x = Double.parseDouble(coords[0].split(":")[1]);
                y = Double.parseDouble(coords[1].split(":")[1]);
                z = Double.parseDouble(coords[2].split(":")[1]);

                World world = productModel.portal_world;
                if (world == null) {
                    System.out.println("[RandomTP] The portal world is invalid! The portal won't work.");
                    return;
                }
                productModel.portal_base = new Location(world, x, y, z);

            } else {
                System.out.println("[RandomTP] The portal location is invalid! The portal won't work.");
            }
        }
    }
}
