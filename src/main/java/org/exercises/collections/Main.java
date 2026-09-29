package org.exercises.collections;

import org.exercises.exceptions.CustomCollectionEmpty;
import org.exercises.exceptions.CustomCollectionMaxOccupancyReached;

import java.util.Iterator;

public class Main {
    static void main() {
        IO.println(String.format("Hello and welcome to Collections Main!"));

        //1. Implement a generic array as a custom collection and iterate over it.
        customCollectionCreateAndIterate();

    }

    static void customCollectionCreateAndIterate() {
        
        //try out the add/remove exceptions
        customCollectionExceptionTest();

        //create a custom collection object
        CustomCollection<Integer> ccInt = createCustomCollectionInstance( 3);

        //iterate over the custom collection -
        // iterator code can be replaced by the enhanced for loop, which only works if the class implements the iterable interface
        // enhanced for implicitly calls the hasNext() and next() methods
        parseWithIterator(ccInt);
        IO.println("-------------------");
        parseWithForEach(ccInt);
    }

    static CustomCollection<Integer> createCustomCollectionInstance(int size) {
        CustomCollection<Integer> ccInt = new CustomCollection<>(size);
        for (int i=1; i<size+1; i++) {
            ccInt.add(i);
        }
        return ccInt;
    }

    static void parseWithIterator(CustomCollection<Integer> cc) {
        Iterator<Integer> iterator = cc.iterator();
        while(iterator.hasNext()) {
            IO.println("Print with iterator: " + iterator.next());
        }
    }

    static void parseWithForEach(CustomCollection<Integer> cc) {
        for(int i : cc) {
            IO.println("Print with for: " + i);
        }
    }

    static void customCollectionExceptionTest() {
        CustomCollection<Integer> ccInt = new CustomCollection<>(3);
        try {
            ccInt.add(9);
//            ccInt.add(8);
//            ccInt.add(7);
//            ccInt.add(6);
            ccInt.remove();
            ccInt.remove();
        } catch(CustomCollectionMaxOccupancyReached e) {
            IO.println(e.toString());
            ccInt.remove();
            ccInt.remove();
        } catch (CustomCollectionEmpty e) {
            IO.println(e.toString());
            ccInt.add(9);
        }
    }
}
