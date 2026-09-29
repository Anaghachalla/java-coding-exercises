## To Practice
1. Implement a generic array as a custom collection and iterate over it.

## Notes
* A ForEach (enhanced-for) loop can only be applied to an instance of a class that implements the `Iterable` interface.
* Enhanced-for implicitly calls the `hasNext()` and `next()` methods (that are overridden by a nested class that implements an `Iterator` interface)
* The `Collection` interface extends the `Iterable` interface
* A class, supposedly a `CustomCollection` implements an `Iterable` and a nested sub class within the `CustomCollection` class, say `CustomIterator` implements the `Iterator` interface and overrides the `hasNext()` and `next()` methods, in order to enable traversal using a for-each loop over the custom collection object. The `CustomIterator` maintains its own iteration variable, similar to `i` in a for loop.
* `Iterator` interface has 2 methods `hasNext()` and `next()`. It is extended by the `ListIterator` interface which provides 2 additional methods `hasPrevious()` and `previous()`.
* `ArrayList` and `Vector` -> mostly same except `Vector` is Thread Safe, and hence has a performance overhead compared to `ArrayList`
* `ArrayList`, `Vector` -> implement `List` interface
* `LinkedList` -> implements `List` and `Deque` interfaces
* `Deque` interface extends the `Queue` interface
* `PriorityQueue` implements the `Queue` interface  


![collections1.png](../../../../resources/collections1.png)
![collections2.png](../../../../resources/collections2.png)