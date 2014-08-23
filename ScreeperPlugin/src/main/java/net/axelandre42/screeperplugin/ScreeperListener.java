package net.axelandre42.screeperplugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ScreeperListener implements Listener 
{
	private ScreeperPlugin plugin;
	
	public ScreeperListener(ScreeperPlugin plugin) 
	{
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) 
	{
		try 
		{
			File df = this.plugin.getDataFolder();
			String fp = df.getAbsolutePath() + File.separator + "connects.txt";

			FileWriter fw = new FileWriter(fp, true);

			byte[] addr = e.getPlayer().getAddress().getAddress().getAddress();
			String data = new String(new Date().getTime() + ":" + e.getPlayer().getUniqueId().toString() + ":" + e.getPlayer().getName() + ":" + addr[0] + "." + addr[1] + "." + addr[2] + "." + addr[3] + "\r\n");

			fw.write(data); 
			fw.flush();
			fw.close();
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
	}
}
