
public class Quad<Pair> {

	private Pair pari1;
	private Pair pair2;
	
	public Quad(Pair p1, Pair p2) {
		this.pari1 = p1;
		this.pair2 = p2;
	}
	
	public String toString() {
		return pari1 + ", " + pair2;
	}

}
