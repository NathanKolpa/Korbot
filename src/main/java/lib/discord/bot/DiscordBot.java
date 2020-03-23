package lib.discord.bot;

import lib.core.chat.EventDispatcher;
import lib.core.chat.callbacks.MessageCallback;
import lib.discord.bot.adapters.MessageAdapter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class DiscordBot implements EventDispatcher
{
	private final JDABuilder builder;

	public DiscordBot(String token)
	{
		builder = JDABuilder.createDefault(token);
	}

	public void startAndWait() throws LoginException, InterruptedException
	{
		JDA jda = builder.build();
		jda.awaitReady();
	}

	@Override
	public void setOnMessage(MessageCallback callback)
	{
		builder.addEventListeners(new MessageAdapter(callback));
	}
}
