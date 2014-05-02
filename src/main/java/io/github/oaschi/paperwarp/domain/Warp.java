package io.github.oaschi.paperwarp.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.bukkit.Location;

import com.avaje.ebean.validation.NotEmpty;

@Entity
@Table(name = "warps")
public class Warp extends LocationPersistable {
	private static final long serialVersionUID = -2843929155225762192L;

	@NotEmpty
	private String name;

	@NotEmpty
	private String playerName;

	public Warp(Location location, String name, String player) {
		super(location);
		this.name = name;
		this.playerName = player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


}