## Records (RecordDemo) - JDK 16
* To reduce verbosity of java code in Data carrier classes (as opposed to functional classes where classes actually do some action, purpose of data carrier classes is to just hold some data)
* Eg: DTOs (Data transfer Objects) - only used for storage/request/response transfer.
* Record is a class behind the scenes, and it
    * cannot extend any other class, as it extends the Record class
    * can implement interfaces
    * can have methods defined in its body (normal, static)
    * can have static variables inside the body, but all instance variables should be defined in the record declaration.
* Variables holding data inside a class - states, inside a record - components
* Records provide
    * implicit all args constructor
    * private and final variables (initialize only once)
    * getters (of format: variableName() - since there are no setters, no need to say getVariableName()), overridden toString, equals and hashCode methods
    * immutability - no setters - only set once through constructor
* We may explicitly add a no args constructor inside the record body by calling the all args constructor, but it is not recommended as record components are final and immutable.
* Main purpose of records is to carry data - we do not expect it to change
* We can provide customizable constructors (including no args constructor) involving some pre-checks etc.. that the data might be expected to hold
* Canonical constructor - has the same parameters defined in the record state description
* Compact canonical constructor - reduced form of canonical constructor - removes assignments and args declaration

## Sealed classes and interfaces (SealedClassDemo) - JDK 17
* Abstract class - meant to be inherited by a concrete class
* Final class - cannot be inherited by any class
* The middle ground where only certain classes are permitted to inherit/extend a class and others are not - Sealed classes
* Sealed interfaces can permit other interfaces that can extend it.
* If any other class/interface that is not in the permit list tries to extend, compilation error is thrown
* Classes permitted by sealed class should either be `sealed`, `non_sealed` or `final`.
* Interfaces permitted by sealed interface should either be `sealed` or `non-sealed`
* A sealed class must have sub-classes.
* Sealed classes can extend other classes that are either sealed or non-sealed, and can also implement interfaces.