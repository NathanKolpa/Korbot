package lib.core.commands.input;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputParser
{
	public InputCommand parse(String input)
	{
		String[] parts = input.split("\\s+");

		if(parts.length <= 0)
			return null;

		InputCommand cmd = new InputCommand();
		cmd.getArguments().addAll(Arrays.stream(parts).map(InputArgument::new).collect(Collectors.toList()));
		return cmd;
	}
}
