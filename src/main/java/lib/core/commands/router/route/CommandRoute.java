package lib.core.commands.router.route;

import lib.core.commands.input.InputCommand;
import lib.core.commands.template.Command;

public interface CommandRoute
{
	Command[] match(InputCommand command);
	Command[] getAll();
}
