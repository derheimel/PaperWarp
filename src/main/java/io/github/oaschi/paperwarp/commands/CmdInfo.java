package io.github.oaschi.paperwarp.commands;

import org.bukkit.command.CommandSender;

import io.github.oaschi.paperwarp.Localization;
import io.github.oaschi.paperwarp.PaperWarp;
import io.github.oaschi.paperwarp.permission.PWPermission;

public class CmdInfo extends PlayerCommand{

	public CmdInfo(CommandSender sender) {
		super(PWPermission.INFO, sender);
	}

	@Override
	public void execute() {
		PaperWarp.plugin.getPWLogger().info(Localization.INFO);
	}

}
