package io.github.oaschi.paperwarp.dao;

import io.github.oaschi.paperwarp.PaperWarp;
import io.github.oaschi.paperwarp.domain.Warp;

import java.util.List;

public abstract class WarpDao extends AbstractWarpDao<Warp>{
	
	public WarpDao(PaperWarp plugin) {
		super(plugin, Warp.class);
	}
	public abstract Warp findByPlayerAndName(String player, String name);
	public abstract List<Warp> findByPlayer(String player);
	
}