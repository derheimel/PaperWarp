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
	private Map<String, Object> attributes = new HashMap<>();
	
	public void parseAndExecute(CommandSender sender, String[] args){
		CmdLineParser parser = new CmdLineParser();
		
		if(!args[0].startsWith("-")){
			attributes.put("warp", args[0]);
		}
		
		//primary options
		Option<String> optCreate = parser.addStringOption('c', "create");
		Option<String> optDelete = parser.addStringOption('d', "delete");
		
		//secundary options with parameter
		Option<String> optWelcome = parser.addStringOption('w', "welcome");
		Option<String> optShortCut = parser.addStringOption('s', "short");
		
		//secundary options without parameter
		Option<Boolean> optAll = parser.addBooleanOption('a', "all");
		Option<Boolean> optIsPublic = parser.addBooleanOption('p', "public");
		
		try{
			parser.parse(args);
		}
		catch(OptionException e){
			
		}
		
		attributes.put("create", parser.getOptionValue(optCreate));
		attributes.put("delete", parser.getOptionValue(optDelete));
		
		attributes.put("welcome", parser.getOptionValue(optWelcome));
		attributes.put("short", parser.getOptionValue(optShortCut));
		
		attributes.put("all", parser.getOptionValue(optAll, false));
		attributes.put("public", parser.getOptionValue(optIsPublic, false));
		
		execute(sender);
	}
	
	private void execute(CommandSender sender){
		Localization msg = null;
		
		if(attributes.containsKey("warp")){
			warp(sender);
		}
		else if(attributes.get("create") != null){
			if(attributes.get("delete") != null){
				msg = Localization.MULTIPLE_PRIMARY_FLAGS;
			}
			else
				createWarp(sender);
		}
		
		
	}
	
	private void warp(CommandSender sender){
		if(attributes.get("create") != null 
				|| attributes.get("delete") != null
				|| attributes.get("welcome") != null
				|| attributes.get("all") != Boolean.FALSE){
			
			logger.info(sender, Localization.INVALID_FLAG);
		}
		else
			new CmdWarp(sender, (String)attributes.get("warp"), (boolean)attributes.get("public")).execute();
	}
	
	private void createWarp(CommandSender sender){
		if(attributes.get("all") == Boolean.TRUE){
			logger.info(sender, Localization.INVALID_FLAG);
		}
		else
			new CmdCreateWarp(sender, attributes).execute();
	}
	
//	public static AbstractCommand parse(CommandSender sender, String[] args){
//		AbstractCommand cmd = null;
//		Player player  = null;
//		if(sender instanceof Player) player = (Player) sender;
//		PWLogger logger = PaperWarp.plugin.getPWLogger();
//		Localization message;
//		
//		Map<String, Object> attributes = new HashMap<>();
//		Flag primary = null;
//		
//		int i = 0;
//		while(i < args.length){
//			String arg = args[i++];
//			
//			if(Flag.PUBLIC.matches(arg)){
//				attributes.put("isPublic", true);
//			}
//			else if(Flag.ALL.matches(arg)){
//				attributes.put("all", true);
//			}
//			else if(Flag.CREATE.matches(arg)){
//				if(primary != null){
//					primary = Flag.CREATE;
//					attributes.put("create", args[i++]);
//				}
//				else
//					message = Localization.MULTIPLE_PRIMARY_FLAGS;
//			}
//			else if(Flag.DELETE.matches(arg)){
//				if(primary != null){
//					primary = Flag.DELETE;
//					attributes.put("delete", args[i++]);
//				}
//				else
//					message = Localization.MULTIPLE_PRIMARY_FLAGS;
//			}
//			else if(Flag.WELCOME.matches(arg)){
//				
//			}
//		}
//		
//		return cmd;
//	}

}
