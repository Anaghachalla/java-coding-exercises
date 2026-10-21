package org.exercises.solidPrinciples.isp;

import org.exercises.exceptions.IrrelevantMethodException;

public class Square implements Shape2D{
    int side;
    Square(int side) {
        this.side = side;
    }
    @Override
    public int area() {
        return side*side;
    }
}
