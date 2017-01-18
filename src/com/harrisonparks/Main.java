package com.harrisonparks;

public class Main {

    public static void main(String[] args) {
	    String cityName = "Columbus";
        int zipCode = 43232;
        double[] highTemperature = {32, 25, 27, 40, 45};
        double average = (highTemperature[0] + highTemperature[1] + highTemperature[2] + highTemperature[3] + highTemperature[4]) / 5;

        System.out.println("City: " + cityName);
        System.out.println("Zip Code: " + zipCode);
        System.out.println("Average High Temperature: " + average);

    }
}
