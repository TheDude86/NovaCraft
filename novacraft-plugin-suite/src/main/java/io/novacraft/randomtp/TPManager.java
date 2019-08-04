//package io.novacraft.randomtp;
//
///*
// * Created by snowbud56 on July 01, 2019
// * Do not change or use this code without permission
// */
//
//import io.novacraft.Novacraft;
//import org.bukkit.Location;
//import org.bukkit.Material;
//import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.entity.Player;
//
//import java.util.Objects;
//import java.util.Random;
//
//public class TPManager {
//
//    public static void teleportPlayer(Player p, RandomTPModel model) {
//        FileConfiguration config = Novacraft.getInstance().getConfig();
//        int minX = config.getInt("x_min");
//        int maxX = config.getInt("x_max");
//        int minZ = config.getInt("z_min");
//        int maxZ = config.getInt("z_max");
//        Random r = new Random();
//        int x = r.nextInt(maxX - minX) + minX;
//        int z = r.nextInt(maxZ - minZ) + minZ;
//        int y = 255;
//        boolean foundY = false;
//        Location location = new Location(model.survival_world, x, y, z);
//        Objects.requireNonNull(location.getWorld()).loadChunk(location.getChunk());
//        while (!foundY) {
//            if (location.getBlock().getType() != Material.AIR) {
//                foundY = true;
//                p.teleport(location.add(0, 2,0));
//            } else {
//                location.add(0, -1, 0);
//            }
//            if (location.getY() <= 0) {
//                teleportPlayer(p, model);
//                return;
//            }
//        }
//    }
//}
