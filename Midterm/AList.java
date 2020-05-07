import java.util.Arrays;

/**
 * A class that implements a list of objects by using an array. Entries in a
 * list have positions that begin with 1. Duplicate entries are allowed.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class AList<T extends Comparable<? super T>> implements ListInterface<T> {
	private T[] list; // Array of list entries; ignore list[0]
	private int numberOfEntries;
	private boolean integrityOK;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	public AList() {
		this(DEFAULT_CAPACITY);
	} 

	public AList(int initialCapacity) {
		integrityOK = false;

		// Is initialCapacity too small?
		if (initialCapacity < DEFAULT_CAPACITY) {
			initialCapacity = DEFAULT_CAPACITY;
		} else { 
			checkCapacity(initialCapacity);
		}

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempList = (T[]) new Comparable[initialCapacity + 1];
		list = tempList;
		numberOfEntries = 0;
		integrityOK = true;
	} 

	public void add(T newEntry) {
		add(numberOfEntries + 1, newEntry);
	} 

	public void add(int givenPosition, T newEntry) {
		checkIntegrity();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) {
			if (givenPosition <= numberOfEntries) {
				makeRoom(givenPosition);
			}
			list[givenPosition] = newEntry;
			numberOfEntries++;
			ensureCapacity(); // Ensure enough room for next add
		} else {
			throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");
		}
	} 

	public T remove(int givenPosition) {
		checkIntegrity();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			// Assertion: The list is not empty
			T result = list[givenPosition]; // Get entry to be removed

			// Move subsequent entries towards entry to be removed,
			// unless it is last in list
			if (givenPosition < numberOfEntries) {
				removeGap(givenPosition);
			}
			list[numberOfEntries] = null;
			numberOfEntries--;
			return result; 
		} else {
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
		}
	} 

	
	public T getEntry(int givenPosition) {
		checkIntegrity();
		if (validPosition(givenPosition)) {
			// Assertion: The list is not empty
			return list[givenPosition];
		} else {
			System.out.print(givenPosition);
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
		}
	} 
	
	public T replace(int givenPosition, T newEntry) {
		checkIntegrity();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			// Assertion: The list is not empty
			T originalEntry = list[givenPosition];
			list[givenPosition] = newEntry;
			return originalEntry;
		} else {
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
		}
	}


	public boolean contains(T anEntry) {
		checkIntegrity();
		boolean found = false;
		int index = 1;
		while (!found && (index <= numberOfEntries)) {
			if (anEntry.equals(list[index]))
				found = true;
			index++;
		} 
		return found;
	} 

	public void clear() {
		checkIntegrity();

		// Clear entries but retain array; no need to create a new array
		for (int index = 1; index <= numberOfEntries; index++) {
			list[index] = null;
		}

		numberOfEntries = 0;
	} 
	
	public int getLength() {
		return numberOfEntries;
	} 

	public boolean isEmpty() {
		return numberOfEntries == 0; // Or getLength() == 0
	} 
	
	public T[] toArray() {
		checkIntegrity();

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries]; // Unchecked cast
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = list[index + 1];
		}

		return result;
	}


	// Doubles the capacity of the array list if it is full.
	// Precondition: checkIntegrity has been called.
	private void ensureCapacity() {
		int capacity = list.length - 1;
		if (numberOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity); // Is capacity too big?
			list = Arrays.copyOf(list, newCapacity + 1);
		} 
	} 

	// Makes room for a new entry at newPosition.
	// Precondition: 1 <= newPosition <= numberOfEntries + 1;
	// numberOfEntries is list's length before addition;
	// checkIntegrity has been called.
	private void makeRoom(int givenPosition) {
		// Assertion: (newPosition >= 1) && (newPosition <= numberOfEntries + 1)
		int newIndex = givenPosition;
		int lastIndex = numberOfEntries;

		// Move each entry to next higher index, starting at end of
		// list and continuing until the entry at newIndex is moved
		for (int index = lastIndex; index >= newIndex; index--) {
			list[index + 1] = list[index];
		}
	}
	
	// Shifts entries that are beyond the entry to be removed to the
	// next lower position.
	// Precondition: 1 <= givenPosition < numberOfEntries;
	// numberOfEntries is list's length before removal;
	// checkIntegrity has been called.
	private void removeGap(int givenPosition) {
		int removedIndex = givenPosition;
		for (int index = removedIndex; index < numberOfEntries; index++)
			list[index] = list[index + 1];
	} 

	// Throws an exception if this object is corrupt.
	private void checkIntegrity() {
		if (!integrityOK) {
			throw new SecurityException("AList object is corrupt.");
		}
	} 

	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY) {
			throw new IllegalStateException(
					"Attempt to create a list " + "whose capacity exceeds " + "allowed maximum.");
		}
	} 

	private boolean validPosition(int position) {
		return position >= 1 && position <= numberOfEntries;
	}

	

	public void addToFront(ANode<T> first) {
		if (first != null) {
			// get size of added list O(n)
			int listSize = 0;
			ANode<T> current = first;
			while (current != null) {
				listSize += 1;
				current = current.next;
			}
			
			// make listSize room in array in the front  // O(logn)
			int originalNumberOfEntries = numberOfEntries;
			numberOfEntries += listSize;
			while (numberOfEntries > list.length) {
				ensureCapacity();
			}
			
			// shifting current content to proper position // O(n)
			for (int i = originalNumberOfEntries; i >= 0; i--) {
				list[i+listSize] = list[i];
			}
			
			// copy list data into array O(n)
			current = first;
			int i = 1;
			while (current != null) {
				list[i] = current.data;
				current = current.next;
				i++;
			}
		}
			
	}


} 
