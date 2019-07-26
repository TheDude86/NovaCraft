package io.novacraft.randomtp.command;

/*
 * Created by snowbud56 on July 01, 2019
 * Do not change or use this code without permission
 */

import io.novacraft.Novacraft;
import io.novacraft.randomtp.RandomTP;
import io.novacraft.randomtp.TPManager;
import io.novacraft.randomtp.portals.PortalManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Objects;

public class WarpCommand implements CommandExecutor, Listener {

    @EventHandler
    public void playerWarpCommandEvent(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().toLowerCase().equals("/warp random")) {
            e.setCancelled(true);
            TPManager.teleportPlayer(e.getPlayer());
        } else if (e.getMessage().toLowerCase().equals("/rtpreload")) {
            e.setCancelled(true);
            RandomTP.portalWorld = Bukkit.getWorld(Objects.requireNonNull(Novacraft.getInstance().getConfig().getString("portal_world")));
            RandomTP.teleportWorld = Bukkit.getWorld(Objects.requireNonNull(Novacraft.getInstance().getConfig().getString("survival_world")));
            if (Novacraft.getInstance().getConfig().getBoolean("portal_enabled")) PortalManager.initiate();
            e.getPlayer().sendMessage(ChatColor.GREEN + "Successfully reloaded from config.");
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
            return false;
        }
        TPManager.teleportPlayer((Player) sender);
        return true;
    }
}