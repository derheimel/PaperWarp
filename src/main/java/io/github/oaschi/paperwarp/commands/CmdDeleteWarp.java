package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.Localization;
import io.github.oaschi.paperwarp.dao.WarpDaoImpl;
import io.github.oaschi.paperwarp.permission.PWPermission;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdDeleteWarp extends PlayerCommand{
	
	String name;
	Player creator;
	boolean isPublic;
	boolean all;
	
	/**
	 * Only called by the public constructors.
	 */
	private CmdDeleteWarp(CommandSender sender, Player creator, String name, boolean isPublic, boolean all){
		super(sender);
		this.name = name;
		this.creator = creator;
		this.isPublic = isPublic;
		this.all = all;
		
		setPermission(PWPermission.WARP_DELETE_OWN);
		if(isPublic && !getWarpdao().exists(getPlayer(), name)){
			setPermission(PWPermission.WARP_DELETE_PUBLIC);
		}
	}
	
	/**
	 * If you want to delete a single warp of a specific player, use this constructor.
	 */
	public CmdDeleteWarp(CommandSender sender, Player creator, String name, boolean isPublic) {
		this(sender, creator, name, isPublic, false);
	}
	
	/**
	 * If you want to delete a single warp of the command sender, use this constructor.
	 */
	public CmdDeleteWarp(CommandSender sender, String name, boolean isPublic){
		this(sender, null, name, isPublic);
	}
	
	/**
	 * If you want to delete any warps of a specific player, use this constructor.
	 */
	public CmdDeleteWarp(CommandSender sender, Player creator, boolean isPublic){
		this(sender, creator, null, isPublic, true);
	}
	
	/**
	 * If you want to delete any warps of the command sender, use this constructor.
	 */
	public CmdDeleteWarp(CommandSender sender, boolean isPublic){
		this(sender, (Player)null, isPublic);
	}

	@Override
	public void execute() {
		WarpDaoImpl dao = getWarpdao();
		Player sender = getPlayer();
		World world = sender.getWorld();
		Localization msg = null;
		if(creator == null) creator = sender;
		
		
		
		if(isPublic && !all){
			if(dao.exists(world, name)){
				dao.deletePublic(world, name);
				msg = Localization.WARP_DELETED_PUBLIC;
			}
			else{
				msg = Localization.WARP_EXISTS_NOT;
			}
		}
		else if(isPublic && all){
			if(dao.findPublic(creator).size() > 0){
				dao.deletePublic(creator);
				msg = Localization.WARP_DELETED_ALL_PUBLIC;
			}
			else{
				msg = Localization.PLAYER_HASNOWARPS_PUBLIC;
			}
		}
		else if(!isPublic && !all){
			if(dao.exists(creator, name)){
				dao.deletePrivate(creator, name);
				msg = Localization.WARP_DELETED_PRIVATE;
			}
			else{
				msg = Localization.WARP_EXISTS_NOT;
			}
		}
		else if(!isPublic && all){
			if(dao.findPrivate(creator).size() > 0){
				dao.deletePrivate(creator);
				msg = Localization.WARP_DELETED_ALL_PRIVATE;
			}
			else{
				msg = Localization.PLAYER_HASNOWARPS_PRIVATE;
			}
		}
		
		getLogger().info(sender, msg);
	}

}
