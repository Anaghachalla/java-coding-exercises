package org.exercises.collections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Objects;

@Getter
@AllArgsConstructor
@ToString
public class StudentMarks implements Comparable<StudentMarks>{
    private String name;
    private int maths;
    private int physics;

    @Override
    public int compareTo(@NonNull StudentMarks o) {
        /*
            Integer.compare(this.maths, o.maths), this.maths - o.maths and below - would sort in ascending order, reverse for desc
            current object (this) < other object (o) -> return -1 (or any negative number)
            this > o -> return 1 (or any positive number)
            this == o -> return 0
         */
//        if (this.maths < o.maths)
//            return 1;
//        if (this.maths > o.maths)
//            return -1;
//        return 0;
        IO.println("StudentMark's Comparable's compareTo() method called");
        return o.maths - this.maths;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentMarks that = (StudentMarks) o;
        return maths == that.maths && physics == that.physics && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maths, physics);
    }
}
