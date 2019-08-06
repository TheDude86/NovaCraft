package io.novacraft.clans.PlayerClanCommands;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static io.novacraft.clans.PlayerClanCommands.GetPrefix.colorPossibilites;

public class Tutorial {

    void Page1(Player player) {
        player.sendMessage(ChatColor.GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        player.sendMessage(ChatColor.AQUA + "Create: " + ChatColor.GREEN + "Create a clan");
        player.sendMessage(ChatColor.AQUA + "Invite: " + ChatColor.GREEN + "Invite a player to your clan");
        player.sendMessage(ChatColor.AQUA + "Leave: " + ChatColor.GREEN + "Leave your clan");
        player.sendMessage(ChatColor.AQUA + "Kick: " + ChatColor.GREEN + "Kick player from your clan");
        player.sendMessage(ChatColor.AQUA + "Delete: " + ChatColor.GREEN + "Delete your clan");
        player.sendMessage(ChatColor.AQUA + "List: " + ChatColor.GREEN + "List all existing clans");
        player.sendMessage(ChatColor.GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    void Page2(Player player) {

        player.sendMessage(ChatColor.GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        player.sendMessage(ChatColor.AQUA + "Info: " + ChatColor.GREEN + "Get info about a clan");
        player.sendMessage(ChatColor.AQUA + "AddSlots: " + ChatColor.GREEN + "Add slots to your clan");
        player.sendMessage(ChatColor.AQUA + "SetBanner: " + ChatColor.GREEN + "Set the banner in your main hand as the clan banner");
        player.sendMessage(ChatColor.AQUA + "SetPrefix:  " + ChatColor.GREEN + "Set a 5 Character limit prefix, you can specify 2 colors");
        player.sendMessage(ChatColor.AQUA + "Colors for prefix: " + ChatColor.GREEN + colorPossibilites.toString().replace("[", "").replace("]", ""));
        player.sendMessage(ChatColor.GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

}
