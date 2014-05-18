package io.github.oaschi.paperwarp.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.avaje.ebean.validation.NotEmpty;

@Entity
@Table(name = "warps")
public class Warp extends AbstractWarp {
	private static final long serialVersionUID = 5446575579486664968L;
	
	public static final String COL_NAME = "name";
	public static final String COL_IS_PUBLIC = "isPublic";
	
	@NotEmpty
	@Column(name = COL_NAME)
	private String name;
	
	@NotEmpty
	@Column(name = COL_IS_PUBLIC)
	private boolean isPublic = false;
	
	public Warp(){
		//required for JPA
	}
	
	public Warp(Player creator, String name, boolean isPublic){
		this(creator, name);
		this.isPublic = true;
	}
	
	public Warp(Player creator, String name){
		this(creator.getLocation(), creator.getUniqueId(), name);
	}
	
	public Warp(Location location, UUID creatorId, String name, boolean isPublic){
		this(location, creatorId, name);
		this.isPublic = isPublic;
	}
	
	public Warp(Location location, UUID creatorId, String name){
		super(location, creatorId);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

}