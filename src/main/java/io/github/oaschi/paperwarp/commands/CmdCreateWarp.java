package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.Localization;
import io.github.oaschi.paperwarp.domain.Warp;
import io.github.oaschi.paperwarp.permission.PWPermission;

public class CmdCreateWarp extends PlayerCommand{
	
	public CmdCreateWarp(boolean isPublic){
		if(isPublic) setPermission(PWPermission.WARP_CREATE_PUBLIC);
		else setPermission(PWPermission.WARP_CREATE_PRIVATE);
	}

	@Override
	public void execute() {
		String name = combineStringArray(args, ' ');
		if(!this.getWarpdao().exists(player.getUniqueId().toString(), name)){
			Warp w = new Warp(player.getLocation(), player.getUniqueId(), name);
			this.getWarpdao().save(w);
			getLogger().info(player, Localization.WARP_CREATED);
		}
		else{
			getLogger().info(player, Localization.WARP_EXISTS);
		}
	}

}