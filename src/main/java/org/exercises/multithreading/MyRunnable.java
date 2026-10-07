package org.exercises.multithreading;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        IO.println("Implementing Runnable interface");
        for (int i=0; i<5; i++)
            IO.println("Inside " + Thread.currentThread() + " " + i);
    }
}
