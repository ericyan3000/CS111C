import java.util.ArrayList;
import java.util.Arrays;

public class HomeworkM4Driver {

	public static void main(String[] args) {
		System.out.println("************************************TESTING ARRAYBAG REMOVE ALL");
		ArrayBag<Integer> numbersBag = new ArrayBag<Integer>();
		int numRemoved = numbersBag.removeAll(1);
		System.out.println("Number removed is 0:" + numRemoved);
		System.out.println("The bag contains  0:" + numbersBag.getCurrentSize() + " (in ANY order)    []\n\t\t\t\t\t"+ Arrays.toString(numbersBag.toArray()));
		numbersBag.clear();
		numbersBag.add(1);
		numbersBag.add(7);
		numbersBag.add(2);
		numbersBag.add(1);
		numbersBag.add(4);
		numbersBag.add(3);
		numbersBag.add(1);
		numbersBag.add(1);
		numbersBag.add(7);
		numbersBag.add(1);
		numRemoved = numbersBag.removeAll(1);
		System.out.println("Number removed is 5:" + numRemoved);
		System.out.println("The bag contains  5:" + numbersBag.getCurrentSize() + "  (in ANY order)   [7, 7, 2, 3, 4]\n\t\t\t\t\t"+ Arrays.toString(numbersBag.toArray()));
		numRemoved = numbersBag.removeAll(7);
		System.out.println("Number removed is 2:" + numRemoved);
		System.out.println("The bag contains  3:" + numbersBag.getCurrentSize() + " (in ANY order)    [4, 3, 2]\n\t\t\t\t\t"+ Arrays.toString(numbersBag.toArray()));
		numRemoved = numbersBag.removeAll(8);
		System.out.println("Number removed is 0:" + numRemoved);
		System.out.println("The bag contains  3:" + numbersBag.getCurrentSize() + " (in ANY order)    [4, 3, 2]\n\t\t\t\t\t"+ Arrays.toString(numbersBag.toArray()));
		numbersBag.clear();
		numbersBag.add(1);
		numbersBag.add(1);
		numbersBag.add(1);
		numbersBag.add(1);
		numRemoved = numbersBag.removeAll(1);
		System.out.println("Number removed is 4:" + numRemoved);
		System.out.println("The bag contains  0:" + numbersBag.getCurrentSize() + "    \t\t[]\n\t\t\t\t\t"+ Arrays.toString(numbersBag.toArray()));
	
		
		
		System.out.println("\n\n************************************TESTING RESIZABLEARRAYBAG TRIM TO SIZE");
		// NOTE: you need to modify ResizableArrayBag somehow to access and test the length of the array
		// NOTE: If you try to directly print information about the bag array, you might get strange runtime crashes. 
		//       Remember that arrays and generics don't always play nice!
		//       You should be able to fix these by casting the bag to Object[] before accessing any other information, like this:
		//       ( ( Object[])myBag.bag ) 
		
		ResizableArrayBag<Integer> resizableBag = new ResizableArrayBag<Integer>(20);
		System.out.println("The size of the bag is \t\t  0:" + resizableBag.getCurrentSize());
		int length = (( Object[])resizableBag.bag).length; // code here to get the size of the bag array 

		System.out.println("The length of the bag array is \t 20:" + length);
		for(int i=0; i<100; i++) {
			resizableBag.add(1);
		}
		length = (( Object[])resizableBag.bag).length; // code here to get the size of the bag array 
		System.out.println("The size of the bag is \t\t100:" + resizableBag.getCurrentSize());	
		System.out.println("The length of the bag array is \t160:" + length);
		
		
		resizableBag.trimToSize();
		length = (( Object[])resizableBag.bag).length; // code here to get the size of the bag array 
		System.out.println("The size of the bag is \t\t100:" + resizableBag.getCurrentSize());
		System.out.println("The length of the bag array is \t100:" + length);
		
		resizableBag.add(43);
		length = (( Object[])resizableBag.bag).length; // code here to get the size of the bag array 
		System.out.println("The size of the bag is \t\t101:" + resizableBag.getCurrentSize());
		System.out.println("The length of the bag array is \t200:" + length);
		
		resizableBag.trimToSize();
		length = (( Object[])resizableBag.bag).length; // code here to get the size of the bag array 
		System.out.println("The size of the bag is \t\t101:" + resizableBag.getCurrentSize());
		System.out.println("The length of the bag array is \t101:" + length);

	
		System.out.println("\n\n************************************TESTING ALIST REMOVE ALL");
		AList<Integer> numbersList = new AList<>();
		numRemoved = numbersList.removeAll(1);
		System.out.println("Number removed is 0:" + numRemoved);
		System.out.println("The list contains 0:" + numbersList.getLength() + "\n\t[]\n\t"+ Arrays.toString(numbersList.toArray()));

		numbersList.add(1);
		numbersList.add(2);
		numbersList.add(1);
		numbersList.add(1);		
		numbersList.add(4);
		numbersList.add(3);
		numbersList.add(7);
		numbersList.add(1);		
		numRemoved = numbersList.removeAll(1);
		System.out.println("\nNumber removed is 4:" + numRemoved);
		System.out.println("The list contains 4:" + numbersList.getLength() + "\n\t[2, 4, 3, 7]\n\t"+ Arrays.toString(numbersList.toArray()));

		numRemoved = numbersList.removeAll(7);
		System.out.println("\nNumber removed is 1:" + numRemoved);
		System.out.println("The list contains 3:" + numbersList.getLength() + "\n\t[2, 4, 3]\n\t"+ Arrays.toString(numbersList.toArray()));
		
		numRemoved = numbersList.removeAll(8);
		System.out.println("\nNumber removed is 0:" + numRemoved);
		System.out.println("The list contains 3:" + numbersList.getLength() + "\n\t[2, 4, 3]\n\t"+ Arrays.toString(numbersList.toArray()));
		
		numbersList.clear();
		numbersList.add(1);
		numbersList.add(1);
		numbersList.add(1);
		numbersList.add(1);
		numRemoved = numbersList.removeAll(1);
		System.out.println("\nNumber removed is 4:" + numRemoved);
		System.out.println("The list contains 0:" + numbersList.getLength() + "\n\t[]\n\t"+ Arrays.toString(numbersList.toArray()));

	
		System.out.println("\n\n************************************TESTING ALIST EQUALS");		
		AList<String> produceList = new AList<String>();
		AList<String> foodList = new AList<String>();
		
		// two empty lists
		System.out.println("Result is  true: " + produceList.equals(foodList));
		
		// empty parameter, non-empty invoking object
		produceList.add("banana");
		produceList.add("date");
		produceList.add("grape");
		produceList.add("eggplant");
		System.out.println("Result is false: " + produceList.equals(foodList));
		
		// empty invoke object, non-empty parameter
		produceList.clear();
		foodList.add("banana");
		foodList.add("date");
		foodList.add("grape");		
		System.out.println("Result is false: " + produceList.equals(foodList));

		// lists have different lengths
		produceList.add("banana");
		produceList.add("date");
		produceList.add("grape");
		produceList.add("eggplant");
		System.out.println("Result is false: " + produceList.equals(foodList));

		// lists have same lengths but different contents
		produceList.add("carrot");
		System.out.println("Result is false: " + produceList.equals(foodList));
		
		// equivalent lists
		foodList.add("eggplant");
		foodList.add("carrot");
		System.out.println("\nThe produce list contains \t"	+ Arrays.toString(produceList.toArray()));
		System.out.println("The food list contains \t\t"	+ Arrays.toString(foodList.toArray()));
		System.out.println("Result is  true: " + produceList.equals(foodList));

		// lists have same contents but different orders
		foodList.add("squash");
		foodList.replace(1, "grape");
		foodList.replace(3, "banana");
		produceList.replace(2,"squash");
		produceList.add("date");
		System.out.println("\nThe produce list contains \t"	+ Arrays.toString(produceList.toArray()));
		System.out.println("The food list contains \t\t"	+ Arrays.toString(foodList.toArray()));
		System.out.println("Result is false: " + produceList.equals(foodList));

		// different size arrays, but equivalent lists
		AList<Integer> numberList1 = new AList<Integer>(100);
		numberList1.add(1);
		numberList1.add(2);
		numberList1.add(3);
		AList<Integer> numberList2 = new AList<Integer>();
		numberList2.add(1);
		numberList2.add(2);
		numberList2.add(3);
		System.out.println("\nResult is  true: " + numberList1.equals(numberList2));	

		
		System.out.println("\n\n************************************TESTING EXTRA CREDIT ALIST COMPARABLE");	
		AList<Integer> numberListA = new AList<Integer>();
		AList<Integer> numberListB = new AList<Integer>();
		System.out.println("Result 0:" + numberListA.compareTo(numberListB) + "\t\tList A and B are empty.");

		numberListA.add(1);
		System.out.println("Result positive: " + numberListA.compareTo(numberListB) + "\tList A is bigger (more elements)");

		numberListA.remove(1);
		numberListB.add(1);
		System.out.println("Result negative:" + numberListA.compareTo(numberListB) + "\tList A is smaller (fewer elements)");
		
		numberListA.add(1);
		numberListB.add(2);
		System.out.println("Result negative:" + numberListA.compareTo(numberListB) + "\tList A is smaller (fewer elements)");
		numberListA.add(2);
		System.out.println("Result 0:" + numberListA.compareTo(numberListB) + "\t\tList A and List B are the same size and have the same elemnets");
		numberListA.add(3);
		numberListB.add(4);
		System.out.println("Result negative:" + numberListA.compareTo(numberListB) + "\tList A is smaller (lists are the same size; for the first non-matching element, the a list element is smaller");
		numberListB.replace(3,3);
		System.out.println("Result 0:" + numberListA.compareTo(numberListB) + "\t\tList A and List B are the same size and have the same elemnets");
		numberListA.add(4);
		numberListB.add(3);
		System.out.println("Result positive: " + numberListA.compareTo(numberListB) + "\tList A is bigger (lists are the same size; for the first non-matching element, the a list element is bigger");
		
		AList<String> wordListA = new AList<String>();
		wordListA.add("a");
		wordListA.add("b");
		wordListA.add("c");
		AList<String> wordListB = new AList<String>();
		wordListB.add("a");
		wordListB.add("d");
		wordListB.add("a");
		System.out.println("Result negative:" +  wordListA.compareTo(wordListB) + "\tList A is smaller (lists are the same size; for the first non-matching element, the a list element is smaller");


	}

}
