package org.exercises.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private final Queue<Integer> queue;
    private final int capacity;

    BlockingQueue(int cap) {
        capacity = cap;
        queue = new LinkedList<>();
    }

    public boolean isFull() {
        return (queue.size() == capacity);
    }

    public boolean isEmpty() {
        return (queue.isEmpty());
    }


    public boolean add(int item) {
        synchronized (queue) {
             while (isFull()) { //to ensure when a thread acquires a lock after a wait, the condition is checked again. else, it would go ahead and add the item and would fail.
                 try {
                     IO.println("add - lock wait");
                     queue.wait();
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
             }
             queue.add(item);
            IO.println("add - lock notify");
             queue.notifyAll();
             return true;
        }
    }

    public int remove() {
        synchronized (queue) {
            while (isEmpty()) {
                try {
                    IO.println("poll - lock wait");
                    queue.wait(); //we put wait on lock
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int item = queue.poll();
            IO.println("poll - lock notify");
            queue.notifyAll();
            return item;
        }
    }

}
