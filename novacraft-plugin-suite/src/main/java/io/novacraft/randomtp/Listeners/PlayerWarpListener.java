package io.novacraft.randomtp.Listeners;

import io.novacraft.Novacraft;
import io.novacraft.randomtp.RandomTPModel;
import io.novacraft.randomtp.TPManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Objects;

public class PlayerWarpListener implements Listener {
    private RandomTPModel model;

    public PlayerWarpListener(RandomTPModel model) {
        this.model = model;
    }

    @EventHandler
    public void playerWarpCommandEvent(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().toLowerCase().equals("/warp random")) {
            e.setCancelled(true);
            TPManager.teleportPlayer(e.getPlayer());
        } else if (e.getMessage().toLowerCase().equals("/rtpreload")) {
            e.setCancelled(true);
            model.portal_world = Bukkit.getWorld(Objects.requireNonNull(Novacraft.getInstance().getConfig().getString("portal_world")));
            model.survival_world = Bukkit.getWorld(Objects.requireNonNull(Novacraft.getInstance().getConfig().getString("survival_world")));
            e.getPlayer().sendMessage(ChatColor.GREEN + "Successfully reloaded from config.");
        }
    }
}
