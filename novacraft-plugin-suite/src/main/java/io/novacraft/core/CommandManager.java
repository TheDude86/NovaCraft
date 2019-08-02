package io.novacraft.core;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class CommandManager<MODEL> {
    protected MODEL model;

    public CommandManager(MODEL model) {
        this.model = model;
    }

    public abstract void initCommands(JavaPlugin plugin);
}
