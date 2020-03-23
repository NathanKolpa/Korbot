package lib.core.commands.router;

import lib.core.commands.input.InputCommand;
import lib.core.commands.router.route.CommandRoute;
import lib.core.commands.template.Command;

import java.text.ParseException;

public class CommandRouter
{
	private CommandRoute root;

	public Command routeCommand(InputCommand inputCommand)
	{
		Command[] commands = this.root.match(inputCommand);

		if(commands == null)
		{
			return null;
		}

		//get the first valid command
		for(Command command : commands)
		{
			if(command.isValid(inputCommand))
			{
				return command;
			}
		}

		return null;
	}

	public CommandRoute getRoot()
	{
		return root;
	}

	public void setRoot(CommandRoute root)
	{
		this.root = root;
	}
}
