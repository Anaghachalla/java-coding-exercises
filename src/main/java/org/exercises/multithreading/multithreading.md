1. Create a deadlock situation
2. Create a multithreaded system and how they share resources


## Notes

* Thread vs Process
* User thread and Daemon thread
* `Thread` (concrete class) ---implements---> `Runnable` (interface)
* 2 ways of creating a thread:
  * Implement the `Runnable` interface - preferred method - implement the abstract method `run()`
  * Extending the `Thread` class - not preferred as extending the Thread class means we cannot extend any other class - override the `run()` method
* `Runnable` is a functional interface. So, it can also be instantiated with a lambda function.
* Thread.currentThread() -> Thread[#26,MyThread199,5,main] : [id, thread name, thread priority, thread group]
* Default thread priority is 5
* Thread.start() -> creates a new thread, Thread.run() is just a method call and does not create a new thread.
* Threads share the same memory space, and hence the objects.

### Synchronization
* Since threads share the same memory space and objects, there could be a **Race condition** - scenario where one thread reads and another thread writes to the same object.
* To prevent this, a thread should acquire a lock on a shared resource, finish its execution and release the lock. The thread scheduler then decides which thread should run next and give that thread the lock.
* This can be achieved using the `synchronized` keyword.
* By doing so we make a class **Thread safe**.
* Any object can be used as a lock.
* Examples of default thread safe classes - `StringBuffer`, `Vector`, `HashTable`
* Equivalent classes that are not thread safe - `StringBuilder`, `ArrayList`, `HashMap`
* Synchronized block vs method: this is used as a lock implicitly for synchronized methods, whereas for blocks we explicitly specify the lock.
* Methods in a class can be bounded by different lock objects or same using blocks.

### sleep(), wait(), notify(), notifyAll()
* sleep() is called on the Thread. It pauses the thread but does not let go of any locks held by the thread.
* wait() is called on the lock. It releases the lock from the current thread holding it, which can be acquired by another thread, execute and notify that the waiting thread can re-acquire the lock and resume.
* it throws an interrupted exception when another thread interrupts the thread while it is waiting.
* producer-consumer problem
* thread acquires a lock, but fails a conditional check -> lock.wait() -> scheduler hands lock to one of the other threads -> executes -> lock.notifyAll() -> previous wait thread will check the condition again, if checks pass then execute else wait() again.

## join()
* join() is called on a thread. when that is done, parent thread waits for this thread to complete first and then continues execution, rather than getting executed simultaneously.
* join(time) - parent thread waits till the time elapses and then continues executing simultaneously to this thread.