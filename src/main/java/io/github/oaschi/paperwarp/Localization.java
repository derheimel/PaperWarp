package io.github.oaschi.paperwarp;

import org.bukkit.ChatColor;

import com.bergerkiller.bukkit.common.localization.ILocalizationDefault;

public enum Localization implements ILocalizationDefault{
	
	WARP_EXISTS("warp.exists", ChatColor.YELLOW + "This name is already in use!"),
	WARP_EXISTS_NOT("warp.existsnot", ChatColor.YELLOW + "This warp does not exist."),
	WARP_CREATED_PRIVATE("warp.created.private", ChatColor.GREEN + "Private warp created!"),
	WARP_CREATED_PUBLIC("warp.created.public", ChatColor.GREEN + "Public warp created!"),
	INFO("info", "THIS IS INFORMATION"),
	PLAYER_COMMAND("general.playercommand", "This command is for players only!"),
	FLAG_NEEDS_ARGUMENT("general.flagneedsargument", ChatColor.YELLOW + "This flag needs an argument!"),
	MULTIPLE_FLAGS_WITH_ARGUMENT("general.multipleflagswithargument", ChatColor.YELLOW + "You can't group multiple arguments together that need an argument!"),
	MULTIPLE_PRIMARY_FLAGS("general.multiprimaryflags", ChatColor.YELLOW + "You can't combine multiple primary flags!"),
	INVALID_FLAG("general.invalidflag", ChatColor.YELLOW + "You used an invalid Flag!"),
	
	
	;
	
	private final String name;
	private final String defValue;
	
	Localization(String name, String defValue){
		this.name = name;
		this.defValue = defValue;
	}
	
	public String get(String[] args){
		return PaperWarp.plugin.getLocale(name, args);
	}
	
	public String get(){
		return get(new String[]{});
	}

	@Override
	public String getDefault() {
		return this.defValue;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
}