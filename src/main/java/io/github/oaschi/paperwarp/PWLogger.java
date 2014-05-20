package io.github.oaschi.paperwarp;

import java.util.logging.Logger;

import org.bukkit.command.CommandSender;
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
	
	public void info(CommandSender reciever, Localization msg){
		this.info(reciever, msg, new String[]{});
	}
	
	public void info(CommandSender reciever, Localization msg, String[] args){
		if(reciever instanceof Player)
			reciever.sendMessage(this.getFormattedMessage(msg.get(args)));
		else
			reciever.sendMessage(msg.get(args));
	}
	
	public void info(String msg){
		this.logger.info(msg);
	}
	
	public void info(Localization msg){
		this.info(msg.get());
	}
	
	public void infoPlain(CommandSender reciever, String msg){
		reciever.sendMessage(msg);
	}
	
}
