package com.harrisonparks.week_02;


public class Main {
    public static void main(String[] args) {
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        int[] temps = {45, 29, 10, 22, 41, 28, 33};
        double[] probability = {0.95, 0.6, 0.25, 0.05, 0, 0.75, 0.9};

        for (int i = 0; i < days.length; i++) {
            if (temps[i] <= 32 && probability[i] > 0.5) {
                System.out.println(days[i]);
            }
        }
    }
}