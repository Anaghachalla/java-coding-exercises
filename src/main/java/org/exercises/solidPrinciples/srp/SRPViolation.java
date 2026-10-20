package org.exercises.solidPrinciples.srp;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class SRPViolation {
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
    private class ShoppingCart { //shopping cart does too many things - change cart state, save state (irrelevant), payment initiation (irrelevant), generate invoice (irrelevant)
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
        void generateInvoice() {
            IO.println("Invoice----");
            for(Product p : products) {
                IO.println("Product: " + p.getName() + " Price: " + p.getPrice());
            }
            IO.println("End----");
        }
        void saveToDB() {
            IO.println("Cart state saved to db...." + products);
        }

    }

    void main() {
        ShoppingCart sc = new ShoppingCart();
        sc.addToCart(new Product("Apple", 50));
        sc.addToCart(new Product("Grapes", 35));
        IO.println("Cart value: " + sc.calculateCartValue());
        sc.generateInvoice();
        sc.saveToDB();
    }
}
