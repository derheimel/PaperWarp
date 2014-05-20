package io.github.oaschi.paperwarp.commands;

public enum Flag {
	
	CREATE(true, 'c'), //creates a new warp
	DELETE(true, 'd', 'r'), //deletes a warp
	PUBLIC(false, 'p'), //makes the warp public
	ALL(false, 'a'), //applies the command to all warps
	WELCOME(false, 'w'), //sets a welcome message
	SHORT(false, 's'), //sets a shortcut for the command (without the shortcut flag)
	
	;
	
	private boolean primary;
	private char flag;
	private char[] aliases;
	
	Flag(boolean primary, char flag, char... aliases){
		this.flag = flag;
		this.aliases = aliases;
	}
	
	public boolean matches(String str){
		str = str.replace("-", "");
		if(str.length() == 1){
			char label = str.charAt(0);
			if(label == flag) return true;
			for(char alias : aliases){
				if(label == alias) return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "" + flag;
	}

	public boolean isPrimary() {
		return primary;
	}

}
