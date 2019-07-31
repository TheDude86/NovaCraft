package io.novacraft.staffchat;

import io.novacraft.core.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public class StaffChatCommandManager extends CommandManager<StaffChatModel> {

    public StaffChatCommandManager(StaffChatModel staffChatModel) {
        super(staffChatModel);
    }

    @Override
    public void initCommands(JavaPlugin plugin) {
        Objects.requireNonNull(getServer().getPluginCommand("sc")).setExecutor(new StaffChatCommand());
    }
}
