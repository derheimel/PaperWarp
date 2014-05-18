package io.github.oaschi.paperwarp.dao;

import io.github.oaschi.paperwarp.domain.Warp;

import java.util.List;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class WarpDaoImpl extends WarpDao{
	
	public WarpDaoImpl(){
		super();
	}
	
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
	
	public boolean exists(Player creator, String name){
		return findPrivate(creator, name) != null;
	}

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