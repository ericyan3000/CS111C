import java.util.Arrays;

public class HomeworkM5Driver {

	public static void main(String[] args) {

		System.out.println("\n******TESTING QUESTION: PRINT AT INTERVAL");
		Node<String> firstNode = new Node<String>("a", new Node<String>("b", new Node<String>("c", new Node<String>("d"))));
		// sets up the chain a -> b -> c -> d
		System.out.println("Prints should match: \na c");
		printAtInterval(firstNode, 2); 
		System.out.println();
		
		System.out.println("Prints should match: \na d");
		printAtInterval(firstNode, 3); 
		System.out.println();
	
		System.out.println("Prints should match: \na");
		printAtInterval(firstNode, 4); 
		System.out.println();
		
		firstNode = new Node<String>("c", new Node<String>("d", new Node<String>("e", new Node<String>("f", new Node<String>("g")))));
		// sets up the chain c -> d -> e -> f -> g
		System.out.println("Prints should match: \nc e g");
		printAtInterval(firstNode, 2);
		System.out.println();
		
		firstNode = new Node<String>("c", new Node<String>("d", new Node<String>("e", new Node<String>("f", new Node<String>("g")))));
		// sets up the chain c -> d -> e -> f -> g
		System.out.println("Prints should match: \nc f");
		printAtInterval(firstNode, 3);
		System.out.println();

		firstNode = new Node<String>("a", new Node<String>("b", new Node<String>("c", new Node<String>("d", new Node<String>("e", new Node<String>("f", new Node<String>("g", new Node<String>("h"))))))));
		// sets up the chain a -> b -> c -> d -> e -> f -> g -> h
		System.out.println("Prints should match: \na d g");
		printAtInterval(firstNode, 3); 
		System.out.println();
		
		firstNode = new Node<String>("q", new Node<String>("r", new Node<String>("s", new Node<String>("t"))));
		// sets up the chain q -> r -> s -> t
		System.out.println("Prints should match: \nq");
		printAtInterval(firstNode, 5); 
		System.out.println();
		
		System.out.println("Prints should match: \nq r s t");
		printAtInterval(firstNode, 1); 
		System.out.println();
	
		firstNode = null; // empty chain
		System.out.println("Should print nothing (and not crash)");
		printAtInterval(firstNode, 5);
		System.out.println();

		firstNode = new Node<String>("m"); // singleton chain
		System.out.println("Prints should match: \nm");
		printAtInterval(firstNode, 5);
		System.out.println();
	
			
		System.out.println("\n******TESTING QUESTION: LINKED BAG REMOVE ALL");
		LinkedBag<Integer> numberBag = new LinkedBag<Integer>();
		
		// testing on empty bag
		System.out.println("Before removing 1, the bag contains " + Arrays.toString(numberBag.toArray()));
		numberBag.removeAll(1);
		System.out.println("After, the bag contains\n[]  \n" + Arrays.toString(numberBag.toArray()) +  "\nSize is 0: " + numberBag.getCurrentSize() +"\n");
		
		// testing on singleton bag
		numberBag.add(1);
		System.out.println("Before removing 1, the bag contains " + Arrays.toString(numberBag.toArray()) );
		numberBag.removeAll(1);
		System.out.println("After, the bag contains\n[]  \n" + Arrays.toString(numberBag.toArray()) +  "\nSize is 0: " + numberBag.getCurrentSize()+"\n");		
		numberBag.add(1); 		numberBag.add(1); 		numberBag.add(1);
		
		// testing on bag with all matches
		System.out.println("Before removing 1, the bag contains " + Arrays.toString(numberBag.toArray()));
		numberBag.removeAll(1);
		System.out.println("After, the bag contains\n[]  \n" + Arrays.toString(numberBag.toArray()) +  "\nSize is 0: " + numberBag.getCurrentSize()+"\n");		

		// testing on bag with some matches
		numberBag.add(1); 		numberBag.add(1);  		numberBag.add(2);
		numberBag.add(4); 		numberBag.add(1); 		numberBag.add(5); 		numberBag.add(1);
		System.out.println("Before removing 1, the bag contains " + Arrays.toString(numberBag.toArray()) );
		numberBag.removeAll(1);
		// NOTE: this code is only here so that the results will be sorted so you can directly compare to what they should be
		// don't worry too much about this, it's not part of what we're looking at this week!
		//Comparable[] comparableResult = (Comparable[])numberBag.toArray();
		Integer[] result = Arrays.copyOf(((Comparable[])numberBag.toArray()),numberBag.getCurrentSize(), Integer[].class);
		Arrays.sort(result);
		System.out.println("After, the bag contains\n[2, 4, 5] \n" + Arrays.toString(result) +  "\nSize is 3: " + numberBag.getCurrentSize()+"\n");		

		// testing on bag with some matches
		numberBag.clear();
		numberBag.add(1); 		numberBag.add(1); 		numberBag.add(3); 		numberBag.add(1);
		numberBag.add(1); 		numberBag.add(4); 		numberBag.add(1); 		numberBag.add(5);
		numberBag.add(1); 		numberBag.add(1);
		System.out.println("Before removing 1, the bag contains " + Arrays.toString(numberBag.toArray()));
		numberBag.removeAll(1);
		result = Arrays.copyOf(((Comparable[])numberBag.toArray()),numberBag.getCurrentSize(), Integer[].class);
		Arrays.sort(result);
		System.out.println("After, the bag contains\n[3, 4, 5] \n" + Arrays.toString(result) +  "\nSize is 3: " + numberBag.getCurrentSize()+"\n");		

		// testing on bag with some matches
		System.out.println("Before removing 5, the bag contains " + Arrays.toString(numberBag.toArray()) );
		numberBag.removeAll(5);
		result = Arrays.copyOf(((Comparable[])numberBag.toArray()),numberBag.getCurrentSize(), Integer[].class);
		Arrays.sort(result);
		System.out.println("After, the bag contains\n[3, 4] \n" + Arrays.toString(result) +  "\nSize is 2: " + numberBag.getCurrentSize()+"\n");	
		
		// testing on bag with some matches
		numberBag.add(4);
		numberBag.add(5);
		System.out.println("Before removing 4, the bag contains " + Arrays.toString(numberBag.toArray()) );
		numberBag.removeAll(4);
		result = Arrays.copyOf(((Comparable[])numberBag.toArray()),numberBag.getCurrentSize(), Integer[].class);
		Arrays.sort(result);
		System.out.println("After, the bag contains\n[3, 5] \n" + Arrays.toString(result) +  "\nSize is 2: " + numberBag.getCurrentSize()+"\n");	

		// testing on bag with no matches
		System.out.println("Before removing 7, the bag contains " + Arrays.toString(numberBag.toArray()) );
		numberBag.removeAll(7);
		result = Arrays.copyOf(((Comparable[])numberBag.toArray()),numberBag.getCurrentSize(), Integer[].class);
		Arrays.sort(result);
		System.out.println("After, the bag contains\n[3, 5] \n" + Arrays.toString(result) +  "\nSize is 2: " + numberBag.getCurrentSize()+"\n");	


		System.out.println("\n******TESTING QUESTION: LLIST GET MAX");
		LList<Integer> numbersList = new LList<Integer>();

		// testing max in the middle
		numbersList.add(1); 	numbersList.add(2); 	numbersList.add(1);
		numbersList.add(4); 		numbersList.add(3);
		System.out.println("The max in the list is 4: " + numbersList.getMax() + "\tSize of list is still 5: " + numbersList.getLength());
	
		numbersList.add(1);
		System.out.println("The max in the list is 4: " + numbersList.getMax()+ "\tSize of list is still 6: " + numbersList.getLength());
		
		// testing duplicate max
		numbersList.add(4);
		System.out.println("The max in the list is 4: " + numbersList.getMax()+ "\tSize of list is still 7: " + numbersList.getLength());
		
		// testing max at the end
		numbersList.add(5);
		System.out.println("The max in the list is 5: " + numbersList.getMax()+ "\tSize of list is still 8: " + numbersList.getLength());
		
		// testing max at the beginning
		numbersList.add(1, 7);
		System.out.println("The max in the list is 7: " + numbersList.getMax()+ "\tSize of list is still 9: " + numbersList.getLength());

		// testing singleton
		numbersList.clear(); 		numbersList.add(1);
		System.out.println("The max in the list is 1: " + numbersList.getMax()+ "\tSize of list is still 1: " + numbersList.getLength());
		
		// testing empty list
		numbersList.clear();
		System.out.println("Should either print null or throw an exception- but NOT a Null Pointer Exception");
		System.out.println(numbersList.getMax());
		
		
		System.out.println("\n******TESTING QUESTION: LLIST ADD ALL");
		LList<String> produceList = new LList<String>();
		
		// add a 1-element array to an empty list
		produceList.addAll(new String[]{"peach"});
		System.out.println("The list contains[peach] \n\t\t " + Arrays.toString(produceList.toArray()));
		System.out.println("Size is 1: " + produceList.getLength());
		
		// add an array to a non-empty list
		String[] stringArray = { "banana", "date", "grape", "eggplant",	"jicama", "grape" };
		produceList.addAll(stringArray);
		System.out.println("\nThe list contains[peach, banana, date, grape, eggplant, jicama, grape] \n\t\t "
						+ Arrays.toString(produceList.toArray()));
		System.out.println("Size is 7: " + produceList.getLength());
		
		// add an empty array to a non-empty list
		produceList.addAll(new String[] {});
		System.out.println("\nThe list contains[peach, banana, date, grape, eggplant, jicama, grape] \n\t\t "
				+ Arrays.toString(produceList.toArray()));
		System.out.println("Size is 7: " + produceList.getLength());
		
		// add an array to an empty list
		produceList.clear();
		produceList.addAll(new String[] { "banana", "date", "grape", "eggplant",	"jicama", "grape" });
		System.out.println("\nThe list contains[banana, date, grape, eggplant, jicama, grape] \n\t\t "
						+ Arrays.toString(produceList.toArray()));
		System.out.println("Size is 6: " + produceList.getLength());
		
		// add an empty array to an empty list
		produceList.clear();
		produceList.addAll(new String[] {});
		System.out.println("\nThe list contains[] \n\t\t "
				+ Arrays.toString(produceList.toArray()));
		System.out.println("Size is 0: " + produceList.getLength());


		System.out.println("\n******TESTING QUESTION EXTRA CREDIT: DOUBLE NODE PALINDROME");
		
		// sets up the chain 4->3->4->3->4(odd length palindrome)
		DoubleNode<Integer> n1 = new DoubleNode<Integer>(4);
		DoubleNode<Integer> n2 = new DoubleNode<Integer>(3);		
		DoubleNode<Integer> n3 = new DoubleNode<Integer>(4);
		DoubleNode<Integer> n4 = new DoubleNode<Integer>(3);
		DoubleNode<Integer> n5 = new DoubleNode<Integer>(4);
		n1.next = n2; n2.previous = n1;	
		n2.next = n3; n3.previous = n2;
		n3.next = n4; n4.previous = n3;
		n4.next = n5; n5.previous = n4;
		System.out.println("Should print true: " + isDoublyLinkedPalindromeList(n1, n5));
		
		
		// sets up the chain 4->3->-3->4 (even length palindrome)
		n1 = new DoubleNode<Integer>(4);
		n2 = new DoubleNode<Integer>(3);	
		n3 = new DoubleNode<Integer>(3);
		n4 = new DoubleNode<Integer>(4);
		n1.next = n2;
		n2.next = n3;
		n2.previous = n1;
		n3.next = n4;
		n3.previous = n2;
		n4.previous = n3;
		System.out.println("Should print true: " + isDoublyLinkedPalindromeList(n1, n4));

		// sets up the chain 4->1 (even length non-palindrome)
		n1 = new DoubleNode<Integer>(4);
		n2 = new DoubleNode<Integer>(1);
		n1.next = n2;
		n2.previous = n1;
		System.out.println("Should print false: " + isDoublyLinkedPalindromeList(n1, n2));

		
		// sets up the chain 1->3->-2->1 (even length non-palindrome)
		n4 = new DoubleNode<Integer>(1);
		n3 = new DoubleNode<Integer>(2);
		n2 = new DoubleNode<Integer>(3);		
		n1 = new DoubleNode<Integer>(1);
		n1.next = n2;
		n2.next = n3;
		n2.previous = n1;
		n3.next = n4;
		n3.previous = n2;
		n4.previous = n3;
		System.out.println("Should print false: " + isDoublyLinkedPalindromeList(n1, n4));
		
		// sets up the chain 3->4->-3->4 (even length non-palindrome)
		n4 = new DoubleNode<Integer>(4);
		n3 = new DoubleNode<Integer>(3);
		n2 = new DoubleNode<Integer>(4);		
		n1 = new DoubleNode<Integer>(3);
		n1.next = n2;
		n2.next = n3;
		n2.previous = n1;
		n3.next = n4;
		n3.previous = n2;
		n4.previous = n3;
		System.out.println("Should print false: " + isDoublyLinkedPalindromeList(n1, n4));

		// sets up the chain 4->3->3->2->4(odd length non-palindrome)
		n1 = new DoubleNode<Integer>(4);
		n2 = new DoubleNode<Integer>(3);		
		n3 = new DoubleNode<Integer>(3);
		n4 = new DoubleNode<Integer>(2);
		n5 = new DoubleNode<Integer>(4);
		n1.next = n2; n2.previous = n1;	
		n2.next = n3; n3.previous = n2;
		n3.next = n4; n4.previous = n3;
		n4.next = n5; n5.previous = n4;
		System.out.println("Should print false: " + isDoublyLinkedPalindromeList(n1, n5));
		
		// sets up the chain 4->2->1->2->3(odd length non-palindrome)
		n1 = new DoubleNode<Integer>(4);
		n2 = new DoubleNode<Integer>(2);		
		n3 = new DoubleNode<Integer>(1);
		n4 = new DoubleNode<Integer>(2);
		n5 = new DoubleNode<Integer>(3);
		n1.next = n2; n2.previous = n1;	
		n2.next = n3; n3.previous = n2;
		n3.next = n4; n4.previous = n3;
		n4.next = n5; n5.previous = n4;
		System.out.println("Should print false: " + isDoublyLinkedPalindromeList(n1, n5));
		
		// empty chain
		n1 = null;
		System.out.println("Should print true and not crash: " + isDoublyLinkedPalindromeList(n1, n1));
		
		n1 = new DoubleNode<Integer>(3);
		// sets up the chain 3 (singleton chain)
		System.out.println("Should print true and not crash: " + isDoublyLinkedPalindromeList(n1, n1));
		
		
		
		
	}
	

	public static void printAtInterval(Node<String> firstNode, int interval) {
		String result = "";
		int counter = 0;
		Node<String> currentNode = firstNode;
		while (currentNode != null) {
			if (counter % interval == 0) {
				result += currentNode.data + " ";
			}
			currentNode = currentNode.next;
			counter++;
		}
		System.out.println(result);
		
	}

	
	public static boolean isDoublyLinkedPalindromeList(DoubleNode<Integer> firstNode, DoubleNode<Integer> lastNode)  {
		if (firstNode == null || firstNode.equals(lastNode)) // empty list or singleton
			return true;
		else {
			while ( firstNode != lastNode && firstNode.previous != lastNode  ) { // keep going until midpoint is reached
				if (!firstNode.data.equals(lastNode.data)) // find non-symmetric
					return false;
				else {
					firstNode = firstNode.next;
					lastNode = lastNode.previous;
				}
			}
			return true;
		}
	}

}
