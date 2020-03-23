package lib.core;

import lib.core.chat.EventDispatcher;
import lib.core.commands.input.InputCommand;
import lib.core.commands.input.InputParser;
import lib.core.commands.router.CommandRouter;
import lib.core.commands.template.Command;

import java.text.ParseException;

public class Bot
{
	private final EventDispatcher dispatcher;
	private CommandRouter commands;
	private InputParser parser = new InputParser();

	public Bot(EventDispatcher dispatcher, CommandRouter commands)
	{
		this.dispatcher = dispatcher;
		this.commands = commands;

		dispatcher.setOnMessage((channel, message) ->
		{
			InputCommand inputCommand = parser.parse(message);

			if(inputCommand == null)
				return;

				Command command = commands.routeCommand(inputCommand);

				if(command != null)
				{
					command.getAction().act(inputCommand, channel);
				}
		});
	}

	public CommandRouter getCommands()
	{
		return commands;
	}
}
