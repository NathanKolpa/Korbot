package lib.core.commands.router.route;

import lib.core.commands.input.InputArgument;
import lib.core.commands.input.InputCommand;
import lib.core.commands.template.Command;

public class PrefixRoute implements CommandRoute
{
	private String prefix;
	private CommandRoute child;

	public PrefixRoute(String prefix, CommandRoute child)
	{
		this.prefix = prefix;
		this.child = child;
	}

	@Override
	public Command[] match(InputCommand command)
	{
		// if the first segments is correct
		if(command.getArguments().size() <= 0 || !command.getArguments().get(0).getValue().startsWith(prefix))
		{
			return null;
		}

		InputArgument first = command.getArguments().get(0);
		InputArgument temp = new InputArgument(first.getValue().substring(prefix.length()));
		command.getArguments().set(0, temp);

		Command[] result = child.match(command);

		command.getArguments().set(0, first);

		return result;
	}

	@Override
	public Command[] getAll()
	{
		return child.getAll();
	}
}
