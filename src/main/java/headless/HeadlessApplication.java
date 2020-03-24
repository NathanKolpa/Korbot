package headless;

import headless.commands.impl.HelpCommand;
import headless.commands.impl.RandomMeme;
import headless.config.Config;
import lib.core.Bot;
import lib.core.commands.input.InputArgument;
import lib.core.commands.input.InputCommand;
import lib.core.commands.router.CommandRouter;
import lib.core.commands.router.route.PrefixRoute;
import lib.core.commands.router.route.RouteList;
import lib.core.commands.router.route.SingeRoute;
import lib.core.commands.router.route.SubRoute;
import lib.core.commands.template.Command;
import lib.discord.bot.DiscordBot;

import java.io.IOException;

public class HeadlessApplication
{
	public static void main(String[] args)
	{
		try
		{
			Config config = new Config("./config.xml");

			DiscordBot discordBot = new DiscordBot(config.getToken());
			Bot bot = new Bot(discordBot, getCommands());

			discordBot.startAndWait();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static CommandRouter getCommands()
	{
		CommandRouter commands = new CommandRouter();
		Command help = new Command("help", "Shows the list of available commands", new HelpCommand(commands));

		Command randomMeme = new Command("random meme", "Sends a random meme", new RandomMeme());

		RouteList commandList = new RouteList();
		commandList.addRoute(new SingeRoute("help", help));
		commandList.addRoute(new SingeRoute("meme", randomMeme));
		commands.setRoot(new SubRoute("java", commandList));

		return commands;
	}
}
