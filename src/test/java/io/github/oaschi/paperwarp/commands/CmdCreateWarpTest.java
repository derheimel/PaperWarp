package io.github.oaschi.paperwarp.commands;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyChar;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import io.github.oaschi.paperwarp.permission.PWPermission;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.junit.Test;

public class CmdCreateWarpTest {
	
//	@Test
//	public void testCmdCreateWarp() {
//		CommandSender sender = mock(Player.class);
//		Map<String, Object> atts = new HashMap<>();
//		CmdCreateWarp w = new CmdCreateWarp(false);
//		assertEquals(PWPermission.WARP_CREATE_PRIVATE, w.getPermission());
//		
//		w = new CmdCreateWarp(true);
//		assertEquals(PWPermission.WARP_CREATE_PUBLIC, w.getPermission());
//	}
//
//	@Test
//	public void testExecute() {
//		CmdCreateWarp cmdcw = spy(new CmdCreateWarp(false));
//		String foo = "foo";
//		doReturn(foo).when(cmdcw).combineStringArray(any(String[].class), anyChar());
//		
//		Player player = mock(Player.class);
//		doReturn(player).when(cmdcw).getPlayer();
//		
//		
//	}

}
