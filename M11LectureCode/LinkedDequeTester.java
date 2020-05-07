public class LinkedDequeTester {

	public static void main(String[] args) {
		// *** to use, temporarily make the firstNode and lastNode in LinkedDeque public 
		// (note I also made parts of the DLNode class public)
		LinkedDeque<String> wordDeque = new LinkedDeque<String>();
		
		printDeque(wordDeque);
		wordDeque.addToBack("amps");
		printDeque(wordDeque);
		wordDeque.addToBack("bank");
		printDeque(wordDeque);
		wordDeque.addToFront("card");
		printDeque(wordDeque);
		wordDeque.addToFront("door");
		printDeque(wordDeque);
		wordDeque.removeFront();
		printDeque(wordDeque);
		wordDeque.removeBack();
		printDeque(wordDeque);
		wordDeque.removeFront();
		printDeque(wordDeque);
		wordDeque.removeBack();
		printDeque(wordDeque);
		
		String str1 = "abccba";
		String str2 = "abc";
		String str3 = "a";
		String str4 = "";
		String str5 = "aa";
		String str6 = "aba";
		
		System.out.println(isPalindrome(str6));
		System.out.println(isPalindrome(str1));
		System.out.println(isPalindrome(str2));
		System.out.println(isPalindrome(str3));
		System.out.println(isPalindrome(str4));
		System.out.println(isPalindrome(str5));
		
	}

	private static void printDeque(LinkedDeque deque) {
		
		LinkedDeque.DLNode currentFirst = deque.firstNode;
		LinkedDeque.DLNode currentLast = deque.lastNode;
		if(currentFirst==null) {
			System.out.println("Front: null \tBack: null");
		} else if(currentFirst==currentLast) {
			System.out.println("Front: " + deque.firstNode.data + "\tBack: " + deque.lastNode.data+"\t"+deque.lastNode.data);
		} else {
			System.out.print("Front: " + deque.firstNode.data + "\tBack: " + deque.lastNode.data+"\t");
			System.out.print(currentFirst.data + " <--> ");
			currentFirst = currentFirst.next;
			while(currentFirst.next != null) {
				System.out.print(currentFirst.data + " <--> ");
				currentFirst = currentFirst.next;
				
			}
			System.out.println(currentFirst.data);
		}
	}
	
	public static boolean isPalindrome(String word) {
		int wordLength = word.length();
		if (wordLength <= 0)
			return false;
		else {
			int i = 0;
			DequeInterface<Character> charDeque = new LinkedDeque<Character>();
			while (i < wordLength / 2) {
				charDeque.addToBack(word.charAt(i));
				i++;
			}
			if (wordLength % 2 != 0)
				i++;
			while ( i < wordLength) {
				if (charDeque.removeBack() != word.charAt(i)) {
					return false;
				}
				i++;
			}
			return true;
		}
	}
	
}