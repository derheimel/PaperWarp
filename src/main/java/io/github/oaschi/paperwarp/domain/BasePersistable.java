package io.github.oaschi.paperwarp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BasePersistable implements Serializable{
	
	private static final long serialVersionUID = -1490885810086515617L;
	
	public static final String COL_ID = "id";

	@Id
	@Column(name = COL_ID)
	private Integer id;

	private long version = Long.MIN_VALUE;

	@Override
	public int hashCode(){
		return(getId() != null) ? getId().hashCode() : System.identityHashCode(this);
	}
	
	public BasePersistable(){
		// required for JPA
	}

	@Override
	public boolean equals(Object o){
		if(o == null) return false;
		if(o == this) return true;

		if(!this.getClass().equals(o.getClass())){
			return false;
		}
		BasePersistable other = (BasePersistable) o;
		if(this.getId() == null){
			if(other.getId() != null){
				return false;
			}
		}
		return this.getId().equals(other.getId());
	}

	public void incrementVersion() {
		this.version++;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

}