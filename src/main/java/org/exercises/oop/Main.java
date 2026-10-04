package org.exercises.oop;

import java.util.HashSet;
import java.util.Set;

public class Main {
    static void main() {
        immutableClassDemo();
    }

    static void immutableClassDemo() {
        Set<String> electives = new HashSet<>();
        electives.add("Maths"); electives.add("Physics");

        CustomImmutableClass student = new CustomImmutableClass(9, "Anagha", electives);
        IO.println("Student:" + student);

        electives.add("Chemistry");
        IO.println("Electives of student:" + student.getElectives()); //would have been modified if shallow copy was used to set the value

        Set<String> electives2 = student.getElectives();
        electives2.add("Chemistry");
        IO.println("Electives of student:" + student.getElectives()); //would have been modified if shallow copy was used to get the value

    }
}
