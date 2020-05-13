import java.util.Random;
public class RandomNumberGuesser extends NumberGuesser
{
	private Random random = new Random();
	private int number;
	
	public RandomNumberGuesser()
	{
		super();
		setNumber(lower, upper);
	}	
	public RandomNumberGuesser(int low, int high)
	{
		super(low, high);
		setNumber(low, high);
		
	}
	public void setNumber(int min, int max)
	{	
		number = (random.nextInt(max - min + 1)) + min;
	}
	public int getLower()
	{
		return super.getLower();
	}
	public int getUpper()
	{
		return super.getUpper();
	}
	public int getCurrentGuess()
	{
		return number;
	}
	public void higher()
	{
		if (upper > lower)
			lower = number + 1;			
		setNumber(lower, upper);
		
	}
	public void lower()
	{
		if (upper > lower)
			upper = number - 1;
		setNumber(lower, upper);	
	}
	public void reset()
	{
		super.reset();
	}
}
