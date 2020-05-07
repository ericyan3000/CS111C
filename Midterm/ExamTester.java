import java.util.*;

public class ExamTester {

	public static void main(String[] args) {
		System.out.println("******************************* TESTING LINKEDBAG DUPLICATE METHOD *****");
		// duplicate 1, 2, 3
		LinkedBag<Integer> bag1 = new LinkedBag<Integer>();
		bag1.add(1); 		bag1.add(2); 		bag1.add(3);
		bag1.duplicateContents();
		Integer[] results = getSortedResults(bag1.toArray());
		System.out.println("Should print\n[1, 1, 2, 2, 3, 3]\n" + Arrays.toString(results));

		// duplicate 1, 1, 2, 2, 3, 3
		bag1.duplicateContents();
		results = getSortedResults(bag1.toArray());
		System.out.println("Should print\n[1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3]\n" + Arrays.toString(results));
		
		// duplicate an empty bag
		bag1.clear();
		bag1.duplicateContents();
		results = getSortedResults(bag1.toArray());
		System.out.println("Should print\n[]\n" + Arrays.toString(results));
		
		// duplicate a singleton bag
		bag1.add(4);
		bag1.duplicateContents();
		results = getSortedResults(bag1.toArray());
		System.out.println("Should print\n[4, 4]\n" + Arrays.toString(results));

		System.out.println("\n******************************* TESTING LISTINTERFACE CLIENT ROTATE METHOD *****");
		// rotate 1, 2, 3, 4, 5, 6 by 2 
		ListInterface<Integer> list1 = new AList<Integer>();
		list1.add(1); list1.add(2);	list1.add(3); list1.add(4); list1.add(5); list1.add(6);
		rotatePositive(list1, 3);
		results = getResults(list1.toArray());
		System.out.println("Should print\n[4, 5, 6, 1, 2, 3]\n" + Arrays.toString(results));
		
		// rotate 1, 2, 3, 4, 5, 6 by 6 
		list1.clear();
		list1.add(1); list1.add(2);	list1.add(3); list1.add(4); list1.add(5); list1.add(6);
		rotatePositive(list1, 6);
		results = getResults(list1.toArray());
		System.out.println("Should print\n[1, 2, 3, 4, 5, 6]\n" + Arrays.toString(results));

		// rotate 1, 2, 3, 4, 5, 6 by 7 
		list1.clear();
		list1.add(1); list1.add(2);	list1.add(3); list1.add(4); list1.add(5); list1.add(6);
		rotatePositive(list1, 7);
		results = getResults(list1.toArray());
		System.out.println("Should print\n[6, 1, 2, 3, 4, 5]\n" + Arrays.toString(results));

		// rotate an empty list
		list1.clear();
		rotatePositive(list1, 5);
		results = getResults(list1.toArray());
		System.out.println("Should print\n[]\n" + Arrays.toString(results));
		
		// rotate 1, 2, 3, 4, 5, 6 by 10
		list1.clear();
		list1.add(1); list1.add(2);	list1.add(3); list1.add(4); list1.add(5); list1.add(6);
		rotatePositive(list1, 10);
		results = getResults(list1.toArray());
		System.out.println("Should print\n[3, 4, 5, 6, 1, 2]\n" + Arrays.toString(results));

		// rotate an object initialized with LList instead of AList
		ListInterface<Integer> list2 = new LList<Integer>();
		list2.add(1); list2.add(2);	list2.add(3); list2.add(4); list2.add(5); list2.add(6);
		rotatePositive(list2, 3);
		results = getResults(list2.toArray());
		System.out.println("Should print\n[4, 5, 6, 1, 2, 3]\n" + Arrays.toString(results));


		System.out.println("\n******************************* TESTING ALIST ADDTOFRONT METHOD *****");
		// add chain 10, 11, 12 to the front of list 1, 2, 3, 4, 5
		AList<Integer> list3 = new AList<Integer>();
		list3.add(1); list3.add(2); list3.add(3); list3.add(4); list3.add(5);
		ANode<Integer> chainToAdd1 = new ANode<Integer>(10, new ANode<Integer>(11, new ANode<Integer>(12)));
		list3.addToFront(chainToAdd1);
		results = getResults(list3.toArray());
		System.out.println("Should print\n[10, 11, 12, 1, 2, 3, 4, 5]\tsize=8\n" + Arrays.toString(results)+"\tsize="+list3.getLength());
		
		// add chain 10, 11, 12, 13 to the front of list 1, 2, 3, 4
		list3.clear();
		list3.add(1); list3.add(2); list3.add(3); list3.add(4);
		chainToAdd1 = new ANode<Integer>(10, new ANode<Integer>(11, new ANode<Integer>(12, new ANode<Integer>(13))));
		list3.addToFront(chainToAdd1);
		results = getResults(list3.toArray());
		System.out.println("Should print\n[10, 11, 12, 13, 1, 2, 3, 4]\tsize=8\n" + Arrays.toString(results)+"\tsize="+list3.getLength());
		
		// add chain 10, 11, 12, 13 to empty list
		list3.clear();
		chainToAdd1 = new ANode<Integer>(10, new ANode<Integer>(11, new ANode<Integer>(12, new ANode<Integer>(13))));
		list3.addToFront(chainToAdd1);
		results = getResults(list3.toArray());
		System.out.println("Should print\n[10, 11, 12, 13]\tsize=4\n" + Arrays.toString(results)+"\tsize="+list3.getLength());
		
		// add empty chain to list 1, 2, 3, 4
		list3.clear();
		list3.add(1); list3.add(2); list3.add(3); list3.add(4);
		chainToAdd1 = null;
		list3.addToFront(chainToAdd1);
		results = getResults(list3.toArray());
		System.out.println("Should print\n[1, 2, 3, 4]\tsize=4\n" + Arrays.toString(results)+"\tsize="+list3.getLength());

		// add empty chain to empty list
		list3.clear();
		chainToAdd1 = null;
		list3.addToFront(chainToAdd1);
		results = getResults(list3.toArray());
		System.out.println("Should print\n[]\tsize=0\n" + Arrays.toString(results)+"\tsize="+list3.getLength());

	}
	public static void rotatePositive(ListInterface<Integer> list, int distance) {
		if (! list.isEmpty()) {
			distance = distance % list.getLength();
			while (distance > 0 ) {
				int next = 0;  // store temp for next iteration
				int last = list.getEntry(1); // temp from last iteration
				for (int i = 1; i < list.getLength(); i++) {
					next = list.getEntry(i+1);
					list.replace(i+1, last);
					last = next; 
				}
				list.replace(1, last);
				distance--;
			}
		}
	}

	
	
	/*
	 * don't worry about these methods- they are just here so that the generics work
	 * correctly and we can print results for comparison!
	 */
	private static Integer[] getSortedResults(Object[] array) {
		return getResults(array, true);
	}

	private static Integer[] getResults(Object[] array) {
		return getResults(array, false);
	}

	private static Integer[] getResults(Object[] array, boolean sorted) {
		Integer[] results = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			results[i] = (Integer) array[i];
		}
		if (sorted) {
			Arrays.sort(results);
		}
		return results;

	}
}
