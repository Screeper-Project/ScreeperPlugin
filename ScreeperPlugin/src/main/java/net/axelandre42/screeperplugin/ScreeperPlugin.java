package net.axelandre42.screeperplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ScreeperPlugin extends JavaPlugin {
	@Override
	public void onEnable() {
		this.getLogger().info("Enabling Screeper...");
		
		this.getServer().getPluginManager().registerEvents(new ScreeperListener(this.getConfig().getString("web.url"), this), this);
		this.getLogger().info("Screeper Enabled !");
		
	}
	
	@Override
	public void onDisable() {
		this.getLogger().info("Disabling Screeper...");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("screeper")) {
			if (args[0].equalsIgnoreCase("config") && sender.hasPermission("screeper.config")) {
				if (args.length == 3) {
					this.getConfig().set(args[1], args[2]);
					this.saveConfig();
					sender.sendMessage("Successfully set this configuration node !");
					return true;
				} else {
					sender.sendMessage("Arguments length is not valid.");
					return false;
				}
			}
		}
		return false;
	}
}
