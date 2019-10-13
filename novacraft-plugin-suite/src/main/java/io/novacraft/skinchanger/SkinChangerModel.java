package io.novacraft.skinchanger;

import com.mojang.authlib.GameProfile;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SkinChangerModel {
    public Map<Player, GameProfile> playerGameProfiles = new HashMap<>();

    public long commandCooldown = 3600000L;
    public Map<UUID, Long> commandCoolDowns = new HashMap<>();

    public boolean test = false;
}
