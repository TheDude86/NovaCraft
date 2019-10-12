package io.novacraft.staffchat;

import io.novacraft.core.CommandManager;
import io.novacraft.staffchat.command.StaffChatCommand;
import io.novacraft.staffchat.command.StaffChatMessageCommand;
import io.novacraft.staffchat.command.StaffChatReplyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffChatCommandManager extends CommandManager<StaffChatModel> {

    public StaffChatCommandManager(StaffChatModel staffChatModel) {
        super(staffChatModel);
    }

    @Override
    public void addCommands(JavaPlugin plugin) {
        super.addCommands(plugin);
        bindCommand("a", new StaffChatCommand());
        bindCommand("ma", new StaffChatMessageCommand(model));
        bindCommand("ra", new StaffChatReplyCommand(model));
    }
}
