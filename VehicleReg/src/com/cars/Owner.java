package com.cars;
import java.util.ArrayList;
import java.util.List;

public class Owner {
    private String name;
    private List<Car> cars = new ArrayList<>();

    public Owner(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public List<Car> getCars() { return cars; }

    public void addCar(Car car) {
        cars.add(car);
    }

    public boolean removeCar(String make, String model) {
        return cars.removeIf(c -> c.getMake().equalsIgnoreCase(make) &&
                c.getModel().equalsIgnoreCase(model));
    }
}
