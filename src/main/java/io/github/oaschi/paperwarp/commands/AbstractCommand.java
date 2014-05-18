package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.PWLogger;
import io.github.oaschi.paperwarp.PaperWarp;
import io.github.oaschi.paperwarp.dao.HomeDaoImpl;
import io.github.oaschi.paperwarp.dao.WarpDaoImpl;
import io.github.oaschi.paperwarp.permission.PWPermission;

import java.util.Arrays;

import org.bukkit.command.CommandSender;

public abstract class AbstractCommand {
	
	private PWPermission permission;
	
	private WarpDaoImpl warpdao;
	private HomeDaoImpl homedao;
	private PWLogger logger;
	
	private boolean aborted;
	
	protected String[] args;
	
	public AbstractCommand(){
		this.warpdao = PaperWarp.plugin.warpdao;
		this.homedao = PaperWarp.plugin.homedao;
		this.logger = PaperWarp.plugin.logger;
	}
	
	public AbstractCommand(PWPermission permission){
		this();
		this.permission = permission;
	}
	
	abstract public void execute();
	
	abstract protected void init(CommandSender sender);
	
	public final void init(CommandSender sender, String[] args){
		this.args = args;
		init(sender);
	}
	
	public static void execute(CommandSender sender, String[] args){
		AbstractCommand cmd = null;
		
		if(args.length == 0){
			cmd = new CmdInfo();
			cmd.init(sender);
		}
		
		else if(args[0].startsWith("-")){
			switch(args[0].toLowerCase()){
			case "-c": cmd = new CmdCreateWarp(false); break;
			}
			cmd.init(sender, Arrays.copyOfRange(args, 1, args.length));
		}
		else{
			cmd = new CmdWarp(false);
			cmd.init(sender, args);
		}
		
		if(!cmd.isAborted())
			cmd.execute();
	}

	protected void setPermission(PWPermission permission) {
		this.permission = permission;
	}
	
	protected String combineStringArray(String[] args, char seperator){
		String combinedString = "";
		for(String str : args){
			combinedString += str + seperator;
		}
		return combinedString.substring(0, combinedString.length());
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
