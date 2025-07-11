import java.util.*;
public class GenericX{
   public static void main(String[] args){
       //list -> Interface and bigger
       //Arraylist -> class and smaller
       //List Inter = new ArrayList(); -> can take any object 
       

       List<String> list = new ArrayList<>();
       list.add("South Africa"); 
       list.add("Lesotho");
       list.add("Zimbabwe");
       list.remove(1); // lesotho is removed
       list.remove("South Africa");
       list.add("China");
       list.set(2, "Congo");
       list.remove(1);
       list.contains("South Africa");
       list.isEmpty();
       
       System.out.println(list);
       System.out.println(list.size());
       System.out.println(list.contains("Congo"));
       System.out.println(list.contains("South Africa"));
       System.out.println(list.contains("First item: " + list.get(0)));
       System.out.println(list.contains("First item: " + list.get(46))); //-1 does not exist
       System.out.println(list.contains("First item: " + list.lastIndexOf("China")));
       System.out.println("List size: "+ list.size());
       List<String> list2 = new ArrayList<>();
       System.out.println(list.equals(list2));

       list.clear();

       System.out.println("List size: "+ list.size());
      
       
   }
}