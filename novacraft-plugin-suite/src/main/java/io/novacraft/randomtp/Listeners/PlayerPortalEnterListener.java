package io.novacraft.randomtp.Listeners;

/*
 * Created by snowbud56 on July 01, 2019
 * Do not change or use this code without permission
 */

import io.novacraft.randomtp.RandomTPModel;
import io.novacraft.randomtp.TPManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerPortalEnterListener implements Listener {
    public RandomTPModel model;

    public PlayerPortalEnterListener(RandomTPModel model) {
        this.model = model;
    }

    @EventHandler
    public void playerPortalEnter(PlayerMoveEvent e) {
        if (model.portal_base == null || e.getTo() == null) return;
        Player p = e.getPlayer();
        if (e.getTo().getBlock() == e.getFrom().getBlock()) return;
        if (e.getTo().getBlock().getType() == Material.NETHER_PORTAL || e.getTo().getBlock().getType() == Material.END_PORTAL) {
            if (p.getWorld().equals(model.portal_base.getWorld()) && p.getLocation().distance(model.portal_base) <= 5) {
                TPManager.teleportPlayer(p, model);
            }
        }
    }
}
