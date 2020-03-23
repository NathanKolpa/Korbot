package lib.core.chat;

import java.io.File;

public interface Channel
{
	void sendMessage(String text);
	void sendFile(File file);
}
