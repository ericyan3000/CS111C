import java.util.Random;
import java.util.Scanner;
public class BlackJack 
{
  public static void main(String[] args) 
  {
    Scanner keyboard = new Scanner(System.in);
    int c1, c2, card, total = 0;
    Random random = new Random();
    boolean again = true;
    while(again)
    {
      c1 = 1 + random.nextInt(10);
      c2 = 1 + random.nextInt(10);
      total = c1 + c2;
      System.out.println("First cards: " + c1 +", " + c2);
      System.out.println("Total: " + total);
      String choice= "y";
      while(total < 21)
      {
        System.out.print("Do you want another card? (y/n): ");
        choice = keyboard.next();
        if(choice.equalsIgnoreCase("y"))
        {
          card = 1 + random.nextInt(10);
          System.out.println("Card: " + card);
          total += card;
          System.out.println("Total: " + total);
        }
        else
          break;
      }
      if(total > 21)
        System.out.println("Bust!");
        System.out.print("Would you like to play again? (y/n): ");
        choice = keyboard.next();
      if(!choice.equalsIgnoreCase("y"))
        again = false;
     }
  }
}