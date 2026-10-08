package org.exercises.designPatterns.decorator;

public class WheatBunBurger extends BurgerDecorator {

    WheatBunBurger(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + " with wheat bun";
    }

    @Override
    public int getCost() {
        return burger.getCost() + 50;
    }
}
