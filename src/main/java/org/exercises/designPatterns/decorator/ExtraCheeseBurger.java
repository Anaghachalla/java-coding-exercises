package org.exercises.designPatterns.decorator;

public class ExtraCheeseBurger extends BurgerDecorator {

    ExtraCheeseBurger(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + " with extra cheese";
    }

    @Override
    public int getCost() {
        return burger.getCost() + 20;
    }
}
