package org.exercises.solidPrinciples.isp;

public class Cube implements Shape3D {
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
