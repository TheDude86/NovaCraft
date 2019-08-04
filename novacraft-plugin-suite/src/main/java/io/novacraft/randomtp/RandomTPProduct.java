//package io.novacraft.randomtp;
//
//import io.novacraft.core.NovacraftBaseProduct;
//import io.novacraft.randomtp.Listeners.RandomTPEventManager;
//import io.novacraft.randomtp.command.RandomTPCommandManager;
//import org.bukkit.plugin.java.JavaPlugin;
//
//public class RandomTPProduct extends NovacraftBaseProduct<RandomTPModel> {
//
//    public RandomTPProduct(JavaPlugin plugin) {
//        super(plugin);
//    }
//
//    @Override
//    public void onCreate() {
//        setCommandManager(new RandomTPCommandManager(this.model));
//        setEventManager(new RandomTPEventManager(this.model));
//        setConfigMapper(new RandomTPConfigMapper());
//    }
//}
