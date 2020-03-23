package lib.core.commands.template;

import lib.core.commands.input.InputCommand;

import java.util.ArrayList;

public class Command
{
	private String name;
	private String description;
	private CommandAction action;
	private ArrayList<Argument> arguments = new ArrayList<>();

	public Command(String name, String description, CommandAction action)
	{
		this.name = name;
		this.description = description;
		this.action = action;
	}

	public boolean matches(InputCommand input)
	{
		return input.getArguments().size() - 1 == arguments.size();
	}

	public boolean isValid(InputCommand input)
	{
		if (!matches(input))
			return false;

		for (int i = 0; i < input.getArguments().size() - 1; i++)
		{
			if (!arguments.get(i).isValid(input.getArguments().get(i + 1)))
			{
				return false;
			}
		}

		return true;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public ArrayList<Argument> getArguments()
	{
		return arguments;
	}

	public void setArguments(ArrayList<Argument> arguments)
	{
		this.arguments = arguments;
	}

	public CommandAction getAction()
	{
		return action;
	}

	public void setAction(CommandAction action)
	{
		this.action = action;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
