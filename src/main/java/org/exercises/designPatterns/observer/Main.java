package org.exercises.designPatterns.observer;

public class Main {
    static void main() {
        WeatherStation weatherStation = new WeatherStation();
        TVStation tvStation = new TVStation(weatherStation);
        MeteorologyDepartment meteorologyDepartment = new MeteorologyDepartment(weatherStation);

        weatherStation.updateParameters(30, 15);
        delay();

        weatherStation.updateParameters(25, 10);
        delay();

        weatherStation.updateParameters(40, 20);
        delay();

    }

    private static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
