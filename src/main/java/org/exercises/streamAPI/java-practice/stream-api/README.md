# Java Stream API Practice Roadmap

A hands-on checklist for practising the Java Stream API, from fundamentals to advanced traversal and interview-style challenges.

## How to use this file

- [ ] Solve each exercise yourself before looking up a solution.
- [ ] Predict the output before running your code.
- [ ] Test empty inputs, duplicate values, and edge cases.
- [ ] Prefer readable pipelines over clever one-liners.
- [ ] Note the Java version required by each API.
- [ ] For parallel-stream exercises, verify correctness before measuring performance.

## Practice setup

Use the following model and sample data for employee-based exercises. The `record` syntax requires Java 16+. For Java 8 or 11, replace the record with a regular class containing fields, a constructor, and getters.

```java
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StreamPractice {

    record Employee(
        int id,
        String name,
        String department,
        double salary,
        int age,
        List<String> skills
    ) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee(1, "Alice", "Engineering", 90000, 29,
                List.of("Java", "AWS", "SQL")),
            new Employee(2, "Bob", "Engineering", 75000, 25,
                List.of("Java", "Docker")),
            new Employee(3, "Charlie", "HR", 60000, 35,
                List.of("Excel", "SQL")),
            new Employee(4, "Diana", "Engineering", 110000, 32,
                List.of("Java", "AWS", "Kubernetes")),
            new Employee(5, "Eve", "HR", 65000, 28,
                List.of("Excel", "Java")),
            new Employee(6, "Frank", "Finance", 80000, 40,
                List.of("SQL", "Python")),
            new Employee(7, "Grace", "Finance", 95000, 31,
                List.of("Python", "AWS")),
            new Employee(8, "Henry", "Engineering", 90000, 27,
                List.of("Java", "SQL"))
        );

        // Practise your solutions here.
    }
}
```

---

## Level 1 — Stream fundamentals

- [ ] 1. Create a stream from a list and print every element. (`stream()`, `forEach()`)
- [ ] 2. Filter all even numbers from a list of integers. (`filter()`)
- [ ] 3. Convert a list of names to uppercase. (`map()`, `toUpperCase()`)
- [ ] 4. Find all numbers greater than 10 and less than 50. (`filter()`, predicate composition)
- [ ] 5. Remove duplicate numbers from a list. (`distinct()`)
- [ ] 6. Sort numbers in ascending and descending order. (`sorted()`, `Comparator`)
- [ ] 7. Sort strings by length. (`sorted(Comparator.comparingInt(...))`)
- [ ] 8. Get the first 5 elements of a list. (`limit()`)
- [ ] 9. Skip the first 3 elements and print the rest. (`skip()`)
- [ ] 10. Count how many strings start with `A`. (`filter()`, `count()`)
- [ ] 11. Check whether any employee earns more than 100000. (`anyMatch()`)
- [ ] 12. Check whether all employees are at least 18 years old. (`allMatch()`)
- [ ] 13. Check whether no employee belongs to the Legal department. (`noneMatch()`)
- [ ] 14. Find the first employee in Engineering. (`filter()`, `findFirst()`)
- [ ] 15. Find any employee in Finance. (`filter()`, `findAny()`)
- [ ] 16. Convert a stream of employee names into a list. (`map()`, `collect()` / `toList()`)
- [ ] 17. Convert a list of names into a set of unique names. (`collect()`, `toSet()`)

## Level 2 — `map()`, `flatMap()` and transformations

- [ ] 1. Convert a list of sentences into a list of individual words using `flatMap()`.
- [ ] 2. Flatten `List<List<Integer>>` into one `List<Integer>`.
- [ ] 3. Given employees and their skills, get a list of all skills.
- [ ] 4. Get all unique skills across all employees.
- [ ] 5. Find employees who know both Java and AWS.
- [ ] 6. Convert each employee into a string containing their name and salary.
- [ ] 7. Convert a list of strings into their lengths.
- [ ] 8. Given a list of integers, produce each number and its square as a flat list: `[1, 1, 2, 4, 3, 9]`.
- [ ] 9. Use `mapToInt()` to calculate the sum of all employee ages.
- [ ] 10. Convert a list of strings into an `IntStream` of their lengths.
- [ ] 11. Compare `map()` and `flatMap()` when the mapping function returns a list or stream.
- [ ] 12. Solve a nested-list flattening problem using `mapMulti()` and compare it with `flatMap()` (Java 16+).

## Level 3 — Collectors and aggregation

