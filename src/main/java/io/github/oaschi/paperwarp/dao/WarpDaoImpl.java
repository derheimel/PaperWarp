package io.github.oaschi.paperwarp.dao;

import io.github.oaschi.paperwarp.domain.Warp;

import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

public class WarpDaoImpl extends WarpDao{
	
	public WarpDaoImpl(){
		super();
	}
	
	@Override
	public Warp findByCreatorAndName(Player creator, String name) {
		String creatorId = creator.getUniqueId().toString();
		Warp w = getDatabase().find(Warp.class)
				.where()
				.eq(Warp.COL_CREATOR_ID, creatorId)
				.ieq(Warp.COL_NAME, name)
				.findUnique();
		
		return w;
	}

	@Override
	public List<Warp> findByCreator(Player creator) {
		String creatorId = creator.getUniqueId().toString();
		List<Warp> warps = getDatabase().find(Warp.class)
				.where()
				.eq(Warp.COL_CREATOR_ID, creatorId)
				.findList();
		
		return warps;
	}
	
	public boolean exists(Player creator, String name){
		return findByCreatorAndName(creator, name) != null;
	}

}