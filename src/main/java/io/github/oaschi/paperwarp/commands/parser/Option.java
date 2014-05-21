package io.github.oaschi.paperwarp.commands.parser;

import io.github.oaschi.paperwarp.PWUtils;


public class Option implements Cloneable{
	
	private String name;
	private char[] aliases;
	private boolean argRequired;
	private boolean multipleArgs;
	private Class<?> type = String.class;
	private String value = null;
	
	public Option(String name, char... aliases){
		this.name = name;
		this.aliases = aliases;
	}
	
	@Override
	public Option clone(){
		try {
			return (Option) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean matches(String str){
		str = PWUtils.stripLeadingHyphens(str);
		if(str.length() == 1){
			char label = str.charAt(0);
			for(char alias : aliases){
				if(label == alias) return true;
			}
		}
		return false;
	}
	
	public void addValue(String value){
		if(this.value == null) this.value = "" + value;
		else this.value += " " + value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char[] getAliases() {
		return aliases;
	}

	public void setAliases(char[] aliases) {
		this.aliases = aliases;
	}

	public boolean isArgRequired() {
		return argRequired;
	}

	public void setArgRequired(boolean argRequired) {
		this.argRequired = argRequired;
	}

	public boolean isMultipleArgs() {
		return multipleArgs;
	}

	public void setMultipleArgs(boolean multipleArgs) {
		this.multipleArgs = multipleArgs;
	}

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
