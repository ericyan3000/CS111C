import java.util.*;
public class RandomNumberGuesserProgram 
{
	public static void main(String[] args) 
	{
				
		String input, playAgain;
		
		// This line tests the NumberGuesser class.
//		NumberGuesser gameOne = new NumberGuesser(1, 100);       
		
		// This line test the RandomNumberGuesser class.
		RandomNumberGuesser gameOne = new RandomNumberGuesser(1, 100);	
		
		System.out.printf("Think of a number between %d and %d\n", gameOne.getLower(), gameOne.getUpper());
		Scanner keyboard = new Scanner(System.in);
		
		do
		{
			System.out.printf("Is the number %d? (h/l/c): ", gameOne.getCurrentGuess());
			input = keyboard.nextLine();

			if (input.charAt(0) == 'h')
				gameOne.higher();
			else if (input.charAt(0) == 'l')
				gameOne.lower();
			else
			{
				System.out.printf("You picked %d? Great pick.\n", gameOne.getCurrentGuess());

				System.out.print("Do you want to play again? (y/n): ");
				playAgain = keyboard.nextLine();

				if (playAgain.charAt(0) == 'y')
				{
					gameOne.reset();
					input = "we continue the while loop";
				}
				else
					System.out.println("Good bye.");
			}
		}	while (input.charAt(0) != 'c');
	} 
}









//NumberGuesser gameOne = new NumberGuesser(1, 100);