package io.github.oaschi.paperwarp;

import java.util.logging.Logger;

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
	
	public void info(String msg){
		this.logger.info(this.getFormattedMessage(msg));
	}
	
	public void info(Localization loc){
		this.info(loc, new String[]{});
	}
	
	public void info(Localization loc, String[] args){
		this.logger.info(this.getFormattedMessage(loc.get(args)));
	}
	
	public void infoPlain(String msg){
		this.logger.info(msg);
	}
	
}
