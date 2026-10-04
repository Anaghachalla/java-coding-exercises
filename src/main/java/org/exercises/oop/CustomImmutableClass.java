package org.exercises.oop;

import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@ToString
public final class CustomImmutableClass {
    private final int id;
    private final String name;
    private final Set<String> electives;

    public CustomImmutableClass(int id, String name, Set<String> electives) {
        this.id = id;
        this.name = name;
        this.electives = new HashSet<>(electives); //do not set a shallow copy
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getElectives() {
        return new HashSet<>(electives); //do not return a shallow copy
    }
}
