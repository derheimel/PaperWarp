package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.Localization;
import io.github.oaschi.paperwarp.PWLogger;
import io.github.oaschi.paperwarp.PWUtils;
import io.github.oaschi.paperwarp.PaperWarp;
import io.github.oaschi.paperwarp.commands.parser.CommandLine;
import io.github.oaschi.paperwarp.commands.parser.MissingArgumentException;
import io.github.oaschi.paperwarp.commands.parser.Option;
import io.github.oaschi.paperwarp.commands.parser.OptionGroup;
import io.github.oaschi.paperwarp.commands.parser.Options;
import io.github.oaschi.paperwarp.commands.parser.Parser;
import io.github.oaschi.paperwarp.commands.parser.UnknownOptionException;

import org.bukkit.command.CommandSender;


public class PWCommandExecutor {
	
	private PWLogger logger = PaperWarp.plugin.getPWLogger();
	
	private String name;
	private String create;
	private String delete;
	private String welcome;
	private String shortCut;
	private boolean all;
	private boolean isPublic;
	
	private Options options;
	
	public PWCommandExecutor(){
		options = new Options();
		
		OptionGroup primary = new OptionGroup();
		primary.setRequired(true);
		
		Option optCreate = new Option("create", 'c');
		optCreate.setArgRequired(true);
		optCreate.setMultipleArgs(true);
		Option optDelete = new Option("delete", 'd', 'r');
		optDelete.setArgRequired(true);
		optDelete.setMultipleArgs(true);
		
		primary.add(optCreate);
		primary.add(optDelete);
		
		Option optWelcome = new Option("welcome", 'w');
		optWelcome.setArgRequired(true);
		optWelcome.setMultipleArgs(true);
		Option optShortCut = new Option("short", 's');
		optShortCut.setArgRequired(true);
		optShortCut.setMultipleArgs(true);
		
		Option optAll = new Option("all", 'a');
		Option optPublic = new Option("public", 'p');
		
		options.add(primary);
		options.add(optWelcome);
		options.add(optShortCut);
		options.add(optAll);
		options.add(optPublic);
	}
	
	public void execute(CommandSender sender, String[] args){
		Parser parser = new Parser();
		CommandLine cmd = null;
		
		try{
			cmd = parser.parse(options, args);
		}
		catch(MissingArgumentException e){
			e.printStackTrace();
		}
		catch(UnknownOptionException e){
			e.printStackTrace();
		}
		
		create = cmd.getOptionValue('c');
		delete = cmd.getOptionValue('d');
		
		welcome = cmd.getOptionValue('w');
		shortCut = cmd.getOptionValue('s');
		
		all = Boolean.parseBoolean(cmd.getOptionValue('a'));
		isPublic = Boolean.parseBoolean(cmd.getOptionValue('p'));
		
		String[] nameArr = cmd.getOptionlessArgs().toArray(new String[0]);
		name = PWUtils.combineStringArray(nameArr, ' ');
		
		process(sender);
		resetValues();
	}
	
	private void process(CommandSender sender){
		Localization msg = null;
		
		if(name != null){
			warp(sender);
		}
		else if(create != null && delete != null){
			msg = Localization.MULTIPLE_PRIMARY_FLAGS;
		}
		else if(create != null){
			createWarp(sender);
		}
		else if(delete != null){
			deleteWarp(sender);
		}
		
		if(msg != null){
			logger.info(sender, msg);
		}
	}
	
	private void deleteWarp(CommandSender sender){
		if(create != null
				|| welcome != null){
			
			logger.info(sender, Localization.INVALID_FLAG);
		}
		else{
			new CmdDeleteWarp(sender, delete, isPublic).execute();
		}
	}
	
	private void warp(CommandSender sender){
		if(create != null
				|| delete != null
				|| welcome != null
				|| all){
			
			logger.info(sender, Localization.INVALID_FLAG);
		}
		else{
			new CmdWarp(sender, name, isPublic).execute();
		}
	}
	
	private void createWarp(CommandSender sender){
		if(all){
			logger.info(sender, Localization.INVALID_FLAG);
		}
		else{
			new CmdCreateWarp(sender, create, welcome, isPublic).execute();
		}
	}
	
	private void resetValues(){
		this.name = null;
		this.create = null;
		this.delete = null;
		this.welcome = null;
		this.shortCut = null;
		this.all = false;
		this.isPublic = false;
	}

}
