package cars.lib;


public class CarList implements Cars
{
	String name;
	String make;
	
	public CarList(String name, String make)
	{
		setName(name);
		setMake(make);
	}
	
	@Override
	public boolean setName(String name)
	{
		this.name = name;
		return true;
	}
	
	@Override
	public boolean setMake(String make)
	{
		this.make = make;
		return true;
	}
	
	@Override
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public String getMake()
	{
		return this.make;
	}
}

