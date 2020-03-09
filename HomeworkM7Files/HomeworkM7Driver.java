import java.util.*;
import java.lang.Character;

public class HomeworkM7Driver {

	public static void main(String[] args) {
		
		System.out.println("\n******TESTING ARRAY REVERSER");
		int[] array1 = {1, 2, 3, 4, 5};
		System.out.println("Before reverse: " + Arrays.toString(array1));
		System.out.println("After reverse should be");
		printReverse(array1);
		reverseArray(array1);
		System.out.println(Arrays.toString(array1));
		System.out.println("After reversing back should be");	
		printReverse(array1);
		reverseArray(array1);
		System.out.println(Arrays.toString(array1));
		
		int[] array2 = {1, 2, 3, 4, 5, 6};
		System.out.println("\nBefore reverse: " + Arrays.toString(array2));
		System.out.println("After reverse should be");
		printReverse(array2);
		reverseArray(array2);
		System.out.println(Arrays.toString(array2));
		System.out.println("After reversing back should be");	
		printReverse(array2);
		reverseArray(array2);
		System.out.println(Arrays.toString(array2));
		
		int[] array3 = {1, 2};
		System.out.println("\nBefore reverse: " + Arrays.toString(array3));
		System.out.println("After reverse should be");
		printReverse(array3);
		reverseArray(array3);
		System.out.println(Arrays.toString(array3));
		int[] array4 = {1};
		System.out.println("\nBefore reverse: " + Arrays.toString(array4));
		System.out.println("After reverse should be");
		printReverse(array4);
		reverseArray(array4);
		System.out.println(Arrays.toString(array4));
		int[] array5 = {};
		System.out.println("\nBefore reverse: " + Arrays.toString(array5));
		System.out.println("After reverse should be");
		printReverse(array5);
		reverseArray(array5);
		System.out.println(Arrays.toString(array5));
			
		System.out.println("******TESTING Q WITHOUT U");
		System.out.println("\nAll of these should be false. They do NOT contain a \"q\" that is not immediately followed by a \"u\"");
		System.out.println("hello: \t\tfalse: " + qNotFollowedByU("hello") + "\t no q; odd length"); 
		System.out.println("cats: \t\tfalse: " + qNotFollowedByU("cats")+ "\t no q; even length"); 
		System.out.println("a: \t\tfalse: " + qNotFollowedByU("a")+ "\t no q; single letter"); 
		System.out.println("\"\": \t\tfalse: " + qNotFollowedByU("")+ "\t no q; empty string"); 
		System.out.println("quite: \t\tfalse: " + qNotFollowedByU("quite")+ "\t q followed by u at the beginning of the word"); 
		System.out.println("equal: \t\tfalse: " + qNotFollowedByU("equal")+ "\t q followed by u in the middle of a word; odd length"); 
	      System.out.println("aqua: \t\tfalse: " + qNotFollowedByU("aqua")+ "\t q followed by u in the middle of a word; even length");	
		System.out.println("nonsensewordqu: false: " + qNotFollowedByU("nonsensewordqu")+ "\t q followed by u at the end of the word"); 
		System.out.println("QUOTE: \t\tfalse: " + qNotFollowedByU("QUOTE")+ "\t q followed by u in caps"); 
		System.out.println("qu: \t\tfalse: " + qNotFollowedByU("qu")+ "\t q followed by u and nothing else"); 
	
		System.out.println("\nAll of these should be true. They DO contain a \"q\" that is not immediately followed by a \"u\"");	
		System.out.println("qat: \t\ttrue: " + qNotFollowedByU("qat")+ "\t q without u at the beginning of the word"); 
		System.out.println("cinq: \t\ttrue: " + qNotFollowedByU("cinq")+ "\t q without u at the end of the word; even length");  
		System.out.println("drinq: \t\ttrue: " + qNotFollowedByU("drinq")+ "\t q without u at the end of the word; odd length"); 
		System.out.println("nonsenseqword: \ttrue: " + qNotFollowedByU("nonsenseqword")+ "\t q without u in the middle of the word"); 
		System.out.println("aquaq: \t\ttrue: " + qNotFollowedByU("aquaq")+ "\t q without u in a word that also has a \"qu\" before it");  
		System.out.println("qaqu: \t\ttrue: " + qNotFollowedByU("qaqu")+ "\t q without u in a word that also has a \"qu\" after it"); 
		System.out.println("qiteu: \t\ttrue: " + qNotFollowedByU("qiteu")+ "\t q without u right after, but with a u later on"); 
		System.out.println("q: \t\ttrue: " + qNotFollowedByU("q")+ "\t q all on its own- single letter");  
		System.out.println("qq: \t\ttrue: " + qNotFollowedByU("qq")+ "\t q all on its own- double letter");  
		System.out.println("uq: \t\ttrue: " + qNotFollowedByU("uq")+ "\t q with a u before it");  
		System.out.println("Qtip: \t\ttrue: " + qNotFollowedByU("Qtip")+ "\t q without a u in caps"); 

		System.out.println("\n******TESTING GET FREQUENCY OF");	
		LinkedBag<Integer> numbersLinkedBag = new LinkedBag<Integer>();
		System.out.println("The bag contains[] \n\t\t"	+ Arrays.toString(numbersLinkedBag.toArray()));
		System.out.println("Should be 0: " + numbersLinkedBag.getFrequencyOf(1));
		numbersLinkedBag.add(1);
		System.out.println("The bag contains[1] \n\t\t"	+ Arrays.toString(numbersLinkedBag.toArray()));
		System.out.println("Should be 1: " + numbersLinkedBag.getFrequencyOf(1));
		System.out.println("The bag contains[1] \n\t\t"	+ Arrays.toString(numbersLinkedBag.toArray()));
		System.out.println("Should be 0: " + numbersLinkedBag.getFrequencyOf(2));
		numbersLinkedBag.add(2);
		numbersLinkedBag.add(1);
		numbersLinkedBag.add(4);
		numbersLinkedBag.add(3);
		numbersLinkedBag.add(1);
		System.out.println("The bag contains[1, 3, 4, 1, 2, 1] \n\t\t"	+ Arrays.toString(numbersLinkedBag.toArray()));
		System.out.println("Should be 3: " + numbersLinkedBag.getFrequencyOf(1));
		System.out.println("Should be 1: " + numbersLinkedBag.getFrequencyOf(4));
		System.out.println("Should be 0: " + numbersLinkedBag.getFrequencyOf(5));		
		System.out.println("The bag still contains  [1, 3, 4, 1, 2, 1] \n\t\t\t"	+ Arrays.toString(numbersLinkedBag.toArray()));


		System.out.println("\n******TESTING EXTRA CREDIT COUNT POSITIVES");	
		BagInterface<Integer> numbersBag = new LinkedBag<Integer>(); 
		numbersBag.add(2);
		numbersBag.add(-1);
		numbersBag.add(3);
		numbersBag.add(5);
		numbersBag.add(-2);
		numbersBag.add(-4);
		numbersBag.add(1);
		System.out.println("The bag contains[1, -4, -2, 5, 3, -1, 2] \n\t\t"	+ Arrays.toString(numbersBag.toArray()));
		System.out.println("There are 4 positives: " + countPositives(numbersBag));
		System.out.println("The bag still contains  [1, -4, -2, 5, 3, -1, 2] \n\t\t\t"	+ Arrays.toString(numbersBag.toArray()));
		numbersBag.clear();
		numbersBag.add(-2);
		numbersBag.add(-4);
		numbersBag.add(-3);
		System.out.println("The bag contains[-3, -4, -2] \n\t\t"	+ Arrays.toString(numbersBag.toArray()));
		System.out.println("There are 0 positives: " + countPositives(numbersBag));
		System.out.println("The bag still contains  [-3, -4, -2] \n\t\t\t"	+ Arrays.toString(numbersBag.toArray()));
		numbersBag.clear();
		numbersBag.add(2);
		numbersBag.add(4);
		numbersBag.add(3);
		System.out.println("The bag contains[3, 4, 2] \n\t\t"	+ Arrays.toString(numbersBag.toArray()));
		System.out.println("There are 3 positives: " + countPositives(numbersBag));
		System.out.println("The bag still contains  [3, 4, 2] \n\t\t\t"	+ Arrays.toString(numbersBag.toArray()));
		numbersBag.clear();
		System.out.println("The bag contains[] \n\t\t"	+ Arrays.toString(numbersBag.toArray()));
		System.out.println("There are 0 positives: " + countPositives(numbersBag));
		System.out.println("The bag still contains  [] \n\t\t\t"	+ Arrays.toString(numbersBag.toArray()));
		numbersBag.add(3);
		System.out.println("The bag contains[3] \n\t\t"	+ Arrays.toString(numbersBag.toArray()));
		System.out.println("There are 1 positives: " + countPositives(numbersBag));
		System.out.println("The bag still contains  [3] \n\t\t\t"	+ Arrays.toString(numbersBag.toArray()));
		numbersBag.clear();
		numbersBag.add(-3);
		System.out.println("The bag contains[-3] \n\t\t"	+ Arrays.toString(numbersBag.toArray()));
		System.out.println("There are 0 positives: " + countPositives(numbersBag));
		System.out.println("The bag still contains  [-3] \n\t\t\t"	+ Arrays.toString(numbersBag.toArray()));
		
//		System.out.println(methodA(4));
//		System.out.println(methodA(-3));
//		System.out.println(methodB("hello there",'h'));
//		infiniteRecursion(0);
//		int[] array = new int[]{0, 0, 0};
////		array[0] = 0;
////		array[1] = 0;
////		array[2] = 0;
//		System.out.println(countZeros(array));
		

	}

