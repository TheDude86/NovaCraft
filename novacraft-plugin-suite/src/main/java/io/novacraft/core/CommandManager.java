package io.novacraft.core;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public abstract class CommandManager<MODEL> {
    protected MODEL model;
    private JavaPlugin plugin;

    public CommandManager(MODEL model) {
        this.model = model;
    }

    public void addCommands(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void bindCommand(String commandString, CommandExecutor executor) {
        Objects.requireNonNull(plugin.getCommand(commandString)).setExecutor(executor);
    }
}
