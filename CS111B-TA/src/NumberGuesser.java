public class NumberGuesser 
{
	protected int lower;
	protected int upper;
	private int initialLower;
	private int initialUpper;
	
	public NumberGuesser()
	{
		lower = 0;
		upper = 0;
	}
	public NumberGuesser(int min, int max)
	{
		lower = min;
		initialLower = min;
		upper = max;
		initialUpper = max;
	}
	public void setLower(int min)
	{
		lower = min;
	}
	public int getLower()
	{
		return lower;
	}
	public void setUpper(int max)
	{
		upper = max;
	}
	public int getUpper()
	{
		return upper;
	}
	public void higher()
	{
		lower = getCurrentGuess() + 1;
	}
	public void lower()
	{
		if (upper > 2)
			upper = getCurrentGuess() - 1;
	}
	public int getCurrentGuess()
	{
		return (lower + upper) / 2;
	}
	public void reset()
	{
		lower = initialLower;
		upper = initialUpper;
	}
}
