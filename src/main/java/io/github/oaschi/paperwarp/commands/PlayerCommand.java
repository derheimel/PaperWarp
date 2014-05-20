package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.Localization;
import io.github.oaschi.paperwarp.permission.PWPermission;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class PlayerCommand extends AbstractCommand{
	
	private Player player;
	
	public PlayerCommand(CommandSender sender){
		this(null, sender);
	}
	
	public PlayerCommand(PWPermission permission, CommandSender sender){
		super(permission);
		if(sender instanceof Player) this.player = (Player) sender;
		else{
			this.getLogger().info(Localization.PLAYER_COMMAND);
			this.setAborted(true);
		}
	}

	@Override
	abstract public void execute();

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
