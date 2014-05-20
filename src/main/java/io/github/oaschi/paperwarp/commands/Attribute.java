package io.github.oaschi.paperwarp.commands;

public enum Attribute {
	
	WARP, //teleports the player to a warp
	CREATE('c', "create"), //creates a new warp
	DELETE('d', "delete"), //deletes a warp
	PUBLIC('p', "public"), //makes the warp public
	ALL('a', "all"), //applies the command to all warps
	WELCOME('w', "welcome"), //sets a welcome message
	SHORT('s', "short"), //sets a shortcut for the command (without the shortcut flag)
	
	;
	
	private char shortForm;
	private String longForm;
	
	Attribute(char shortForm, String longForm){
		this.shortForm = shortForm;
		this.longForm = longForm;
	}
	
	Attribute(){
		
	}

	public char getShortForm() {
		return shortForm;
	}

	public void setShortForm(char shortForm) {
		this.shortForm = shortForm;
	}

	public String getLongForm() {
		return longForm;
	}

	public void setLongForm(String longForm) {
		this.longForm = longForm;
	}

}