- [ ] 1. Collect employee names into a list. (`Collectors.toList()`)
- [ ] 2. Collect unique departments into a set. (`toSet()`)
- [ ] 3. Join all employee names into a comma-separated string. (`joining()`)
- [ ] 4. Calculate the total salary of all employees. (`summingDouble()`)
- [ ] 5. Calculate the average employee salary. (`averagingDouble()`)
- [ ] 6. Find the highest-paid employee. (`maxBy()`, `max()`)
- [ ] 7. Find the lowest-paid employee. (`minBy()`, `min()`)
- [ ] 8. Group employees by department. (`groupingBy()`)
- [ ] 9. Count employees in each department. (`groupingBy()`, `counting()`)
- [ ] 10. Calculate average salary per department. (`groupingBy()`, `averagingDouble()`)
- [ ] 11. Calculate total salary expenditure per department. (`groupingBy()`, `summingDouble()`)
- [ ] 12. Partition employees into salary above and below 80000. (`partitioningBy()`)
- [ ] 13. Group employees by department and then by age group. (nested `groupingBy()`)
- [ ] 14. Group employees by department and return only their names. (`groupingBy()`, `mapping()`)
- [ ] 15. Find the highest-paid employee in each department. (`groupingBy()`, `maxBy()`)
- [ ] 16. Find the number of employees for each skill. (`flatMap()`, `groupingBy()`, `counting()`)
- [ ] 17. Create a map from employee ID to employee. (`toMap()`)
- [ ] 18. Create a map from department to total salary. (`toMap()` with a merge function)
- [ ] 19. Handle duplicate keys when collecting employees into a map. (`toMap()` merge function)
- [ ] 20. Calculate salary statistics: count, sum, min, max and average. (`summarizingDouble()`)
- [ ] 21. Return a sorted map of department names to employee counts. (`groupingBy()` with a map supplier)
- [ ] 22. Collect results into a specific collection such as `TreeSet`. (`toCollection()`)
- [ ] 23. Calculate the difference between the highest and lowest salaries. (`mapToDouble()`, `summaryStatistics()`)
- [ ] 24. Use `Collectors.teeing()` to calculate average salary and employee count in one collection pass. (`teeing()`, Java 12+)

For nested grouping, aim for a structure such as:

```text
Engineering
    20s -> [Bob, Henry, Alice]
    30s -> [Diana]
HR
    20s -> [Eve]
    30s -> [Charlie]
```

Choose and document your age ranges; the exact groups depend on those definitions.

## Level 4 — `reduce()`, `Optional` and primitive streams

- [ ] 1. Calculate the sum of integers using `reduce()`.
- [ ] 2. Calculate the product of integers using `reduce()`.
- [ ] 3. Find the maximum number using `reduce()`.
- [ ] 4. Concatenate strings using `reduce()`.
- [ ] 5. Explain why `reduce(0, Integer::sum)` is safe with an identity of zero.
- [ ] 6. Find the second-highest distinct salary.
- [ ] 7. Find the third-highest distinct number.
- [ ] 8. Find the highest salary without sorting the entire collection.
- [ ] 9. Return an `Optional<Employee>` for the highest-paid employee.
- [ ] 10. Handle an empty stream safely when finding the maximum.
- [ ] 11. Convert `List<Integer>` into `IntStream` and calculate its average.
- [ ] 12. Use `IntStream.range()` to generate numbers from 1 to 100 (remember the upper bound is exclusive).
- [ ] 13. Use `IntStream.rangeClosed()` to include both endpoints.
- [ ] 14. Generate the first 10 squares using `IntStream`.
- [ ] 15. Use `DoubleStream` to calculate the average of a list of doubles.
- [ ] 16. Compare `mapToInt().sum()` with `reduce()` for integer summation.

## Level 5 — Java 9+ and modern Stream API

- [ ] 1. From a sorted list, take elements while they are less than 10. (`takeWhile()`, Java 9+)
- [ ] 2. From a sorted list, skip elements while they are less than 10. (`dropWhile()`, Java 9+)
- [ ] 3. Generate an infinite sequence of integers and take the first 10. (`iterate()`, `limit()`)
- [ ] 4. Generate a sequence with a seed, continuation predicate and next-value function. (`iterate()` overload, Java 9+)
- [ ] 5. Generate values using `Stream.generate()`. (`generate()`)
- [ ] 6. Create a stream containing zero or one element from a nullable value. (`Stream.ofNullable()`, Java 9+)
- [ ] 7. Use `Optional.stream()` to flatten a stream of optional values. (`Optional.stream()`, Java 9+)
- [ ] 8. Collect a stream into an unmodifiable list. (`Stream.toList()`, Java 16+)
- [ ] 9. Compare `Stream.toList()` and `Collectors.toList()` for mutability.
- [ ] 10. Flatten each input into multiple elements using `mapMulti()`. (`mapMulti()`, Java 16+)
- [ ] 11. Collect a stream into two results, such as a count and a sum. (`Collectors.teeing()`, Java 12+)
- [ ] 12. Use `Stream.of()` with zero, one and multiple elements.
- [ ] 13. Create an empty stream and combine it with another stream. (`empty()`, `concat()`)

