package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.Localization;
import io.github.oaschi.paperwarp.permission.PWPermission;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class PlayerCommand extends AbstractCommand{
	
	protected Player player;
	
	public PlayerCommand(){
		
	}
	
	public PlayerCommand(PWPermission permission){
		super(permission);
	}

	@Override
	abstract public void execute();
	
	@Override
	protected final void init(CommandSender sender) {
		if(sender instanceof Player) this.player = (Player) sender;
		else{
			this.getLogger().info(Localization.PLAYER_COMMAND);
			this.setAborted(true);
		}
	}

}
