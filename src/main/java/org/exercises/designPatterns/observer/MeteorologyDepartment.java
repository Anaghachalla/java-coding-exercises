package org.exercises.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class MeteorologyDepartment implements Observer{
    List<Integer> temperatureHistory;
    List<Integer> humidityHistory;

    MeteorologyDepartment(Observable o) {
        temperatureHistory = new ArrayList<>();
        humidityHistory = new ArrayList<>();
        o.registerObserver(this);
    }

    @Override
    public void update(int temp, int humidity) {
        temperatureHistory.add(temp);
        humidityHistory.add(humidity);
        getAverageTemperature();
        getAverageHumidity();
    }

    public void getAverageTemperature() {
        double average =  temperatureHistory.stream().mapToInt(Integer::intValue).average().orElse(0);
        IO.println("Reporting from Meteorology department: Average temperature of " + temperatureHistory.size() + " days: " + average);
    }

    public void getAverageHumidity() {
        double average = humidityHistory.stream().mapToInt(Integer::intValue).average().orElse(0);
        IO.println("Reporting from Meteorology department: Average humidity of " + humidityHistory.size() + " days: " + average);
    }
}
