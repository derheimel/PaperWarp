package io.github.oaschi.paperwarp.dao;

import io.github.oaschi.paperwarp.PaperWarp;
import io.github.oaschi.paperwarp.domain.Warp;

import java.util.List;

public class WarpDaoImpl extends WarpDao{
	
	public WarpDaoImpl(PaperWarp plugin){
		super(plugin);
	}
	
	@Override
	public Warp findByPlayerAndName(String player, String name) {
		Warp w = getDatabase().find(Warp.class)
				.where()
				.eq("playerName", player)
				.ieq("name", name)
				.findUnique();
		
		return w;
	}

	@Override
	public List<Warp> findByPlayer(String player) {
		List<Warp> warps = getDatabase().find(Warp.class)
				.where()
				.eq("playerName", player)
				.findList();
		
		return warps;
	}

}
