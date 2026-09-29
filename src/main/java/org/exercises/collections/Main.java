package org.exercises.collections;

import org.exercises.exceptions.CustomCollectionEmpty;
import org.exercises.exceptions.CustomCollectionMaxOccupancyReached;

import java.util.*;

public class Main {
    static void main() {
        IO.println("Hello and welcome to Collections Main!");

        //1. Implement a generic array as a custom collection and iterate over it.
//        customCollectionCreateAndIterate();

        //collectionDemo - Iterator, ListIterator, toArray
        collectionDemoInt();
        collectionDemoString();

    }

    static void collectionDemoInt() {
        CollectionDemo<Integer> cd = new CollectionDemo<>(List.of(1,2,3,4,5));

        ListIterator<Integer> iterator = cd.getListIterator(LinkedList.class);

        IO.println(iterator.next()); //next would do arr[cursor++] -> postfix increment
        IO.println(iterator.next());
        IO.println(iterator.previous()); //prev would do arr[--cursor] -> prefix decrement
    }

    static void collectionDemoString() {
        CollectionDemo<String> cdStr = new CollectionDemo<>(List.of("Anagha", "Challa"));
        String[] strArr = cdStr.getArray(ArrayList.class, String.class);
        IO.println("Printing the array - " + Arrays.toString(strArr));
        IO.println("Printing the LinkedList" + cdStr.getLinkedList());
    }

    static void customCollectionCreateAndIterate() {

        //try out the add/remove exceptions
        customCollectionExceptionTest();

        //create a custom collection object
        CustomCollection<Integer> ccInt = createCustomCollectionInstance( 3);

        //iterate over the custom collection -
        // iterator code can be replaced by the enhanced for loop, which only works if the class implements the iterable interface
        // enhanced for implicitly calls the hasNext() and next() methods
        traverseWithIterator(ccInt);
        IO.println("-------------------");
        traverseWithForEach(ccInt);
    }

    static CustomCollection<Integer> createCustomCollectionInstance(int size) {
        CustomCollection<Integer> ccInt = new CustomCollection<>(size);
        for (int i=1; i<size+1; i++) {
            ccInt.add(i);
        }
        return ccInt;
    }

    static void traverseWithIterator(CustomCollection<Integer> cc) {
        Iterator<Integer> iterator = cc.iterator();
        while(iterator.hasNext()) {
            IO.println("Print with iterator: " + iterator.next());
        }
    }

    static void traverseWithForEach(CustomCollection<Integer> cc) {
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
