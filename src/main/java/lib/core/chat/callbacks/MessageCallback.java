package lib.core.chat.callbacks;

import lib.core.chat.Channel;

public interface MessageCallback
{
	void onMessage(Channel channel, String message);
}
