package pl.blackwater.namemc.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Util {
	
	public static String fixColor(String s){
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	public static boolean sendMsg(Player p, String s){
		if(s != null){
			p.sendMessage(fixColor(s));
			return true;
		}
		return false;
	}
	public static boolean sendMsg(CommandSender sender, String s){
		if(s != null){
			sender.sendMessage(fixColor(s));
			return true;
		}
		return false;
	}

}
