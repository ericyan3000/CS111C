
public class VoterHashTableSeparateChaining {

	private Node<Voter>[] hashTable;
	private int tableSize;

	public VoterHashTableSeparateChaining(int size) {
		hashTable = (Node<Voter>[]) new Node[size];
		tableSize = size;
	}
	
	public int getHashTableLocation(int voterID) {
		return voterID % tableSize;
	}

	// completing extra credit.
	public boolean addVoter(Voter voterToAdd) {
		if ( voterToAdd != null) {
			int location = getHashTableLocation(voterToAdd.getId());
			// if the location is null
			if (hashTable[location] == null)
				hashTable[location] = new Node<Voter>(voterToAdd);
			// if it's occupied, add to the end if no duplicate is found
			else {
				Node<Voter> currNode = hashTable[location];
				while (currNode != null) {
					if (currNode.getData().getId() == voterToAdd.getId())
						return false;
					else {
						if (currNode.next == null) {
							currNode.next = new Node<Voter>(voterToAdd);
							break;
						}
						currNode = currNode.next;
					}
				}
			}
			return true;
		}
		else
			return false;
	}

	public Voter getVoter(int voterID) {
		int location = getHashTableLocation(voterID);
		Node<Voter> currNode = hashTable[location];
		while (currNode != null) {
			if (currNode.getData().getId() == voterID)
				return currNode.getData();
			else
				currNode = currNode.next;
		}
		return null;
	}

	public void printTable() {
		for (int i = 0; i < tableSize; i++) {
			if (hashTable[i] != null) {
				System.out.print("Location " + i + ": ");
				Node<Voter> current = hashTable[i];
				while (current != null && current.next != null) {
					System.out.print(current.data.getName() + " -> ");
					current = current.next;
				}
				System.out.println(current.data.getName());
			}
		}
	}

}
