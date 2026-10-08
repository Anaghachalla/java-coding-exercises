package org.exercises.designPatterns.decorator;

public abstract class Burger {
    private String description;
    private int cost;

    public abstract String getDescription();
    public abstract int getCost();
}
