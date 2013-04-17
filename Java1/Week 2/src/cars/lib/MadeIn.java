package cars.lib;

/* Setting up ENUM so we can tell where cars were made */

public enum MadeIn
{
	HOMEMADE("Domestic"), CHINAMADE("Foreign");

	private MadeIn(final String text)
	{
		this.text = text;
	}

	private final String text;

	@Override
	public String toString()
	{
		return text;
	}
}
