package io.github.oaschi.paperwarp.dao;

import io.github.oaschi.paperwarp.domain.Warp;

import java.util.List;
import java.util.UUID;

public abstract class WarpDao extends AbstractWarpDao<Warp>{
	
	public WarpDao() {
		super(Warp.class);
	}
	public abstract Warp findByCreatorAndName(String creator, String name);
	public abstract Warp findByCreatorAndName(UUID creator, String name);
	public abstract List<Warp> findByCreator(String creator);
	public abstract List<Warp> findByCreator(UUID creator);
	
}