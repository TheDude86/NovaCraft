package io.novacraft.skinchanger.listeners;

import com.mojang.authlib.GameProfile;
import io.novacraft.Novacraft;
import io.novacraft.core.logging.L;
import io.novacraft.skinchanger.NMSManager;
import io.novacraft.skinchanger.SkinChangerModel;
import io.novacraft.skinchanger.SkinManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

public class OnPlayerJoinListener implements Listener {
    SkinChangerModel model;

    public OnPlayerJoinListener(SkinChangerModel model) {
        this.model = model;
    }

    @EventHandler
    public void skinUpdateOnJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        model.playerGameProfiles.remove(p);
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Map.Entry<Player, GameProfile> disguise : model.playerGameProfiles.entrySet()) {
                    try {
                        //Craft World and Server
                        Class<?> craftWorldClass = NMSManager.getCraftBukkitClass("CraftWorld");
                        Object converted = craftWorldClass.cast(p.getWorld());
                        Method handle = converted.getClass().getMethod("getHandle");
                        Object worldServObj = handle.invoke(converted);
                        Object convertedToWorldServer = NMSManager.getNMSClass("WorldServer").cast(worldServObj);

                        //EntityPlayer
                        Class<?> entityPlayerClass = NMSManager.getNMSClass("EntityPlayer");
                        Constructor<?> entityPlayerCon = entityPlayerClass.getConstructor(NMSManager.getNMSClass("MinecraftServer"), NMSManager.getNMSClass("WorldServer"), GameProfile.class, NMSManager.getNMSClass("PlayerInteractManager"));

                        Class<?> craftServerClass = NMSManager.getCraftBukkitClass("CraftServer");

                        Object craftServerConverted = craftServerClass.cast(Bukkit.getServer());
                        Method getServerMethod = NMSManager.getCraftBukkitClass("CraftServer").getMethod("getServer");
                        Object minecraftServer = getServerMethod.invoke(craftServerConverted);

                        Class<?> PIMClass = NMSManager.getNMSClass("PlayerInteractManager");
                        Constructor<?> PIMConstructor = PIMClass.getConstructor(NMSManager.getNMSClass("WorldServer"));
                        Object PIMObject = PIMConstructor.newInstance(convertedToWorldServer);

                        Object entityPlayer = entityPlayerCon.newInstance(minecraftServer, convertedToWorldServer, disguise.getValue(), PIMObject);

                        //Setting up craft player
                        Class<?> craftPlayerClass = NMSManager.getCraftBukkitClass("entity.CraftPlayer");
                        Object cPconverted = craftPlayerClass.cast(disguise.getKey());
                        Method targetHandleMethod = cPconverted.getClass().getMethod("getHandle");
                        Object targetHandle = targetHandleMethod.invoke(cPconverted);

                        //Setting up the packets
                        Object playerConnection = NMSManager.getConnection(p);
                        Class<?> packetPlayerInfoClass = NMSManager.getNMSClass("PacketPlayOutPlayerInfo");
                        Class<?> playerInfoActionEnum = NMSManager.getNMSClass("PacketPlayOutPlayerInfo$EnumPlayerInfoAction");
                        Constructor<?> packetPlayerInfoConstructor = packetPlayerInfoClass.getConstructor(playerInfoActionEnum, Iterable.class);
                        Object packetRemovePlayer = packetPlayerInfoConstructor.newInstance(playerInfoActionEnum.getEnumConstants()[4], Collections.singletonList(targetHandle));
                        Object packetAddPlayer = packetPlayerInfoConstructor.newInstance(playerInfoActionEnum.getEnumConstants()[0], Collections.singletonList(entityPlayer));

                        //Sending the packets
                        Method sendPacket = playerConnection.getClass().getMethod("sendPacket", NMSManager.getNMSClass("Packet"));
                        sendPacket.invoke(playerConnection, packetRemovePlayer);
                        sendPacket.invoke(playerConnection, packetAddPlayer);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(disguise.getKey().getName() + "'s disguise has been updated for " + p.getName());
                }
            }
        }.runTaskLater(Novacraft.getInstance(), 3L);
        if (SkinManager.shouldUpdatePlayer(p, model)) {
            Location loc = p.getLocation();
            p.teleport(new Location(Bukkit.getWorld((p.getWorld() == Bukkit.getWorld("world_nether") ? "world" : "world_nether")), 0, 1, 0));
            new BukkitRunnable() {
                @Override
                public void run() {
                    p.teleport(loc);
                    p.setHealth(p.getMaxHealth());
                }
            }.runTaskLater(Novacraft.getInstance(), 5L);
        }
    }
}
