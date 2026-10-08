package org.exercises.designPatterns.decorator;

public class ZingerBurger extends Burger{
    @Override
    public String getDescription() {
        return "Zinger Burger";
    }

    @Override
    public int getCost() {
        return 210;
    }
}
