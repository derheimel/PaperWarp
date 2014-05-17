package io.github.oaschi.paperwarp.commands;

import io.github.oaschi.paperwarp.Localization;
import io.github.oaschi.paperwarp.PaperWarp;

public class CmdInfo extends PlayerCommand{

	@Override
	public void execute() {
		PaperWarp.plugin.logger.info(Localization.INFO);
	}

}
