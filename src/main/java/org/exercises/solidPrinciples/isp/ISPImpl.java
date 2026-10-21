package org.exercises.solidPrinciples.isp;

public class ISPImpl {
    void main() {
        Shape3D cube = new Cube(9);
        IO.println("Cube area, volume: " + cube.area() + ", " + cube.volume());
        Shape2D square = new Square(9);
        IO.println("square area: " + square.area());
    }
}
