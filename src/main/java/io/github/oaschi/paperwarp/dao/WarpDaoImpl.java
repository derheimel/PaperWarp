package io.github.oaschi.paperwarp.dao;

import io.github.oaschi.paperwarp.domain.Warp;

import java.util.List;
import java.util.UUID;

public class WarpDaoImpl extends WarpDao{
	
	public WarpDaoImpl(){
		super();
	}
	
	@Override
	public Warp findByCreatorAndName(String creator, String name) {
		Warp w = getDatabase().find(Warp.class)
				.where()
				.eq("playerUUID", creator)
				.ieq("name", name)
				.findUnique();
		
		return w;
	}
	
	@Override
	public Warp findByCreatorAndName(UUID creator, String name) {
		return this.findByCreatorAndName(creator.toString(), name);
	}

	@Override
	public List<Warp> findByCreator(String creator) {
		List<Warp> warps = getDatabase().find(Warp.class)
				.where()
				.eq("playerUUID", creator)
				.findList();
		
		return warps;
	}
	
	@Override
	public List<Warp> findByCreator(UUID creator) {
		return this.findByCreator(creator.toString());
	}
	
	public boolean exists(String creator, String name){
		return findByCreatorAndName(creator, name) != null;
	}

}