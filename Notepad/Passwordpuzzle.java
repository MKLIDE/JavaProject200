import java.util.Scanner; 
public class Passwordpuzzle{
 public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
        int numWords = Integer.parseInt(getUserInfo(sc,"How many words do you want to use?"));
        String userWords = getUserInfo(sc,"Enter the words: ");
        
        String[] words = new String[numWords];
        for(int i = 0; i < words.length; i++){
           words[i] = userWords.split(" ");
           
        }
        int counter = 0;
        for(String word: words){
            word = word.trim().toLowerCase().chatAt(word.length()-(word.length()-1)).toUpperCase();
            counter++;
            System.out.println(counter+"-"+word);
        }
        int[] twoNum = new int[2];
        for(int i = 0; i < twoNum.leng - 1 ; i++){
            int chosenNum = Integer.parseInt(getUserInfo(sc,"Choose two numbers: ");
        }
        
        for(int i = 0; i < words.length; i++){
            if(
        }
             
   
  }
 public static String getUserInfo(Scanner sc, String prompt){
	System.out.println(prompt); 
        return sc.nextLine();
 }
}