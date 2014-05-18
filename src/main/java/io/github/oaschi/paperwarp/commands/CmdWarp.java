package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.Localization;
import io.github.oaschi.paperwarp.domain.Warp;
import io.github.oaschi.paperwarp.permission.PWPermission;

import org.bukkit.entity.Player;

public class CmdWarp extends PlayerCommand{
	
	public CmdWarp(boolean isPublic){
		if(isPublic) setPermission(PWPermission.WARP_PUBLIC);
		else setPermission(PWPermission.WARP_PRIVATE);
	}

	public void execute() {
		String name = this.combineStringArray(args, ' ');
		Player player = this.getPlayer();
		
		Warp destination = this.getWarpdao().findPrivate(player, name);
		
		if(destination != null){
			player.teleport(destination.getLocation());
		}
		else{
			this.getLogger().info(player, Localization.WARP_EXISTS_NOT);
		}
	}

}
