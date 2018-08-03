package pl.blackwater.namemc.connect;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import io.netty.handler.timeout.TimeoutException;
import pl.blackwater.namemc.settings.Config;

public class NameMcConnection {
	private static String toString(InputStream in, String encoding) throws IOException{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[8192];
		int len = 0;
		while ((len = in.read(buf)) != -1)
			baos.write(buf,0,len);
		in.close();
		return new String(baos.toByteArray(),encoding);
	}
	private static String getContent(String urlName){
		String body = null;
		try{
			URL url = new URL(urlName);
			URLConnection con = url.openConnection();
			InputStream in = con.getInputStream();
			String encoding = con.getContentEncoding();
			encoding = encoding == null ? "UTF-8" : encoding;
			body = toString(in, encoding);
			in.close();
		}catch (TimeoutException timeout){}catch (Exception localEcxeption){}
		return body;
	}
	public static boolean checkConnection(){
		String response = getContent("https://api.namemc.com/server/" + Config.SERVER_IP + "/likes");
		return response != null;
	}
	public static List<String> GetNameMCLikeList(){
		String response = (getContent("https://api.namemc.com/server/" + Config.SERVER_IP + "/likes")).replace("[", "]").replace(" ", "");
		List<String> list = new ArrayList<String>();
		for(String s : response.split(",")){
			list.add(s);
		}
		return list;
	}
	public static boolean checkNameMcLikeUser(Player p){
		boolean response = Boolean.valueOf(getContent("https://api.namemc.com/server/" + Config.SERVER_IP + "/likes?profile=" + p.getUniqueId().toString()));
		return response;
	}
}
