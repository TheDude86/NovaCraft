package io.novacraft.randomtp.command;

import io.novacraft.core.CommandManager;
import io.novacraft.randomtp.RandomTPModel;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class RandomTPCommandManager extends CommandManager<RandomTPModel> {

    public RandomTPCommandManager(RandomTPModel randomTPModel) {
        super(randomTPModel);
    }

    @Override
    public void initCommands(JavaPlugin plugin) {
        Objects.requireNonNull(plugin.getCommand("rtp")).setExecutor(new WarpCommand(model));
    }
}
