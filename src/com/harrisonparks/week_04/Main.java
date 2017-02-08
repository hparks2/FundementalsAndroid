package com.harrisonparks.week_04;

import com.sun.javafx.binding.StringFormatter;

import java.util.*;

public class Main {
//get city name
    static Map<String, Integer[]> getInput() {
        Map<String, Integer[]> cityTempMap = new HashMap<>();
        List<String> cities = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a city or END to stop.");
        String city = scanner.nextLine();
        while (!city.equals("END")) {
            cities.add(city);
            System.out.println("Enter a city or END to stop.");
            city = scanner.nextLine();
        }
//get city temps
        for (String cityName: cities) {
            System.out.println("Enter the average temperature for each of the next 5 days for " + cityName);
            String temperatures = scanner.nextLine();
            String[] fiveTemps = temperatures.split(" ");
            Integer[] fiveInts = new Integer[5];
            // Coverting strings to ints
            for (int i = 0; i < fiveTemps.length; i++) {
                fiveInts[i] = Integer.parseInt(fiveTemps[i]);
            }
            cityTempMap.put(cityName, fiveInts);
        }
        return cityTempMap;
    }

    static Map<String, Double> calculateAverages(Map<String, Integer[]> temperatures) {
        Map<String, Double> averageMap = new HashMap<>();
        for (String city: temperatures.keySet()) {
            Integer[] cityTemperatures = temperatures.get(city);
            //calculate average
            Double average = new Double(0);
            for (Integer temp: cityTemperatures) {
                average += temp;
            }
            average /= 5;
            averageMap.put(city, average);
        }
        return averageMap;
    }


    static void displayAverage(Map<String, Double> averageMap) {
        for(String city: averageMap.keySet()) {
            System.out.println(city + ": " + averageMap.get(city));
        }
    }

    public static void main(String [] args) {
        Map<String, Integer[]> temperatures = getInput();
        Map<String, Double> averages = calculateAverages(temperatures);
        displayAverage(averages);
    }
}