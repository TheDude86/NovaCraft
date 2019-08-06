package io.novacraft.clans.PlayerClanCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.novacraft.clans.PlayerClanCommands.GenerateFile.getFilePath;

public class PlayerClanCommands implements CommandExecutor, TabCompleter {

    private static final List<String> COMMANDS = Arrays.asList("create", "delete", "invite", "leave", "accept", "deny", "list", "addslots", "info", "kick", "setprefix", "setbanner", "getbanner", "tutorial");
    File file = new File(getFilePath());
    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

    @SuppressWarnings("typo")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args[0].equalsIgnoreCase("Create")) {
                new CreateClan(args[1], (Player) sender);
                return true;
            } else if (args[0].equalsIgnoreCase("Delete")) {
                new DeleteClan((Player) sender);
                return true;
            } else if (args[0].equalsIgnoreCase("Invite")) {
                new InvitePlayer(args[1], (Player) sender);
                return true;
            } else if (args[0].equalsIgnoreCase("Leave")) {
                new LeaveClan((Player) sender);
                return true;
            } else if (args[0].equalsIgnoreCase("Accept")) {
                new AcceptInvite((Player) sender);
                return true;
            } else if (args[0].equalsIgnoreCase("Deny")) {
                new DenyInvite((Player) sender);
                return true;
            } else if (args[0].equalsIgnoreCase("List")) {
                new ClanList((Player) sender);
                return true;
            } else if (args[0].equalsIgnoreCase("AddSlots")) {
                new AddSlots((Player) sender);
                return true;
            } else if (args[0].equalsIgnoreCase("Info")) {
                try {
                    if (args[1] != null) {
                        new ClanInfo((Player) sender, args[1]);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    new ClanInfo((Player) sender);
                }
                return true;
            } else if (args[0].equalsIgnoreCase("Kick")) {
                new KickPlayer((Player) sender, args[1]);
                return true;
            } else if (args[0].equalsIgnoreCase("setprefix")) {
                new SetPrefix((Player) sender, args[1], args[2], args[3]);
                return true;
            } else if (args[0].equalsIgnoreCase("setbanner")) {
                new SetClanBanner((Player) sender);
                return true;
            } else if (args[0].equalsIgnoreCase("getbanner")) {
                new GetClanBanner((Player) sender);
                return true;
            } else if (args[0].equalsIgnoreCase("tutorial")) {
                if (args.length == 1) {
                    new Tutorial().Page1((Player) sender);
                } else if (args.length == 2) {
                    if (args[1].equalsIgnoreCase("1")) {
                        new Tutorial().Page1((Player) sender);
                    } else if (args[1].equalsIgnoreCase("2")) {
                        new Tutorial().Page2((Player) sender);
                    } else {
                        Player player = (Player) sender;
                        player.sendMessage(ChatColor.GREEN + "Use " + ChatColor.AQUA + "/clans tutorial 1" + ChatColor.GREEN + " or " + ChatColor.AQUA + "/clans tutorial 2");
                    }
                }
            }
            return false;
        } else {
            sender.sendMessage("You must be a player to use this command!");
            return true;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], COMMANDS, new ArrayList<>());
        } else {
            return null;
        }
    }
}