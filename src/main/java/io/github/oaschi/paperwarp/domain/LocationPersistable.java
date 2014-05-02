package io.github.oaschi.paperwarp.domain;

import javax.persistence.MappedSuperclass;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.avaje.ebean.validation.NotEmpty;
import com.avaje.ebean.validation.NotNull;

@MappedSuperclass
public abstract class LocationPersistable extends BasePersistable{
	private static final long serialVersionUID = -7321930595158606735L;

	@NotEmpty
	private String worldName;

	@NotNull
	private double x;

	@NotNull
	private double y;

	@NotNull
	private double z;

	@NotNull
	private float yaw;

	@NotNull
	private float pitch;

	public LocationPersistable(){
		//required for JPA
	}

	public LocationPersistable(Location location){
		super();
		this.worldName = location.getWorld().getName();
		this.x = location.getX();
		this.y = location.getY();
		this.z = location.getZ();
		this.yaw = location.getYaw();
		this.pitch = location.getPitch();
	}

	public Location getLocation(){
		World world = Bukkit.getServer().getWorld(worldName);
		return new Location(world, x, y, z, yaw, pitch);
	}
	
	public double distance(Player player) {
		return player.getLocation().distance(getLocation());
	}

	public String getWorldName() {
		return worldName;
	}

	public void setWorldName(String worldName) {
		this.worldName = worldName;
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