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

        //priority queue demo - Comparable, Comparator
        priorityQueueComparableDemo();
        priorityQueueComparatorDemo();
        priorityQueueStudentMarks();

        //set, hashset, linkedhashset
        setDemo();
        sortedSetDemo();

    }

    static void sortedSetDemo() {
        IO.println("SortedSet--------------");
        List<StudentMarks> marksList = getStudentMarksList();

        Set<StudentMarks> smarks1 = new TreeSet<>(marksList);
        IO.println("TreeSet with comparable on maths marks:: " + smarks1);

        Set<StudentMarks> smarks2 = new TreeSet<>((a,b) -> b.getPhysics() - a.getPhysics());
        smarks2.addAll(marksList);

        IO.println("TreeSet with comparator on phy marks:: " + smarks2);

        NavigableSet<Integer> set1 = new TreeSet<>();
        set1.add(9);
        set1.add(4);
        set1.add(0);
        set1.add(2);

        IO.println("Integer TreeSet:: " + set1);

        IO.println("Floor 1 - " + set1.floor(1));
        IO.println("Ceiling 1 - " + set1.ceiling(1));
        IO.println("Floor/Ceiling 2 - " + set1.ceiling(2));

        IO.println("Higher 2 - " + set1.higher(2));
        IO.println("Lower 2 - " + set1.lower(2));

    }

    static void setDemo() {
        IO.println("Set-------");
        Set<Integer> hs1 = new HashSet<>();

        hs1.add(2);
        hs1.add(4);
        hs1.add(1);
        hs1.add(9);
        hs1.add(2);
        hs1.add(0);
        IO.println("Hashset1: " + hs1);

        for (int i : hs1) {
            IO.print("HS1: " + i + ", ");
        }

        Set<Integer> hs2 = new LinkedHashSet<>();
        hs2.add(7);
        hs2.add(3);
        hs2.add(5);
        hs2.add(9);
        hs2.add(6);
        hs2.add(4);

        IO.println("\nHashset2: " + hs2);

        for (int i : hs2) {
            IO.print("HS2: " + i + ", ");
        }

        HashSet<StudentMarks> smSet = new HashSet<>(getStudentMarksList());

        IO.println("\nCheck for contains in set: " + smSet.contains(new StudentMarks("a", 70, 100))); //this would return false if hashcode() and equals() are not overridden in StudentMarks class

    }

    static List<StudentMarks> getStudentMarksList() {
        List<StudentMarks> smarks = new ArrayList<>();
        smarks.add(new StudentMarks("a", 70, 100));
        smarks.add(new StudentMarks("b", 100, 70));
        smarks.add(new StudentMarks("c", 70, 50));
        smarks.add(new StudentMarks("d", 80, 90));
        smarks.add(new StudentMarks("e", 90, 40));
        return smarks;
    }

    static void priorityQueueStudentMarks() {
        IO.println("Priority Queue StudentMarks-----------");

        List<StudentMarks> smarks = getStudentMarksList();

        //get top3 students according to their MATHS marks
        PriorityQueue<StudentMarks> pq = new PriorityQueue<>(smarks); //class org.exercises.collections.StudentMarks cannot be cast to class java.lang.Comparable
        IO.println("PQ of StudentMarks with Comparable: " + pq);

        List<StudentMarks> top3maths = new ArrayList<>();
        int index = 0;
        while(!pq.isEmpty()) {
            if (index == 3) {
                break;
            }
            top3maths.add(pq.poll());
            index++;
        }

        IO.println("Top 3 students according to MATHS marks: " + top3maths);

        IO.println("----------------");

        //get top3 students according to their PHYSICS marks
        PriorityQueue<StudentMarks> pq2 = new PriorityQueue<>((a,b) -> {
            IO.println("Comparator's compare() is called");
            return b.getPhysics() - a.getPhysics();
        });
        pq2.addAll(smarks);
        IO.println("PQ of StudentMarks with Comparator: " + pq);

        List<StudentMarks> top3phy = new ArrayList<>();
        index = 0;
        while(!pq2.isEmpty()) {
            if (index == 3) {
                break;
            }
            top3phy.add(pq2.poll());
            index++;
        }

        IO.println("Top 3 students according to PHYSICS marks: " + top3phy);

    }

    static void priorityQueueComparatorDemo() {
        IO.println("Priority queue - CustomIntComparator - makes use of the compare() method ------------");
        PriorityQueue<Integer> pq = new PriorityQueue<>(new CustomIntComparator()); //Total ordering
        pq.offer(1);
        pq.offer(9);
        pq.offer(0);
        pq.offer(2);

        //doing the same as above, but with a lambda function instead of an explicit Comparator implementation
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b) -> b-a);
        pq2.addAll(pq);

        IO.println("Current priority queue: " + pq); //order - 0, 2, 1, 9

        List<Integer> top2 = new ArrayList<>();
        int index = 0;
        while(!pq.isEmpty()) {
            if (index == 2) {
                break;
            }
            top2.add(pq.poll());
            index++;
        }
        IO.println("Top 2 list" + top2); //List - 9,2
    }

    static void priorityQueueComparableDemo() {
        IO.println("Priority queue - default Integer Comparable - makes use of the compareTo() method ------------");
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //Natural ordering - Integer wrapper class implements Comparable interface and overrides compareTo() to sort in ascending order
        pq.offer(1);
        pq.offer(9);
        pq.offer(0);
        pq.offer(2);

        IO.println("Current priority queue: " + pq); //order - 0, 2, 1, 9

        List<Integer> bottom2 = new ArrayList<>();
        int index = 0;
        while(!pq.isEmpty()) {
            if (index == 2) {
                break;
            }
            bottom2.add(pq.poll());
            index++;
        }
        IO.println("Bottom 2 list" + bottom2); //List - 0, 1

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
        IO.println("customCollectionCreateAndIterate -------------");
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
