import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class of List  whose entries are stored in a fixed-size array.
 * The list could only add element at the begining or the end
 * List index starts from 0
 * 
 * @author Zexi Yan
 * @version 1.0
 */

public class ArrayHeadTailList<T> implements HeadTailListInterface<T> {

	private T[] listArray;
	private int numberOfElements;
	private boolean integrityOK;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	
	public ArrayHeadTailList(int initialCapacity) {
		integrityOK = false;
		checkCapacity(initialCapacity); // ensure the capacity is valid
		
		if (initialCapacity > 0) {
			listArray = (T[]) new Object[initialCapacity];
			numberOfElements = 0;
			integrityOK = true;
		}
	}
	
	
	// Adds an element at the beginning of the list and shifts all other entries to the right by one position
	public void addFront(T element) {
		for (int i = numberOfElements - 1; i >= 0; i--) {
			listArray[i+1] = listArray[i];
		}
		
		listArray[0] = element;
		numberOfElements++; 
		ensureCapacity(); 
	}
	
	
	// Adds an element at the end of the list
	public void addBack(T element) {
		listArray[numberOfElements] = element;
		numberOfElements++;
		ensureCapacity();
	}
	
	// removes the first entry and shift all other entries to the left by 1
	public T removeFront() {
		T result = listArray[0];
		if (!isEmpty()) {
			for (int i = 0; i < numberOfElements - 1; i++) {
				listArray[i] = listArray[i+1];
			}
			listArray[numberOfElements - 1] = null;
			numberOfElements--;
		}
		return result;
	}
	
	
	// Removes the last entry
	public T removeBack() {
		if (!isEmpty()) {
			T result = listArray[numberOfElements - 1];
			listArray[numberOfElements - 1] = null;
			numberOfElements--;
			return result;
		}
		else
			return null;
	}
	
	// Returns true if the element is in the list, false otherwise
	public boolean contains(T element) {
		for (T item : listArray) {
			if (element.equals(item))
				return true;
		}
		return false;
	}
	
	// @Return the index of the first occurance of the given element in the list
	// @Return -1 if not in the list
	public int indexOf(T element) {
		for (int i = 0; i < numberOfElements; i++) {
			if (listArray[i].equals(element))
				return i;
		}
		return -1;
	}
	
	public int lastIndexOf(T element) {
		for (int i = numberOfElements - 1; i >= 0; i--) {
			if (listArray[i].equals(element))
				return i;
		}
		return -1;
	}
		
	public T getEntry(int index) {
		if (index >= 0 && index <= numberOfElements - 1) 
			return listArray[index];
		else
			return null;
	}
	
	public void display() {
		System.out.println(numberOfElements + " elements; " 
				+ "capacity = " + listArray.length + "\t"
				+ showList());
	}
	
	public void clear() {
		T[] newList = (T[]) new Object[listArray.length];
		listArray = newList;
		numberOfElements = 0;
	}
	
	public boolean isEmpty() {
		return numberOfElements == 0;
	}
	
	public int size() {
		return numberOfElements;
	}

	private void checkCapacity(int capacity) {
		if (capacity <= 0 ) 
			throw new IllegalStateException(
					"Attempt to create a list with non-positive capacity.");
		else if (capacity > MAX_CAPACITY )
			throw new IllegalStateException(
					"Attempt to create a list whose capacity exceeds maximum allowded.");
	}
	
	
	// double the array size when full
	private void ensureCapacity() {
		if (numberOfElements >= listArray.length) {
			int newLength = listArray.length * 2;
			T[] tempList = (T[]) Arrays.copyOf(listArray, newLength);
			this.listArray = tempList;
		}
	}
	
	private String showList() {
		T[] tempList = (T[]) new Object[numberOfElements]; 
		for (int i = 0; i < numberOfElements; i++) {
			tempList[i] = listArray[i];
		}
		return Arrays.toString(tempList);
	}
}
