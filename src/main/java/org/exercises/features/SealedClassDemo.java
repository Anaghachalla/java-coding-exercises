package org.exercises.features;

sealed class Mammal extends Thread implements Cloneable permits Dog, Cat{ }

non-sealed class Dog extends Mammal { }

final class Cat extends Mammal { }

class Parrot
//        extends Mammal //error - cannot extend sealed class Mammal as parrot is not in the permit list
{ }

sealed interface A permits B { }

non-sealed interface B extends A { }

interface C
//    extends A //error - cannot extend sealed interface A as C is not in the permit list
{ }

public class SealedClassDemo {
    void main() {

    }
}
