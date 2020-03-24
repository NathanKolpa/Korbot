package lib.core.commands.router.route;

import lib.core.commands.input.InputArgument;
import lib.core.commands.input.InputCommand;
import lib.core.commands.template.Command;

public class SubRoute implements CommandRoute
{
	private String segment;
	private CommandRoute child;

	public SubRoute(String segment, CommandRoute child)
	{
		this.segment = segment;
		this.child = child;
	}

	@Override
	public Command[] match(InputCommand command)
	{
		// if the first segments is correct
		if(command.getArguments().size() <= 0 || !command.getArguments().get(0).getValue().equals(segment))
		{
			return null;
		}

		InputArgument first = command.getArguments().get(0);
		command.getArguments().remove(0);

		Command[] result = child.match(command);

		command.getArguments().add(0, first);

		return result;
	}

	@Override
	public Command[] getAll()
	{
		return child.getAll();
	}
}
