package io.novacraft.dungeons;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class GUIListener implements Listener {

    File file = new File(    "plugins/Dungeons/DungeonGUI.yml");
    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

    @EventHandler
    private void inventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        if (e.getInventory() == CreateGUI.GUI) {
             try {
                 if (item.getType()!= null | item.getType() != Material.AIR) {
                     e.setCancelled(true);
                     if (yamlConfiguration.getString(e.getRawSlot() + ".status").equals(DungeonStatus.OPEN.toString())) {
                         getServer().dispatchCommand(getServer().getConsoleSender(), new GetCommand().getCommand(e.getRawSlot()));
                         new WriteToConfig().setToActive(e.getRawSlot());
                         new WriteToConfig().setTimestamp(e.getRawSlot());
                         p.teleport(new Location(Bukkit.getWorld(yamlConfiguration.getString(e.getRawSlot() + ".worldname")), yamlConfiguration.getDouble(e.getRawSlot() + ".teleport.x"), yamlConfiguration.getDouble(e.getRawSlot() + ".teleport.y"), yamlConfiguration.getDouble(e.getRawSlot() + ".teleport.z")));
                     } else if ((((System.currentTimeMillis() - yamlConfiguration.getLong(e.getRawSlot() + ".timestamp")) / 60000)) >= 1) {
                         new WriteToConfig().setToOpen(e.getRawSlot());
                         inventoryClick(e);
                     } else {
                         new WriteToConfig().setToCooldown(e.getRawSlot());
                     }
                 }
             } catch (NullPointerException n) {

             } catch (IllegalArgumentException i) {

             }
        }
    }
}