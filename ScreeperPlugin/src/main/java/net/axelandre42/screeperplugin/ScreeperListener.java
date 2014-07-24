package net.axelandre42.screeperplugin;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ScreeperListener implements Listener {
	private URL url;
	private ScreeperPlugin plugin;
	
	public ScreeperListener(String url, ScreeperPlugin plugin) {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			this.plugin.getLogger().log(Level.WARNING, "The comunicating URL is malformed ! You will can't communicate with the web interface.");
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		try {
			int code = ScreeperPluginUtils.httpPostRequest(url,
					ScreeperPluginUtils.encodeToURL("type=join", "dName=" + e.getPlayer().getDisplayName()));
			this.plugin.getLogger().log(Level.INFO, "The request " + url.toString() + " has returned " + code);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			this.plugin.getLogger().log(Level.WARNING, "The request to " + url.toString() + " has throwed an exception !");
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		try {
			int code = ScreeperPluginUtils.httpPostRequest(url,
					ScreeperPluginUtils.encodeToURL("type=quit", "dName=" + e.getPlayer().getDisplayName()));
			this.plugin.getLogger().log(Level.INFO, "The request " + url.toString() + " has returned " + code);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			this.plugin.getLogger().log(Level.WARNING, "The request to " + url.toString() + " has throwed an exception !");
		}
	}
}
