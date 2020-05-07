

public class NumberGuesser
{
  private int originalUpper,originalLower;
  private int currentUpper,currentLower;
  public NumberGuesser(int originalLower,int originalUpper)
  {
    this.originalUpper = originalUpper;
    this.originalLower = originalLower;
    this.currentLower = originalLower;
    this.currentUpper = originalUpper;
  }
  public int getCurrentGuess()
  {
    return ((currentUpper - currentLower) / 2) + currentLower;
  }
  public void higher()
  {
    currentLower = getCurrentGuess();
  }
  public void lower()
  {
    currentUpper = getCurrentGuess();
  }
  public void reset()
  {
    this.currentLower = originalLower;
    this.currentUpper = originalUpper;
  }
}

