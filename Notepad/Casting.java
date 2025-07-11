//widening -> Automatic (small - big)
//Narrowing -> Manual (Big - small)
//Value overflow -> byte b = 127; b = (byte)(b+1) = -128 due to number being too big, and the opp is also true.

public class Casting{
 public static void main(String[] args){
    int a = -128;
    int b = 127;
    double c = 50.50;
    int resultA = (int)(c + 1);
    byte resultB = (byte)(b + 1);
    byte resultC = (byte)(a - 1);
    System.out.println("Casting double num to int: " + resultA); 
    System.out.println("Casting int num to byte: "+ resultB);
    System.out.println("Casting int num to byte: "+ resultC);

 }
}