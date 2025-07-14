package com.cars;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarManager manager = new CarManager();

        System.out.println("Car Management System");

        while (true) {
            System.out.println("\nCurrent Owner: " +
                    (manager.getCurrentOwner() != null ?
                            manager.getCurrentOwner().getName() : "None"));

            System.out.println("1. Add new owner");
            System.out.println("2. Switch owner");
            System.out.println("3. Add car to current owner");
            System.out.println("4. Remove car from current owner");
            System.out.println("5. View current owner's cars");
            System.out.println("6. View all cars (manual + owners)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter owner name: ");
                    String name = scanner.nextLine();
                    manager.addOwner(name);
                    System.out.println("Owner added successfully!");
                    break;

                case 2:
                    if (manager.getCurrentOwner() == null) {
                        System.out.println("No owners available. Please add an owner first.");
                        break;
                    }
                    manager.displayOwners();
                    System.out.print("Select owner number: ");
                    int ownerNum = scanner.nextInt();
                    scanner.nextLine();
                    manager.switchOwner(ownerNum - 1);
                    break;

                case 3:
                    if (manager.getCurrentOwner() == null) {
                        System.out.println("No owner selected. Please add or select an owner first.");
                        break;
                    }
                    System.out.print("Enter make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    Car newCar = new Car(make, model, year, price, manager.getCurrentOwner().getName());
                    manager.getCurrentOwner().addCar(newCar);
                    System.out.println("Car added successfully!");
                    break;

                case 4:
                    if (manager.getCurrentOwner() == null) {
                        System.out.println("No owner selected. Please add or select an owner first.");
                        break;
                    }
                    System.out.print("Enter make of car to remove: ");
                    String rMake = scanner.nextLine();
                    System.out.print("Enter model of car to remove: ");
                    String rModel = scanner.nextLine();

                    boolean removed = manager.getCurrentOwner().removeCar(rMake, rModel);
                    if (removed) {
                        System.out.println("Car removed successfully!");
                    } else {
                        System.out.println("Car not found.");
                    }
                    break;

                case 5:
                    if (manager.getCurrentOwner() == null) {
                        System.out.println("No owner selected. Please add or select an owner first.");
                        break;
                    }
                    displayCars(manager.getCurrentOwner().getCars());
                    break;

                case 6:
                    displayCars(manager.getAllCars());
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayCars(List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("No cars to display.");
            return;
        }

        System.out.println("\nList of Cars:");
        System.out.println(String.format("%-10s %-15s %-6s %-12s %-10s",
                "Make", "Model", "Year", "Price", "Owner"));
        System.out.println("--------------------------------------------------");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}