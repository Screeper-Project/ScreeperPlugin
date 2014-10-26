package net.legasteel.screeperplugin;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import org.bukkit.plugin.java.JavaPlugin;

public class ScreeperPlugin extends JavaPlugin {
	public ScreeperPlugin() {}
	
	@Override
	public void onEnable() {
		this.getLogger().info("Enabling Screeper plugin...");	
		this.getServer().getPluginManager().registerEvents(new ScreeperListener(this), this);
		this.getLogger().info("Screeper plugin Enabled !");
	}
	
	@Override
	public void onDisable() {
		this.getLogger().info("Disabling Screeper plugin...");
	}
}
