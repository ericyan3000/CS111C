import java.util.*;

public class VoidRecursionExamples {

	public static void main(String[] args) {
		printCharacters("Hello!");
		printCharactersEfficient("Hello!");
		
		int[] numbers = {1, 2, 3, 4, 5, 6};
		System.out.println(Arrays.toString(numbers));
		doubleArray(numbers);
		System.out.println(Arrays.toString(numbers));
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		doubleList(list);
		System.out.println(list);
		
		System.out.println("Climb 0 step: " + countSteps(0));
		System.out.println("Climb 1 step: " + countSteps(1));
		System.out.println("Climb 2 steps: " + countSteps(2));
		System.out.println("Climb 3 steps: " + countSteps(3));
		System.out.println("Climb 4 steps: " + countSteps(4));
		System.out.println("Climb 5 steps: " + countSteps(5));
		System.out.println("Climb 6 steps: " + countSteps(6));
		System.out.println("Climb 100 steps: " + countSteps(40));
		
		

	}
	
	public static void printCharacters(String word) {
		/*
		if(word.length()==1) { // base case
			System.out.println(word.charAt(0)); // word.substring(0,1); // prints the first character- solve a small part now	
		} else { // recursive case 
			System.out.println(word.charAt(0)); // word.substring(0,1); // prints the first character- solve a small part now	
			printCharacters(word.substring(1)); // recursively repeat the task with the rest of the word minus first character
		}
		*/			
		System.out.println(word.charAt(0)); // word.substring(0,1); // prints the first character- solve a small part now
		if(word.length()>1) { // recursive case
			printCharacters(word.substring(1)); // recursively repeat the task with the rest of the word minus first character
		}
		// implicit base case- not explicitly listed
		System.out.println(word.charAt(0)); // word.substring(0,1); // prints the first character- solve a small part now
	}
	
	public static void printCharactersEfficient(String word) {
		printCharactersEfficientHelper(word, 0);
	}
	private static void printCharactersEfficientHelper(String word, int index) {
		System.out.println(word.charAt(index));
		if(index < word.length()-1 ) { // recursive call
			printCharactersEfficientHelper(word, index+1);
		}
	}
	
	public static void doubleArray(int[] array) {
		doubleArrayHelper(array, 0);
	}
	private static void doubleArrayHelper(int[] array, int index) {
		if(index<array.length) { // recursive call
			array[index] = array[index] * 2; // small part we're solving now
			doubleArrayHelper(array, index+1); // recursive call
		}
		// implicit base case
	}
	
	public static void doubleList(List<Integer> list) {
		doubleListHelper(list, 0);
	}
	private static void doubleListHelper(List<Integer> list, int index) {
		if(index<list.size()) { // recursive case
			int value = list.get(index);
			list.set(index, value*2);
			doubleListHelper(list, index+1);
		}
		// implicit base case
	}
	
	
	// Return the number of ways to climb a stair with steps
	public static int countSteps(int s) {
		// smaller problem: 3 different ways to take the next hoop,  1, 2 or 3. It depends on how many steps remaining
		// it would be  countSteps(s-1) + countStep(s-2) + countStep(s-3) to be the total number of ways
		if (s > 3) //recursive case
			return countSteps(s-3) + countSteps(s-2) + countSteps(s-1);
		else if (s == 3) // base case, remaining 3 steps
			return 1 + countSteps(s-2) + countSteps(s-1);
		else if (s == 2) // remaining 2 steps
			return 1 + countSteps(s-1);
		else if (s == 1)  // remaining 1 step
			return 1;
		else // edge case, no step
			return 0;
			
	}
	
	
	
	
	
	
	
	
	
	

}
