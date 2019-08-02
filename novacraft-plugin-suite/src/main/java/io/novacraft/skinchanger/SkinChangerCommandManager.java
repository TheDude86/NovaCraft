package io.novacraft.skinchanger;

import io.novacraft.core.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SkinChangerCommandManager extends CommandManager<SkinChangerModel> {

    public SkinChangerCommandManager(SkinChangerModel skinChangerModel) {
        super(skinChangerModel);
    }

    @Override
    public void addCommands(JavaPlugin plugin) {
        super.addCommands(plugin);
        bindCommand("skin", new SkinCommand(this.model));
    }
}
