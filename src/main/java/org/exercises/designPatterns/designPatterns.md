## Singleton Design Pattern
* A class can be instantiated only once.
* Creating another instance of that class would just give you the same old instance, rather than a new one.

## Decorator Design Pattern
* Adds behaviour to an object at runtime without changing its class or subclassing it. 
* Decorators wrap the original object and delegate to it, layering on extra functionality.
* We use it when we need optional, combinable features — and we don't want a subclass explosion for every possible combination.

## Observer pattern
* Defines a one-to-many relationship between objects — when one object (the subject/observable) changes state, all its dependents (observers) are notified and updated automatically.