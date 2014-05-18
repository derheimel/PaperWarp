package io.github.oaschi.paperwarp.dao;

import io.github.oaschi.paperwarp.domain.Home;

public class HomeDaoImpl extends HomeDao{

	public HomeDaoImpl() {
		super();
	}

	@Override
	public Home findByCreatorId(String creatorId) {
		return getDatabase().find(Home.class).where().eq(Home.COL_CREATOR_ID, creatorId).findUnique();
	}

}
