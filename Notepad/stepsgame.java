//package StepsGame;
import java.util.Scanner;

public class Stepsgame {
   public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);
     
     String name = getInput(sc,"Enter your name: ");
     if(name.isEmpty()) {
    		 System.out.println("Name can not be empty!!!, please enter a name");
    		 System.exit(0);
     }
     String compareName = getInput(sc,"Enter any word for comparison: ");    
     String name1 = getInput(sc,"Enter another word: ");
         	 
     
     System.out.println("Hello " + name + ", how are you today?");
     System.out.println("Number of characters " + name.length());
     System.out.println("First character of the name " + name.charAt(0));
     System.out.println("Last character of the name: " + name.charAt(name.length()-1));
     
     if(name.contains("a") || name.contains("b")) {
    	 System.out.println("Your name contains the letter 'a' or 'A'");
     }else {
    	 System.out.println("No 'a' or 'A' found in your name");
     }
     System.out.println(name1);
     String result = "";
     for(int i = 0; i < name1.length(); i++) {
    	 result = "";
    	 for(int k =0;k<=i;k++) {
    		 result += name1.charAt(k);
    	 }
    	  System.out.println(result);
     }
	
	
      for(int i = 1; i <= name1.length(); i++) {
    	if(i == 5) {
    		break;
    	}else if(i==3){
    		continue;
    	}
    	System.out.println("Counting: " + i);
    	
    	}
      
      System.out.println("Thanks, "+ name + ", for playing the String Steps Game!");
      
      System.out.println(name.equalsIgnoreCase(compareName));
      String displayName = name.concat(" "+compareName);
      System.out.println(displayName);
      
    }
	public static String getInput(Scanner sc, String prompt) {
		System.out.println(prompt);
		String input = sc.nextLine();
		return input;
		
	}
}
