package org.exercises.solidPrinciples.isp;

import org.exercises.exceptions.IrrelevantMethodException;

public class ISPViolation {
    private interface Shape {
        int area();
        int volume();
    }

    private class Square implements  Shape {
        int side;
        Square(int side) {
            this.side = side;
        }
        @Override
        public int area() {
            return side*side;
        }

        @Override
        public int volume() {
            throw new IrrelevantMethodException(); //Square has no volume, but method is overridden
        }
    }

    private class Cube implements Shape {
        int side;
        Cube(int side) {
            this.side = side;
        }
        @Override
        public int area() {
            return 6 * side * side;
        }

        @Override
        public int volume() {
            return side*side*side;
        }
    }

    void main() {
        Shape cube = new Cube(9);
        IO.println("Cube area, volume: " + cube.area() + ", " + cube.volume());
        Shape square = new Square(9);
        IO.println("square area, volume: " + square.area() + ", " + square.volume());
    }
}
