/**
 * 
 */
package io.github.oaschi.paperwarp;

import org.bukkit.plugin.PluginDescriptionFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author oaschi
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({PluginDescriptionFile.class, PaperWarp.class})
public class PWLoggerTest {
	
	/**
	 * Not implemented yet due to a bug in PowerMock
	 * that causes a StackOverflowError when mocking
	 * an object with a final equals() or hashCode() method.
	 */
	@Test
	public void testGetFormattedMessage() throws Exception {
//		PluginDescriptionFile pdf = PowerMockito.mock(PluginDescriptionFile.class);
//		PowerMockito.when(pdf.getFullName()).thenReturn("PaperWarp v0.1");
//		
//		PaperWarp plugin = PowerMockito.mock(PaperWarp.class);
//		PowerMockito.when(plugin.getDescription()).thenReturn(pdf);
//		
//		PaperWarpLogger logger = new PaperWarpLogger(plugin);
//		
//		String message = "yo, what's bouncin'";
//		String formattedMessage = Whitebox.<String>invokeMethod(logger, "getFormattedMessage", message);
//		
//		assertEquals("[PaperWarp v0.1]: yo, what's bouncin'", formattedMessage);
	}

}
