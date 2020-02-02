import java.util.ArrayList;

public class TrioTester {

	public static void main(String[] args) {

		Trio<Integer> numberTrio = new Trio<Integer>(3, 4, 5);
		/* 
		 * un-comment the line of code below and it should cause a compiler error because trio1 should only accept Strings
		 */
		//numberTrio.setItem2("apple");
		
		Trio<String> wordTrio = new Trio<String>("hello");
		wordTrio.setItem2("goodbye");
		wordTrio.setItem3("farewell");
		/* 
		 * un-comment the line of code below and it should cause a compiler error because wordTrio should only accept Strings
		 */
		//wordTrio.setItem2(3);


		
		System.out.println("***TESTING TOSTRING METHOD***");
		System.out.println("Should print a text representation of the Trio that contains(3, 4, 5):");
		System.out.println(numberTrio);
		System.out.println("Should print a text representation of the Trio that contains (hello, goodbye, farewell):");
		System.out.println(wordTrio);
		
		System.out.println("\n***TESTING GETTERS AND SETTERS METHOD***");
		System.out.println("Item 1 should be 3: " + numberTrio.getItem1());
		System.out.println("Item 2 should be 4: " + numberTrio.getItem2());
		System.out.println("Item 3 should be 5: " + numberTrio.getItem3());
		numberTrio.setItem1(6);
		numberTrio.setItem2(7);
		numberTrio.setItem3(8);
		System.out.println("Item 1 should be 6: " + numberTrio.getItem1());
		System.out.println("Item 2 should be 7: " + numberTrio.getItem2());
		System.out.println("Item 3 should be 8: " + numberTrio.getItem3());	
			
		System.out.println("\n***TESTING HASDUPLICATES METHOD***");		
		numberTrio = new Trio<Integer>(3, 4, 5);
		System.out.println("Trio (3, 4, 5) contains duplicates? false: " + numberTrio.hasDuplicates());
		numberTrio = new Trio<Integer>(3, 3, 5);
		System.out.println("Trio (3, 3, 5) contains duplicates?  true: " + numberTrio.hasDuplicates());
		numberTrio = new Trio<Integer>(3, 4, 4);
		System.out.println("Trio (3, 4, 4) contains duplicates?  true: " + numberTrio.hasDuplicates());
		numberTrio = new Trio<Integer>(3, 4, 3);
		System.out.println("Trio (3, 4, 3) contains duplicates?  true: " + numberTrio.hasDuplicates());
		numberTrio = new Trio<Integer>(4, 4, 4);
		System.out.println("Trio (4, 4, 4) contains duplicates?  true: " + numberTrio.hasDuplicates());
		
		System.out.println("\n***TESTING COUNT METHOD***");
		numberTrio = new Trio<Integer>(3, 4, 5);
		System.out.println("Trio (3, 4, 5) contains how many 1s? 0: " + numberTrio.count(1));
		numberTrio = new Trio<Integer>(1, 4, 5);
		System.out.println("Trio (1, 4, 5) contains how many 1s? 1: " + numberTrio.count(1));
		numberTrio = new Trio<Integer>(3, 1, 5);
		System.out.println("Trio (3, 1, 5) contains how many 1s? 1: " + numberTrio.count(1));
		numberTrio = new Trio<Integer>(3, 4, 1);
		System.out.println("Trio (3, 4, 1) contains how many 1s? 1: " + numberTrio.count(1));
		numberTrio = new Trio<Integer>(1, 1, 2);
		System.out.println("Trio (1, 1, 2) contains how many 1s? 2: " + numberTrio.count(1));
		numberTrio = new Trio<Integer>(1, 2, 1);
		System.out.println("Trio (1, 2, 1) contains how many 1s? 2: " + numberTrio.count(1));
		numberTrio = new Trio<Integer>(2, 1, 1);
		System.out.println("Trio (2, 1, 1) contains how many 1s? 2: " + numberTrio.count(1));
		numberTrio = new Trio<Integer>(1, 1, 1);
		System.out.println("Trio (1, 1, 1) contains how many 1s? 3: " + numberTrio.count(1));
		
		System.out.println("\n***TESTING COUNT METHOD WITH STRINGS***");			
		String testString1 = new String("hello");
		String testString2 = new String("HELLO");
		System.out.println("Trio (hello, goodbye, farewell) contains how many hello? 1: " + wordTrio.count(testString1));
		System.out.println("Trio (hello, goodbye, farewell) contains how many HELLO? 0: " + wordTrio.count(testString2));

		System.out.println("\n***TESTING RESET METHOD***");
		numberTrio.reset(43);
		System.out.println("Should print a text representation of the Trio that contains 43, 43, 43:");
		System.out.println(numberTrio);
		System.out.println("Trio (43, 43, 43) contains how many 43s?    3: " + numberTrio.count(43));
		System.out.println("Trio (43, 43, 43) contains duplicates?   true: " + numberTrio.hasDuplicates());
			

		System.out.println("\n***TESTING EQUALS METHOD***");	
		// no duplicates, same items in same order
		Trio<String> wordTrio2 = new Trio<String>(new String("apple"), new String("ball"), new String("cat"));
		Trio<String> wordTrio3 = new Trio<String>(new String("apple"), new String("ball"), new String("cat"));
		System.out.println("Trios (apple, ball, cat) and (apple, ball, cat) the same? true : " + wordTrio2.equals(wordTrio3));

		// no duplicates, same items in different order
		Trio<Character> charTrio1 = new Trio<Character>('a', 'b', 'c');
		Trio<Character> charTrio2 = new Trio<Character>('b', 'c', 'a');
		System.out.println("Trios (a, b, c) and (b, c, a) the same? true : " + charTrio1.equals(charTrio2));
		
		// no duplicates, same items in different order
		Trio<Integer> numberTrio2 = new Trio<Integer>(5, 6, 8);
		Trio<Integer> numberTrio3 = new Trio<Integer>(8, 5, 6);
		System.out.println("Trios (5, 6, 8) and (8, 5, 6) the same? true : " + numberTrio2.equals(numberTrio3));

		// same items, but different items are duplicated
		numberTrio2 = new Trio<Integer>(1, 2, 1);
		numberTrio3 = new Trio<Integer>(1, 1, 2);
		System.out.println("Trios (1, 2, 1) and (1, 1, 2) the same? true : " + numberTrio2.equals(numberTrio3));

		// same items, but different items are duplicated
		numberTrio2 = new Trio<Integer>(2, 1, 1);
		numberTrio3 = new Trio<Integer>(1, 1, 2);
		System.out.println("Trios (2, 1, 1) and (1, 1, 2) the same? true : " + numberTrio2.equals(numberTrio3));
	
		// different items
		numberTrio2 = new Trio<Integer>(5, 5, 8);
		numberTrio3 = new Trio<Integer>(8, 5, 6);
		System.out.println("\nTrios (5, 5, 8) and (8, 5, 6) the same? false: " + numberTrio2.equals(numberTrio3));
		
		// same items, but different items are duplicated
		numberTrio2 = new Trio<Integer>(1, 1, 2);
		numberTrio3 = new Trio<Integer>(1, 2, 2);
		System.out.println("Trios (1, 1, 2) and (1, 2, 2) the same? false: " + numberTrio2.equals(numberTrio3));

		// same items, but different items are duplicated
		numberTrio2 = new Trio<Integer>(2, 1, 2);
		numberTrio3 = new Trio<Integer>(1, 2, 1);
		System.out.println("Trios (2, 1, 2) and (1, 2, 1) the same? false: " + numberTrio2.equals(numberTrio3));

		
		// different items (and types!)
		System.out.println("Trios (5, 6, 8) and (hello, goodbye, farewell) the same? false: " + numberTrio2.equals(wordTrio));

					
		
	}

}
