public class RelationalOp{
 public static void main(String[] args){
    int a = 4;
    int b = 5;
    String c = "Hello";
    String d = "Class";
    
    System.out.println("Is a:4 > b:5? " + (a > b)); 
    System.out.println("Is a:4 < b:5? "+ (a < b));
    //System.out.println("Is c > d? " + (c > b)); // can't compare a String to int.

 }
}