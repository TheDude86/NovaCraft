package io.novacraft.trophies.listeners;

/*
 * Created by snowbud56 on August 08, 2019
 * Do not change or use this code without permission
 */

import io.novacraft.trophies.TrophiesModel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class TrophyBreakEvent implements Listener {
    TrophiesModel model;

    TrophyBreakEvent(TrophiesModel model) {
        this.model = model;
    }

    @EventHandler
    public void onTrophyBreak(EntityDamageEvent e) {
        //TODO
    }
}
