package com.cars;

public class Car {
    private String make;
    private String model;
    private int mileage;
    private int year;
    private double price;
    private String owner;

    public Car(String make, String model, int mileage, int year, double price, String owner) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
        this.owner = owner;
    }

    // Getters
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getMileage() { return mileage; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public String getOwner() { return owner; }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-15s %-6d $%-10.2f %-10s",
                make, model, mileage, year, price, owner);
    }
}