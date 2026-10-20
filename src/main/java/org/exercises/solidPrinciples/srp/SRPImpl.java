package org.exercises.solidPrinciples.srp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class SRPImpl {
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
    private class InvoiceGenerator {
        private ShoppingCart sc;

        InvoiceGenerator(ShoppingCart sc) {
            this.sc = sc;
        }

        void generateInvoice() {
            IO.println("Invoice----");
            for(Product p : sc.getProducts()) {
                IO.println("Product: " + p.getName() + " Price: " + p.getPrice());
            }
            IO.println("End----");
        }

    }

    @Getter
    @Setter
    @ToString
    private class CartStatePersist {
        private ShoppingCart sc;
        CartStatePersist(ShoppingCart sc) {
            this.sc = sc;
        }
        void saveToDB() {
            IO.println("Cart state saved to db...." + sc.getProducts());
        }
    }

    void main() {
        ShoppingCart sc = new ShoppingCart();
        sc.addToCart(new Product("Apple", 50));
        sc.addToCart(new Product("Grapes", 35));
        IO.println("Cart value: " + sc.calculateCartValue());

        InvoiceGenerator ig = new InvoiceGenerator(sc);
        ig.generateInvoice();

        CartStatePersist csp = new CartStatePersist(sc);
        csp.saveToDB();

    }
}