	public static boolean qNotFollowedByU(String word) {
		return qNotFollowedByUHelper(word, 0);
	}
	
	private static boolean qNotFollowedByUHelper(String word, int index) {
		if (index >= word.length())
			return false;
		else {
			if (Character.toLowerCase(word.charAt(index)) == 'q') // matching 'q'
				return (index == word.length() - 1) || Character.toLowerCase(word.charAt(index + 1)) != 'u' || qNotFollowedByUHelper(word, index + 1); 
				// true if 'q' is last character, or the next character is not 'u', or keep looking
			else 
				return qNotFollowedByUHelper(word, index + 1); 
		}	
	}


	public static void reverseArray(int[] array) {
		// recursively reverse first and last element
		reverseArrayHelper(array, 0, array.length - 1);
	}
	
	private static void reverseArrayHelper(int[] array, int first, int last) {
		if (first < last) { // explicitly recursive case 
			int temp = array[first];
			array[first] = array[last];
			array[last] = temp;
			reverseArrayHelper(array, first+1, last-1);
		}
	}

	// a printing method for testing purposes
	public static void printReverse(int[] array) {
		System.out.print("[");
		for(int i=array.length-1; i>0; i--) {
			System.out.print(array[i] + ", ");
		}
		if(array.length>0) {
			System.out.print(array[0]);
		}
		System.out.println("]");
	}
	
