public class LinkedHeadTailList<T extends Comparable<? super T>> implements HeadTailListInterface<T>, Comparable<LinkedHeadTailList<T>> {

	private Node head, tail;
   
	public LinkedHeadTailList() {
	   head = tail = null;
	}


	private class Node {
		private T data; 
		private Node next; 

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} 
	}

	@Override
	public void addFront(T newEntry) {
		Node newNode = new Node(newEntry);
		if (!isEmpty()) 
			newNode.next = head;
		else
			tail = newNode;
		head = newNode;
	}
	
	@Override
	public void addBack(T newEntry) {
		Node newNode = new Node(newEntry);
		if (!isEmpty())
			tail.next = newNode;
		else
			head = newNode;
		tail = newNode;
	}
	
	@Override
	public T removeFront() {
		if (isEmpty()) 
			return null;
		else {
			Node temp = head;
			head = head.next;
			if (head == null) // removing from singleton
				tail = null;
			return temp.data;
		}
	}
	
	@Override
	public T removeBack() {
		if (isEmpty()) 
			return null;
		else {	
			Node temp = tail; 
			
			if ( size() == 1 ) // singleton
				clear();
			else {
				Node currentNode = head;
				while (currentNode.next != tail) { // move cursor to the node before tail
					currentNode = currentNode.next;
				}
				tail = currentNode;
			}
			return temp.data;
		}	
	}
	
	@Override
	public void clear() {
		head = tail = null;
	}
	
	@Override
	public T getEntry(int givenPosition) {
		if (isEmpty() || !isValidPosition(givenPosition))
			return null;
		else {
			int counter = 0;
			Node currentNode = head;
			while (counter < givenPosition) { // move cursor to the givenPosition
				currentNode = currentNode.next;
				counter++;
			}
			return currentNode.data;
		}
	}
	
	@Override
	public void display() {
		System.out.print("[");
		Node currentNode = head;
		while (currentNode != tail) {
			System.out.print(currentNode.data + ", ");
			currentNode = currentNode.next;
		}
		if (!isEmpty()) {
			System.out.print(tail.data);
			System.out.print("]\t");
			System.out.print("head=" + head.data + " tail=" + tail.data + "\n");
		}
		else
			System.out.print("]\n");
	}
	
	@Override
	public int indexOf(T anEntry) {
		int position = -1;
		boolean isFound = false;
		Node currentNode = head;
		
		if (!isEmpty()) {
			while (currentNode != tail && !currentNode.data.equals(anEntry)) { // keep searching until match or reach end
				currentNode = currentNode.next;
				position++;
			}
			if (currentNode.data.equals(anEntry)) {
				position++; // Because position starts at -1, only increment if match found
				isFound = true;
			}
		}

		return isFound ? position : -1;
	}
	
	@Override
	public int lastIndexOf(T anEntry) {
		int position = -1;
		int counter = 0;
		Node currentNode = head;
		
		if (!isEmpty()) {
			while (currentNode != tail) { // keep searching till the last element
				if (currentNode.data.equals(anEntry)) // update position when match found
					position = counter;
				counter++;
				currentNode = currentNode.next;
			}
			if (currentNode.data.equals(anEntry)) // if tail node is a match
				position = counter;
		}
		return position;
	}
	
	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int size() {
		if (isEmpty())
			return 0;
		else 
			return sizeHelper(head, tail);
	}
	
	private int sizeHelper(Node head, Node tail) {
		if (head.equals(tail)) // base case 
			return 1;
		else  // recursive case
			return 1 + sizeHelper(head.next, tail);
	}
	
	@Override
	public boolean isEmpty() {
		return head == null;
	}
	
	private boolean isValidPosition(int givenPosition) {
		return givenPosition < size() && givenPosition >= 0;
	}

	@Override
	public int compareTo(LinkedHeadTailList<T> otherList) {
		Node currentNode = head;
		Node otherCurrentNode = otherList.head;
		
		while (currentNode != null && otherCurrentNode != null) {
			if (!currentNode.data.equals(otherCurrentNode.data)) // find the fist mismatch
				return currentNode.data.compareTo(otherCurrentNode.data);
			currentNode = currentNode.next;
			otherCurrentNode = otherCurrentNode.next;
		}
		return size() - otherList.size(); // compare by size 
	}
}
