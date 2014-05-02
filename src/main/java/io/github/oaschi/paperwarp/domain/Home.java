package io.github.oaschi.paperwarp.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.bukkit.Location;

@Entity
@Table(name = "homes")
public class Home extends AbstractWarp {
	private static final long serialVersionUID = -7390075948761650156L;

	public Home(Location location, String creator) {
		super(location, creator);
	}
	
	public Home(){
		//required for JPA
	}

}