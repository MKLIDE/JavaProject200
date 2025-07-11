import java.util.*;
public class IteratorX{

   public static void main(String[] args){
	
       System.out.println("----------------Iterator---------------------");
       //Iterator -> used loop through to collections one by one.
       //Key mothods hasNext() -> checks if the are more values.
       //Note asList = fixed, thus no add, get / set method.
       /*List<String> fruits = new ArrayList<>(List.of("Apple","Banana","Cherry"));
       Iterator<String> it = fruits.iteraror();
       while(it.hasNext()){
         String fruit = it.next();
         System.out.println(fruit);
       }*/
       //remove
       //.Collection.Sort() / List.sort(comparator)
       List<String> fruits = new ArrayList<>(List.of("Apple","Banana","Cherry"));
       Collections.sort(fruits);
       System.out.println(fruits);
       List<String> fruits1 = new ArrayList<>(Arrays.asList("Apple","Banana","Cherry"));
       Collections.sort(fruits1);
       System.out.println(fruits1);
       List<String> fruits2 = Arrays.asList("Apple","Banana","Cherry");
       Collections.sort(fruits2);
       System.out.println(fruits2);

   }
}