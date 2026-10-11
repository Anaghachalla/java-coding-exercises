package org.exercises.streamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicDemo {
    void main() {
        IO.println("Hello and welcome to Streams Main!");

        intStreamBasicDemo();

    }

    void intStreamBasicDemo() {
        List<Integer> list = new ArrayList<>(Arrays.asList(5,2,9,1,3,13,20,7));
        IO.println("Original list: " + list);

        //obtain a Stream to the list
        Stream<Integer> stream = list.stream();


        Optional<Integer> maxVal = stream.max(Integer::compare);
//        Optional<Integer> minVal = stream.min(Integer::compare); //this doesn't work as stream once used cannot be re-used. we need to obtain a new stream

//        if(maxVal.isPresent()) {
//            IO.println("Max value in stream: " + maxVal.get());
//        } //if condition can be replaced by the following
        maxVal.ifPresent(integer -> IO.println("Max value in stream: " + integer));

        Optional<Integer> minVal = list.stream().min(Integer::compare);
        minVal.ifPresent(integer -> IO.println("Min value in stream: " + integer));

        //sorting a stream
        IO.println("sorted stream---------");
        Stream<Integer> sortedStream = list.stream().sorted();
        sortedStream.forEach(e -> IO.print(e + ", "));
        IO.println();

        //filter odd numbers
        IO.println("filter odd numbers---------");
        Stream<Integer> oddNumbers = list.stream().filter(n -> (n%2) == 1);
        oddNumbers.forEach(e -> IO.print(e + ", "));
        IO.println();

        //filter odd numbers > 5
        IO.println("filter odd numbers > 5---------");
//        Stream<Integer> oddNumbersGreater5 = list.stream().filter(n -> ((n%2) == 1) && (n>5));
        Stream<Integer> oddNumbersGreater5 = list.stream().filter(n -> ((n%2) == 1)).filter(n -> n>5);
        oddNumbersGreater5.forEach(e -> IO.print(e + ", "));
        IO.println();

        //reduce (optional) - product of arr elements
        Optional<Integer> product = list.stream().reduce((a,b) -> a*b); //only takes accumulator, returns the type as optional
        product.ifPresent(val -> IO.println("reduce1 - product of numbers: " + val));

        //reduce - sum of arr elements
        int sum = list.stream().reduce(0, Integer::sum); //identity + accumulator -> returns the type directly
        IO.println("reduce2 - Sum of numbers: " + sum);

        //reduce with parallel streams - product of square roots: square root each number and multiply
        double productOfSqurt = list.parallelStream().reduce(1.0, (a,b) -> a * Math.sqrt(b), (a,b)-> a * b); // (identity value, accumulator, combiner)
        IO.println("reduce3 - product of square roots: " + productOfSqurt);

        //map and collect - map square root of elements
        List<Double> sqrtStream = list.stream().map(Math::sqrt).toList(); //immutable, java 16+
        List<Double> sqrtStream2 = list.stream().map(Math::sqrt).collect(Collectors.toCollection(ArrayList::new)); //mutable
        List<Double> sqrtStream3 = list.stream().map(Math::sqrt).collect(Collectors.toList());

        //map and collect to LinkedList
        LinkedList<Double> sqrtLL = list.stream()
                .map(Math::sqrt)
//                .collect(() -> new LinkedList<Double>(),
//                        (ll, element) -> ll.add(element),
//                        (ll1, ll2) -> ll1.addAll(ll2));
                .collect(LinkedList::new, //returns a new ll (similar ops for hashset etc..)
                        LinkedList::add, //add elements to ll
                        LinkedList::addAll//combine 2 lls
                );

        //iterator
        Iterator<Integer> ite = list.iterator();
        while(ite.hasNext()) {
            IO.println("Log via iterator - " + ite.next());
        }

        //spliterator - tryAdvance - need to provide a loop to cycle through the elements
        Spliterator<Integer> splInt = list.spliterator();
        while(splInt.tryAdvance(n -> IO.println("Log via spliterator tryAdvance - " + n)));

        //spliterator - forEachRemaining() - no need to provide a loop (and iterator)
        Spliterator<Integer> splInt2 = list.spliterator();
        splInt2.forEachRemaining(n -> IO.println("Log via spliterator forEachRemaining - " + n));

        //spliterator trySplit()
        spliteratorTrySplitDemo();

        //flatMap demo
        flatMapDemo();
    }

    void flatMapDemo() {
        IO.println("flatMap() demooo-------");
        List<String> sentences = List.of(
                "Java is fun",
                "Streams are powerful",
                "Learn Java"
        );

        // 1. Using map(): each sentence becomes an array of words
        List<String[]> mappedResult = sentences.stream()
                .map(sentence -> sentence.split(" "))
                .collect(Collectors.toList());

        System.out.println("Using map():");
        mappedResult.forEach(words ->
                System.out.println(Arrays.toString(words))
        );

        // 2. Using flatMap(): all words become individual elements
        List<String> flatMappedResult = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());

        System.out.println("\nUsing flatMap():");
        System.out.println(flatMappedResult);
    }

    void spliteratorTrySplitDemo() {
        List<String> list = new ArrayList<>(Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Phi", "Omega"));

        //obtain a spliterator
        Spliterator<String> splist = list.spliterator();

        //split the first iterator into 2
        Spliterator<String> splist2 = splist.trySplit();

        //if splist could be split use splist2 first
        if(splist2 != null) {
            IO.print("Output from splist2: ");
            splist2.forEachRemaining(n -> IO.print(n + ", "));
        }

        IO.print("\nOutput from splist: ");
        splist.forEachRemaining(n -> IO.print(n + ", "));
        IO.println();

    }

}
