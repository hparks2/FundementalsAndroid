package com.harrisonparks.week_11;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface WeatherDataListener {
    void update(String data);
}

interface WeatherSensor {
    void addListener(WeatherDataListener listener);
    void updateListeners(String data);
}


class TempSensor implements WeatherSensor {
    List<WeatherDataListener> listeners = new ArrayList<>();
    private String temperature;

    public void updateTemperature() {
        double measuredTemp = new Random().nextDouble() * 100;
        temperature = "Temperature: " + measuredTemp;
        updateListeners(temperature);
    }

    @Override
    public void addListener(WeatherDataListener listener) {
        listeners.add(listener);
    }

    @Override
    public void updateListeners(String data) {
        for (WeatherDataListener listener: listeners) {
            listener.update(data);
        }
    }
}

class HumidSensor implements WeatherSensor {
    List<WeatherDataListener> listeners = new ArrayList<>();
    private String humidity;

    public void updateHumidity() {
        double measuredTemp = new Random().nextDouble();
        humidity = "Humidity: " + measuredTemp;
        updateListeners(humidity);
    }

    @Override
    public void addListener(WeatherDataListener listener) {
        listeners.add(listener);
    }

    @Override
    public void updateListeners(String data) {
        for (WeatherDataListener listener: listeners) {
            listener.update(data);
        }
    }
}

class PressureSensor implements WeatherSensor {
    List<WeatherDataListener> listeners = new ArrayList<>();
    private String pressure;

    public void updatePressure() {
        double measuredTemp = new Random().nextDouble();
        pressure = "Pressure: " + measuredTemp;
        updateListeners(pressure);
    }

    @Override
    public void addListener(WeatherDataListener listener) {
        listeners.add(listener);
    }

    @Override
    public void updateListeners(String data) {
        for (WeatherDataListener listener: listeners) {
            listener.update(data);
        }
    }
}

class WeatherStation implements WeatherDataListener {
    List<String> log = new ArrayList<>();


    @Override
    public void update(String data) {
        System.out.println("New weather data: " + data);
        log.add(data);
    }

    public void displayLog() {
        for (String weatherItem: log) {
            System.out.println(weatherItem);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        WeatherStation myWeatherStation = new WeatherStation();

        TempSensor tempSensor = new TempSensor();
        HumidSensor humidSensor = new HumidSensor();
        PressureSensor pressureSensor = new PressureSensor();

        tempSensor.addListener(myWeatherStation);
        humidSensor.addListener(myWeatherStation);
        pressureSensor.addListener(myWeatherStation);

        System.out.println("Simulate sensor updates");
        tempSensor.updateTemperature();
        humidSensor.updateHumidity();
        tempSensor.updateTemperature();
        pressureSensor.updatePressure();

        System.out.println("All weather events");
        myWeatherStation.displayLog();
    }
}