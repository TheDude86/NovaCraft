package io.novacraft.staffchat;

import io.novacraft.core.NovacraftBaseProduct;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffChatProduct extends NovacraftBaseProduct<StaffChatModel> {
    public StaffChatProduct(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setCommandManager(new StaffChatCommandManager(this.model));
    }

    @Override
    public StaffChatModel getInitialModel() {
        return new StaffChatModel();
    }
}
