package myPack;
public class Pizza{
  String size;
  int slices; 
  //simple constructor
  public Pizza(String size, int slices){
    System.out.println("Creating a pizza");
    this.size = size;
    this.slices = slices;
  }
  public void displayInfo(){
   System.out.println("Size: "+ "---> " + size);
   System.out.println("Slices: "+"---> "+ slices);
  }
}