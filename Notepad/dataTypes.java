public class DataTypes{

   //Note! local v do not have default value, but Instance variable do (0 by default).
   //Static v always run before instance v
    char c;
    boolean what;
    int a,b,d = 10;
    {b = d; a = b;} 
    int x = returnLocalV();
    static int y = 2;
    String name;
   
   Public static void main(String[] args){
     int z = 2;
     byte eyes = 2;
     short legs = 2;
     //short fnc = eyes * legs; incompatible types
     int fnc = eyes * legs;
     //int computer training = 3; 
     int computer_training = 4;
     //float temp = 1.3;  lossy conversion from double to float
     float temp = 1.3f;
     double measure = 2.3;
     long fingers = 100000;
     System.out.println(fnc);
     System.out.println(computer_training);
     System.out.println(temp);
     System.out.println(measure);
     System.out.println(fingers);
     System.out.println("-----------------types of variables-------------------");
     DataTypes eTypes = new DataTypes();
     DataTypes vTypes = new DataTypes(eTypes.d,eTypes.d);
     System.out.println("Local v: "+z+" instnace v: "+vTypes.x+" static v: "+y);
     System.out.println("-----------------Marking-------------------"); 
     //System.out.println("value = "+eTypes.name);
     
   }
   public int returnLocalV(){
     int z = 4;
     return z;
   } 

}