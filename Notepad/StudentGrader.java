import java.util.Scanner;
public class StudentGrader{
  public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      String retry = DisplayGrader(sc);

      while(retry.equals("Y") || retry.equals("y")){
      	retry = DisplayGrader(sc);
        if(retry.equals("N") || retry.equals("n")) break;
      }
      String exit = "";
      do{
           System.out.println("Do you want to exit the program? (Enter Y for Yes / Enter N for No):");
	   exit = sc.nextLine();
           if(exit.equals("Y") || exit.equals("y")){System.out.println("Exiting the program..."); break;}
       }while(exit.equals("N") || exit.equals("n"));
  }
  public static String DisplayGrader(Scanner sc){
     System.out.print("Please enter your exam score:");
     int examScore = Integer.parseInt(sc.nextLine());
     int finalScore = 0;
     if(examScore >= 40 && examScore <= 95){
        finalScore = examScore + 5;
     }else if(examScore > 95){
        finalScore = 100;
     }else{
        finalScore = examScore - 2;
      }
     

      if(finalScore >= 50){
         System.out.println("Pass");
      }else{
	 System.out.println("Fail");
      }
      
      String status = (finalScore >= 80) ? "Excellent" : (finalScore > 60 && finalScore < 79)? "Good" : "Needs Improvement";
      System.out.println("Status: "+ status);
       int lastDigit = finalScore % 10;
       System.out.println("finalScore: "+ finalScore);
       System.out.println("last digit: "+ lastDigit);
       switch(lastDigit){
	case 0: System.out.println("Nice round number!\n");break;
	case 5: System.out.println("Nice round number!\n");break;
	case 1: System.out.println("Low tail.\n");break;
	case 4: System.out.println("Low tail.\n");break;
	case 6: System.out.println("High tail.\n");break;
	case 9: System.out.println("High tail.\n");break;
	default: System.out.print("Intresting score!\n");break;
       }
      System.out.println("Do you want to retry the grading process? Enter Y for yes / Enter N for no:");
      String retry = sc.nextLine();
      return retry;
  }
}