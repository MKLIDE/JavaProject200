package com.cars;
import java.util.*;
public class CarSorter {
    // Normalization factors (adjust these based on your priorities)
    private static final double MILEAGE_WEIGHT = 0.6;  // 60% importance
    private static final double YEAR_WEIGHT = 0.4;      // 40% importance

    public static void sortCars(ArrayList<Car> cars) {
        if (cars.isEmpty()) return;

        // Find min/max values for normalization
        int minMileage = Integer.MAX_VALUE;
        int maxMileage = Integer.MIN_VALUE;
        int minYear = Integer.MAX_VALUE;
        int maxYear = Integer.MIN_VALUE;

        for (Car car : cars) {
            minMileage = Math.min(minMileage, car.getMileage());
            maxMileage = Math.max(maxMileage, car.getMileage());
            minYear = Math.min(minYear, car.getYear());
            maxYear = Math.max(maxYear, car.getYear());
        }
        //final result of both min mileage & year.
        int finalMinMileage = minMileage;
        int finalMinYear = minYear;

        // Calculate range values (avoid division by zero)
        double mileageRange = Math.max(1, maxMileage - minMileage);
        double yearRange = Math.max(1, maxYear - minYear);

        // Sort using combined score

        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                // Normalize values to 0-1 range (higher is better)
                double mileageScore1 = 1 - ((car1.getMileage() - finalMinMileage) / mileageRange);
                double yearScore1 = (car1.getYear() - finalMinYear) / yearRange;

                double mileageScore2 = 1 - ((car2.getMileage() - finalMinMileage) / mileageRange);
                double yearScore2 = (car2.getYear() - finalMinYear) / yearRange;

                // Calculate weighted scores
                double totalScore1 = (mileageScore1 * MILEAGE_WEIGHT) + (yearScore1 * YEAR_WEIGHT);
                double totalScore2 = (mileageScore2 * MILEAGE_WEIGHT) + (yearScore2 * YEAR_WEIGHT);

                // Sort in descending order of total score
                return Double.compare(totalScore2, totalScore1);
            }
        });
    }
}
//usage
//Best cars first (sorting using % of mileage and year)
//CarSorter.sortCars((ArrayList<Car>) cars); 