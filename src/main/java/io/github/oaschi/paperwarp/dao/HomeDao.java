package io.github.oaschi.paperwarp.dao;

import io.github.oaschi.paperwarp.domain.Home;

public abstract class HomeDao extends AbstractWarpDao<Home>{

	public HomeDao() {
		super(Home.class);
	}
	
	public abstract Home findByPlayer(String creator);

}