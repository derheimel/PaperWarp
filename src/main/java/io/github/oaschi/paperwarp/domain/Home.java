package io.github.oaschi.paperwarp.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.bukkit.Location;

@Entity
@Table(name = "homes")
public class Home extends Warp {
	private static final long serialVersionUID = 324740455479091906L;
	
	public Home(Location location, String name, String playerName) {
		super(location, name, playerName);
	}

}