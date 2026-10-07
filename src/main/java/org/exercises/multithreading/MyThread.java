package org.exercises.multithreading;

public class MyThread extends Thread {

    public MyThread() {
        super();
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        IO.println("Extending Thread class");
        for (int i=0; i<5; i++)
            IO.println("Inside " + Thread.currentThread() + " " + i);
    }
}
