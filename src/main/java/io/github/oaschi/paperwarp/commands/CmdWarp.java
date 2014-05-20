package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.Localization;
import io.github.oaschi.paperwarp.domain.Warp;
import io.github.oaschi.paperwarp.permission.PWPermission;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdWarp extends PlayerCommand{
	
	private boolean isPublic;
	private String name;
	
	public CmdWarp(CommandSender sender, String name, boolean isPublic){
		super(sender);
		this.isPublic = isPublic;
		this.name = name;
		
		if(isPublic) setPermission(PWPermission.WARP_PUBLIC);
		else setPermission(PWPermission.WARP_PRIVATE);
	}

	public void execute() {
		Player creator = getPlayer();
		World world = creator.getWorld();
		
		Warp destination = null;
		if(!isPublic){
			destination = getWarpdao().findPrivate(creator, name);
		}
		if(destination == null){
			destination = getWarpdao().findPublic(world, name);
		}
		
		if(destination != null){
			creator.teleport(destination.getLocation());
			String welcome = destination.getWelcomeMessage();
			if(welcome != null && welcome.length() > 0){
				getLogger().infoPlain(creator, welcome);
			}
		}
		else{
			getLogger().info(creator, Localization.WARP_EXISTS_NOT);
		}
	}

}
