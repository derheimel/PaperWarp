package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.PaperWarp;
import io.github.oaschi.paperwarp.dao.WarpDaoImpl;
import io.github.oaschi.paperwarp.domain.Warp;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CmdPw implements CommandExecutor{
	
	private PaperWarp plugin;
	private WarpDaoImpl warpdao;
	
	public CmdPw(PaperWarp plugin){
		this.plugin = plugin;
		this.warpdao = plugin.warpdao;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length > 0){
			Warp w = new Warp(new Location(sender.getServer().getWorlds().get(0), 0, 0, 0), "swaggerboy", "swagwarp");
			warpdao.save(w);
		}
		else{
			Warp w = warpdao.findAll().get(0);
			sender.sendMessage(w.getCreator());
		}
		
		return true;
	}

}
