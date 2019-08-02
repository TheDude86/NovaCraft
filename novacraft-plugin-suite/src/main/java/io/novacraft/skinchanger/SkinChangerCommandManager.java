package io.novacraft.skinchanger;

import io.novacraft.core.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class SkinChangerCommandManager extends CommandManager<SkinChangerModel> {

    public SkinChangerCommandManager(SkinChangerModel skinChangerModel) {
        super(skinChangerModel);
    }

    @Override
    public void initCommands(JavaPlugin plugin) {
        Objects.requireNonNull(plugin.getCommand("skin")).setExecutor(new SkinCommand(this.model));
    }
}
