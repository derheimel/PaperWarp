package io.github.oaschi.paperwarp.commands.parser;

import java.util.HashMap;
import java.util.Map;

public class OptionGroup{
	
	private Map<String, Option> options = new HashMap<>();
	private String selected;
	private boolean required;
	
	public void add(Option option){
		options.put(option.getName(), option);
	}

	public Map<String, Option> getOptions() {
		return options;
	}

	public void setOptions(Map<String, Option> options) {
		this.options = options;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(Option opt) {
		if(opt == null){
			selected = null;
		}
		else{
			selected = opt.getName();
		}
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
	
}
