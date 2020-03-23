package lib.discord.bot.adapters;

import lib.core.chat.callbacks.MessageCallback;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageAdapter extends ListenerAdapter
{
	private final MessageCallback callback;

	public MessageAdapter(MessageCallback callback)
	{
		this.callback = callback;
	}

	@Override
	public void onMessageReceived(MessageReceivedEvent event)
	{
		if(event.getAuthor().isBot())
			return;
		
		callback.onMessage(new DiscordChannel(event.getChannel()), event.getMessage().getContentRaw());
	}
}
