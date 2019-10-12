package io.novacraft.staffchat;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StaffChatModel {

    public Map<UUID, Player> lastMessaged = new HashMap<>();

}
