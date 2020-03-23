package headless.commands.impl;

import lib.core.chat.Channel;
import lib.core.commands.input.InputCommand;
import lib.core.commands.router.CommandRouter;
import lib.core.commands.template.Argument;
import lib.core.commands.template.Command;
import lib.core.commands.template.CommandAction;

public class HelpCommand implements CommandAction
{
	private final CommandRouter router;

	public HelpCommand(CommandRouter router)
	{
		this.router = router;
	}

	@Override
	public void act(InputCommand input, Channel sourceChannel)
	{
		Command[] all = router.getRoot().getAll();
		StringBuilder builder = new StringBuilder();

		for(Command command : all)
		{
			builder.append("**" + command.getName() + "** ");
			for (Argument argument : command.getArguments())
			{
				builder.append("*" + argument.getName() + "* ");
			}

			builder.append("`" +command.getDescription() + "`\n");
		}

		sourceChannel.sendMessage(builder.toString());
	}
}
