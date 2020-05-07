import java.util.*;

public class BalanceParenthesisChecker {

	public static void main(String[] args) {
		String balance1 = "(a+(b+[c-d]/{e+f})-g)";
		String unbalance1 = "{a-b*(b+c)-d]";
		String unbalance2 = "(a+b*(d+e-f)+g)*{h+i";
		String unbalance3 = "a * ( b / { c + ( d - e ) } * f )";
		
		System.out.println(balance1 + " balanced?");
		System.out.println("true : " + isBalanced(balance1) +"\n");
		System.out.println(unbalance1 + " balanced?");
		System.out.println("false : " + isBalanced(unbalance1) +"\n");
		System.out.println(unbalance2 + " balanced?");
		System.out.println("false : " + isBalanced(unbalance2) +"\n");
		System.out.println(unbalance3 + " balanced?");
		System.out.println("false : " + isBalanced(unbalance3) +"\n");

		String str1 = "abccba";
		String str2 = "";
		String str3 = "a";
		String str4 = "abcabc";
		
		System.out.println(isPalindrome(str1));
		System.out.println(isPalindrome(str2));
		System.out.println(isPalindrome(str3));
		System.out.println(isPalindrome(str4));
	}
	
	public static boolean isPalindrome(String text) {
		if (text.length() == 0) 
			return false;
		else if (text.length() == 1)
			return true;
		else {
			StackInterface<Character> temp = new LinkedStack<Character>();
			temp.push(text.charAt(0));
			for (int i = 1; i < text.length(); i++) {
				if (text.charAt(i) != temp.peek()) 
					temp.push(text.charAt(i));
				else
					temp.pop();
			}
			return temp.isEmpty();
		}
	}

	public static boolean isBalanced(String expression) {
		Stack<Parenthesis> stack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char currentChar = expression.charAt(i);
			
			if(Parenthesis.isParenthesis(currentChar)) { // we have a parenthesis!
				
				Parenthesis currentParens = new Parenthesis(currentChar);
				
				if(currentParens.isOpen()) {
					stack.push(currentParens);
				} else { // currentParen.isClosed()
					if(stack.isEmpty()) { // no open parens to match up!
						System.out.println("Unbalanced because extra closed parenthesis.");
						return false;
					} else {
						Parenthesis mostRecentOpenParens = stack.pop();
						
						if(!currentParens.isMatch(mostRecentOpenParens)) {
							System.out.println("Unbalanced because mismatched parentheses.");
							return false;
						}
					} // closing of my stack being non-empty
				} // closing of my else for finding a closed parenthesis
			} // closing of my conditional for finding any type of parenthesis
		} // closing of my for loop- means we've parsed the entire expression and haven't found any problems
		
		if(stack.isEmpty()) {
			System.out.println("Balanced!");
			return true;
		} else {
			System.out.println("Unbalanced because extra open parenthesis.");
			return false;
		}
	}

}
