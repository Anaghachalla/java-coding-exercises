package org.exercises.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observable {
    private int temp;
    private int humidity;
    private final List<Observer> observersList;

    WeatherStation() {
        observersList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        if (!observersList.contains(o)) {
            observersList.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observersList.remove(o);
    }

    @Override
    public void notifyObservers() {
        observersList.forEach((o) -> o.update(temp, humidity));
    }

    //some parameter measuring sensors call this method on changes detected
    public void updateParameters(int temp, int humidity) {
        this.temp = temp;
        this.humidity = humidity;
        notifyObservers();
    }
}
