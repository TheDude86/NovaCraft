package io.novacraft.dungeons;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CreateGUI {

    static Inventory GUI;
    ItemStack item;
    ItemMeta itemMeta;
    ArrayList<String> lore;

    CreateGUI(Player player) {
        GUI = Bukkit.getServer().createInventory(player, 27, "Dungeons");
        new AddItemsToGUI();
        player.openInventory(GUI);
    }

    static Inventory getInventory() {
        return GUI;
    }

}
