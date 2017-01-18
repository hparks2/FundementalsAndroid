package com.harrisonparks.week_01;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by hparks2 on 1/17/2017.
 */
public class Main {
    public static void main(String[] args) {
        int currentTemperature;
        currentTemperature = 50;
        int tomorrowTemperature = 45;

        double currentHumidity = 0.55;
        double tomorrowHumidity = 0.45;
        char fahrenheit = 'F';
        char celcius = 'C';

        String cityName = "Columbus";

        System.out.println("Compound Assignment");
        tomorrowHumidity += 0.2;
        currentHumidity /= 2;
        System.out.println(tomorrowHumidity);
        System.out.println(currentHumidity);

        System.out.println("Unary decrement");
        int tomorrowLowTemperature = --tomorrowTemperature;
        int lowTemperature = currentTemperature--;
        System.out.println(tomorrowLowTemperature);
        System.out.println(lowTemperature);
        System.out.println(currentTemperature);

        System.out.println("Comparison");
        boolean isHumid = tomorrowHumidity == 0.65;
        boolean isColumbus = cityName.equals("Columbus");
        System.out.println(isHumid);
        System.out.println(isColumbus);
    }

}
