import java.time.*;
import java.util.HashMap;

public class Fibonacci {

	public static void main(String[] args) {
		int fibNum = 5999;
		Instant start = Instant.now();
		System.out.println(fibonacciIterative(fibNum));
		Instant end = Instant.now();
		System.out.println("Iterative solution in " + Duration.between(start, end).toMillis() + " milliseconds.");
		System.out.println(iterativeMethodCounter + " passes through the loop.");
	}
	

	private static int recursiveMethodCounter = 0;
	
	public static long fibonacciRecusive(int n) {
		HashMap<Integer, Long> fibonacciMap = new HashMap<>();
		fibonacciMap.put(1, (long) 1);
		fibonacciMap.put(2, (long) 1);
		return fibonacciRecursiveHelper(n, fibonacciMap);
	}
	
	private static long fibonacciRecursiveHelper(int n, HashMap<Integer, Long> fibonacciMap) {
		recursiveMethodCounter++;
		if (n < 2) {
			return n;
		}
		else if (fibonacciMap.containsKey(n))
			return fibonacciMap.get(n);
		else {
			Long ans = fibonacciRecursiveHelper(n-1, fibonacciMap) + fibonacciRecursiveHelper(n-2, fibonacciMap);
			fibonacciMap.put(n, ans);
			return ans;
		}
	}

	private static int iterativeMethodCounter = 0;
	
	public static long fibonacciIterative(int n) { 
		long sum1 = 0, sum2 = 1;

			
		for(int i=0; i<n; i++) { 
			iterativeMethodCounter++;
			
			long temp= sum1; 
			sum1 = sum2; 
			sum2 = temp + sum2; 
		} 
		return sum1; 
	} 


}
