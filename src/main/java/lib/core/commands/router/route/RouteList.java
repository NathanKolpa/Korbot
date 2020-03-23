package lib.core.commands.router.route;

import com.sun.deploy.util.ArrayUtil;
import lib.core.commands.input.InputCommand;
import lib.core.commands.template.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RouteList implements CommandRoute
{
	private ArrayList<CommandRoute> routes = new ArrayList<>();

	public void addRoute(CommandRoute route)
	{
		routes.add(route);
	}

	@Override
	public Command[] match(InputCommand command)
	{
		ArrayList<Command> matching = new ArrayList<>();

		for (CommandRoute route : routes)
		{
			Command[] result = route.match(command);

			if (result != null)
			{
				matching.addAll(Arrays.asList(result));
			}
		}

		if (matching.size() <= 0)
			return null;

		return matching.toArray(new Command[0]);
	}

	@Override
	public Command[] getAll()
	{
		List<Command[]> commands = routes.stream().map(x -> x.getAll()).collect(Collectors.toList());
		Command[] ret = new Command[commands.stream().mapToInt(x -> x.length).sum()];

		int currentIndex = 0;
		for(Command[] commandArr : commands)
		{
			for(Command current : commandArr)
			{
				ret[currentIndex] = current;
				currentIndex++;
			}
		}

		return ret;
	}
}
