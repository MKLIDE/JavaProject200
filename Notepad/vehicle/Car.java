package vehicle;
import java.util.Scanner;
class Car{
  private String model;
  private int year;
  private double price;
  {
    System.out.println("Initializing");
  }
  public Car(String model, int year, double price){
   this.model = model;
   this.year = year;
   this.price = price;
  }
  public void displayDetails(){
   System.out.println("Car Model: "+ model);
   System.out.println("Car Year: "+ year);
   System.out.println("Car Price: R"+ price);
  }
  
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter car model: ");
    String model = sc.nextLine();
    System.out.println("Enter Car year: ");
    int year = Integer.parseInt(sc.nextLine());
    System.out.println("Enter car Price: ");
    double price = Double.parseDouble(sc.nextLine());
    Car c1 = new Car(model,year,price);
    c1.displayDetails();
    sc.close();
    
   
  }
}