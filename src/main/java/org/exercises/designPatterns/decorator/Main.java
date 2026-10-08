package org.exercises.designPatterns.decorator;

public class Main {
    static void main() {
        Burger burger = new VeggieBurger();
        IO.println(burger.getDescription() + " price: " + burger.getCost());

        burger = new ExtraCheeseBurger(burger);
        IO.println(burger.getDescription() + " price: " + burger.getCost());

        burger = new WheatBunBurger(burger);
        IO.println(burger.getDescription() + " price: " + burger.getCost());
    }
}
