package lib.core.commands.template;

import lib.core.commands.input.InputArgument;
import lib.core.commands.template.validator.Validator;

import java.util.ArrayList;

public class Argument
{
	private String name;
	private String description;
	private ArrayList<Validator> validators;

	public Argument(String name, String description)
	{
		this.name = name;
		this.description = description;
		this.validators = new ArrayList<>();
	}

	public Argument(String name,  String description, ArrayList<Validator> validators)
	{
		this.name = name;
		this.description = description;
		this.validators = validators;
	}

	public boolean isValid(InputArgument arg)
	{
		for (Validator validator : validators)
		{
			if(!validator.isValid(arg))
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

	public ArrayList<Validator> getValidators()
	{
		return validators;
	}
}
