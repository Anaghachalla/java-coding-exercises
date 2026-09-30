package org.exercises.collections;

import org.exercises.exceptions.CustomCollectionEmpty;
import org.exercises.exceptions.CustomCollectionMaxOccupancyReached;

import java.util.*;

public class Main {
    static void main() {
        IO.println("Hello and welcome to Collections Main!");

        //1. Implement a generic array as a custom collection and iterate over it.
        customCollectionCreateAndIterate();

        //collectionDemo - Iterator, ListIterator, toArray
        collectionDemoInt();
        collectionDemoString();

        //queues demo - FIFO queue, stack, deque, priority queue
        queuesDemo();
        stackDemo();
        dequeDemo();
        priorityQueueDemo();
    }

    static void priorityQueueDemo() {
        IO.println("Priority queue------------");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        pq.offer(9);
        pq.offer(0);
        pq.offer(2);

        IO.println("Current priority queue: " + pq);
        

    }

    static void queuesDemo() {
        //FIFO
        IO.println("queue--------");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(9);
        queue.offer(1);
        queue.offer(0);

        IO.println("Current queue: " + queue);

        IO.println("Queue polled: " + queue.poll());
        IO.println("Queue empty: " + queue.isEmpty());
        IO.println("Current queue: " + queue);
        IO.println("Queue peek: " + queue.peek());

        while(true) {
            Integer i = queue.poll();
            IO.println("Queue polled: " + i);
            if (i == null) { //no exception, just returns a null value
                IO.println("Queue is empty - cannot poll further");
                break;
            }
        }

    }

    static void stackDemo() {
        //LIFO
        //standard implementation is with ArrayDeque, Stack is legacy
        IO.println("stack------");
        //Deque<Integer> stack = new ArrayDeque<>(); -> ideally
        Stack<Integer> stack = new Stack<>();
        stack.push(9);
        stack.push(1);
        stack.push(0);

        IO.println("Current stack: " + stack);
        IO.println("Stack Popped: " + stack.pop());
        IO.println("Current stack: " + stack);

        IO.println("Stack peek: " + stack.peek());

        while(!stack.isEmpty()) {
            IO.println("Stack Pop loop: " + stack.pop());
        }

    }

    static void dequeDemo() {
        //Double ended queues

        IO.println("deque--------");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(1);
        deque.offerFirst(9);
        deque.offerLast(0);
        deque.offerFirst(7);

        IO.println("Current deque: " + deque);

        IO.println("Deque poll first: " + deque.pollFirst());
        IO.println("Deque poll last: " + deque.pollLast());

        IO.println("Current deque: " + deque);

        IO.println("Deque peek: " + deque.peek());

        try {
            while(true) {
                Integer i = deque.remove();
                IO.println("Queue polled: " + i);
            }
        } catch (Exception e) {
            IO.println("Caught exception while deque remove: " + e);
        }
    }

    static void collectionDemoInt() {
        ListsDemo<Integer> cd = new ListsDemo<>(List.of(1,2,3,4,5));

        ListIterator<Integer> iterator = cd.getListIterator(LinkedList.class);

        IO.println(iterator.next()); //next would do arr[cursor++] -> postfix increment
        IO.println(iterator.next());
        IO.println(iterator.previous()); //prev would do arr[--cursor] -> prefix decrement
    }

    static void collectionDemoString() {
        ListsDemo<String> cdStr = new ListsDemo<>(List.of("Anagha", "Challa"));
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
