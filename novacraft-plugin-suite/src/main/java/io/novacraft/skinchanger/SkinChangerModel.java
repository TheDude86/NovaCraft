package io.novacraft.skinchanger;

import com.mojang.authlib.GameProfile;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class SkinChangerModel {
    public Map<Player, GameProfile> playerGameProfiles = new HashMap<>();
    public boolean test = false;
}
