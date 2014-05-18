package io.github.oaschi.paperwarp.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.bukkit.Location;
import org.bukkit.entity.Player;

@Entity
@Table(name = "homes")
public class Home extends AbstractWarp {
	private static final long serialVersionUID = -7390075948761650156L;

	public Home(Player creator){
		this(creator.getLocation(), creator.getUniqueId());
	}
	
	public Home(Location location, UUID creatorId) {
		super(location, creatorId);
	}
	
	public Home(){
		//required for JPA
	}

}