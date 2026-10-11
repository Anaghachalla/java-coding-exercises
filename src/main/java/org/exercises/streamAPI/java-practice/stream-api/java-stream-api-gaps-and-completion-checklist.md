# Java Stream API — Gap Topics & Completion Checklist

This document supplements the **Java Stream API Practice Roadmap**. It lists topics to add to the original nine-level roadmap and provides a final checklist for deciding when your Stream API preparation is complete.

Target: practical Java backend development and interviews, especially Java 17/21.

---

## 1. Collector internals and composition

- [ ] Practise `Collectors.collectingAndThen()`.
- [ ] Practise `Collectors.filtering()` (Java 9+).
- [ ] Practise `Collectors.flatMapping()` (Java 9+).
- [ ] Practise `Collectors.toMap()` with a merge function.
- [ ] Understand what happens when `toMap()` encounters duplicate keys without a merge function.
- [ ] Understand the four main collector components: supplier, accumulator, combiner and finisher.
- [ ] Understand collector characteristics: `CONCURRENT`, `UNORDERED` and `IDENTITY_FINISH`.
- [ ] Compare `groupingBy()` and `groupingByConcurrent()`.
- [ ] Use downstream collectors to group, filter, transform and aggregate values.

### Suggested exercises

1. Group employees by department, keeping only employees with salaries above 80,000 in each department.
2. Group employees by department and collect only their names using `mapping()`.
3. Group employees by department and flatten their skill lists using `flatMapping()`.
4. Collect employee names into an unmodifiable list using `collectingAndThen()`.
5. Convert employees into a map keyed by department and define how duplicate departments should be merged.
6. Explain how a parallel collector combines partial results.

---

## 2. Stream ordering, short-circuiting and performance

- [ ] Understand encounter order versus execution order.
- [ ] Understand when `unordered()` is valid and what guarantees it removes.
- [ ] Understand the ordering behavior of `distinct()` and `sorted()`.
- [ ] Compare `limit()` and `skip()` on ordered and unordered streams.
- [ ] Understand short-circuiting with `findFirst()`, `findAny()`, `anyMatch()`, `allMatch()` and `noneMatch()`.
- [ ] Understand why ordered parallel operations can be more expensive.
- [ ] Benchmark sequential versus parallel streams using JMH or another repeatable benchmark setup rather than one timing measurement.
- [ ] Avoid assuming parallel streams are faster simply because the data set is large.

### Suggested exercises

1. Compare `findFirst()` and `findAny()` on sequential and parallel streams.
2. Compare `forEach()` and `forEachOrdered()` on a parallel stream.
3. Compare `limit()` on ordered and unordered parallel streams; document the semantic differences.
4. Benchmark a CPU-intensive operation sequentially and in parallel, with warm-up and repeated runs.
5. Explain why `sorted()` generally requires more coordination than `filter()`.

---

## 3. Primitive streams and conversions

- [ ] Practise `mapToInt()`, `mapToLong()` and `mapToDouble()`.
- [ ] Practise `boxed()` to convert primitive streams into object streams.
- [ ] Practise `mapToObj()` to convert primitive stream elements into objects.
- [ ] Understand `IntStream`, `LongStream` and `DoubleStream`.
- [ ] Understand `OptionalInt`, `OptionalLong` and `OptionalDouble`.
- [ ] Know when primitive streams avoid boxing overhead and when object streams are more suitable.

### Suggested exercises

1. Calculate the sum and average of employee ages using `mapToInt()`.
2. Convert a list of integers to an `IntStream`, then back to `List<Integer>` using `boxed()`.
3. Convert an `IntStream` of IDs into strings using `mapToObj()`.
4. Find the maximum value using `OptionalInt` and handle an empty stream.
5. Compare `mapToInt(...).sum()` with `map(...).reduce(...)`.

---

## 4. Edge cases and correctness

- [ ] Handle empty streams and empty collections.
- [ ] Handle null elements and mapping functions that may return null.
- [ ] Understand how exceptions from lambdas propagate.
- [ ] Understand the risks of modifying a collection while streaming over it.
- [ ] Distinguish an unmodifiable list from deeply immutable data.
- [ ] Avoid side effects inside `map()` and `filter()` unless there is a clear reason.
- [ ] Avoid shared mutable state in parallel pipelines.
- [ ] Treat stream instances as single-use.
- [ ] Understand that intermediate operations may be optimized away when their effects are not required to produce the terminal result.

