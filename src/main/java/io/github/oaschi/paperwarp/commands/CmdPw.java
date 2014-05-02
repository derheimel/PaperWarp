package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.PaperWarp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CmdPw implements CommandExecutor{
	
	private PaperWarp plugin;
	
	public CmdPw(PaperWarp plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return true;
	}

}
