import java.util.*;
public class PassByX{
   int x = 10;
   public static void main(String[] args){
       PassByX e = new PassByX();
       e.x = 5;
       modifyObject(e);
       System.out.println(e.x);  // Prints 10, not 5 or 20
       //pass by value
       int y = 10;
       System.out.println("--------------Ya-----------");
       PassByValue(y);
       System.out.println("outside: "+y);

   }
   public static void PassByValue(int z){
     z = 20;
     System.out.println("in the method the value is:"+z);
   }
   static void modifyObject(PassByX e) {
    e.x = 10;  // Modifies the original object's state
    e = new PassByX();  // Only changes the local reference
    e.x = 20;  // Doesn't affect the original
    System.out.println("in the method the value is:"+e.x);
   }
}