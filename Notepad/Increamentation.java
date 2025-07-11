public class Increamentation{
 public static void main(String[] args){
    int a = 1;
    int b = 2;
    int c = 3;
    int d = 4;
    //2 Output is has increamented by 1 and in memory the value has also increamented by 1.
    System.out.println("Pre-increament: a = " + ++a);
    //2 Output is the exact value, but in memory the value has increamented by (+1). 
    System.out.println("Post-increament: b= "+ b++);
    //2 Output is has decreamented by 1 and in memory the value has also decreamented by 1.
    System.out.println("Pre-increament: c = " + --c);
    //4 Output is the exact value, but in memory the value has decreamented by (-1).
    System.out.println("Post-increament: d = "+ d--); 
    System.out.println("------------POST vs PRE----------------");
    int i;
    int j = 15;
    i = j;
    i += 5;
    i -= 5;
    i *= 5;
    i /= 5;
    i %= 5;
    System.out.println("I is = "+ i);
    
 }
}