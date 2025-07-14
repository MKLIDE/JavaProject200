package com.cars;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Owner> owners = new ArrayList<>();
    private List<Car> manualCars = new ArrayList<>();
    private Owner currentOwner;

    public CarManager() {
        // Initialize with some manual cars
        manualCars.add(new Car("Toyota", "Camry", 12223,2020, 25000, "Dealership"));
        manualCars.add(new Car("Honda", "Accord", 20034, 2019,23000, "Dealership"));
        manualCars.add(new Car("Ford", "Raptor", 30000, 2024,50000, "Dealership"));
        manualCars.add(new Car("Toyota", "Hilux", 11000, 2022,24000, "Dealership"));
        manualCars.add(new Car("BMW", "7 Series", 567778, 2019, 40000, "Dealership"));
    }

    public void addOwner(String name) {
        owners.add(new Owner(name));
        currentOwner = owners.get(owners.size() - 1);
    }

    public Owner getCurrentOwner() { return currentOwner; }

    public List<Car> getAllCars() {
        List<Car> allCars = new ArrayList<>(manualCars);
        for (Owner owner : owners) {
            allCars.addAll(owner.getCars());
        }
        return allCars;
    }

    public void displayOwners() {
        System.out.println("\nAvailable Owners:");
        for (int i = 0; i < owners.size(); i++) {
            System.out.println((i+1) + ". " + owners.get(i).getName());
        }
    }

    public void switchOwner(int index) {
        if (index >= 0 && index < owners.size()) {
            currentOwner = owners.get(index);
        }
    }
}
