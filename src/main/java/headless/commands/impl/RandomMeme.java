package headless.commands.impl;

import lib.core.chat.Channel;
import lib.core.commands.input.InputCommand;
import lib.core.commands.template.CommandAction;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class RandomMeme implements CommandAction
{
	@Override
	public void act(InputCommand input, Channel sourceChannel)
	{
		try
		{
			URL url = getClass().getResource("/memes/");

			File dir = new File(url.toURI());
			File[] memes = Objects.requireNonNull(dir.listFiles());

			int randomIndex = ThreadLocalRandom.current().nextInt(0, memes.length);

			sourceChannel.sendFile(memes[randomIndex]);
		}
		catch (URISyntaxException e)
		{
		}
	}
}
