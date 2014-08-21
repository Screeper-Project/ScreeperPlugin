package net.axelandre42.screeperplugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
		File jf = new File(df.getAbsolutePath()+File.separator+"connects.txt");
		OutputStreamWriter osw = null;
		InputStreamReader isr = null;
		try {
			osw = new OutputStreamWriter(new FileOutputStream(jf));
			isr = new InputStreamReader(new FileInputStream(jf));
			byte[] addr = e.getPlayer().getAddress().getAddress().getAddress();
			String str = new String(new Date().getTime() + ":" + e.getPlayer().getUniqueId().toString() + ":" + e.getPlayer().getName() + ":" + addr[0] + "." + addr[1] + "." + addr[2] + "." + addr[3] + "\r");
			char[] chTab = str.toCharArray();
			for (int i = 0; i < chTab.length; i++) {
				osw.append(chTab[i]);
			}
			osw.flush();
			plugin.getLogger().info(str);
			plugin.getLogger().info("Cette ligne a été enregistré dans le fichier : " + jf.getAbsolutePath());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
