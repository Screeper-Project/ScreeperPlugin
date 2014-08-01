package net.axelandre42.screeperplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class ScreeperPlugin extends JavaPlugin {
	public ScreeperPlugin() {}
	
	@Override
	public void onEnable() {
		this.getLogger().info("Enabling Screeper...");
		this.getServer().getPluginManager().registerEvents(new ScreeperListener(this), this);
		this.getLogger().info("Screeper Enabled !");
		
	}
	
	@Override
	public void onDisable() {
		this.getLogger().info("Disabling Screeper...");
	}
}
