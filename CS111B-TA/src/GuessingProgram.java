

import java.util.Scanner;
public class GuessingProgram
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    String again, ans;   
    NumberGuesser obj = new NumberGuesser(1, 101);
    do
    {
      obj.reset();
      System.out.println("Pick a number between 1 and 100");
      while(true)
      {
        System.out.print("Is the number " + obj.getCurrentGuess() + "? (h/l/c):");
        ans = input.next();
        if(ans.equalsIgnoreCase("h"))
        {
          obj.higher();
        }
        else if(ans.equalsIgnoreCase("l"))
        {
          obj.lower();
        }
        else if(ans.equalsIgnoreCase("c"))
        {
          System.out.println("You picked " + obj.getCurrentGuess() + "? Great pick.");
          break;
        }
      }
    System.out.print("Do you want to play again? (y/n): ");
    again = input.next();
    } while(again.equalsIgnoreCase("y"));
    System.out.println("GoodBye");
  }
}

