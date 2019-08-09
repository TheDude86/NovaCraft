package io.novacraft.dungeons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static io.novacraft.dungeons.CreateGUI.GUI;

public class AddItemsToGUI {

    File file = new File(    "plugins/Dungeons/DungeonGUI.yml");
    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

    public AddItemsToGUI() {
        Set<String> keys = yamlConfiguration.getKeys(false);
        while (keys.size() > 0) {
            ItemStack item = new ItemStack(Material.getMaterial((String) yamlConfiguration.get(keys.toArray()[0].toString() + ".item.type")));
            ItemMeta itemMeta = item.getItemMeta();
            List<String> lore;
            lore = yamlConfiguration.getStringList(keys.toArray()[0].toString() + ".item.info");
            itemMeta.setDisplayName((String) yamlConfiguration.get(keys.toArray()[0].toString() + ".item.name"));
            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);
            GUI.addItem(item);
            keys.remove(keys.toArray()[0]);
        }
    }
}
