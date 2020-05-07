import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SearchTester {

	private final static int MAX_NUMBER_FOR_RANDOM = 10; 
	private final static int ARRAY_SIZE = 0;
	
	public static void main(String[] args) {

		Random generator = new Random();
		Integer[] numbers = new Integer[ARRAY_SIZE];
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = generator.nextInt(MAX_NUMBER_FOR_RANDOM);
			System.out.print(numbers[i] + " ");
		}
		System.out.println("");
		
		
		
//		System.out.println("RANDOM TARGET IN THE ARRAY");
		int target = generator.nextInt(MAX_NUMBER_FOR_RANDOM);

//		System.out.println("RANDOM TARGET NOT IN THE ARRAY");
/*		target = generator.nextInt(100);
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] == target) {
				numbers[i]--;
			}
		}
*/
//		System.out.println("TARGET IN THE ARRAY- LARGEST VALUE");
//		target = 99; // assuming this value is there!

//		System.out.println(" TARGET IN THE ARRAY- SMALLEST VALUE");
//		target = 0; // assuming this value is there!

		
//		System.out.println("TARGET NOT IN THE ARRAY- LARGER VALUE");	
//		target = 999;
		
//		System.out.println("TARGET NOT IN THE ARRAY- SMALLER VALUE");
//		target = -999;

		//System.out.println(numbers);
		System.out.println("Target is " + target);
		ArrayList<Integer> list = Searches.findIndicesRecursiveSorted(numbers, target);
		System.out.println(list.toString());
		
		
/*		
		System.out.println("SEARCHES ON UNSORTED DATA");
		int location = Searches.linearSearchIterative(numbers,  target);
		System.out.println("Location is " + location);
		location = Searches.linearSearchRecursive(numbers, target);
		System.out.println("Location is " + location);
*/		
//		Arrays.sort(numbers);
//		System.out.println("SEARCHES ON SORTED DATA");

		//System.out.println(Arrays.toString(numbers));
//		location = Searches.linearSearchIterative(numbers,  target);
//		System.out.println("Location is " + location);
		
		//int location = Searches.linearSearchIterativeImprovedForSorted(numbers, target);
		//System.out.println("Location is " + location);
		//location = Searches.binarySearchIterative(numbers, target);
		//System.out.println("Location is " + location);
//		location = Searches.binarySearchRecursive(numbers, target);
//		System.out.println("Location is " + location);
//		
		
	}
	

}
