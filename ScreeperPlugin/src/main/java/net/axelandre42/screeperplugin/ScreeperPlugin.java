package net.axelandre42.screeperplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ScreeperPlugin extends JavaPlugin {
	@Override
	public void onEnable() {
		this.getLogger().info("Enabling Screeper...");
		
		FileConfiguration config = this.getConfig();
		
		if (!config.contains("web.url"))
			config.addDefault("web.url", "http://example.com/");
		
		this.getServer().getPluginManager().registerEvents(new ScreeperListener("", this), this);
		this.getLogger().info("Screeper Enabled !");
	}
	
	@Override
	public void onDisable() {
		this.getLogger().info("Disabling Screeper...");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("screeper")) {
			
		}
		return false;
	}
}
