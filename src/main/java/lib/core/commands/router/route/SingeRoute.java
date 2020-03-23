package lib.core.commands.router.route;

import lib.core.commands.input.InputCommand;
import lib.core.commands.template.Command;

public class SingeRoute implements CommandRoute
{
	private final String name;
	private Command[] commands;

	public SingeRoute(String name, Command command)
	{
		this.name = name;
		commands = new Command[1];
		commands[0] = command;
	}

	@Override
	public Command[] match(InputCommand command)
	{
		if(command.getArguments().size() <= 0)
			return null;

		if(!command.getArguments().get(0).getValue().equals(name))
			return null;

		if(!getCommand().matches(command))
			return null;


		return commands;
	}

	@Override
	public Command[] getAll()
	{
		return commands;
	}

	private Command getCommand()
	{
		return commands[0];
	}
}
