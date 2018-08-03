package pl.blackwater.namemc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import net.md_5.bungee.api.ChatColor;
import pl.blackwater.namemc.commands.NameMcCommand;
import pl.blackwater.namemc.connect.NameMcConnection;
import pl.blackwater.namemc.settings.Config;

public class Main extends JavaPlugin{
	@Getter private static Main plugin;
	public void onEnable(){
		plugin = this;
		saveDefaultConfig();
		new Config();
		send("&6Sprawdzanie poloczenia z &2pl.NameMC.com &6...");
		boolean status = NameMcConnection.checkConnection();
		if(status){
			send("&6Poloczenie z strona NAMEMC.COM zostalo uzyskane.");
			send("&6Liczba polubien twojego serwer'a: &2" + NameMcConnection.GetNameMCLikeList().size());
		}else{
			send("&6Poloczenie z strona NAMEMC.COM nie zostalo uzyskane. Sprawdz SERVER_IP w configuracji pluginu");
		}
		getCommand("namemc").setExecutor(new NameMcCommand());
	}
	private static void send(String msg){
		Bukkit.getConsoleSender().sendMessage("&7(&4NAMEMC&7) &8» " + ChatColor.translateAlternateColorCodes('&', msg));
	}

}
