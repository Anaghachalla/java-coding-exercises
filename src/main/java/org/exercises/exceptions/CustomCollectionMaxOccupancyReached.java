package org.exercises.exceptions;

public class CustomCollectionMaxOccupancyReached extends RuntimeException {

    @Override
    public String toString() {
        return "CustomCollection max occupancy reached. Cannot add new elements.";
    }
}
