package io.novacraft.dungeons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdminCommand implements CommandExecutor, TabCompleter {

    List<String> COMMANDS = Arrays.asList("setteleport", "setItemName", "setItemType", "cleariteminfo", "additeminfo", "setcommand");

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String alias, String[] args) {
        Player p = (Player) commandSender;
        if (args.length != 0) {
            if (args[0].equalsIgnoreCase("setteleport")) {
                if (args.length > 1) {
                    int index = getIndex(args[1]);
                    if (!isIndexWithinConstraints(index)) {
                        p.sendMessage("index must be 0 to 26");
                        return true;
                    } else {
                        new WriteToConfig().setTeleportX(index, p.getLocation().getX());
                        new WriteToConfig().setTeleportY(index, p.getLocation().getY());
                        new WriteToConfig().setTeleportZ(index, p.getLocation().getZ());
                        new WriteToConfig().setWorld(index, p.getWorld());
                        new WriteToConfig().setToOpen(index);
                        p.sendMessage("location set to " + p.getLocation().getX() + "," + p.getLocation().getY() + "," + p.getLocation().getZ() + " in world " + p.getWorld());
                        return true;
                    }
                } else {
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("setItemName")) {
                if (args.length > 1) {
                    int index = getIndex(args[1]);
                    if (!isIndexWithinConstraints(index)) {
                        p.sendMessage("index must be 0 to 26");
                        return true;
                    } else {
                        if (args.length >= 3) {
                            StringBuilder itemName = new StringBuilder();
                            for (int i = 2; i < args.length; i++) {
                                itemName.append(args[i]);
                                itemName.append(" ");
                            }
                            new WriteToConfig().setItemName(index, ChatColor.RED + itemName.toString());
                            return true;
                        } else {
                            p.sendMessage("Provide a name!");
                            return true;
                        }
                    }
                } else {
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("setItemType")) {
                if (args.length > 1) {
                    int index = getIndex(args[1]);
                    if (isIndexWithinConstraints(index)) {
                        if (getItemInHand(p).getType() != Material.AIR) {
                            new WriteToConfig().setItemType(index, getItemInHand(p).getType());
                            p.sendMessage("item type set to " + getItemInHand(p).getType());
                            return true;
                        } else {
                            p.sendMessage("Must put item in main hand");
                            return true;
                        }
                    } else {
                        p.sendMessage("index must be 0 to 26");
                        return true;
                    }
                } else {
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("cleariteminfo")) {
                if (args.length > 1) {
                    int index = getIndex(args[1]);
                    if (isIndexWithinConstraints(index)) {
                        new WriteToConfig().clearItemInfo(index);
                        return true;
                    } else {
                        p.sendMessage("index must be 0 to 26");
                        return true;
                    }
                } else {
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("additeminfo")) {
                if (args.length > 1) {
                    int index = getIndex(args[1]);
                    if (isIndexWithinConstraints(index)) {
                        StringBuilder itemInfo = new StringBuilder();
                        for (int i = 2; i < args.length; i++) {
                            itemInfo.append(args[i]);
                            itemInfo.append(" ");
                        }
                        new WriteToConfig().setItemInfo(index, ChatColor.BLUE + itemInfo.toString());
                        return true;
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("setcommand")) {
                if (args.length > 1) {
                    int index = getIndex(args[1]);
                    if (isIndexWithinConstraints(index)) {
                        StringBuilder commandString = new StringBuilder();
                        for (int i = 2; i < args.length; i++) {
                            commandString.append(args[i]);
                            commandString.append(" ");
                        }
                        new WriteToConfig().setCommand(index, commandString.toString());
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    public ItemStack getItemInHand(Player player) {
        return player.getInventory().getItemInMainHand();
    }

    public int getIndex(String index) {
        try {
            return Integer.parseInt(index);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 27;
        }
    }

    public boolean isIndexWithinConstraints(int index) {
        if (index > 26 | index < 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], COMMANDS, new ArrayList<>());
        } else {
            return null;
        }
    }
}