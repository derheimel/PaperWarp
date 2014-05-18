package io.github.oaschi.paperwarp.dao;

import org.bukkit.entity.Player;

import io.github.oaschi.paperwarp.domain.Home;

public abstract class HomeDao extends AbstractWarpDao<Home>{

	public HomeDao() {
		super(Home.class);
	}
	
	public abstract Home findByCreatorId(Player creator);

}
