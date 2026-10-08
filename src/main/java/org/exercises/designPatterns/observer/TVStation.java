package org.exercises.designPatterns.observer;

public class TVStation implements Observer{
    private int currentTemp;
    private int currentHumidity;

    TVStation(Observable o) {
        o.registerObserver(this);
    }

    @Override
    public void update(int temp, int humidity) {
        currentTemp = temp;
        currentHumidity = humidity;
        displayCurrentReport();
    }

    public void displayCurrentReport() {
        IO.println("Reporting from TV Station: Current temperature: " + currentTemp + ", Current humidity: " + currentHumidity);
    }
}