## Level 6 — Sequential vs. parallel streams

- [ ] 1. Calculate the sum of 1 to 1,000,000 using a sequential stream.
- [ ] 2. Calculate the same sum using a parallel stream.
- [ ] 3. Compare both results for correctness.
- [ ] 4. Benchmark both approaches with sufficient warm-up iterations and repeated measurements.
- [ ] 5. Find the maximum salary using a parallel stream.
- [ ] 6. Group employees by department using a parallel stream.
- [ ] 7. Compare `groupingBy()` and `groupingByConcurrent()` for counting employees by department.
- [ ] 8. Compare `forEach()` and `forEachOrdered()` in a parallel stream.
- [ ] 9. Print numbers using a parallel stream and observe whether output order is preserved.
- [ ] 10. Use `reduce()` to calculate a sum in parallel.
- [ ] 11. Explain why a mutable identity such as `new ArrayList<>()` is unsuitable for the three-argument `reduce()` operation.
- [ ] 12. Identify and fix the race condition in this code:

  ```java
  List<Integer> result = new ArrayList<>();

  IntStream.rangeClosed(1, 1000)
      .parallel()
      .forEach(result::add);
  ```

- [ ] 13. Rewrite the previous example safely using `collect()`.
- [ ] 14. Compare `findFirst()` and `findAny()` on sequential and parallel streams.
- [ ] 15. Compare `anyMatch()`, `allMatch()` and `noneMatch()` on large collections.
- [ ] 16. Determine when `.unordered()` can legally improve parallel processing.
- [ ] 17. Explain why parallel streams can be slower for small collections or inexpensive operations.
- [ ] 18. Investigate parallel streams in a web request under significant CPU load.

**Important:** Parallel streams do not automatically make code faster. Benchmark representative workloads and avoid shared mutable state.

## Level 7 — Laziness, short-circuiting and stream pitfalls

- [ ] 1. Create a stream with `filter()` and `map()` but no terminal operation. Do the intermediate operations execute?
- [ ] 2. Add `count()` as a terminal operation. Which operations execute, and why can some pipeline stages be optimized away?
- [ ] 3. Use `peek()` to trace elements through a pipeline.
- [ ] 4. Demonstrate short-circuiting with `findFirst()`.
- [ ] 5. Use `limit()` on an infinite stream. Why does it terminate?
- [ ] 6. Explain why you cannot reuse a stream after a terminal operation.
- [ ] 7. What happens when you call `stream()` twice on the same list?
- [ ] 8. Compare `peek()` and `map()` and explain their intended purposes.
- [ ] 9. Explain why modifying a collection while streaming over it can cause problems.
- [ ] 10. Explain why this reduction is incorrect for parallel execution when the input is non-empty:

  ```java
  numbers.parallelStream()
      .reduce(10, Integer::sum);
  ```

  Hint: the identity must be an identity element for the accumulator and work correctly across partitions.

- [ ] 11. Explain why `sorted()` generally needs more information than `filter()`.
- [ ] 12. Explain the difference between encounter order and execution order.
- [ ] 13. Investigate whether `distinct()` preserves encounter order for an ordered stream.
- [ ] 14. Explain why side effects inside `map()` or `filter()` should generally be avoided.
- [ ] 15. Why should you not assume `peek()` always executes for every element in every pipeline?
- [ ] 16. Compare `findFirst()` with `min()` when the goal is to find the smallest number.
- [ ] 17. Explain the difference between a stateless operation such as `filter()` and a stateful operation such as `distinct()`.
- [ ] 18. What happens if a predicate or mapping function throws an exception?

## Level 8 — `Spliterator` and advanced traversal

- [ ] 1. Obtain a spliterator from a list and traverse elements with `tryAdvance()`.
- [ ] 2. Process all remaining elements using `forEachRemaining()`.
- [ ] 3. Inspect the characteristics returned by `characteristics()`.
- [ ] 4. Check `ORDERED`, `SIZED`, `SUBSIZED`, `SORTED`, `DISTINCT` and `IMMUTABLE` where applicable.
- [ ] 5. Get the estimated number of remaining elements using `estimateSize()`.
- [ ] 6. Split a spliterator using `trySplit()` and traverse both parts.
- [ ] 7. Explain how splitting enables parallel stream processing.
- [ ] 8. Compare `Iterator`, `Spliterator` and `Stream`.
- [ ] 9. Explain what happens when `tryAdvance()` is called after the spliterator is exhausted.
- [ ] 10. Explore `list.stream().spliterator()` versus `list.spliterator()`.