	public static int methodA(int n) {
		   if(n==0) {
		      return 0;
		   } else if(n>0) {
		      return 1 + methodA(n-1);
		   } else {
		      return 1 + methodA(n+1);
		   }
	}
	
	public static int methodB(String s, char c) {
		   if(s.length()==0) {
		      return 0;
		   } else {
		      return (s.charAt(0)==c ? 1 : 0) + methodB(s.substring(1), c);
		   }
	}
	
	public static void infiniteRecursion(int n) {
		   if (n > 0) { 
		      System.out.println("here"); 
		      infiniteRecursion(n-1);
		   } else if(n < 0){ 
		      System.out.println("here");
		      infiniteRecursion(n+1);
		   } else {   
		      System.out.println("here"); 
		   }
		}

	public static int countZeros(int[] array) {
		 return countZerosHelper(array, 0, array.length, 0);
		}

		private static  int countZerosHelper(int[] array, int start, int stop, int count) {
		 if(start < stop) {
		 if(array[start] == 0) {
		 count++;
		 }
		 countZerosHelper(array, start+1, stop, count);
		 }
		 return count;
		}

	public static int countPositives(BagInterface<Integer> bag) {
		BagInterface<Integer> tempBag = new LinkedBag<Integer>();
		int count = countPositivesHelper(bag, tempBag);
		
		while (!tempBag.isEmpty())
			bag.add(tempBag.remove());
		
		return count;
	}

	private static int countPositivesHelper(BagInterface<Integer> bag, BagInterface<Integer> tempBag) {
		if (bag.isEmpty())
			return 0;
		else {
			int number = bag.remove();
			tempBag.add(number);
			return (number > 0 ? 1 : 0) + countPositivesHelper(bag, tempBag); 
		}
	}
}
