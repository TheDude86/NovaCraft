//package io.novacraft.randomtp;
//
//import io.novacraft.Novacraft;
//import io.novacraft.core.Config;
//import io.novacraft.core.ConfigMapper;
//import org.bukkit.Bukkit;
//import org.bukkit.Location;
//import org.bukkit.World;
//
//public class RandomTPConfigMapper implements ConfigMapper<RandomTPModel> {
//
//    @Override
//    public RandomTPModel mapConfigData(Config model) {
//        RandomTPModel randomTPModel = new RandomTPModel();
//        randomTPModel.portal_enabled = model.portal_enabled;
//        randomTPModel.portal_location = model.portal_location;
//        randomTPModel.portal_world = Bukkit.getWorld(model.portal_world);
//        randomTPModel.survival_world = Bukkit.getWorld(model.survival_world);
//
//        if (randomTPModel.portal_enabled) {
//            String[] coords = Novacraft.getInstance().getConfig().getString("portal_location").split(",");
//            double x, y, z;
//            if (coords.length == 3) {
//                x = Double.parseDouble(coords[0].split(":")[1]);
//                y = Double.parseDouble(coords[1].split(":")[1]);
//                z = Double.parseDouble(coords[2].split(":")[1]);
//
//                World world = randomTPModel.portal_world;
//                if (world == null) {
//                    System.out.println("[RandomTP] The portal world is invalid! The portal won't work.");
//                    return randomTPModel;
//                }
//                randomTPModel.portal_base = new Location(world, x, y, z);
//
//            } else {
//                System.out.println("[RandomTP] The portal location is invalid! The portal won't work.");
//                return randomTPModel;
//            }
//
//        }
//
//
//        return randomTPModel;
//    }
//}