## Level 9 — Interview-style coding challenges

Try solving these without traditional loops first, then consider whether a loop would be clearer.

- [ ] 1. Find the second-highest distinct salary across all employees. (`distinct()`, `sorted()`, `skip()`, `findFirst()`)
- [ ] 2. Find the highest-paid employee in each department. (`groupingBy()`, `maxBy()`)
- [ ] 3. Find the department with the highest average salary. (`groupingBy()`, `averagingDouble()`, `max()`)
- [ ] 4. Find employees who share the same salary. (`groupingBy()`)
- [ ] 5. Find duplicate strings in a list. (`groupingBy()`, `counting()`)
- [ ] 6. Find the most frequently occurring word in a paragraph. (`flatMap()`, `groupingBy()`, `max()`)
- [ ] 7. Find the first non-repeated character in a string. (`chars()`, `groupingBy()`, insertion-order-aware map)
- [ ] 8. Find the top three highest-paid employees. (`sorted()`, `limit()`)
- [ ] 9. Find employees whose salary exceeds their department's average. (`groupingBy()`, `averagingDouble()`, `filter()`)
- [ ] 10. Partition employees into those who know Java and those who do not. (`partitioningBy()`)
- [ ] 11. Create a map of each skill to the names of employees who have it. (`flatMap()`, `groupingBy()`, `mapping()`)
- [ ] 12. Find common elements between two lists. (`filter()`, `Set`, `distinct()`)
- [ ] 13. Find the frequency of every integer in a list. (`groupingBy()`, `counting()`)
- [ ] 14. Merge two maps by summing values for duplicate keys. (`Stream.concat()`, `toMap()`, merge function)
- [ ] 15. Find the longest word in a list and handle an empty list. (`max()`, `Comparator`, `Optional`)
- [ ] 16. Flatten nested order data and calculate revenue per customer. (`flatMap()`, `groupingBy()`, `summingDouble()`)
- [ ] 17. Return the top two salaries in each department. (`groupingBy()`, `collectingAndThen()`, `sorted()`, `limit()`)
- [ ] 18. Calculate total, average and maximum salary in one collection pass. (`summarizingDouble()`)
- [ ] 19. Find departments with at least three employees. (`groupingBy()`, `counting()`, map entries)
- [ ] 20. Remove null values and blank strings from a list. (`filter()`, `Objects::nonNull`, `String` methods)

## Recommended priority

### Priority 1 — Essential
- [ ] Complete Levels 1–4.
- [ ] Complete the first 10 Level 9 challenges.
- [ ] Become comfortable with `filter()`, `map()`, `flatMap()`, `sorted()`, `distinct()`, `reduce()`, `Optional`, `groupingBy()`, `partitioningBy()` and `toMap()`.

### Priority 2 — Important for understanding
- [ ] Complete Levels 5–7.
- [ ] Understand Java-version differences, lazy evaluation, short-circuiting, stream reuse, collector behavior and parallel correctness.

### Priority 3 — Advanced
- [ ] Complete Levels 8–9.
- [ ] Practise `Spliterator`, `mapMulti()`, concurrent collectors, multi-level grouping and performance benchmarking.

## Review checklist

After every exercise, ask:

- [ ] Can I make this pipeline simpler without making it harder to read?
- [ ] Do I understand the type returned at every pipeline stage?
- [ ] Do I need a mutable collection or an unmodifiable one?
- [ ] Does the solution preserve encounter order?
- [ ] Does it work with empty input, duplicate values and nulls where relevant?
- [ ] Would parallel execution help, or merely add overhead?
- [ ] Can I explain the solution without relying on memorized syntax?

## Java version reference

| API / feature | Introduced |
|---|---:|
| Core Stream API, `map()`, `filter()`, `flatMap()`, collectors | Java 8 |
| `takeWhile()`, `dropWhile()`, `ofNullable()`, `Optional.stream()`, three-argument `iterate()` | Java 9 |
| `Collectors.teeing()` | Java 12 |
| `Stream.toList()`, `mapMulti()`, records | Java 16 |
| `Stream.toList()` returns an unmodifiable list; `Collectors.toList()` does not guarantee a specific implementation or mutability. | — |

This roadmap is intended as a practice tracker. Add your own solutions, notes, and links to commits as you work through each level.
