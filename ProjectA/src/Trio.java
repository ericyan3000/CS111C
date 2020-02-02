
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
		return item1 + "\t" + item2 + "\t" + item3;
	}
	
	public void reset(T item) {
		item1 = item;
		item2 = item;
		item3 = item;
	}
	
	public int count(Object item) {
		return 1;
	}
	
	public boolean hasDuplicates() {
		return item1.equals(item2) || item2.equals(item3) || item1.equals(item3);
	}
	
	public boolean equals(Object other) {
		this.count(item1);
		
		if (other instanceof Trio<?>) {
			Trio<?> otherTrio = (Trio<?>) other;
			
			// check if otherTrio contains all items in Tiro, and vice versa
			boolean check1 = otherTrio.count(item1) > 0 && otherTrio.count(this.item2) > 0 && otherTrio.count(this.item3) > 0;
			boolean check2 = this.count(otherTrio.getItem1()) > 0  && this.count(otherTrio.getItem2()) > 0 && this.count(otherTrio.getItem3()) > 0;
			
			// return true if they contains each other
			return check1 && check2;
			
		}
		else
			return false;
	}
}
