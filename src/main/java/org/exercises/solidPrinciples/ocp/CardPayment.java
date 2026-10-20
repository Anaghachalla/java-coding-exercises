package org.exercises.solidPrinciples.ocp;

public class CardPayment implements Payment{
    OCPImpl.ShoppingCart sc;
    CardPayment(OCPImpl.ShoppingCart sc) {
        this.sc = sc;
    }
    @Override
    public void initiatePayment() {
        IO.println("Initiating CARD payment for cart items..." + sc.getProducts());
    }
}
