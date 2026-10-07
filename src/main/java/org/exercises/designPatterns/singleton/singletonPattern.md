## Singleton Design Pattern
* A class can be instantiated only once.
* Creating another instance of that class would just give you the same old instance, rather than a new one.
* This would mean that the same instance would be reused across multiple scenarios. In multithreaded environments, it is important for the class to be Thread safe.
* Do not let the service call the constructor directly (make it **private**). This would result in multiple instances rather than a single instance being reused.
* We should have a method `getInstance` that would return the same object instance. But that method would require an object to be invoked. To solve this, use **static** on the class variable and also the method.
### In multithreaded environments
* once the instance is created, any number of threads can safely access the `getInstance()`, as control never goes to the instantiation line ever. Only issue arises when threads try to simultaneously access `getInstance()` before the object is instantiated.
* Adding `synchronized` on the `getInstance()` method would add a lot of overhead and unnecessarily block threads after instance is created. The only line of code to be thread safe is the instantiation code, so add it in a synchronized block.
* add a double check before instantiation.
#### Volatile
* Each thread can cache variables in its local CPU cache rather than always reading from main memory. 
* A stale cached value is the core problem volatile solves.
* eg: there could be scenarios where you have a flag, and threads are using that flag to decide on the operation to be done, and change the status of the flag.
  * in such cases, threads make use of the local copy of the flag, which might have become stale/inconsistent since another thread has changed it.
  * To solve this, make the variable volatile. 
* volatile guarantees that writes go directly to main memory, and reads always fetch from main memory — bypassing the thread's local cache entirely. So, all threads always see the latest value.
### Breaching the singleton design pattern (with the above design)
* **Cloneable** — if the singleton implements `Cloneable`, calling `object.clone()` bypasses `getInstance()` and creates a second instance. Fix: override `clone()` and throw `CloneNotSupportedException`.
* **Reflection API** — `getDeclaredConstructor()` + `setAccessible(true)` can make the private constructor accessible and invoke it directly. Fix: throw an exception inside the constructor if an instance already exists.
* **Serializable** — deserializing a saved singleton creates a brand new instance separate from the one in memory. Fix: implement `readResolve()` returning the existing instance, which the deserialization mechanism will use instead of the newly created one.