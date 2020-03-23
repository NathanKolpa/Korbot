package lib.core.commands.template;

import lib.core.chat.Channel;
import lib.core.commands.input.InputCommand;

public interface CommandAction
{
	void act(InputCommand input, Channel sourceChannel);
}
