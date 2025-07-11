import java.util.Scanner;
public class Analyzer{
 	
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            //1
	    System.out.println("Enter / type any sentence: ");
	    String sentence = sc.nextLine();
            //2
	    sentence = sentence.trim();
	    //3
	    sentence = sentence.toLowerCase();
 	    String[] words = sentence.split(" ");
	    for(String w : words){
		 System.out.println(w+"\n");
	    }
	    //4
	    //a
            System.out.println("First word's length: "+words[0].length());
	    //b
	    System.out.println("Index of 'a': "+words[0].indexOf("a"));
	    //c
            System.out.println("Does the 1st word start 'J' and ends with 'G': "+(words[0].startsWith("j") && words[0].endsWith("g")));
            //d
	    int value = words[0].length();
            String str = String.valueOf(value);
	    System.out.println("Length of the 1st word using value of: "+str);
	    //5
            System.out.println("Please type a second word: ");
	    String secWord = sc.nextLine();
 	    if(words[0].compareTo(secWord) < 0){
		System.out.println("Second word comes before.");
	    }else if(words[0].compareTo(secWord) > 0){
		System.out.println("Second word comes after.");
	    }else{
		System.out.println("Both words are the same.");
	    }
            //6
	     if(words[0].intern() == secWord.intern()){
		System.out.println("Both the first word("+words[0]+") and the second("+secWord+") refers to the same object.");
	     }else{
		System.out.println("First word("+words[0]+") and the second("+secWord+") do not refer to the same object.");
	     }
	    //7
	    String finalOutput = String.format("Thank you");
	    System.out.println(finalOutput);
	    //8
	    int counter = 0;
	    for(String w : words){
		  counter++;
	    }
	    System.out.println("number of words in sentence: "+counter);
	    //9 
	    /*String joinedWords = words[0];
            for(int i = 0;i < counter - 1; i++){
	          if(i != (counter - 1)) {joinedWords += String.join(",")};
		  joinedWords += words[i];
            }*/
	    String joinedWords = "";
            for(int i = 0;i < counter; i++){
	          joinedWords += String.join(", ",words[i]);
            }
	    System.out.println("Joined words: "+ joinedWords);
	    //10
            System.out.println("Please type a third word: ");
	    String thirdWord = sc.nextLine();
	    if(words[0].compareTo(secWord) <= 0 && words[0].compareTo(thirdWord) <= 0){
		System.out.println("first word("+words[0]+") comes before both word 2("+secWord+") and word 3("+thirdWord+") ");
	    }else if(words[0].compareTo(secWord) >= 0 && secWord.compareTo(thirdWord) <= 0){
		System.out.println("Second word("+secWord+") comes before both word 1("+words[0]+") and word 3("+thirdWord+")");
	    }else{
		System.out.println("Third("+thirdWord+") word comes first before both word 1("+words[0]+") and word 2("+secWord+")");
	    }

    
	}
}