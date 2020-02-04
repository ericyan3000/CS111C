
public class PairTester {

	public static void main(String[] args) {
		Pair<Integer> numberPair = new Pair<Integer>(3,4);
		Pair<Integer> numberPair2 = new Pair<Integer>(4,3);
		Pair<Integer> numberPair3 = new Pair<Integer>(4,4);
		Pair<String> wordPair = new Pair<String>("hello", "goodbye");
		
		System.out.println(numberPair);
		System.out.println(wordPair);
		
		System.out.println("same pair False : " + numberPair.equals(wordPair));
		System.out.println("same pair True : " + numberPair.equals(numberPair2));
		System.out.println("same pair False : " + numberPair3.equals(numberPair2));
		
		// testing our sameItems method
		String s1 = new String("apple");
		String s2 = new String("apple");
		Pair<String> wordPair2 = new Pair<String>(s1, s2);
		System.out.println("wordPair2 contains the same items? " + wordPair2.sameItems());
		
		PairDifferent<Integer,String> numberWordPair = new PairDifferent<Integer,String>(2, "hello");
		PairDifferent<Integer,Integer> doubleNumberPair = new PairDifferent<Integer,Integer>(1,1);
		
		Quad<Integer, String> quadTest = new Quad<Integer, String>(numberPair, wordPair);
		Quad<Integer, String> quadTest2 = new Quad<Integer, String>(3, 4, "hello", "world");
		
		System.out.println(quadTest);
		System.out.println(quadTest2);

	}

}
