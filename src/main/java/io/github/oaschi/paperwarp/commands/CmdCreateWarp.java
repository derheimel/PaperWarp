package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.Localization;
import io.github.oaschi.paperwarp.domain.Warp;
import io.github.oaschi.paperwarp.permission.PWPermission;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class CmdCreateWarp extends PlayerCommand{
	
	private boolean isPublic;
	private String name;
	private String welcomeMessage;
	private int time;
	
	
	public CmdCreateWarp(boolean isPublic){
		if(isPublic) setPermission(PWPermission.WARP_CREATE_PUBLIC);
		else setPermission(PWPermission.WARP_CREATE_PRIVATE);
	}

	@Override
	public void execute() {
		String name = combineStringArray(args, ' ');
		Player player = this.getPlayer();
		World world = player.getWorld();
		Warp w = null;
		Localization loc = null;
		
		if(this.getPermission() == PWPermission.WARP_CREATE_PRIVATE){
			if(!this.getWarpdao().exists(player, name)){
				w = new Warp(player, name);
				loc = Localization.WARP_CREATED_PRIVATE;
			}
		}
		else{
			if(!this.getWarpdao().exists(world, name)){
				w = new Warp(player, name, true);
				loc = Localization.WARP_CREATED_PUBLIC;
			}
		}
		
		if(w != null && loc != null){
			this.getWarpdao().save(w);
			this.getLogger().info(player, loc);
		}
		
	}
	
	private void parse(){
		int i = 0;

		while(i < args.length){
			String arg = args[i++];
			
		}
	}

}