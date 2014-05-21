package io.github.oaschi.paperwarp;

import io.github.oaschi.paperwarp.commands.PWCommandExecutor;
import io.github.oaschi.paperwarp.dao.HomeDaoImpl;
import io.github.oaschi.paperwarp.dao.WarpDaoImpl;
import io.github.oaschi.paperwarp.domain.Home;
import io.github.oaschi.paperwarp.domain.Warp;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;

import com.bergerkiller.bukkit.common.PluginBase;

public class PaperWarp extends PluginBase{
	
	private PWLogger logger;
	private PWCommandExecutor commandExecutor;
	
	private Economy econ = null;
	private Permission perms = null;
	
	public static PaperWarp plugin;
	
	private WarpDaoImpl warpdao;
	private HomeDaoImpl homedao;

	@Override
	public void enable() {
		PaperWarp.plugin = this;
		warpdao = new WarpDaoImpl();
		homedao = new HomeDaoImpl();
		logger = new PWLogger();
		commandExecutor = new PWCommandExecutor();
		logger.info("Plugin enabled!");
		
		//extractJars();
		setupDB();
		setupVault();
		setCommandExecutors();
	}
	
	
	@Override
	public void disable() {
		
	}
	
	@Override
	public void localization(){
		this.loadLocales(Localization.class);
	}

	private void setCommandExecutors(){
		getCommand("warp").setExecutor(this);
	}
	
	private void extractJars(){
		try{
			final File[] libs = new File[]{
				new File(getDataFolder(), "/jars/jargs.jar")
			};
			
			for(final File lib : libs){
				if(!lib.exists()){
					JarUtils.extractFromJar(lib.getName(), lib.getAbsolutePath());
				}
			}
			
			addLibsToClasspath(libs);
		}
		catch(final Exception e){
			e.printStackTrace();
		}
	}
	
	private void addLibsToClasspath(final File[] libs) throws IOException{
		for(final File lib : libs){
			if(!lib.exists()){
				getLogger().warning("There was a critical error loading the plugin! Could not find lib: " + lib.getName());
				Bukkit.getServer().getPluginManager().disablePlugin(this);
				return;
			}
			addClassPath(JarUtils.getJarUrl(lib));
		}
	}
	
	private void addClassPath(final URL url) throws IOException{
		final URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		final Class<URLClassLoader> sysclass = URLClassLoader.class;
		try{
			final Method method = sysclass.getDeclaredMethod("addURL", new Class[]{ URL.class });
			method.setAccessible(true);
			method.invoke(sysloader, new Object[] { url });
		}
		catch(final Throwable t){
			t.printStackTrace();
			throw new IOException("Error adding " + url + " to system classloader");
		}
	}
	
	private void setupVault(){
		if(getServer().getPluginManager().getPlugin("Vault") == null){
			logger.info("Vault not found, " + getDescription().getName() + " won't support economy, permissions and chat-plugins.");
			return;
		}
		if(!setupEconomy()){
			logger.info("Economy support disabled.");
		}
		if(!setupPermissions()){
			logger.info("Permission support disabled.");
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
		commandExecutor.execute(sender, args);
		return true;
	}

	public void setPWLogger(PWLogger logger) {
		this.logger = logger;
	}

	public PWLogger getPWLogger() {
		return logger;
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

}
