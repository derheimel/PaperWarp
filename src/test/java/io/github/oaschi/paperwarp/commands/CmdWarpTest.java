package io.github.oaschi.paperwarp.commands;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyChar;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import io.github.oaschi.paperwarp.Localization;
import io.github.oaschi.paperwarp.PWLogger;
import io.github.oaschi.paperwarp.dao.WarpDaoImpl;
import io.github.oaschi.paperwarp.domain.Warp;
import io.github.oaschi.paperwarp.permission.PWPermission;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.junit.Test;

public class CmdWarpTest {
	
//	@Test
//	public void testCmdWarp() {
//		CmdWarp w = new CmdWarp(false);
//		assertEquals(PWPermission.WARP_PRIVATE, w.getPermission());
//		
//		w = new CmdWarp(true);
//		assertEquals(PWPermission.WARP_PUBLIC, w.getPermission());
//	}
//
//	@Test
//	public void testExecute() {
//		CmdWarp cmdw = spy(new CmdWarp(false));
//		String foo = "foo";
//		doReturn(foo).when(cmdw).combineStringArray(any(String[].class), anyChar());
//		
//		Player player = mock(Player.class);
//		doReturn(player).when(cmdw).getPlayer();
//		
//		Warp w = mock(Warp.class);
//		WarpDaoImpl warpdao = mock(WarpDaoImpl.class);
//		doReturn(warpdao).when(cmdw).getWarpdao();
//		doReturn(w).when(warpdao).findPrivate(player, foo);
//		
//		cmdw.execute();
//		
//		verify(player).teleport(any(Location.class));
//		
//		doReturn(null).when(warpdao).findPrivate(player, foo);
//		
//		PWLogger logger = mock(PWLogger.class);
//		doReturn(logger).when(cmdw).getLogger();
//		
//		cmdw.execute();
//		
//		verify(logger).info(player, Localization.WARP_EXISTS_NOT);
//		
//	}

}
