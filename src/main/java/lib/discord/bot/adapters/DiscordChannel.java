package lib.discord.bot.adapters;

import lib.core.chat.Channel;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.io.File;

public class DiscordChannel implements Channel
{
	private final MessageChannel channel;

	public DiscordChannel(MessageChannel channel)
	{
		this.channel = channel;
	}

	@Override
	public void sendMessage(String text)
	{
		channel.sendMessage(text).queue();
	}

	@Override
	public void sendFile(File file)
	{
		channel.sendFile(file).queue();
	}
}
