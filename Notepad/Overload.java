import java.util.*;


//How overloading works?
//Java calls the method that matches the argument that you have specified.
public class OverLoad{

   public static void main(String[] args){
	OverLoad OLoad = new OverLoad();
        OLoad.add(1,2);
	OLoad.add(1,2,3);
	OLoad.add(1,2,3,4);
   }
   public void add(int a, int b){
     System.out.println("add two numbers");
     System.out.println("Sum = "+(a+b));
   }
   public void add(int a, int b, int c){
     System.out.println("add three numbers");
     System.out.println("Sum = "+(a+b+c));
   }
   public void add(int a, int b, int c, int d){
     System.out.println("add four numbers");
     System.out.println("Sum = "+(a+b+c+d));
   }
}