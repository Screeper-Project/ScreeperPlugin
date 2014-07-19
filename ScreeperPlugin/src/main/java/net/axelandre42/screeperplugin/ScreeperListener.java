package net.axelandre42.screeperplugin;

import java.net.MalformedURLException;
import java.net.URL;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ScreeperListener implements Listener {
	private URL url;
	
	public ScreeperListener(String url, ScreeperPlugin plugin) {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
	}
}
