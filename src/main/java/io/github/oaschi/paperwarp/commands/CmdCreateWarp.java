package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.Localization;
import io.github.oaschi.paperwarp.domain.Warp;
import io.github.oaschi.paperwarp.permission.PWPermission;

import org.bukkit.entity.Player;

public class CmdCreateWarp extends PlayerCommand{
	
	public CmdCreateWarp(boolean isPublic){
		if(isPublic) setPermission(PWPermission.WARP_CREATE_PUBLIC);
		else setPermission(PWPermission.WARP_CREATE_PRIVATE);
	}

	@Override
	public void execute() {
		String name = combineStringArray(args, ' ');
		Player player = this.getPlayer();
		
		if(!this.getWarpdao().exists(player, name)){
			Warp w = new Warp(player, name);
			this.getWarpdao().save(w);
			getLogger().info(player, Localization.WARP_CREATED);
		}
		else{
			getLogger().info(player, Localization.WARP_EXISTS);
		}
	}

}