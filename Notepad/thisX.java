public class ThisX{

   public static void main(String[] args){
       ThisX a = new ThisX();
       a.m();
       a.n();
   }
   void n(){
    System.out.println("hello n");
   }
   void m(){
    System.out.println("hello m");
    //m(); //same as this.m();
     this.m();
   }

}