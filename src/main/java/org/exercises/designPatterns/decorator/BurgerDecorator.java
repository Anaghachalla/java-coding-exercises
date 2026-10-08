package org.exercises.designPatterns.decorator;

public abstract class BurgerDecorator extends Burger {
    //this class centralises the burger field and constructor, and both decorators extend it with just super(burger) — no repeated boilerplate
    protected Burger burger;
    BurgerDecorator(Burger burger) {
        this.burger = burger;
    }
}
