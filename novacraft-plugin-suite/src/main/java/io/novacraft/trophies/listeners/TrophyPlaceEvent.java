package io.novacraft.trophies.listeners;

import io.novacraft.trophies.TrophiesModel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class TrophyPlaceEvent implements Listener {
    TrophiesModel model;

    TrophyPlaceEvent(TrophiesModel model) {
        this.model = model;
    }

    @EventHandler
    public void onTrophyPlace(BlockPlaceEvent e) {
        //TODO
    }

}
