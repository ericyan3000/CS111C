import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListHeadTailList<T> implements HeadTailListInterface<T> {
	private int numberOfElements;
	private List<T> list;
	private static final int MAX_CAPACITY = 10000;
	private static final int DEFAULT_CAPACITY = 100;
	
	public ListHeadTailList(int initialCapacity) {
		checkCapacity(initialCapacity);
		this.list = new ArrayList<T>(initialCapacity);
		numberOfElements = 0;
	}
	
	public ListHeadTailList() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public void addFront(T newEntry) {
		list.add(0, newEntry);
		numberOfElements++;
	}

	@Override
	public void addBack(T newEntry) {
		list.add(numberOfElements, newEntry);
		numberOfElements++;
	}

	@Override
	public T removeFront() {
		if (isEmpty())
			return null;
		else {
			numberOfElements--;
			return list.remove(0);
		}
	}

	@Override
	public T removeBack() {
		if (isEmpty())
			return null;
		else {
			numberOfElements--;
			return list.remove(numberOfElements);
		}
	}

	@Override
	public void clear() {
		list = new ArrayList<>();
		numberOfElements = 0;
	}

	@Override
	public T getEntry(int givenPosition) {
		if (isValidPosition(givenPosition)) 
			return list.get(givenPosition);
		else
			return null;
	}



	@Override
	public void display() {
		String content = numberOfElements + " elements; ";
		if (isEmpty()) 
			System.out.println(content);
		else
			System.out.println(content + "\t"
				+ showList());
		
	}

	@Override
	public int indexOf(T anEntry) {
		return list.indexOf(anEntry);
	}

	@Override
	public int lastIndexOf(T anEntry) {
		return list.lastIndexOf(anEntry);
	}

	@Override
	public boolean contains(T anEntry) {
		return list.contains(anEntry);
	}

	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		return numberOfElements == 0;
	}
	
	private void checkCapacity(int capacity) {
		if (capacity <= 0 ) 
			throw new IllegalStateException(
					"Attempt to create a list with non-positive capacity.");
		else if (capacity > MAX_CAPACITY )
			throw new IllegalStateException(
					"Attempt to create a list whose capacity exceeds maximum allowded.");
	}

	private String showList() {
		List<T> tempList = new ArrayList<T>(); 
		for (int i = 0; i < numberOfElements; i++) {
			tempList.add(list.get(i));
		}
		return list.toString();
	}
	
	private boolean isValidPosition(int givenPosition) {
		return givenPosition >= 0 && givenPosition < numberOfElements;
	}
}
