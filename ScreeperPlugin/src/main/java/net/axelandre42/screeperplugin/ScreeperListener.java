package net.axelandre42.screeperplugin;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ScreeperListener implements Listener {
	private String url;
	private ScreeperPlugin plugin;
	
	public ScreeperListener(String url, ScreeperPlugin plugin) {
		this.plugin = plugin;
		this.url = url;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		try {
			URL inst;
			inst = new URL(url + e.getPlayer().getName());
				try {
					int code = ScreeperPluginUtils.httpPostRequest(inst);
					this.plugin.getLogger().log(Level.INFO, "The request " + inst.toString() + " has returned " + code);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					this.plugin.getLogger().log(Level.WARNING, "The request to " + inst.toString() + " has throwed an exception !");
				}
		} catch (MalformedURLException e2) {
			// TODO Auto-generated catch block
			this.plugin.getLogger().severe("The URL given in tne config is malformed !!!");
		}
	}
}
