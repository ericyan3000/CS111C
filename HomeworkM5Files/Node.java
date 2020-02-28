public class Node<T> {
	
	public T data; // Entry in list
	public Node next; // Link to next node

	public Node(T dataPortion) {
		data = dataPortion;
		next = null;
	} // end constructor

	public Node(T dataPortion, Node nextNode) {
		data = dataPortion;
		next = nextNode;
	} // end constructor

	public T getData() {
		return data;
	} // end getData

	public void setData(T newData) {
		data = newData;
	} // end setData

	public Node getNextNode() {
		return next;
	} // end getNextNode

	public void setNextNode(Node nextNode) {
		next = nextNode;
	} // end setNextNode
	
	public static <T> T findThirdFromLast(Node<T> firstNode) {
		if (firstNode == null || firstNode.next == null || firstNode.next.next == null)
			return null;
		else {
			Node<T> currentNode = firstNode;
			while (currentNode.next.next.next != null) {
				currentNode = currentNode.next;
			}
			return currentNode.data;
		}
	}
	
	// Returns the middle element in chain. If even number of elements in chain, return the second element in the middle element pairs.
	public static <T> T findMiddleElement(Node<T> firstNode) { // use double pointer
		if (firstNode == null) // empty node 
			return null;
		else if (firstNode.next == null) // singleton 
			return firstNode.data;
		else { 
			Node<T> currentNode = firstNode;
			Node<T> currentNodeDouble = firstNode;
			while (currentNodeDouble != null && currentNodeDouble.next != null) { // iterate while the double pointer has  
				currentNode = currentNode.next;
				currentNodeDouble = currentNodeDouble.next.next;
			}
			return currentNode.data;
		}
	}
} // end Node