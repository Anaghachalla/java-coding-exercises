# Java Multithreading Interview Exercise: Thread-Safe Task Queue

## Goal

Build a small **producer-consumer system** using traditional Java threads.

The purpose is to practice real multithreading concepts rather than simply creating and starting threads.

---

# Core Exercise

Build a `TaskQueue` that holds tasks waiting to be processed.

Your system should have:

- Multiple **producer threads**
- Multiple **consumer/worker threads**
- A shared task queue

Producers continuously create tasks and add them to the queue.

Consumers take tasks from the queue and process them.

---

# Constraints

Start with these constraints:

1. Use `Thread` / `Runnable`.
2. **Do not use virtual threads.**
3. **Do not use `ExecutorService` initially.**
4. **Do not use `BlockingQueue`.**
5. Implement the synchronization yourself using Core Java mechanisms.

Your `TaskQueue` should provide operations conceptually equivalent to:

```java
addTask(Task)
takeTask()
```

---

# Important Requirement

If the queue is empty:

> A consumer should **wait** rather than repeatedly checking the queue.

If a producer adds a task while consumers are waiting:

> An appropriate waiting consumer should be **woken up**.

You will therefore need to think about:

- `synchronized`
- Intrinsic locks / object monitors
- `wait()`
- `notify()`
- `notifyAll()`
- Race conditions
- Shared mutable state

---

# Make It Testable

Create something along the lines of:

```text
3 producers
3 consumers
1000 tasks
```

Give every task a unique ID.

After processing completes, verify that:

- Every task was processed.
- No task was processed twice.
- No task was lost.
- The program terminates correctly.

---

# Interview Questions to Think Through

Once the basic implementation works, answer these questions yourself.

### 1. Multiple consumers

What happens if two consumers call `takeTask()` at exactly the same time?

What prevents them from taking the same task?

---

### 2. `wait()` and condition checking

Why should the condition around `wait()` generally be checked using:

```java
while (...)
```

rather than:

```java
if (...)
```

?

---

### 3. `notify()` vs `notifyAll()`

What is the difference between:

```java
notify()
```

and:

```java
notifyAll()
```

?

What problems could occur if you choose the wrong one?

---

### 4. Thread termination

How should consumers know that producers have finished and there will be no more tasks?

Design a **graceful termination mechanism**.

Don't simply terminate all threads from `main`.

---

### 5. Race conditions

Identify every piece of shared mutable state in your program.

For each one, ask:

> What happens if multiple threads access this at the same time?

---

# Second Stage

Once your manually synchronized implementation works, create a second version using:

```java
BlockingQueue
```

Use:

```java
ArrayBlockingQueue
```

Replace your custom `TaskQueue` with the standard concurrency utility.

Then compare the two implementations.

Think about:

- What synchronization did you have to implement yourself?
- What does `BlockingQueue` handle for you?
- What happens when the queue is empty?
- What happens when the queue is full?
- How does the API make the producer-consumer pattern easier?

---

# Concepts You Should Be Able to Explain

After completing the exercise, you should be able to explain:

1. Thread lifecycle.
2. `Runnable`.
3. `Thread.start()` vs `Thread.run()`.
4. Race conditions.
5. `synchronized`.
6. Intrinsic locks / monitors.
7. `wait()`.
8. `notify()` and `notifyAll()`.
9. Why `wait()` belongs inside a condition-checking loop.
10. Producer-consumer pattern.
11. Atomicity vs visibility.
12. Graceful thread termination.
13. Why `BlockingQueue` exists.
14. The difference between manually implementing synchronization and using a concurrency utility.

---

# Restrictions

For the **first implementation**, do not use:

- Virtual threads
- `ExecutorService`
- `Executor`
- `BlockingQueue`
- `ConcurrentHashMap`
- Other high-level concurrency utilities

Use the lower-level Core Java mechanisms so that you have to reason about the concurrency yourself.

---

# Optional Challenge

After everything works, intentionally introduce a synchronization bug.

For example:

- Remove a synchronization boundary.
- Change a `while` condition to `if`.
- Change `notifyAll()` to `notify()`.
- Introduce an unsafe shared counter.

Run the program repeatedly and try to observe the resulting behavior.

The goal is to understand **why** the synchronization is necessary, not just memorize the syntax.

---

# Review

When finished, review your implementation against the requirements above.

Then compare your solution with an interviewer-style review covering:

- Correctness
- Race conditions
- Synchronization strategy
- `wait()` / `notify()` usage
- Thread lifecycle
- Termination strategy
- Visibility and atomicity
- API design
- Readability
- Possible improvements
