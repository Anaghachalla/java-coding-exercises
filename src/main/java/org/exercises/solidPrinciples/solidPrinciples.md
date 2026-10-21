# Solid Principles

## Single Responsibility Principle (SRP)
* A class should have only one reason to change - it should be responsible to do only one thing
* Eg: A separate remote for each appliance instead of a common one.

## Open-Close principle (OCP)
* A class should be open for extension (for a new feature) but closed for modification (changing existing code).
* Do not change existing code in order to add a new feature.
* This is achieved via Abstraction, Inheritance and Polymorphism

## Liskov Substitution Principle (LSP)
* Sub-classes should be substitutable for their base classes.
* Should be able to use the sub-class wherever a base class is expected, without inducing any issues.
* Possible when a sub-class extends the features of a base class, and not narrow it down.
* A child should behave  like  its parent.
* Guidelines: (revisit)
  * Signature Rule
  * Property Rule
  * Method Rule

## Interface Segregation Principle (ISP)
* Many client specific interfaces are better than 1 general purpose interface.
* Child should not be forced to implement methods that are irrelevant to it.

## Dependency Inversion Principle (DIP)
* High level modules should not depend on low level modules, rather, both should depend on an abstraction.

### Why to follow design principles?
* For the code to be
  * Maintainable
  * Readable
  * Bug-free and simple to resolve

