package io.novacraft.core;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class EventManager<MODEL> {
    protected MODEL model;

    public EventManager(MODEL model) {
        this.model = model;
    }

    public abstract void initListeners(JavaPlugin plugin);
}
