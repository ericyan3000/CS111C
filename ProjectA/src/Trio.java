
public class Trio<T> {
	private T item1, item2, item3;
	
	public Trio(T item1, T item2, T item3) {
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}
	
	public Trio(T item) {
		this(item, item, item);
	}

	public T getItem1() {
		return item1;
	}

	public void setItem1(T item1) {
		this.item1 = item1;
	}

	public T getItem2() {
		return item2;
	}

	public void setItem2(T item2) {
		this.item2 = item2;
	}

	public T getItem3() {
		return item3;
	}

	public void setItem3(T item3) {
		this.item3 = item3;
	}
	
	@Override
	public String toString() {
		return item1 + ", " + item2 + ", " + item3;
	}
	
	public void reset(T item) {
		item1 = item;
		item2 = item;
		item3 = item;
	}
	
	public int count(Object item) {
		int countItem = 0;
		
		countItem += item.equals(item1) ? 1 : 0;
		countItem += item.equals(item2) ? 1 : 0;
		countItem += item.equals(item3) ? 1 : 0;
		
		return countItem;
	}
	
	public boolean hasDuplicates() {
		return item1.equals(item2) || item2.equals(item3) || item1.equals(item3);
	}
	
	public boolean equals(Object other) {
		
		if (other instanceof Trio<?>) {
			Trio<?> otherTrio = (Trio<?>) other;
			
			// if both hold the same item with the same count
			boolean check1 = this.count(item1) == otherTrio.count(item1);
			boolean check2 = this.count(item2) == otherTrio.count(item2);
			boolean check3 = this.count(item3) == otherTrio.count(item3);
			
			// return true if all true
			return check1 && check2 && check3;
		}
		else
			return false;
	}
}
