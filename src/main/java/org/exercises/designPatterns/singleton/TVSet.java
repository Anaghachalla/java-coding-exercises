package org.exercises.designPatterns.singleton;

//only 1 TV per family, should be reused between each family member
public class TVSet {
    private static volatile TVSet tvSetInstance; //this acts as a flag
    private TVSet() {
        IO.println("TVSet instantiated");
    }

     public static TVSet getInstance() {
        if (tvSetInstance == null) {
            try { Thread.sleep(100); } catch (InterruptedException e) {} //just to force a race condition with a simple executor service
            //here - t1, t2 -> t1 releases the lock after instantiation, t2 acquires the lock here and re-instantiate the object - so add a double check
            synchronized (TVSet.class) {
                if (tvSetInstance == null) { //-> double check
                    tvSetInstance = new TVSet();
                }
            }
        }
        return tvSetInstance;
    }
}
