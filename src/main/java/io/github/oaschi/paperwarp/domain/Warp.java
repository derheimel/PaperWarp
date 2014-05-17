package io.github.oaschi.paperwarp.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.bukkit.Location;

import com.avaje.ebean.validation.NotEmpty;

@Entity
@Table(name = "warps")
public class Warp extends AbstractWarp {
	private static final long serialVersionUID = 5446575579486664968L;
	
	@NotEmpty
	private String name;
	
	public Warp(){
		//required for JPA
	}

	public Warp(Location location, String creatorId, String name) {
		super(location, creatorId);
		this.name = name;
	}
	
	public Warp(Location location, UUID creatorId, String name){
		this(location, creatorId.toString(), name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}