package org.exercises.designPatterns.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static void main() {
//        basicSingletonDemo();
        singletonWithMultithreading();
    }

    static void singletonWithMultithreading() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(TVSet::getInstance);
        executor.execute(TVSet::getInstance);

        executor.shutdown();
    }

    static void basicSingletonDemo() {
        TVSet member1 = TVSet.getInstance();
        TVSet member2 = TVSet.getInstance();

        IO.println(member1);
        IO.println(member2);
    }
}
