package com.harrisonparks.week_03;

import java.util.Scanner;

public class Main {
    static double getTemp(){
        System.out.println("Enter a temperature.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return Double.parseDouble(input);
    }

    static double fahrenheitToCelsius(double fahrenheit) {
        return 5.0/9 * (fahrenheit - 32);
    }

    static void displayTemp(double temp) {
        System.out.println("The temperature is " + temp);
    }
    public static void main(String[] args) {
        Double userInput = getTemp();
        while (userInput >= -460) {
            double cTemp = fahrenheitToCelsius(userInput);
            displayTemp(cTemp);
            userInput = getTemp();
        }

    }
}
