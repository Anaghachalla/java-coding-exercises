package org.exercises.solidPrinciples.ocp;

public class CODPayment implements Payment {
    OCPImpl.ShoppingCart sc;
    CODPayment(OCPImpl.ShoppingCart sc) {
        this.sc = sc;
    }
    @Override
    public void initiatePayment() {
        IO.println("Initiating COD payment for cart items..." + sc.getProducts());
    }
}
