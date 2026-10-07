package org.exercises.multithreading;

public class Main {
    static void main() {
        IO.println("Main starting...");

//        basicThreadsDemo();

//        threadsafeStackDemo();

        //producer-consumer problem
//        blockingQueueProdConProblem();

//        threadStatesDemo();

//        joinDemo();

        deadlockDemo();

        IO.println("Main exiting...");

    }

    static void deadlockDemo() {
        // for deadlock, threads use locks in reverse order.
        // to release the deadlock, maintain same order of locks between threads.
        String lock1 = "lock1";
        String lock2 = "lock2";

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1);
                    synchronized (lock2) {
                        Thread.sleep(1);
                        IO.println("inside nest in " + Thread.currentThread());
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "thread1");

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1);
                    synchronized (lock1) {
                        Thread.sleep(1);
                        IO.println("inside nest in " + Thread.currentThread());
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "thread2");

        t1.start();
        t2.start();
    }

    static void joinDemo() {
        Thread t = new Thread(() -> {
            IO.println(Thread.currentThread() + " started");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            IO.println(Thread.currentThread() + " finished");
        }, "A thread");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void threadStatesDemo() {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1);
                for(int i =0 ; i<10000; i++);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "States");

        IO.println(t1.getState());

        t1.start();

        while(true) {
            Thread.State state = t1.getState();
            IO.println(state);
            if (state == Thread.State.TERMINATED)
                break;
        }
    }

    static void blockingQueueProdConProblem() {
        BlockingQueue q = new BlockingQueue(5);
        new Thread(()-> {
            for(int i=0; i < 10; i++)
                IO.println("Add to queue " + q.add(i));
        }, "Producer").start();

        new Thread(()-> {
            for (int i=0; i<10; i++)
                IO.println("Poll from queue " + q.remove());
        }, "Consumer").start();

    }

    static void threadsafeStackDemo() {
        Stack stack = new Stack(5);

        new Thread(() -> {
            for(int i =0; i<10; i++)
                IO.println("Pushed: "+ stack.push(i));
        }, "Pusher").start();

        new Thread(() -> {
            for(int i =0; i<10; i++)
                IO.println("Popped: " + stack.pop());
        }, "Popper").start();
    }

    static void basicThreadsDemo() {
        IO.println("basic thread demo---------------");

        Thread t1 = new MyThread("thread1");
        //t1.setDaemon(true); //creating a daemon thread, to be set before starting the thread
        t1.start();

        Thread t2 = new Thread(new MyRunnable(), "thread2");
        t2.start();

        Thread t3 = new Thread(() -> {
            for (int i=0; i<10; i++)
                IO.println("Inside " + Thread.currentThread() + " " + i);
        }, "thread3");

        t3.start();
    }
}
