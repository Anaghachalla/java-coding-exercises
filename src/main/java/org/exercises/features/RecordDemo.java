package org.exercises.features;

/*
//a data carrier class
class Student {
    final private int id;
    final private String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

*/

//all of the above code can be reduced into 1 line
record Student(int id, String name) {

    static String school = "SNIST";

    //Compact canonical constructor - canonical constructor above can be reduced to the following form
    public Student { // no need to define constructor args
        if (id == 0) {
            throw new IllegalStateException("id cannot be 0");
        }
        //no need to set the values
    }

    void sayHi() {
        IO.println(name + " says Hi!!");
    }

    /*

    //canonical constructor - has the same variables as the record state description
    public Student(int id, String name) {
        if (id == 0)
            throw new IllegalStateException("id cannot be 0");
        this.id = id;
        this.name = name;
    }

    //explicit no args constructor - not recommended
    Student() {
        this(0,"");
    }

    */
}

public class RecordDemo {
    void main() {
        Student s1 = new Student(1, "Jack"); //records provide an all args constructor implicitly
        Student s2 = new Student(1, "Jack");

        //records override toString and equals/hashcode implicitly unlike a class
        IO.println(s1);
        IO.println(s1.equals(s2));

//        Student s3 = new Student(0, "abc"); //throws an exception
//        IO.println(s3);

        IO.println("Name of student: " + s1.name() + ", id: " + s1.id());
        s1.sayHi();
        IO.println("Students belong to the school: " + Student.school);

    }
}
