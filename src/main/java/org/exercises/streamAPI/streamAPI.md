## Streams
* Represents a sequence of objects. It operates on a data source, such as an array or collection.
* Stream operations do not modify the existing data, rather, it results in the creation of a new stream that produces the sorted data.
* `Stream` (interface) ---extends--> `BaseStream` (interface) ---extends--> `AutoCloseable` (interface)
* A stream once used/consumed cannot be reused.
* Streams can be used in try-with-resources (due to the extension of AutoCloseable)

* Terminal Operations - operations that return a result based on the elements in the stream. Types of Terminal operations
  * Reduction Operations - operations that reduce a stream into a single value. Eg: min(), max(), count(), reduce() etc..
* Intermediate operations - return a new stream that can be used. eg: map(), filter()
* Accumulator - function that operates on 2 values and produces a result
* BinaryOperator (functional interface) --extends--> BiFunction (functional interface)
* Accumulator operation satisfies the following:
  * Stateless - operation does not relay on state information
  * Non-interfering - data source is not modified
  * Associative - given an associative operator used in a sequence of operations, it does not matter which pair of operands are processed first.
* Identity - operation with the element produces the element
  * eq: 0 + x = x -> 0 is identity for sum, 1*x = x -> 1 is identity for product
* Parallel streams:
  * for parallel processing of a stream.
  * to ensure results from sequential and parallel streams are the same, operations applied to parallel streams should be stateless, non-interfering and associative.
  * there could be a combiner function that tells how to combine partial results.
* Streams can be switched between parallel and sequential as required
  * Parallel to sequential using `sequential()` specified by `BaseStream`
  * Sequential to parallel using `parallel()` specified by `BaseStream`
* If the data source is ordered, Streams are ordered. While using parallel streams, we can give a performance boost by allowing a stream to be unordered. This can be done using `unordered()` method.
* Map function - used to apply some transformational operation on each element in the stream. It should be stateless and non-interfering. 
  * Variations of map function - return primitive streams - mapToLong, mapToInt, mapToDouble
* Multiple Intermediate operations can be chained together with a terminal operation at the end
* Collecting - to obtain a collection from a stream
  * Collector interface
  * collect() performs a mutable reduction.
* Streams support 2 types of iterators - 
  * the traditional Iterator - hasNext() and next() (implicitly used in enhanced for loop)
  * Spliterator - tryAdvance(), forEachRemaining(), 
* Spliterator supports parallel processing
* Other methods:
  * allMatch(), anyMatch(), noneMatch() - to determine if one or more elements in a stream satisfy a specified predicate
  * count() - to obtain number of elements in a stream
  * distinct() - to get a stream containing only unique elements
  * of() - to create a stream containing a specified set of elements
  * flatMap() - used when one input element can produce multiple output elements, and you want all those output elements combined into a single stream.
* flatMap()
  * Conceptually, flatMap() performs three steps:
    1. Take one element from the original stream.
    2. Apply the function, which returns a stream of zero or more elements.
    3. Consume those elements as part of the resulting stream, rather than keeping each returned stream as a separate element.


