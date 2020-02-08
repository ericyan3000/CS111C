import java.util.*;

public class HomeworkM3Driver {

	public static void main(String[] args) {
		System.out.println("******TESTING QUESTION: COMPARABLE");
		Person p1 = new Person("Anne", "Teak", 123);
		Person p2 = new Person("Trina", "Woods", 234);
		Person p3 = new Person("Trina", "Forest", 345);
		Person p4 = new Person("Holly", "Wood", 456);
		Person p5 = new Person("Holly", "McRel", 567);
		Person p6 = new Person("anne", "teak", 678);
		Person p7 = new Person("Holly", "Wood", 789);
		List<Person> people =  new ArrayList<Person>();
		people.add(p1); people.add(p2); people.add(p7); people.add(p3); people.add(p4); people.add(p5); people.add(p6);  
		System.out.println("Before sorting:");
		System.out.println(people);
		Collections.sort(people);
		System.out.println("Prints should match:\n[Trina Forest (345), Holly McRel (567), Anne Teak (123), anne teak (678), Holly Wood (456), Holly Wood (789), Trina Woods (234)]");
		System.out.println(people);
		
		System.out.println("\n******TESTING QUESTION: TESTING IF BAG IS A SET");
		BagInterface<String> wordBag = new ArrayBag<>();
		System.out.println("Prints should match (contents should be the same- order might be different):");
		System.out.println(Arrays.toString(wordBag.toArray()));
		boolean setResult = isSet(wordBag);
		System.out.println(Arrays.toString(wordBag.toArray()));
		System.out.println("Bag is set? \t true: " + setResult);
		
		wordBag.add("hi");
		System.out.println("\nPrints should match (contents should be the same- order might be different):");
		System.out.println(Arrays.toString(wordBag.toArray()));
		setResult = isSet(wordBag);
		System.out.println(Arrays.toString(wordBag.toArray()));
		System.out.println("Bag is set? \t true: " + setResult);

		wordBag.add("HI");
		wordBag.add("hello");
		System.out.println("\nPrints should match (contents should be the same- order might be different):");
		System.out.println(Arrays.toString(wordBag.toArray()));
		setResult = isSet(wordBag);
		System.out.println(Arrays.toString(wordBag.toArray()));
		System.out.println("Bag is set? \t true: " + setResult);

		wordBag.add("hi");
		System.out.println("\nPrints should match (contents should be the same- order might be different):");
		System.out.println(Arrays.toString(wordBag.toArray()));
		setResult = isSet(wordBag);
		System.out.println(Arrays.toString(wordBag.toArray()));
		System.out.println("Bag is set? \tfalse: " + setResult);
		
		wordBag.clear();
		wordBag.add("a");
		wordBag.add("c");
		wordBag.add("b");
		wordBag.add("d");
		wordBag.add("a");
		System.out.println("\nPrints should match (contents should be the same- order might be different):");
		System.out.println(Arrays.toString(wordBag.toArray()));
		setResult = isSet(wordBag);
		System.out.println(Arrays.toString(wordBag.toArray()));
		System.out.println("Bag is set? \tfalse: " + setResult);
		
		
		
		System.out.println("\n******TESTING QUESTION: CREATING LIST OF WORDS THAT CONTAIN CHAR");
		ListInterface<String> wordList = new AList<>();
		ListInterface<String> shortWordList = createWordListContainChar(wordList,'a');
		System.out.println("The contents of the returned list should be: \n[]");
		System.out.println(Arrays.toString(shortWordList.toArray()));
		
		wordList.add("apple");
		wordList.add("anna");
		wordList.add("bob"); 
		wordList.add("ANIMAL");
		wordList.add("canal");
		wordList.add("frog");
		wordList.add("cat");
		shortWordList = createWordListContainChar(wordList,'a');
		System.out.println("\nThe contents of the returned list should be (in THIS ORDER): \n[apple, anna, canal, cat]");
		System.out.println(Arrays.toString(shortWordList.toArray()));
		System.out.println("The original list should still contain (in THIS ORDER): \n[apple, anna, bob, ANIMAL, canal, frog, cat]");
		System.out.println(Arrays.toString(wordList.toArray()));

	

		System.out.println("\n******TESTING QUESTION: FINDING LAST POSITION");
		List<String> itemList = new ArrayList<>();
		System.out.println("The index should indicate the target is not in the list: " + lastPosition(itemList, "frank"));
		itemList.add("adam");
		itemList.add("betty");
		itemList.add("sue");
		System.out.println("The index should indicate the target is not in the list: " + lastPosition(itemList, "frank"));
		itemList.add("frank");
		itemList.add("sam");
		System.out.println("The index should be: \t3: " + lastPosition(itemList, "frank"));
		itemList.add("frank");
		itemList.add("sue");
		itemList.add("terry");
		itemList.add("adam");
		itemList.add("frank");
		System.out.println("The index should be: \t9: " + lastPosition(itemList, "frank"));
		itemList.add("adam");
		System.out.println("The index should be: \t9: " + lastPosition(itemList, new String("frank")));


		
		System.out.println("\n******TESTING QUESTION: LIST COMPARISON");
		ListInterface<Integer> numListA = new AList<Integer>();
		List<Integer> numListB = new ArrayList<Integer>();
		
		// two empty lists
		System.out.println("Equivalent lists? should be \ttrue :" + equivalentLists(numListA, numListB));		

		// A is empty, B is not
		numListB.add(1); numListB.add(3); numListB.add(1); numListB.add(5); numListB.add(7);
		System.out.println("Equivalent lists? should be \tfalse:" + equivalentLists(numListA, numListB));		
		
		// first elements only match
		numListA.add(1);
		System.out.println("Equivalent lists? should be \tfalse:" + equivalentLists(numListA, numListB));		

		// A has one fewer elements
		numListA.add(3); numListA.add(1); numListA.add(5);
		System.out.println("Equivalent lists? should be \tfalse:" + equivalentLists(numListA, numListB));		

		// equivalent lists
		numListA.add(7);
		System.out.println("Equivalent lists? should be \ttrue :" + equivalentLists(numListA, numListB));		

		// A has one more element
		numListA.add(8);
		System.out.println("Equivalent lists? should be \tfalse:" + equivalentLists(numListA, numListB));		

		// B has one more element
		numListB.add(8); numListB.add(10);
		System.out.println("Equivalent lists? should be \tfalse:" + equivalentLists(numListA, numListB));		

		// A and B have same elements but in a different order
		numListA.clear(); numListA.add(1); numListA.add(2); numListA.add(3); numListA.add(4);
		numListB.clear(); numListB.add(1); numListB.add(3); numListB.add(2); numListB.add(4);
		System.out.println("Equivalent lists? should be \tfalse:" + equivalentLists(numListA, numListB));		

		// A and B have same last elements 
		numListA.clear(); numListA.add(2); numListA.add(3); numListA.add(5); numListA.add(4);
		numListB.clear(); numListB.add(1); numListB.add(6); numListB.add(8); numListB.add(5);
		System.out.println("Equivalent lists? should be \tfalse:" + equivalentLists(numListA, numListB));		
		

		System.out.println("\n******TESTING EXTRA CREDIT QUESTION: MOVE THE MINIMUM TO THE FRONT");
		List<Integer> numberList = new ArrayList<Integer>();
		
		// empty list
		prioritizeMinimumValue(numberList);
		System.out.println("The list should contain: \n[]\n" + numberList);
		
		// one-element list
		numberList.add(4);
		prioritizeMinimumValue(numberList);
		System.out.println("\nThe list should contain: \n[4]\n" + numberList);

		// minimum in the middle of the list
		numberList.add(3);
		numberList.add(2);
		numberList.add(5);
		numberList.add(7);
		prioritizeMinimumValue(numberList);
		System.out.println("\nThe list should contain: \n[2, 4, 3, 5, 7]\n" + numberList);

		// minimum at the end of the list
		numberList.add(1);
		prioritizeMinimumValue(numberList);
		System.out.println("\nThe list should contain: \n[1, 2, 4, 3, 5, 7]\n" + numberList);

		// minimum at the beginning of the list
		numberList.remove(0);
		numberList.add(1, 0);
		prioritizeMinimumValue(numberList);
		System.out.println("\nThe list should contain: \n[0, 2, 4, 3, 5, 7]\n" + numberList);

	}

	public static boolean isSet(BagInterface<String> wordBag) {
		
		
		// YOUR CODE HERE
		return false;
	}
	
	public static ListInterface<String> createWordListContainChar(ListInterface<String> wordList, char key) {
		// YOUR CODE HERE
		return null;
	}
	
	public static int lastPosition(List<String> wordList, String targetWord) {
		// YOUR CODE HERE
		return 0;
	}
	
	public static boolean equivalentLists(ListInterface<Integer> numberListInterface, List<Integer> numberList) {
		// YOUR CODE HERE
		return false;
	}
	
	public static void prioritizeMinimumValue(List<Integer> numberList) {
		// YOUR CODE HERE
	}
}
