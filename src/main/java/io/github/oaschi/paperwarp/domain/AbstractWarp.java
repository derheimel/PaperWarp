package io.github.oaschi.paperwarp.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.avaje.ebean.validation.NotEmpty;
import com.avaje.ebean.validation.NotNull;

@MappedSuperclass
public abstract class AbstractWarp extends BasePersistable{
	private static final long serialVersionUID = 5269948699037792884L;
	
	public static final String COL_WORLD = "world";
	public static final String COL_CREATOR_ID = "creatorId";
	public static final String COL_X = "x";
	public static final String COL_Y = "y";
	public static final String COL_Z = "z";
	public static final String COL_YAW = "yaw";
	public static final String COL_PITCH = "pitch";

	@NotEmpty
	@Column(name = COL_WORLD)
	private String world;

	@NotEmpty
	@Column(name = COL_CREATOR_ID)
	private String creatorId;

	@NotNull
	@Column(name = COL_X)
	private double x;

	@NotNull
	@Column(name = COL_Y)
	private double y;

	@NotNull
	@Column(name = COL_Z)
	private double z;

	@NotNull
	@Column(name = COL_YAW)
	private float yaw;

	@NotNull
	@Column(name = COL_PITCH)
	private float pitch;
	
	public AbstractWarp(){
		//required for JPA
	}
	
	public AbstractWarp(Location location, UUID creatorId){
		super();
		this.creatorId = creatorId.toString();
		this.world = location.getWorld().getName();
		this.x = location.getX();
		this.y = location.getY();
		this.z = location.getZ();
		this.yaw = location.getYaw();
		this.pitch = location.getPitch();
	}
	
	public Location getLocation(){
		World worldObj = Bukkit.getServer().getWorld(world);
		return new Location(worldObj, x, y, z, yaw, pitch);
	}
	
	public void setLocation(Location location){
		this.world = location.getWorld().getName();
		this.x = location.getX();
		this.y = location.getY();
		this.z = location.getZ();
		this.yaw = location.getYaw();
		this.pitch = location.getPitch();
	}
	
	public double distance(Player player) {
		return player.getLocation().distance(getLocation());
	}

	public String getWorld() {
		return world;
	}

	public void setWorld(String world) {
		this.world = world;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public float getYaw() {
		return yaw;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

}
