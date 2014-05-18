package io.github.oaschi.paperwarp;

import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class PWLogger {

	private PaperWarp plugin;
	private Logger logger;
	
	public PWLogger(){
		this.plugin = PaperWarp.plugin;
		this.logger = plugin.getLogger();
	}
	
	private String getFormattedMessage(String msg){
		PluginDescriptionFile pdf = plugin.getDescription();
		return "[" + pdf.getFullName() + "]: " + msg;
	}
	
	public void info(Player reciever, Localization loc){
		this.info(reciever, loc, new String[]{});
	}
	
	public void info(Player reciever, Localization loc, String[] args){
		reciever.sendMessage(this.getFormattedMessage(loc.get(args)));
	}
	
	public void info(String msg){
		this.logger.info(msg);
	}
	
	public void info(Localization loc){
		this.info(loc.get());
	}
	
}
