package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.Localization;
import io.github.oaschi.paperwarp.dao.WarpDaoImpl;
import io.github.oaschi.paperwarp.domain.Warp;
import io.github.oaschi.paperwarp.permission.PWPermission;

import java.util.Map;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdCreateWarp extends PlayerCommand{
	
	private boolean isPublic;
	private String name;
	private String welcomeMessage;
	
	
	public CmdCreateWarp(CommandSender sender, Map<String, Object> attributes){
		super(sender);
		this.isPublic = (boolean) attributes.get("public");
		this.name = (String) attributes.get("create");
		this.welcomeMessage = (String) attributes.get("welcome");
		
		if(isPublic) setPermission(PWPermission.WARP_CREATE_PUBLIC);
		else setPermission(PWPermission.WARP_CREATE_PRIVATE);
	}

	@Override
	public void execute() {
		Warp w = null;
		Player creator = getPlayer();
		Localization msg = null;
		WarpDaoImpl dao = getWarpdao();
		World world = creator.getWorld();
		
		if(isPublic){
			w = new Warp(creator, name, isPublic);
			if(dao.exists(world, name)){
				msg = Localization.WARP_EXISTS;
				setAborted(true);
			}
			else
				msg = Localization.WARP_CREATED_PUBLIC;
		}
		else{
			w = new Warp(creator, name);
			if(dao.exists(creator, name)){
				msg = Localization.WARP_EXISTS;
				setAborted(true);
			}
			else
				msg = Localization.WARP_CREATED_PRIVATE;
		}
		
		if(isAborted()){
			getLogger().info(creator, msg);
			return;
		}
		w.setWelcomeMessage(welcomeMessage);
		
		dao.save(w);
		getLogger().info(creator, msg);
		
	}

}