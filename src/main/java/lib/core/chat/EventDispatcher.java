package lib.core.chat;

import lib.core.chat.callbacks.MessageCallback;

public interface EventDispatcher
{
	void setOnMessage(MessageCallback callback);
}
