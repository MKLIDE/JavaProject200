public class LogicalOp{
 public static void main(String[] args){
    int a = 4;
    int b = 6;
    int e = 5;
    String c = "Hello";
    String d = "Class";
    
    System.out.println("Is a:4 NO equal to b:5? "+ (a != b)); 
    System.out.println("Is a:4 equal to b:5? "+ (a == b));
    System.out.println("Is a:4 = e:5 & Is a:4 = b:5? "+ ((a == b) && ( a == b)));
    //System.out.println("Is c > d? "c > b); // can't compare a String to int.
    // ------------------ BitwiseOp ---------------------------------
    int x = 3;
    int y = 4;
    int z = 5;
    System.out.println("------------XOR (^) -------------------------\n");
    System.out.println("Is x:3 ^ y:4? "+ (x ^ y)); 
    System.out.println("------------SHIFT (>> --> x/(2^y) / << --> x/(2^y)) : sight bit - doesn't preserve a bit ---------------");
    System.out.println("Is x:3 >> y:4? "+ (x >> y));
    System.out.println("Is x:3 << y:4? "+ (x << y)); 
    System.out.println("------------SHIFT (>>> --> x/(2^y) /<<< --> x/(2^y)) : unsight bit - preserve a bit ----------");
    System.out.println("Is x:3 >>> y:4? "+ (x >>> y));
    //System.out.println("Is x:3 <<< y:4? "+ (x <<< y));


 }
}