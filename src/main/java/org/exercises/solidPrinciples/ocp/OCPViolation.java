package org.exercises.solidPrinciples.ocp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class OCPViolation {
    @Getter
    @Setter
    @ToString
    private class Product {
        private String name;
        private double price;
        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    @Getter
    @Setter
    @ToString
    private class ShoppingCart {
        private List<Product> products;

        ShoppingCart() {
            products = new ArrayList<>();
        }

        void addToCart(Product p) {
            products.add(p);
        }
        void removeFromCart(Product p) {
            products.remove(p);
        }
        double calculateCartValue() {
            double price = 0;
            for(Product p : products) {
                price+=p.getPrice();
            }
            return price;
        }
    }

    @Getter
    @Setter
    @ToString
    private class CartPayment {
        private ShoppingCart sc;
        CartPayment(ShoppingCart sc) {
            this.sc = sc;
        }
        private void initiateCardPayment() {
            IO.println("Initiating card payment for cart items..." + sc.getProducts());
        }
        private void initiateCODPayment() {
            IO.println("Initiating COD payment for cart items..." + sc.getProducts());
        }
        private void initiatePayment(String mode) {
            switch (mode) {
                case "card" -> initiateCardPayment();
                case "COD" -> initiateCODPayment();
            }
        }
        //if we want to add more modes of payment in the future, we would have to add new methods and add new conditions in switch here
        // hence modifying existing code and violating ocp
    }

    void main() {
        ShoppingCart sc = new ShoppingCart();
        sc.addToCart(new Product("Apple", 50));
        sc.addToCart(new Product("Grapes", 35));
        IO.println("Cart value: " + sc.calculateCartValue());

        CartPayment cartPayment = new CartPayment(sc);
        cartPayment.initiatePayment("card");
    }
}
