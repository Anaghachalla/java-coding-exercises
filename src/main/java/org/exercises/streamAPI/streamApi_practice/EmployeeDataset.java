package org.exercises.streamAPI.streamApi_practice;

import java.util.List;

/**
 * Sample employee dataset for Java Stream API practice.
 *
 * Requires Java 16+ because Employee is a record.
 * For Java 8 or Java 11, replace the record with a regular class.
 */
public class EmployeeDataset {

    public record Employee(
            int id,
            String name,
            String department,
            double salary,
            int age,
            List<String> skills
    ) {}

    void main() {
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

        
        // Quick sanity check
        employees.forEach(System.out::println);
    }
}
