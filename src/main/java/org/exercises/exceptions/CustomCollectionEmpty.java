package org.exercises.exceptions;

public class CustomCollectionEmpty extends RuntimeException {

    @Override
    public String toString() {
        return "CustomCollection is empty. Cannot remove elements.";
    }
}
