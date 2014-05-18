package io.github.oaschi.paperwarp.dao;

import io.github.oaschi.paperwarp.domain.Warp;

import java.util.List;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class WarpDaoImpl extends WarpDao{
	
	public WarpDaoImpl(){
		super();
	}
	
	/**
	 * Returns a unique private warp of a player in the current world.
	 */
	@Override
	public Warp findPrivate(Player creator, String name) {
		String creatorId = creator.getUniqueId().toString();
		String worldName = creator.getWorld().getName();
		Warp w = getDatabase().find(Warp.class)
				.where()
				.eq(Warp.COL_WORLD, worldName)
				.eq(Warp.COL_CREATOR_ID, creatorId)
				.ieq(Warp.COL_NAME, name)
				.findUnique();
		
		return w;
	}

	/**
	 * Returns a list of all names of private warps a player owns in the current world.
	 */
	@Override
	public List<Warp> findPrivate(Player creator) {
		String creatorId = creator.getUniqueId().toString();
		String worldName = creator.getWorld().getName();
		List<Warp> warps = getDatabase().find(Warp.class)
				.where()
				.eq(Warp.COL_WORLD, worldName)
				.eq(Warp.COL_CREATOR_ID, creatorId)
				.findList();
		
		return warps;
	}

	/**
	 * Checks if a private warp with the given name of the given player exists in the current world.
	 */
	public boolean exists(Player creator, String name){
		return findPrivate(creator, name) != null;
	}
	
	/**
	 * Checks if a public warp with the given name exists in the given world.
	 */
	public boolean exists(World world, String name){
		return findPublic(world, name) != null;
	}

	/**
	 * Returns a unique public warp in the given world.
	 */
	@Override
	public Warp findPublic(World world, String name) {
		String worldName = world.getName();
		Warp w = getDatabase().find(Warp.class)
				.where()
				.eq(Warp.COL_WORLD, worldName)
				.ieq(Warp.COL_NAME, name)
				.findUnique();
		return w;
	}

}