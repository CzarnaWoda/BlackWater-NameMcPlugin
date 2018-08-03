package pl.blackwater.namemc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.blackwater.namemc.connect.NameMcConnection;
import pl.blackwater.namemc.settings.Config;
import pl.blackwater.namemc.utils.Util;

public class NameMcCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
		if(!(sender instanceof Player)){
			return Util.sendMsg(sender, "&4Blad: &7Nie jestes graczem");
		}
		Player p = (Player)sender;
		boolean status = NameMcConnection.checkNameMcLikeUser(p);
		String url = "https://pl.namemc.com/server/" + Config.SERVER_IP;
		if(status){
			Util.sendMsg(p, "&6Polubiles strone naszego serwera &8(&c" + Config.SERVER_IP + "&8) &6na NameMc.");
			Util.sendMsg(p, "&6Wplywa to na rozwoj naszego serwera &7;)");
		}else{
			Util.sendMsg(p, "&6Nie polubiles strony naszego serwera na &cNameMc &6!");
			Util.sendMsg(p, "&6Aby to zrobic wejdz w link: &c&n" + url + "&6, wplywa to na rozwoj serwera ;)");
		}
		return false;
	}

}
