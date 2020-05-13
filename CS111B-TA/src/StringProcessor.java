public class StringProcessor{
  private String str;
  public StringProcessor(){
      str = "";
  }
  public StringProcessor(String s){
      str = s;
  }
  public void setString(String s){
      str = s;
  }
  public String getString(){
      return str;
  }

  public int wordCount(){
    int count = 0;
    for(int i = 0; i < str.length(); i++){
      if(str.charAt(i) == ' '){
          count++;
      }
    }
    count++;
    return count;
  }

  public int uppercaseCount(){
    int count = 0;
    for(int i = 0; i < str.length(); i++){
      if(Character.isUpperCase(str.charAt(i))){
          count++;
      }
    }
    return count;
  }

  public int digitCount(){
    int count = 0;
    for(int i = 0; i < str.length(); i++){
      if(Character.isDigit(str.charAt(i))){
          count++;
      }
    }
    return count;
  }

  public int digitWordCount(){
    int ori = 0;
    int loc = str.indexOf(" ");
    int count = 0;

    while(loc != -1){
        String word = str.substring(ori, loc);
        String s = word.toLowerCase();
        if(s.equals("zero") || s.equals("one") || s.equals("two") || 
        s.equals("three") || s.equals("four") || s.equals("five") ||
        s.equals("six") || s.equals("seven") || s.equals("eight") ||
        s.equals("nine"))
        {
            count++;
        }
        ori = loc + 1;
        loc = str.indexOf(" ", ori);
    }

    String s = str.substring(ori);
    s = s.toLowerCase();
    
    if(s.equals("zero") || s.equals("one") || s.equals("two") || 
    s.equals("three") || s.equals("four") || s.equals("five") ||
    s.equals("six") || s.equals("seven") || s.equals("eight") ||
    s.equals("nine")){
        count++;
    }
    return count;
  }

  public String getNoSpaceString(){
    String s = "";
    for(int i = 0; i < str.length(); i++){
      if(str.charAt(i) != ' '){
          s = s + str.charAt(i);
      }
    }
    return s;
  }

  public String getNoVowelString(){
    String s = "";
    for(int i = 0; i < str.length(); i++){
      if(str.charAt(i) != 'a' && str.charAt(i) != 'A' && str.charAt(i) != 'e' &&
      str.charAt(i) != 'E' && str.charAt(i) != 'i' && str.charAt(i) != 'I' &&
      str.charAt(i) != 'o' && str.charAt(i) != 'O' && str.charAt(i) != 'u' &&
      str.charAt(i) != 'U'){
          s = s + str.charAt(i);
      }
    }
    return s;
  }

  public String getNoDigitWordString(){
    String s = "";
    for(int i = 0; i < str.length(); i++){
      if(!Character.isDigit(str.charAt(i))){
          s = s + str.charAt(i);
      }
    }
    return s;
  }
}