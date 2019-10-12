package io.novacraft.trophies;


import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

public class Trophy {

    public String name;

    //Strings: leftArm, rightArm, leftLeg, rightLeg, head
    public Map<String, Vector> positions = new HashMap<>();

    //Strings: helmet, chestplate, pants, boots
    public Map<String, ItemStack> armor = new HashMap<>();

}
