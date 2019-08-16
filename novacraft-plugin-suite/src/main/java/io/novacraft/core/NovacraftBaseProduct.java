package io.novacraft.core;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class NovacraftBaseProduct<MODEL> {
    protected JavaPlugin plugin;
    private CommandManager<MODEL> commandManager;
    private EventManager<MODEL> eventManager;
    private ConfigMapper<MODEL> configMapper;
    protected MODEL model;

    public NovacraftBaseProduct(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void onCreate() {
        model = getInitialModel();
    }

    abstract public MODEL getInitialModel();

    public void onStart(Config config) {
        if (this.configMapper != null) this.configMapper.mapConfigData(model, config);
        if (this.commandManager != null) this.commandManager.addCommands(this.plugin);
        if (this.eventManager != null) this.eventManager.initListeners(this.plugin);
    }

    void onReload(Config config) {
        if (this.configMapper != null) this.configMapper.mapConfigData(model, config);
    }

    protected void setCommandManager(CommandManager<MODEL> commandManager) {
        this.commandManager = commandManager;
    }

    protected void setEventManager(EventManager<MODEL> eventManager) {
        this.eventManager = eventManager;
    }

    protected void setConfigMapper(ConfigMapper<MODEL> configMapper) {
        this.configMapper = configMapper;
    }
}
