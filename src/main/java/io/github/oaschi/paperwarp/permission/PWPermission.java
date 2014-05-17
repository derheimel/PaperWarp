package io.github.oaschi.paperwarp.permission;

import java.util.Locale;

import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionDefault;

import com.bergerkiller.bukkit.common.permissions.IPermissionDefault;
import com.bergerkiller.bukkit.common.utils.CommonUtil;
import com.bergerkiller.bukkit.common.utils.LogicUtil;
import com.bergerkiller.bukkit.common.utils.StringUtil;


public enum PWPermission implements IPermissionDefault{
	WARP_PRIVATE("warp.warp.private", PermissionDefault.OP, "Sets if the player is allowed to teleport to private warps."),
	WARP_PUBLIC("warp.warp.public", PermissionDefault.OP, "Sets if the player is allowed to teleport to public warps."),
	WARP_CREATE_PRIVATE("warp.create.private", PermissionDefault.OP, "Sets if the player is allowed to create private warps."),
	WARP_CREATE_PUBLIC("warp.create.public", PermissionDefault.OP, "Sets if the player is allowed to create public warps."),
	
	;
	
	private final String name;
	private final String node;
	private final String[] nodeArr;
	private final String description;
	private final PermissionDefault defValue;
	
	PWPermission(String node, PermissionDefault defValue, String description){
		this(node, defValue, description, 0);
	}
	
	PWPermission(String node, PermissionDefault defValue, String description, int argCount){
		this.node = node.toLowerCase(Locale.ENGLISH);
		this.nodeArr = this.node.split("\\.");
		this.defValue = defValue;
		this.description = description;
		this.name = this.node + StringUtil.getFilledString(".*", argCount);
	}

	@Override
	public PermissionDefault getDefault() {
		return this.defValue;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	public boolean has(CommandSender sender, String... args){
		if(args.length == 0){
			return CommonUtil.hasPermission(sender, node);
		}
		else{
			return CommonUtil.hasPermission(sender, LogicUtil.appendArray(nodeArr, args));
		}
	}

}
