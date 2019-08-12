package io.novacraft.bloodmoon;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BloodMoon extends JavaPlugin {
	
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		 BloodMoonListener listener = new BloodMoonListener(this);
		 pm.registerEvents(listener, this);
	}
	
	@Override
	public void onDisable() {
		getLogger().info("BloodMoon has been disabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		World world = player.getWorld();
		
		if(sender instanceof Player) {
			String lowerCmd = cmd.getName().toLowerCase();
			switch(lowerCmd) {
				case "getmoonphase":
					player.sendMessage("" + GetMoonPhase.getMoonPhase(world));
					return true;
				default:
					player.sendMessage("Your command doesn't exist.");
					return true;
			}
		}
		
		return true;
	 }
}
