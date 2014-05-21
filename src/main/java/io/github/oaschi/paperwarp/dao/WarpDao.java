package io.github.oaschi.paperwarp.dao;

import io.github.oaschi.paperwarp.domain.Warp;

import java.util.List;

import org.bukkit.World;
import org.bukkit.entity.Player;

public abstract class WarpDao extends AbstractWarpDao<Warp>{
	
	public WarpDao() {
		super(Warp.class);
	}
	public abstract Warp findPrivate(Player creator, String name);
	public abstract List<Warp> findPrivate(Player creator);
	public abstract Warp findPublic(World world, String name);
	public abstract List<Warp> findPublic(Player creator);
	public abstract boolean deletePublic(World world, String name);
	public abstract boolean deletePublic(Player creator);
	public abstract boolean deletePrivate(Player creator, String name);
	public abstract boolean deletePrivate(Player creator);
	
}