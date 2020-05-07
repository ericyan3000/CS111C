import java.util.ArrayList;
import java.util.List;

public class ListDeque<T> implements DequeInterface<T> {

	public List<T> list;
	private int frontIndex;
	private int backIndex;
	private static final int DEFAULT_INITIAL_CAPACITY = 5;
	
	public ListDeque() {
		frontIndex = 0;
		backIndex = DEFAULT_INITIAL_CAPACITY - 1;
		list = new ArrayList<T>();
		for (int i = 0; i<=backIndex; i++) {
			list.add(null);
		}
	}

	@Override
	public void addToFront(T newEntry) {
		ensureCapacity();
		frontIndex = (frontIndex - 1 + list.size()) % list.size();
		list.set(frontIndex, newEntry);
	}

	@Override
	public void addToBack(T newEntry) {
		ensureCapacity();
		backIndex = ((backIndex + 1) % list.size());
		list.set(backIndex, newEntry);
	}

	@Override
	public T removeFront() {
		if (list.isEmpty())
			return null;
		else {
			T front = getFront();
			list.set(frontIndex,  null);
			frontIndex = (frontIndex + 1) % list.size();
			return front;
		}
	}

	@Override
	public T removeBack() {
		if (list.isEmpty())
			return null;
		else {
			T back = getBack();
			list.set(backIndex,  null);
			backIndex = (backIndex - 1 + list.size()) % list.size();
			return back;
		}
	}

	@Override
	public T getFront() {
		if (isEmpty())
			return null;
		else
			return list.get(frontIndex);
	}

	@Override
	public T getBack() {
		if (isEmpty())
			return null;
		else
			return list.get(backIndex);
	}

	@Override
	public boolean isEmpty() {
		return (( backIndex + 1 ) % list.size() == frontIndex);
		
	}

	@Override
	public void clear() {
		frontIndex = 0;
		backIndex = list.size() - 1;
		for (int i = frontIndex; i<=backIndex; i++) {
			list.set(i, null);
		}
	}
	
	@Override
	public String toString() {
		String text = "[";
		if (isEmpty())
			return "";
		else {
			for (int i = frontIndex; i != backIndex; i = (i+1)%list.size()) {
				text += " " + list.get(i);
			}
			text += " " + list.get(backIndex) + " ]";
			return text;			 
		}
	}
	
	// Doubles the size of the array queue if it is full.
	// Precondition: checkIntegrity has been called.
	private void ensureCapacity() {  // same as ArrayQueue dequeue
		if (frontIndex == ((backIndex + 2) % list.size())) {  // check if the deque is full
			// If list is full, double size of list
			List<T> oldDeque = list;
			int oldSize = oldDeque.size();
			int newSize = 2 * oldSize;

			// The cast is safe because the new array contains null entries
			@SuppressWarnings("unchecked")
			List<T> tempDeque = new ArrayList<T>();
			this.list = tempDeque;
			for (int index = 0; index < oldSize - 1; index++) {
				list.add(oldDeque.get(frontIndex));
				frontIndex = (frontIndex + 1) % oldSize;
			}
			for (int index = oldSize; index < newSize; index++) { // doubling the size of new deque
				list.add(null);
			}
			frontIndex = 0;
			backIndex = oldSize - 2;
		} 
	}


}
