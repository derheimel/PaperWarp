package io.github.oaschi.paperwarp.dao;

import io.github.oaschi.paperwarp.domain.Home;

import org.bukkit.entity.Player;

public class HomeDaoImpl extends HomeDao{

	public HomeDaoImpl() {
		super();
	}
	
	/**
	 * Returns the home of the given player in the current world.
	 */
	@Override
	public Home findByCreatorId(Player creator) {
		String creatorId = creator.getUniqueId().toString();
		String worldName = creator.getWorld().getName();
		Home h = getDatabase()
				.find(Home.class)
				.where()
				.eq(Home.COL_WORLD, worldName)
				.eq(Home.COL_CREATOR_ID, creatorId)
				.findUnique();
		
		return h;
	}

}
