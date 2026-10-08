package org.exercises.designPatterns.decorator;

public class VeggieBurger extends Burger{
    @Override
    public String getDescription() {
        return "Veggie Burger";
    }

    @Override
    public int getCost() {
        return 180;
    }
}
