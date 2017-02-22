package com.harrisonparks.week_06;

import java.util.Scanner;

class UserInput {
    static Scanner scanner = new Scanner(System.in);

    static public int promptInt(String message) {
        System.out.println(message);
        String userInput = scanner.nextLine();
        int userInt = 0;
        boolean isInt = false;
        while (!isInt) {
            try {
                userInt = Integer.parseInt(userInput);
                isInt = true;
            } catch (NumberFormatException e) {
                System.out.println(userInput + " is not a valid integer. " + message);
                userInput = scanner.nextLine();
            }
        }
        return userInt;
    }

    static public double promptDouble(String message) {
        System.out.println(message);
        String userInput = scanner.nextLine();
        double userDouble = 0;
        boolean isDouble = false;
        while (!isDouble) {
            try {
                userDouble = Double.parseDouble(userInput);
                isDouble = true;
            } catch (NumberFormatException e) {
                System.out.println(userInput + " is not a valid double. " + message);
                userInput = scanner.nextLine();
            }
        }
        return userDouble;
    }

    static public String promptString(String message) {
        System.out.println(message);
        String userInput = scanner.nextLine();
        return userInput;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(UserInput.promptInt("Enter an integer."));
        System.out.println(UserInput.promptDouble("Enter a double."));
        System.out.println(UserInput.promptString("Enter a string."));
    }
}