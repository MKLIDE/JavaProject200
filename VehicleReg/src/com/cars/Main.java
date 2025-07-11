package com.cars;
//import java.awt.*;
import java.time.Duration;
//import java.time.LocalDate;
import java.time.LocalTime;
//import java.time.Period;
import java.util.Collection;
//import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
//import com.cars.Car;
public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        ArrayList<Owner> owners = new ArrayList<>();
        ArrayList<Car> cars = new ArrayList<>();

        System.out.println("Welcome");
        System.out.println("(1) Are here as a visitor\n" +
                "(2) Car owner.");
        int visitorMenu = sc.nextInt();

        if(visitorMenu == 1){
            Car carTest1 = new Car();
            //test purpose
            //Car 1
            carTest1.setMake("BMW");
            carTest1.setModel("M5");
            carTest1.setPlateNumber("AAA56GP");
            carTest1.setVin("123");
            carTest1.setYear(2025);
            carTest1.setMileage(3000);
            cars.add(carTest1);
            Car carTest2 = new Car();
            //Car 2
            carTest2.setMake("Audi");
            carTest2.setModel("RS3");
            carTest2.setPlateNumber("AAA66GP");
            carTest2.setVin("333");
            carTest2.setYear(2021);
            carTest2.setMileage(2000);
            cars.add(carTest2);

            while(visitorMenu == 1){
                if(cars.isEmpty()) {
                    //do nothing
                }else{

                    System.out.println();
                    System.out.println("Welcome to cars browser: \n" +
                            "(1) View all vehicle reports in the system.\n" +
                            "(2) View a specific vehicle report in the system.\n" +
                            "(3) Display all vehicles starting from best to least for a purchase.\n" +
                            "(4) Exit app.");
                    int menuOption = sc.nextInt();
                    if(menuOption == 2) {
                        while (menuOption == 2) {
                            int counterA = 0;

                            for (Owner owner1 : owners) {
                                System.out.println(owner1.displayOwnerInfo());
                            }
                            System.out.println();
                            System.out.println("(1) Add another vehicle details to your list\n" +
                                    "(2) View all vehicle reports\n" +
                                    "(3) View a specific vehicle report\n" +
                                    "(4) Exit app.");
                            menuOption = sc.nextInt();
                            if(menuOption == 3){
                                displaySpeceficCars(sc,menuOption,cars);
                            }
                        }
                    }else if(menuOption == 3){
                        displaySpeceficCars(sc,menuOption, cars);
                    }

                }




            }

        }if(visitorMenu == 2){


        }else{

        }
        System.out.println("(1) Please capture vehicle details\n" +
                "(4) Exit app.");
        int menuOption = sc.nextInt();

        //testing
        // System.out.println("Logged: " +menuOption);
        while(menuOption == 1 || menuOption == 2){
                System.out.println("Enter your name: ");
                String name = sc.nextLine();
                System.out.println("Enter your surname: ");
                String surname = sc.nextLine();
                System.out.println("Enter your email: ");
                String email = sc.nextLine();
                System.out.println("Enter your address: ");
                String cellNumber = sc.nextLine();
                System.out.println("Enter your address: ");
                String address = sc.nextLine();
                System.out.println("Enter number of cars you own: ");
                int numCars = sc.nextInt();

               int year = 0;
               int mileage = 0;
               String make = "";
               String model = "";
               String plateNum = "";
               String vinNum = "";
               Car carObj = new Car();

                   System.out.println("Enter make: ");
                   make = sc.next();

                   System.out.println("Enter model: ");
                   model = sc.next();

                   System.out.println("Enter vin: ");
                   vinNum = sc.next();

                   while (!(vinNum.length() == 3)) {//it's usually 17 numbers
                       System.out.println("Enter vin and ensure its 17 characters long");
                       vinNum = sc.next();
                   }

                   System.out.println("Please enter (1) for old format license plate number, and (2) for the current one: ");
                   int plateChoice = sc.nextInt();
                   if (plateChoice == 1) {
                       System.out.println("Enter plate number e.g. AAA555GP");
                       plateNum = sc.next();
                   } else if (plateChoice == 2) {
                       System.out.println("Enter plate number e.g. AA66BBGP");
                       plateNum = sc.next();
                   }
                   System.out.println("Enter mileage: ");
                   mileage = sc.nextInt();

                   System.out.println("Enter year: ");
                   year = sc.nextInt();

                   carObj.setMake(make);
                   carObj.setModel(model);
                   carObj.setPlateNumber(plateNum);
                   carObj.setVin(vinNum);
                   carObj.setYear(year);
                   carObj.setMileage(mileage);
                   cars.add(carObj);
                   System.out.println(make +" "+model+" has been captured under "+name+" "+surname+" in the system.");
                   //Best cars first (sorting using % of mileage and year)
                   CarSorter.sortCars(cars);
                   Owner owner = new Owner(name,surname,email,cellNumber,address,numCars,cars);

                    if(cars.isEmpty()) {
                        System.out.println();
                        System.out.println("There are no cars captured under your name.");
                        System.out.println("(1) Please capture vehicle details\n" +
                                "(3) Exit app.");
                        menuOption = sc.nextInt();
                    }else{
                        owners.add(owner);
                        System.out.println();
                        System.out.println("(1) Add another vehicle details to your list \n" +
                                "(2) View all vehicle reports\n" +
                                "(3) View a specific vehicle report\n" +
                                "(4) Exit app.");
                        menuOption = sc.nextInt();
                        if(menuOption == 2) {
                            while (menuOption == 2) {
                                int counterA = 0;

                                for (Owner owner1 : owners) {
                                    System.out.println(owner1.displayOwnerInfo());
                                }
                                System.out.println();
                                System.out.println("(1) Add another vehicle details to your list\n" +
                                        "(2) View all vehicle reports\n" +
                                        "(3) View a specific vehicle report\n" +
                                        "(4) Exit app.");
                                menuOption = sc.nextInt();
                                if(menuOption == 3){
                                    displaySpeceficCars(sc,menuOption,cars);
                                }
                            }
                        }else if(menuOption == 3){
                            displaySpeceficCars(sc,menuOption, cars);
                        }

                    }




        }
        System.out.println("Thanks for using the app.");
    }

    public static void displaySpeceficCars(Scanner sc, int menuOption, Collection<Car> cars){
        while (menuOption == 3) {
            int selectedCarOption = 0;
            int counter = 0;
            for (Car obcar : cars) {
                counter++;
                System.out.println("choose vehicle options below:");
                System.out.println("("+counter+") Vehicle " + counter + ","+obcar.getMake()+ "-"+obcar.getModel());
            }
            selectedCarOption = sc.nextInt();

            int carscounter = 0;
            for(Car obcar : cars){
                carscounter++;
                if(carscounter == selectedCarOption){
                    System.out.println("**********************************\n" +
                            "VEHICLE " + carscounter + "\n" +
                            "*********************************************");
                    System.out.println("MAKE: " + obcar.getMake());
                    System.out.println("MODEL: " + obcar.getModel());
                    System.out.println("PLATE NUMBER: " + obcar.getPlateNumber());
                    System.out.println("VIN NUMBER: " + obcar.getVin());
                    System.out.println("CAR YEAR: " + obcar.getYear());
                    System.out.println("CAR MILEAGE: " + obcar.getMileage());
                }
            }

            System.out.println();
            System.out.println("(1) Add another vehicle details to your list\n" +
                    "(2) View all vehicle reports\n" +
                    "(3) View a specific vehicle report\n" +
                    "(4) Exit app.");
            menuOption = sc.nextInt();
        }
    }

}
