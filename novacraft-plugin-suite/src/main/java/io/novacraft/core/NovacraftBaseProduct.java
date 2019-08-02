package io.novacraft.core;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class NovacraftBaseProduct<MODEL> {
    protected JavaPlugin plugin;
    protected CommandManager<MODEL> commandManager;
    protected EventManager<MODEL> eventManager;
    protected ConfigMapper<MODEL> configMapper;
    protected MODEL model;

    public NovacraftBaseProduct(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    abstract public NovacraftBaseProduct build();

    protected void initialize(Config config) {
        if (this.commandManager != null) this.commandManager.initCommands(this.plugin);
        if (this.eventManager != null) this.eventManager.initListeners(this.plugin);
        if (this.configMapper != null) model = this.configMapper.mapConfigData(config);
    }
}
