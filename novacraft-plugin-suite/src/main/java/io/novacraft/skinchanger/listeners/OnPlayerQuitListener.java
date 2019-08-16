package io.novacraft.skinchanger.listeners;

import com.mojang.authlib.GameProfile;
import io.novacraft.skinchanger.NMSManager;
import io.novacraft.skinchanger.SkinChangerModel;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;

public class OnPlayerQuitListener implements Listener {
    SkinChangerModel model;

    public OnPlayerQuitListener(SkinChangerModel model) {
        this.model = model;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (model.playerGameProfiles.containsKey(e.getPlayer())) {
            for (Player target : Bukkit.getOnlinePlayers()) {
                try {
                    Class<?> craftWorldClass = NMSManager.getCraftBukkitClass("CraftWorld");
                    Object converted = craftWorldClass.cast(e.getPlayer().getWorld());
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

                    Object entityPlayer = entityPlayerCon.newInstance(minecraftServer, convertedToWorldServer, model.playerGameProfiles.get(e.getPlayer()), PIMObject);

                    //Setting up craft player
                    Class<?> craftPlayerClass = NMSManager.getCraftBukkitClass("entity.CraftPlayer");
                    Object cPconverted = craftPlayerClass.cast(e.getPlayer());
                    Method targetHandleMethod = cPconverted.getClass().getMethod("getHandle");
                    Object targetHandle = targetHandleMethod.invoke(cPconverted);

                    //Setting up the packets
                    Object playerConnection = NMSManager.getConnection(target);
                    Class<?> packetPlayerInfoClass = NMSManager.getNMSClass("PacketPlayOutPlayerInfo");
                    Class<?> playerInfoActionEnum = NMSManager.getNMSClass("PacketPlayOutPlayerInfo$EnumPlayerInfoAction");
                    Constructor<?> packetPlayerInfoConstructor = packetPlayerInfoClass.getConstructor(playerInfoActionEnum, Iterable.class);
                    Object packetRemovePlayer = packetPlayerInfoConstructor.newInstance(playerInfoActionEnum.getEnumConstants()[4], Collections.singletonList(entityPlayer));

                    //Sending the packets
                    Method sendPacket = playerConnection.getClass().getMethod("sendPacket", NMSManager.getNMSClass("Packet"));
                    sendPacket.invoke(playerConnection, packetRemovePlayer);
                } catch (Exception er) {
                    er.printStackTrace();
                }
            }
        }
        model.playerGameProfiles.remove(e.getPlayer());
    }
}
