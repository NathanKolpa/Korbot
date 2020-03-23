package headless;

import headless.commands.impl.HelpCommand;
import headless.commands.impl.RandomMeme;
import lib.core.Bot;
import lib.core.commands.input.InputArgument;
import lib.core.commands.input.InputCommand;
import lib.core.commands.router.CommandRouter;
import lib.core.commands.router.route.PrefixRoute;
import lib.core.commands.router.route.RouteList;
import lib.core.commands.router.route.SingeRoute;
import lib.core.commands.template.Argument;
import lib.core.commands.template.Command;
import lib.discord.bot.DiscordBot;

public class HeadlessApplication
{
	public static void main(String[] args) throws Exception
	{
		DiscordBot discordBot = getDiscordBot();
		Bot bot = new Bot(discordBot, getCommands());

		discordBot.startAndWait();
	}

	private static CommandRouter getCommands()
	{
		CommandRouter commands = new CommandRouter();
		Command help = new Command("help", "Shows the list of available commands", new HelpCommand(commands));

		Command randomMeme = new Command("random meme", "Sends a random meme", new RandomMeme());

		RouteList commandList = new RouteList();
		commandList.addRoute(new SingeRoute("help", help));
		commandList.addRoute(new SingeRoute("meme", randomMeme));
		commands.setRoot(new PrefixRoute("$", commandList));

		return commands;
	}

	private static DiscordBot getDiscordBot()
	{
		return new DiscordBot("NTQyNjM2NzQ0Mzc4NDE3MTUy.Xnk2Kg.ZfDMzCkKSOcqv-LZ7lAyGo6TFmA");
	}
}
