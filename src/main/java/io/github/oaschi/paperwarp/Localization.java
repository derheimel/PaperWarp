package io.github.oaschi.paperwarp;

import org.bukkit.ChatColor;

import com.bergerkiller.bukkit.common.localization.ILocalizationDefault;

public enum Localization implements ILocalizationDefault{
	
	WARP_EXISTS("warp.exists", ChatColor.YELLOW + "This name is already in use!"),
	WARP_EXISTS_NOT("warp.existsnot", ChatColor.YELLOW + "This warp does not exist."),
	WARP_CREATED_PRIVATE("warp.created.private", ChatColor.GREEN + "Private warp created!"),
	WARP_CREATED_PUBLIC("warp.created.public", ChatColor.GREEN + "Public warp created!"),
	WARP_DELETED_PRIVATE("warp.deleted.private", ChatColor.GREEN + "Private warp deleted!"),
	WARP_DELETED_PUBLIC("warp.deleted.public", ChatColor.GREEN + "Public warp deleted!"),
	WARP_DELETED_ALL_PRIVATE("warp.deleted.all.private", ChatColor.GREEN + "All private warps deleted!"),
	WARP_DELETED_ALL_PUBLIC("warp.deleted.all.public", ChatColor.GREEN + "All public warps deleted!"),
	PLAYER_HASNOWARPS_PRIVATE("player.hasnowarps.private", ChatColor.GREEN + "This player has no private warps!"),
	PLAYER_HASNOWARPS_PUBLIC("player.hasnowarps.public", ChatColor.GREEN + "This player has no public warps!"),
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