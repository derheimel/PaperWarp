package io.github.oaschi.paperwarp.permission;

import org.bukkit.command.CommandSender;

public class PermissionManager {

	public boolean hasPermission(CommandSender sender, PWPermission permission){
		return permission.has(sender);
	}
	
	public boolean hasPermission(CommandSender sender, PWPermission permission, String... args){
		return permission.has(sender, args);
	}
	
	public boolean canWarpPrivate(CommandSender sender){
		return hasPermission(sender, PWPermission.WARP_PRIVATE);
	}
	
	public boolean canWarpPublic(CommandSender sender){
		return hasPermission(sender, PWPermission.WARP_PUBLIC);
	}
	
}
