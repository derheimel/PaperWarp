package io.github.oaschi.paperwarp;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;

public class PaperWarpLogger {

	private PaperWarp plugin;
	private Logger logger;
	
	public PaperWarpLogger(PaperWarp plugin){
		this.plugin = plugin;
		this.logger = plugin.getLogger();
	}
	
	private String getFormattedMessage(String msg){
		PluginDescriptionFile pdf = plugin.getDescription();
		return "[" + pdf.getFullName() + "]: " + msg;
	}
	
	public void info(String msg){
		this.logger.info(this.getFormattedMessage(msg));
	}
	
	public void infoPlain(String msg){
		this.logger.info(msg);
	}
	
}
