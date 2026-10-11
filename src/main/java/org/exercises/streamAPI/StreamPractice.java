package org.exercises.streamAPI;

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

    void main(String[] args) {

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