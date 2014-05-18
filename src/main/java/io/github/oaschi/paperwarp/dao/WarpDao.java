package io.github.oaschi.paperwarp.dao;

import io.github.oaschi.paperwarp.domain.Warp;

import java.util.List;

import org.bukkit.entity.Player;

public abstract class WarpDao extends AbstractWarpDao<Warp>{
	
	public WarpDao() {
		super(Warp.class);
	}
	public abstract Warp findByCreatorAndName(Player creator, String name);
	public abstract List<Warp> findByCreator(Player creator);
	
}