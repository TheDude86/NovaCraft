package io.novacraft.randomtp;

/*
 * Created by snowbud56 on July 23, 2019
 * Do not change or use this code without permission
 */

import io.novacraft.Novacraft;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.Objects;

public class RandomTP {

    public static World portalWorld;
    public static World teleportWorld;

    public static void setUpVariables() {

        portalWorld = Bukkit.getWorld(Objects.requireNonNull(Novacraft.getInstance().getConfig().getString("portal_world")));
        teleportWorld = Bukkit.getWorld(Objects.requireNonNull(Novacraft.getInstance().getConfig().getString("survival_world")));
    }

    public static World getPortalWorld() {
        return portalWorld;
    }

    public static World getTeleportWorld() {
        return teleportWorld;
    }
}