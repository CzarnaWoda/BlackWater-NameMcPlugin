package pl.blackwater.namemc.settings;

import org.bukkit.configuration.file.FileConfiguration;

import pl.blackwater.namemc.Main;

public class Config {
	public static String SERVER_IP;
	
	public Config(){
		FileConfiguration config = Main.getPlugin().getConfig();
		SERVER_IP = config.getString("server.ip");
	}
}
