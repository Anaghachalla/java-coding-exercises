package org.exercises.multithreading;

public class Stack {
    private final int[] arr;
    private int top;
//    final String lock1 = "lock1";
//    final String lock2 = "lock2";


    Stack(int capacity) {
        arr = new int[capacity];
        top = -1;
    }

    boolean isEmpty() {
        return (top < 0);
    }

    boolean isFull() {
        return (top >= arr.length - 1);
    }

    static void justAMethod() {
        synchronized (Stack.class) {
            IO.println("Demonstrating the standard practice of locking on a static method");
        }
    }

    //methods changing the state of the same object should be allowed to be accessed only by 1 thread at a time.

    public synchronized boolean push(int element) { //synchronized method - implicit lock on current object (this)
//        synchronized (this) { //synchronized block - explicit lock
            if (isFull()) {
                return false;
            }
            ++top;

            try {
                Thread.sleep(1000);
            } catch (Exception e) { }

            arr[top] = element;
            return true;
//        }
    }

    public synchronized int pop() {
//        synchronized (this) {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            int el = arr[top];
            arr[top] = Integer.MIN_VALUE;

//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) { }

            top--;
            return el;
//        }
    }

}
