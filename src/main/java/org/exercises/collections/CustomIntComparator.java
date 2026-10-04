package org.exercises.collections;

import java.util.Comparator;

public class CustomIntComparator implements Comparator<Integer> {
    /*
        Integer class implements the Comparable interface and overrides its compareTo() -> Natural Ordering
        But the provided implementation is to sort integers in ascending order.
        In order to provide our own custom comparison contract, we define a CustomComparator class implementing the Comparator interface.
        We need to override the compare() method.
        Priority queue calls the compareTo() method by default. In order to make it use this CustomComparator, pass an instance of the CustomComparator class -> Total Ordering
        Precedence: Total ordering > Natural ordering
     */

    @Override
    public int compare(Integer o1, Integer o2) {
        IO.println("Called the CustomIntComparator compare() method");
        return o2 - o1;
    }
}
