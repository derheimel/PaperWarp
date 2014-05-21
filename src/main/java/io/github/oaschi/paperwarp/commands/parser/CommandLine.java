package io.github.oaschi.paperwarp.commands.parser;

import io.github.oaschi.paperwarp.PWUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandLine {
	
	private final List<Option> options = new ArrayList<>();
	private final List<String> args = new ArrayList<>();
	
	public List<String> getOptionlessArgs(){
		return args;
	}
	
	public boolean hasOption(String name){
		return options.contains(resolveOption(name));
	}
	
	public boolean hasOption(char alias){
		return hasOption("" + alias);
	}
	
	private Option resolveOption(String name){
		name = PWUtils.stripLeadingHyphens(name);
		for(Option opt : options){
			if(opt.matches(name)){
				return opt;
			}
		}
		return null;
	}
	
	public String getOptionValue(char alias){
		return getOptionValue("" + alias);
	}
	
	public String getOptionValue(String name){
		for(Option opt : options){
			if(opt.matches(name)){
				if(!opt.isArgRequired()){
					return hasOption(name) ? "true" : "false";
				}
				return opt.getValue();
			}
		}
		return null;
	}
	
	protected void add(Option opt){
		options.add(opt);
	}
	
	protected void add(String arg){
		args.add(arg);
	}

}
