package com.cars;

import java.util.ArrayList;

public class Owner {

    private String name;
    private String surname;
    private String address;
    private String number;
    private String email;
    private ArrayList<Car> myCars;
    private int numCars;

    public Owner(String name,String surname, String email, String number, String address,int numCars, ArrayList<Car> myCars) {
        this.name = name;
        this.myCars = myCars;
        this.email = email;
        this.number = number;
        this.address = address;
        this.surname = surname;
        this.numCars = numCars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public int getNumCars() {
        return numCars;
    }

    public void setNumCars(int numCars) {
        this.numCars = numCars;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Car> getMyCars() {
        return myCars;
    }

    public void setMyCar(ArrayList<Car> myCars) {
        this.myCars = myCars;
    }
    public String displayOwnerInfo() {
        StringBuilder str = new StringBuilder();
        String str1 = "Name: " + name+ "\n"+
                "Surname: " + surname+ "\n"+
                "Email: " + email+ "\n"+
                "Contact: " + number+ "\n"+
                "Address: " + address+ "\n";
        str.append(str1);
        int i = 0;
        for(Car car: myCars){
            String str2 = "**********************************\n" +
                    "VEHICLE " +myCars.get(i)+ "\n" +
                    "*********************************************\n"+
                    "MAKE: " + car.getMake()+ "\n"+
                    "MODEL: " + car.getModel()+ "\n"+
                    "PLATE NUMBER: " + car.getPlateNumber()+ "\n"+
                    "VIN NUMBER: " + car.getVin()+ "\n"+
                    "CAR YEAR: " + car.getYear()+ "\n"+
                    "CAR MILEAGE: " + car.getMileage()+ "\n";
            str.append(str2);
            i++;
        }
        return str.toString();
    }
}
