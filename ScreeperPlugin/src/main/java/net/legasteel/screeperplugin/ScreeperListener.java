package net.legasteel.screeperplugin;

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
import org.bukkit.event.player.PlayerQuitEvent;

public class ScreeperListener implements Listener 
{
	private ScreeperPlugin plugin;
	public static final String DIRECTORY_PATH = "plugins/ScreeperPlugin/";
	
	public static final String INFORMATIONS_FILE_NAME = "informations.sc";
	
	public ScreeperListener(ScreeperPlugin plugin) 
	{
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) 
	{
		// Paths initialisation
		String fp = DIRECTORY_PATH + INFORMATIONS_FILE_NAME;

		//byte[] addr = e.getPlayer().getAddress().getAddress().getAddress();
		String addr = e.getPlayer().getAddress().getHostName();
		String data = new String(new Date().getTime() + 
				":" + e.getPlayer().getUniqueId().toString() + 
				":" + e.getPlayer().getName() + 
				":" + "connect" + "\r\n");
				
		this.plugin.getLogger().info("Connexion du joueur " + e.getPlayer().getName() + ", mise a jour des donnees");
		this.writeFile(data, fp);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) 
	{
		// Paths initialisation
		String fp = DIRECTORY_PATH + INFORMATIONS_FILE_NAME;

		//byte[] addr = e.getPlayer().getAddress().getAddress().getAddress();
		String addr = e.getPlayer().getAddress().getHostName();
		String data = new String(new Date().getTime() + 
				":" + e.getPlayer().getUniqueId().toString() + 
				":" + e.getPlayer().getName() + 
				":" + "disconnect" + "\r\n");
				
		this.plugin.getLogger().info("Deconnexion du joueur " + e.getPlayer().getName() + ", mise a jour des donnees");
		this.writeFile(data, fp);
	}
	
	public void writeFile(String data, String file_path)
	{
		try 
		{
			FileWriter fw = new FileWriter(file_path, true);
			
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
