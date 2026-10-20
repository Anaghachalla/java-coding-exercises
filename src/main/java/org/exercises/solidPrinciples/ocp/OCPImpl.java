package org.exercises.solidPrinciples.ocp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class OCPImpl {
    @Getter
    @Setter
    @ToString
    class Product {
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
    class ShoppingCart {
        private List<Product> products;

        ShoppingCart() {
            products = new ArrayList<>();
        }

        public void addToCart(Product p) {
            products.add(p);
        }
        public void removeFromCart(Product p) {
            products.remove(p);
        }
        public double calculateCartValue() {
            double price = 0;
            for(Product p : products) {
                price+=p.getPrice();
            }
            return price;
        }
    }

    void main() {
        ShoppingCart sc = new ShoppingCart();
        sc.addToCart(new Product("Apple", 50));
        sc.addToCart(new Product("Grapes", 35));
        IO.println("Cart value: " + sc.calculateCartValue());

        Payment cardPayment = new CardPayment(sc);
        cardPayment.initiatePayment();

        Payment codPayment = new CODPayment(sc);
        codPayment.initiatePayment();
        //in case we want to add more payment modes, we can implement the Payment interface and create new concrete classes overriding its methods instead of modifying existing code
    }
}
