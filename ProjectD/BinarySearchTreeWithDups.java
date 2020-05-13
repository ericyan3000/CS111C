import java.util.*;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
		implements SearchTreeInterface<T>, java.io.Serializable {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	@Override
	public T add(T newEntry) {
		T result = newEntry;
		if (isEmpty()) {
			setRootNode(new BinaryNode<T>(newEntry));
		} else {
			addEntryHelperNonRecursive(newEntry);
		}
		return result;
	}
	
	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	private void addEntryHelperNonRecursive(T newEntry) {
		// keep going until the newEntry is added
		BinaryNode<T> currRoot = getRootNode();
		boolean added = false;
		while (!added) {
			int comparison = newEntry.compareTo(currRoot.getData());
			// if smaller or equals to current root
			if (comparison <= 0 ) {
				if (currRoot.hasLeftChild())
					currRoot = currRoot.getLeftChild();
				else {
					currRoot.setLeftChild(new BinaryNode<T>(newEntry));
					added = true;
				}
			}
			// if larger than current root
			else {
				if (currRoot.hasRightChild())
					currRoot = currRoot.getRightChild();
				else {
					currRoot.setRightChild(new BinaryNode<T>(newEntry));
					added = true;
				}
			}
		}
		
	}


	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countEntriesNonRecursive(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> currentNode = getRootNode();

		// consider a loop!
		// keep looping until hits a leaf
		while (!(currentNode == null)) {
			int comparison = target.compareTo(currentNode.getData());
			// if equals or smaller than currentNode
			if (comparison <= 0) {
				if (comparison == 0)
					count += 1;
				if (currentNode.hasLeftChild())
					currentNode = currentNode.getLeftChild();
				else
					currentNode = null;
			}
			// if larger than currentNode
			else {
				if (currentNode.hasRightChild())
					currentNode = currentNode.getRightChild();
				else
					currentNode = null;
			}
		}
		
		return count;
	}

	// YOUR CODE HERE! MUST BE RECURSIVE! YOU ARE ALLOWED TO CREATE A PRIVATE HELPER.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countGreaterRecursive(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> rootNode = getRootNode();
		
		// consider a helper method!
		count = countGreaterRecursiveHelper(target, rootNode);
		
		return count;
	}
	
	private int countGreaterRecursiveHelper(T target, BinaryNode<T> currNode) {
		int count = 0;
		int comparison = target.compareTo(currNode.getData());
		//System.out.println(comparison);
		
		if (comparison <= 0) {
			if (comparison < 0)
				count++;
			if (currNode.hasRightChild()) 
				count += currNode.getRightChild().getNumberOfNodes();
			if (comparison < 0 && currNode.hasLeftChild())
				count += countGreaterRecursiveHelper(target, currNode.getLeftChild());
		}
		else if (comparison > 0) {
			if (currNode.hasRightChild()) 
				count += countGreaterRecursiveHelper(target, currNode.getRightChild());
		}
	
		return count;
	}
		
	// YOUR CODE HERE! MUST USE A STACK!! MUST NOT BE RECURSIVE! 
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countGreaterWithStack(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> rootNode = getRootNode();
		Stack<BinaryNode<T>> nodeStack = new Stack<BinaryNode<T>>();
		nodeStack.push(rootNode);

		// consider a loop based on the stack!
		while (!nodeStack.isEmpty()) {
			BinaryNode<T> currNode = nodeStack.pop();
			int comparison = target.compareTo(currNode.getData());
			
			// if target smaller or equals currNode
			if (comparison <= 0 ) {
				if (comparison < 0)
					count += 1;
				if (currNode.hasRightChild())
					count += currNode.getRightChild().getNumberOfNodes();
				if (currNode.hasLeftChild())
					nodeStack.push(currNode.getLeftChild());
			}
			// if target larger than currNode
			else {
				if (currNode.hasRightChild())
					nodeStack.push(currNode.getRightChild());
			}
		}
		return count;
	}
		
	// YOUR EXTRA CREDIT CODE HERE! THIS METHOD MUST BE O(n). 
	// YOU ARE ALLOWED TO USE A HELPER METHOD. THE METHOD CAN BE ITERATIVE OR RECURSIVE. 
	public int countUniqueValues() {
		Set<T> dupSet = new HashSet<T>();
		BinaryNode<T> rootNode = getRootNode();
		recursiveCountUniqueValue(rootNode, dupSet);
	
		return dupSet.size();
	}
	
	private void recursiveCountUniqueValue(BinaryNode<T> node, Set<T> dupSet) {
		if (node != null) {
			
			if (!dupSet.contains(node.getData()))
				dupSet.add(node.getData());
			
			recursiveCountUniqueValue(node.getLeftChild(), dupSet);
			recursiveCountUniqueValue(node.getRightChild(), dupSet);
		}
	} 
	
	
	public int getLeftHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasLeftChild()) {
			return 0;
		} else {
			return rootNode.getLeftChild().getHeight();
		}
	}

	public int getRightHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasRightChild()) {
			return 0;
		} else {
			return rootNode.getRightChild().getHeight();
		}
	}
	


}