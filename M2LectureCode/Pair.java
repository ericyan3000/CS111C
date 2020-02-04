
public class Pair<T> {
	
	private T item1, item2;
	
	public Pair(T item1, T item2) {
		this.item1 = item1;
		this.item2 = item2;
	}
	
	public T getItem1() {
		return item1;
	}
	public T getItem2() {
		return item2;
	}
	public void setItem1(T item1) {
		this.item1 = item1;
	}
	public void setItem2(T item2) {
		this.item2 = item2;
	}
	
	@Override
	public String toString() {
		return "(" + item1.toString() + " " + item2.toString() + ")";
	}
	
	public boolean sameItems() {
		return item1.equals(item2);
		// return item1==item2; INCORRECT! tests for aliases, not logical equivalence
	}
	
	public boolean contains(T item) {
		return item1.equals(item) || item2.equals(item);
	}
	
	/*
	@Override
	public boolean equals(Object other) {
		if (other instanceof Pair<?>) {
			Pair<T> otherPair = (Pair<T>) other;
			boolean check1 = otherPair.contains(item1) && otherPair.contains(item2);
			boolean check2 = this.contains(otherPair.getItem1()) && this.contains(otherPair.getItem2());
			
			return check1 && check2;
		}
		else
			return false;
	}
	*/
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Pair<?>) {
			Pair<T> otherPair = (Pair<T>) other;
			boolean check1 = item1.equals(otherPair.getItem1()) && item2.equals(otherPair.getItem2());  
			boolean check2 = item1.equals(otherPair.getItem2()) && item2.equals(otherPair.getItem1());
			
			return check1 || check2;
		}
		else 
			return false;
	}

}
