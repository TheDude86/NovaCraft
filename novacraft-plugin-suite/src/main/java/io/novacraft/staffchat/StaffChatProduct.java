package io.novacraft.staffchat;

import io.novacraft.core.NovacraftBaseProduct;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffChatProduct extends NovacraftBaseProduct<StaffChatModel> {
    public StaffChatProduct(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public NovacraftBaseProduct build() {
        this.commandManager = new StaffChatCommandManager(this.model);

        return this;
    }
}
