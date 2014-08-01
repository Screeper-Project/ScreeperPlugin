package net.axelandre42.screeperplugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ScreeperListener implements Listener {
	private ScreeperPlugin plugin;
	
	public ScreeperListener(ScreeperPlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		File df = this.plugin.getDataFolder();
		File jf = new File(df.getAbsolutePath()+File.separator+"file.txt");
		OutputStreamWriter osw = null;
		try {
			osw = new OutputStreamWriter(new FileOutputStream(jf));
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			try {
				jf.createNewFile();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			onJoin(e);
		}
		try {
			osw.write(new Date().getTime() + ":" + e.getPlayer().getUniqueId().toString() + ":" + e.getPlayer().getName() + ":" + e.getPlayer().getAddress().getHostName());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
