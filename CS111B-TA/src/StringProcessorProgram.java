import java.util.Scanner;

public class StringProcessorProgram{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    StringProcessor sp = new StringProcessor();
    String s1 = "";

    do{
        System.out.print("Enter a line of text: ");
        String s = scan.nextLine();
        sp.setString(s);
        System.out.println("words: " + sp.wordCount());
        System.out.println("uppercase: " + sp.uppercaseCount());
        System.out.println("digits: " + sp.digitCount());
        System.out.println("no space: " + sp.getNoSpaceString());
        System.out.println("no vowel: " + sp.getNoVowelString());
        System.out.println("no digits: " + sp.getNoDigitWordString());
        System.out.println(sp.digitWordCount());

        System.out.print("do you want to enter another? (y/n): ");
        s1 = scan.nextLine();
        s1.toLowerCase();
    } while(s1.equals("y"));
  }
}
