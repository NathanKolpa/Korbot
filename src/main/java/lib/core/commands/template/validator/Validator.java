package lib.core.commands.template.validator;

import lib.core.commands.input.InputArgument;

public interface Validator
{
	boolean isValid(InputArgument input);
	String getExplanation();
}