### Suggested exercises

1. Find the maximum of an empty stream safely.
2. Filter null and blank strings from a list.
3. Handle a parsing exception when converting strings into integers.
4. Demonstrate why modifying a source list during traversal is unsafe.
5. Explain why `peek()` is not a reliable place for essential side effects.
6. Compare `Stream.toList()` and `Collectors.toList()` for mutability guarantees.

---

## 5. Additional API methods

Know the purpose and basic usage of these methods. They are lower priority than transformations and collectors.

- [ ] `Stream.concat()`
- [ ] `Stream.builder()`
- [ ] `Stream.iterate()`
- [ ] `Stream.generate()`
- [ ] `Stream.onClose()`
- [ ] Try-with-resources when working with streams backed by resources, such as `Files.lines()`.

### Suggested exercises

1. Combine two streams with `concat()`.
2. Build a stream using `Stream.builder()`.
3. Generate the first 20 even numbers using `iterate()`.
4. Generate a fixed number of values using `generate()` and `limit()`.
5. Read lines from a file using `Files.lines()` inside try-with-resources.

---

# Final Stream API Completion Checklist

Use this checklist after completing the original nine-level roadmap and the gap topics above.

## Core operations

- [ ] Write `filter()`, `map()`, `flatMap()` and `sorted()` pipelines without referring to notes.
- [ ] Explain the type returned after every intermediate operation.
- [ ] Use `distinct()`, `limit()`, `skip()` and `peek()` appropriately.
- [ ] Know when to use `mapMulti()` instead of `flatMap()`.

## Collectors and aggregation

- [ ] Use `groupingBy()`, `partitioningBy()`, `mapping()`, `counting()` and `reducing()` correctly.
- [ ] Use `toMap()` with duplicate-key handling.
- [ ] Use `summarizingInt()`, `summarizingLong()` or `summarizingDouble()` as appropriate.
- [ ] Explain downstream collectors and nested grouping.
- [ ] Explain the supplier, accumulator, combiner and finisher of a collector.

## Optional and primitive streams

- [ ] Handle `Optional` results without unsafe calls to `get()`.
- [ ] Understand `Optional.stream()` and `OptionalInt`/`OptionalLong`/`OptionalDouble`.
- [ ] Use primitive streams and explain boxing/unboxing trade-offs.

## Pipeline behavior

- [ ] Explain lazy evaluation and terminal operations.
- [ ] Explain short-circuiting.
- [ ] Explain encounter order versus execution order.
- [ ] Explain why streams are single-use.
- [ ] Understand empty inputs, duplicate values, nulls and exceptions.

## Reduction and parallel execution

- [ ] Explain why a `reduce()` identity must be a true identity for its accumulator.
- [ ] Explain why a parallel reduction needs an appropriate associative accumulator.
- [ ] Recognize unsafe side effects and shared mutable state.
- [ ] Explain the difference between `forEach()` and `forEachOrdered()`.
- [ ] Know when parallel streams may help and when they may hurt.
- [ ] Benchmark representative workloads before drawing performance conclusions.

## Practical problem-solving

- [ ] Solve at least 10–15 mixed Stream API interview problems independently.
- [ ] Solve second-highest distinct value, grouping/aggregation, duplicate detection and frequency-counting problems.
- [ ] Handle empty input and duplicate values correctly.
- [ ] Compare a stream solution with a loop and explain the trade-offs.
- [ ] Explain your solution clearly, including complexity and important edge cases.

---

## Java version reference

| Feature | Introduced |
|---|---:|
| Core Stream API and collectors | Java 8 |
| `takeWhile()`, `dropWhile()`, `ofNullable()`, `Optional.stream()`, three-argument `iterate()` | Java 9 |
| `Collectors.teeing()` | Java 12 |
| `Stream.toList()`, `mapMulti()`, records | Java 16 |

### Important distinction

`Stream.toList()` returns an unmodifiable list. `Collectors.toList()` does **not** guarantee a specific list implementation or mutability. If you specifically need a mutable `ArrayList`, use `Collectors.toCollection(ArrayList::new)`.

---

## Recommended completion standard

You are ready to move on when you can solve common Stream API problems without notes, explain why your pipeline works, handle relevant edge cases, and recognize when a loop is clearer. You do not need to memorize every API method to be effective in Java backend development.
