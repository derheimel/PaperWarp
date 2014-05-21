package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.PWLogger;
import io.github.oaschi.paperwarp.PaperWarp;
import io.github.oaschi.paperwarp.dao.HomeDaoImpl;
import io.github.oaschi.paperwarp.dao.WarpDaoImpl;
import io.github.oaschi.paperwarp.permission.PWPermission;

public abstract class AbstractCommand {
	
	private PWPermission permission;
	
	private WarpDaoImpl warpdao;
	private HomeDaoImpl homedao;
	private PWLogger logger;
	
	private boolean aborted;
	
	protected String[] args;
	
	public AbstractCommand(){
		PaperWarp plugin = PaperWarp.plugin;
		if(plugin != null){
			this.warpdao = PaperWarp.plugin.getWarpdao();
			this.homedao = PaperWarp.plugin.getHomedao();
			this.logger = PaperWarp.plugin.getPWLogger();
		}
	}
	
	public AbstractCommand(PWPermission permission){
		this();
		this.permission = permission;
	}
	
	abstract public void execute();

	public PWPermission getPermission() {
		return permission;
	}

	protected void setPermission(PWPermission permission) {
		this.permission = permission;
	}

	public WarpDaoImpl getWarpdao() {
		return warpdao;
	}

	public void setWarpdao(WarpDaoImpl warpdao) {
		this.warpdao = warpdao;
	}

	public HomeDaoImpl getHomedao() {
		return homedao;
	}

	public void setHomedao(HomeDaoImpl homedao) {
		this.homedao = homedao;
	}

	public PWLogger getLogger() {
		return logger;
	}

	public void setLogger(PWLogger logger) {
		this.logger = logger;
	}

	public boolean isAborted() {
		return aborted;
	}

	public void setAborted(boolean aborted) {
		this.aborted = aborted;
	}

}
