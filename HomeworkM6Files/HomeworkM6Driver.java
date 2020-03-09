import java.util.*;

public class HomeworkM6Driver {

	// I recommend changing these to smaller numbers to start with!
	// Then once you think you have a good solution, you can increase them for more robust testing.
	public static final int LIST_SIZE = 100; 
	public static final int SINGLE_DUPLICATE_NUMBERS = 10; // minimum number of numbers on the list that will appear twice (have a "single duplicate"
	public static final int DOUBLE_DUPLICATE_NUMBERS = 5;  // minimum number of numbers on the list that will appear three times (have a "duplicate duplicate")
	
	
	public static void main(String[] args) {
		
		// set up an Integer list that is guaranteed to have some single and double duplicates
		List<Integer> numbers = new ArrayList<>();
		Random generator = new Random();
		int max = 5 * LIST_SIZE;
		int min = -1 * max;
		int randomRange = max - min + 1;
		
		// add the first round of numbers
		int originalNumbersToAdd = LIST_SIZE- SINGLE_DUPLICATE_NUMBERS - DOUBLE_DUPLICATE_NUMBERS;
		numbers.add(min); // adding the min and max number to help test for array out of bounds errors
		numbers.add(min);
		numbers.add(max);
		numbers.add(max);
		numbers.add(0);  // adding 0 as a special test case
		numbers.add(0); 
		originalNumbersToAdd-=6;
		for(int i=0; i<originalNumbersToAdd; i++) {
			numbers.add(generator.nextInt(randomRange) + min);			
		}
		
		// add duplicate numbers
		Collections.shuffle(numbers);
		for(int i=0; i<SINGLE_DUPLICATE_NUMBERS; i++) {
			numbers.add(numbers.get(i));
		}
		for(int i=0; i<DOUBLE_DUPLICATE_NUMBERS; i++) {
			numbers.add(numbers.get(i));
		}
		
		// print the list sorted (might help with testing)
		Collections.sort(numbers);
		System.out.println("The original list:");
		System.out.println(numbers);
		Collections.shuffle(numbers);
		
		// the results should be the same for both methods
		System.out.println("\nThe duplicate lists from both methods- these should match!");
		List<Integer> duplicateList = findDuplicatesBad(numbers);
		Collections.sort(duplicateList);
		System.out.println(duplicateList);
		
		duplicateList = findDuplicatesLinear(numbers);
		Collections.sort(duplicateList);
		System.out.println(duplicateList);
	}
	
	public static List<Integer> findDuplicatesBad(List<Integer> numbers) {  // // O(n*n*n)) = O(n**3)   lines a, b, c
		List<Integer> duplicateList = new ArrayList<Integer>();
		for(int i=0; i<numbers.size(); i++) {  				// O(n) from loop i < numbers.size(); line a 
			int numberEvaluating = numbers.get(i);          // 1 step
			boolean duplicateFound = false;					// 1 step
			
			for(int j=i+1; j<numbers.size() && !duplicateFound; j++) {   // O(n) from for loop j < numbers.size(); line b
				int numberChecking = numbers.get(j);  // 1 step
				
				if(numberEvaluating==numberChecking && !duplicateList.contains(numberEvaluating)) { // O(n)
					duplicateFound = true; 
					
					for(int k=j; k<numbers.size(); k++) { // O(n) same loop from line b
						if(numberChecking==Integer.valueOf(numbers.get(k))) {
							duplicateList.add(numberChecking); // O(n) from add(); line c 
						}
					}
				}
			}
		}
		return duplicateList;
	}
	
	
	public static List<Integer> findDuplicatesLinear(List<Integer> numbers) {
		// define an array boolean[] where it maps the value of input list as position in boolean[]
		// eg. value 0 -> boolean[0], 1 -> boolean[1], -3 -> boolean[n+3]
		// initial values are all false indicating not duplicated
		// O(2n+1) to create this array
		
		int duplicatedTableSize = 10 * numbers.size()  + 1;
		boolean[] duplicatedTable = new boolean[duplicatedTableSize];
		for (int i = 0; i < duplicatedTableSize; i++ ) {
			duplicatedTable[i] = false;
		}
		
		// define a list to store duplicated values
		List<Integer> duplicatedList = new ArrayList<Integer>();
		
		// loop through the list  O(n)
		for (int i = 0; i < numbers.size(); i++) {
			// add to unique list if not in unique at position m 
			// O(1)
				int numberChecking = numbers.get(i); // O(1)
				int duplicatedTableIndex = numberChecking >= 0 ? numberChecking : ( 5 * numbers.size() - numberChecking);
				// check if unique by looking at boolean[] at position m: boolean[m] or boolean[n+m] if m is negative   
				// O(1)
				if (!duplicatedTable[duplicatedTableIndex]) {
				
				// if unique, change boolean[m] to true    
				// O(1)
					duplicatedTable[duplicatedTableIndex] = true;
				}
				
				// if not unique, add to duplicated list
				// O(1); arrayList.add()
				else {
					duplicatedList.add(numberChecking);
				}
		}
		
		return duplicatedList;
	}
}
