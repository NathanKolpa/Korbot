package lib.core.commands.input;

public class InputArgument
{
	private String value;

	public InputArgument(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
}
