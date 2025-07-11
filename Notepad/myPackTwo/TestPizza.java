
import myPack.Pizza; // myPack.* -> To imports all the classes in this package.

public class TestPizza{
 public static void main(String[] args){
    Pizza p1 = new Pizza("large",6);
    //p1 = null; // No longer visible to JVM
    p1.displayInfo();
    System.gc(); // suggesting Garbage collection
 }
}