package org.exercises.collections;

import org.exercises.exceptions.CustomCollectionEmpty;
import org.exercises.exceptions.CustomCollectionMaxOccupancyReached;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class CustomCollection<T> implements Iterable<T>{
    private int index;
    private T[] arr;

    public CustomCollection(int size) {
        arr = (T[]) new Object[size]; //works only because the initialization is done with an empty array of some size. If array has elements then the cast would have failed.
        index = 0;
    }

    public int getSize() {
        return index;
    }

    public int getCapacity() {
        return arr.length;
    }

    public void add(T element) {
        if (index == arr.length) {
            throw new CustomCollectionMaxOccupancyReached();
        }
        arr[index++] = element;
    }

    public void remove() {
        if (index == 0) {
            throw new CustomCollectionEmpty();
        }
        arr[--index] = null;
    }

    private class CustomIterator implements Iterator<T> {
        private int cursor = 0; //should not use the outer index - that is for add/remove. cursor acts as the iteration constant i in a for loop

        @Override
        public boolean hasNext() {
            IO.println("hasNext called");
            return cursor < index;
        }

        @Override
        public T next() {
            IO.println("next called");
            //cursor -> postfix increment
            return arr[cursor++];
        }

        //whereas a previous would do something like
        //return arr[--cursor] -> cursor prefix decrement
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

}
