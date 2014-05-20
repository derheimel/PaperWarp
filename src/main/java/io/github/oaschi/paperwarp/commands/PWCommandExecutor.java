package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.Localization;
import io.github.oaschi.paperwarp.PWLogger;
import io.github.oaschi.paperwarp.PaperWarp;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.CommandSender;

import com.sanityinc.jargs.CmdLineParser;
import com.sanityinc.jargs.CmdLineParser.Option;
import com.sanityinc.jargs.CmdLineParser.OptionException;


public class PWCommandExecutor {
	
	private PWLogger logger = PaperWarp.plugin.getPWLogger();
	private Map<Attribute, Object> attributes = new HashMap<>();
	
	public void parseAndExecute(CommandSender sender, String[] args){
		CmdLineParser parser = new CmdLineParser();
		
		//primary options
		Option<String> optCreate = parser.addStringOption(Attribute.CREATE.getShortForm(), Attribute.CREATE.getLongForm());
		Option<String> optDelete = parser.addStringOption(Attribute.DELETE.getShortForm(), Attribute.DELETE.getLongForm());
		
		//secundary options with parameter
		Option<String> optWelcome = parser.addStringOption(Attribute.WELCOME.getShortForm(), Attribute.WELCOME.getLongForm());
		Option<String> optShortCut = parser.addStringOption(Attribute.SHORT.getShortForm(), Attribute.SHORT.getLongForm());
		
		//secundary options without parameter
		Option<Boolean> optAll = parser.addBooleanOption(Attribute.ALL.getShortForm(), Attribute.ALL.getLongForm());
		Option<Boolean> optIsPublic = parser.addBooleanOption(Attribute.PUBLIC.getShortForm(), Attribute.PUBLIC.getLongForm());
		
		if(!args[0].startsWith("-")){
			attributes.put(Attribute.WARP, args[0]);
		}
		
		try{
			parser.parse(args);
		}
		catch(OptionException e){
			
		}
		
		attributes.put(Attribute.CREATE, parser.getOptionValue(optCreate));
		attributes.put(Attribute.DELETE, parser.getOptionValue(optDelete));
		
		attributes.put(Attribute.WELCOME, parser.getOptionValue(optWelcome));
		attributes.put(Attribute.SHORT, parser.getOptionValue(optShortCut));
		
		attributes.put(Attribute.ALL, parser.getOptionValue(optAll, false));
		attributes.put(Attribute.PUBLIC, parser.getOptionValue(optIsPublic, false));
		
		execute(sender);
	}
	
	private void execute(CommandSender sender){
		Localization msg = null;
		
		if(attributes.containsKey(Attribute.WARP)){
			warp(sender);
		}
		else if(attributes.get(Attribute.CREATE) != null){
			if(attributes.get(Attribute.DELETE) != null){
				msg = Localization.MULTIPLE_PRIMARY_FLAGS;
			}
			else
				createWarp(sender);
		}
		
		if(msg != null)
			logger.info(sender, msg);
	}
	
	private void warp(CommandSender sender){
		if(attributes.get(Attribute.CREATE) != null 
				|| attributes.get(Attribute.DELETE) != null
				|| attributes.get(Attribute.WELCOME) != null
				|| attributes.get(Attribute.ALL) != Boolean.FALSE){
			
			logger.info(sender, Localization.INVALID_FLAG);
		}
		else
			new CmdWarp(sender, (String)attributes.get(Attribute.WARP), (boolean)attributes.get(Attribute.PUBLIC)).execute();
	}
	
	private void createWarp(CommandSender sender){
		if(attributes.get(Attribute.ALL) == Boolean.TRUE){
			logger.info(sender, Localization.INVALID_FLAG);
		}
		else
			new CmdCreateWarp(sender, attributes).execute();
	}

}
