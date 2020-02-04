
public class Quad<T, S> {

	private Pair<T> pari1;
	private Pair<S> pair2;
	
	public Quad(T item1, T item2, S item3, S item4) {
		this.pari1 = new Pair<T>(item1, item2);
		this.pair2 = new Pair<S>(item3, item4);
	}
	
	public Quad(Pair p1, Pair p2) {
		this.pari1 = p1;
		this.pair2 = p2;
	}
	
	public String toString() {
		return pari1 + ", " + pair2;
	}

}
