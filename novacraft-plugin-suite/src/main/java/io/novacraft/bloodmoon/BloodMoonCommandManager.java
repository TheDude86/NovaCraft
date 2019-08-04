package io.novacraft.bloodmoon;

import io.novacraft.core.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BloodMoonCommandManager extends CommandManager<BloodMoonModel> {
    public BloodMoonCommandManager(BloodMoonModel bloodMoonModel) {
        super(bloodMoonModel);
    }

    @Override
    public void addCommands(JavaPlugin plugin) {
        super.addCommands(plugin);
        bindCommand("gmp", new BloodMoonCommand());
    }
}
