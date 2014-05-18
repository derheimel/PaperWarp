package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.Localization;
import io.github.oaschi.paperwarp.domain.Warp;
import io.github.oaschi.paperwarp.permission.PWPermission;

public class CmdWarp extends PlayerCommand{
	
	public CmdWarp(boolean isPublic){
		if(isPublic) setPermission(PWPermission.WARP_PUBLIC);
		else setPermission(PWPermission.WARP_PRIVATE);
	}

	public void execute() {
		String name = this.combineStringArray(args, ' ');
		
		Warp destination = this.getWarpdao().findByCreatorAndName(player.getUniqueId(), name);
		
		if(destination != null){
			this.player.teleport(destination.getLocation());
		}
		else{
			this.getLogger().info(Localization.WARP_EXISTS_NOT);
		}
				
	}

}
