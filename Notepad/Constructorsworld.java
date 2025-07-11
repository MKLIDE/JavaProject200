class Constructorsworld{
  int a, b, c = 10;
  String contructorName;
  {b = c; a = b;}
  Constructorsworld(int a, int b, String contructorName){
   this.a = a;
   this.b = b;
   this.constructorName = contructorName;
  }
}

public class PlayConstructor{
 public static void main(String[] args){
   Constructorsworld simpleC = new Constructorsworld();
   System.out.println("Simple Constructor Output: \n"+ "a: " + simpleC.a + "b: "+ simpleC.b +"c: "+ simpleC.c);
   
  }
}