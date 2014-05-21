package io.github.oaschi.paperwarp.commands.parser;

import io.github.oaschi.paperwarp.PWUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Options {
	
	private Map<String, Option> options = new LinkedHashMap<>();
	private Map<String, OptionGroup> optionGroups = new HashMap<>();
	
	public void add(Option opt){
		options.put(opt.getName(), opt);
	}
	
	public void add(OptionGroup group){
		for(Option opt : group.getOptions().values()){
			add(opt);
			optionGroups.put(opt.getName(), group);
		}
	}
	
	public boolean hasOption(String name){
		name = PWUtils.stripLeadingHyphens(name);
		for(Option opt : options.values()){
			if(opt.matches(name)){
				return true;
			}
		}
		return false;
	}
	
	public Option getOption(String name){
		name = PWUtils.stripLeadingHyphens(name);
		for(Option opt : options.values()){
			if(opt.matches(name)){
				return opt;
			}
		}
		return null;
	}
	
	public OptionGroup getOptionGroup(Option opt){
		return optionGroups.get(opt.getName());
	}

	public Map<String, Option> getOptions() {
		return options;
	}

	public void setOptions(Map<String, Option> options) {
		this.options = options;
	}

	public Map<String, OptionGroup> getOptionGroups() {
		return optionGroups;
	}

	public void setOptionGroups(Map<String, OptionGroup> optionGroups) {
		this.optionGroups = optionGroups;
	}
	
}
