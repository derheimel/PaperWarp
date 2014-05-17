/**
 * 
 */
package io.github.oaschi.paperwarp.domain;

import static org.junit.Assert.*;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * @author oaschi
 *
 */
public class AbstractWarpTest {

	@Test
	public void testDistance() {
		World world = mock(World.class);

		class NotAbstractWarp extends AbstractWarp{
			private static final long serialVersionUID = -6341203191829198846L;
		}
		
		AbstractWarp warp = spy(new NotAbstractWarp());
		Location loc = new Location(world, 0, 0, 0);
		doReturn(loc).when(warp).getLocation();

		Player player = mock(Player.class);
		Location loc2 = new Location(world, 100, 50, 0);
		when(player.getLocation()).thenReturn(loc2);
		
		double expected = Math.sqrt(Math.pow(100, 2) + Math.pow(50, 2));
		double actual = warp.distance(player);
		
		verify(player).getLocation();
		verify(warp).getLocation();
		assertEquals(expected, loc.distance(loc2), .1);
		assertEquals(expected, actual, .1);
	}

}