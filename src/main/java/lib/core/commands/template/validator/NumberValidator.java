package lib.core.commands.template.validator;


import lib.core.commands.input.InputArgument;

public class NumberValidator implements Validator
{
	@Override
	public boolean isValid(InputArgument input)
	{
		return input.getValue().matches("-?\\d+(\\.\\d+)?");
	}

	@Override
	public String getExplanation()
	{
		return "Requires the argument to be a number";
	}
}
