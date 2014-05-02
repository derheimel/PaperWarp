package io.github.oaschi.paperwarp;

import io.github.oaschi.paperwarp.commands.CmdPw;
import io.github.oaschi.paperwarp.dao.HomeDaoImpl;
import io.github.oaschi.paperwarp.dao.WarpDaoImpl;
import io.github.oaschi.paperwarp.domain.Home;
import io.github.oaschi.paperwarp.domain.Warp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;

import com.bergerkiller.bukkit.common.PluginBase;

public class PaperWarp extends PluginBase{
	
	protected PaperWarpLogger logger;
	
	public static Economy econ = null;
	public static Permission perms = null;
	
	public final WarpDaoImpl warpdao = new WarpDaoImpl(this);
	public final HomeDaoImpl homedao = new HomeDaoImpl(this);

	@Override
	public void enable() {
		this.logger = new PaperWarpLogger(this);
		this.logger.info("Plugin enabled!");
		
		setupDB();
		setupVault();
		setCommandExecutors();
	}

	private void setCommandExecutors(){
		getCommand("pw").setExecutor(new CmdPw(this));
	}
	
	private void setupVault(){
		if(getServer().getPluginManager().getPlugin("Vault") == null){
			logger.infoPlain("Vault not found, " + getDescription().getName() + " won't support economy, permissions and chat-plugins.");
			return;
		}
		if(!setupEconomy()){
			logger.infoPlain("Economy support disabled.");
		}
		if(!setupPermissions()){
			logger.infoPlain("Permission support disabled.");
		}
	}

	private boolean setupEconomy(){
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if(rsp == null){
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}
	
	private boolean setupPermissions(){
		RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
		perms = rsp.getProvider();
		return perms != null;
	}
	
	public void setupDB(){
		try{
			this.getDatabase().find(Warp.class).findRowCount();
		}
		catch(PersistenceException e){
			System.out.println("Installing database for " + getDescription().getName() + " due to first time usage");
			installDDL();
		}
	}
	
	@Override
    public List<Class<?>> getDatabaseClasses() {
        List<Class<?>> list = new ArrayList<Class<?>>();
        list.add(Warp.class);
        list.add(Home.class);
        return list;
    }

	@Override
	public int getMinimumLibVersion() {
		return 0;
	}
	
	@Override
	public boolean command(CommandSender sender, String command, String[] args) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}

}
