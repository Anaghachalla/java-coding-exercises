# Java Generics Interview Exercise: Generic In-Memory Repository

## Goal

Build a **Core Java generic in-memory repository** that can store objects by ID.

Implement it yourself from the requirements below. Avoid looking up or copying a solution.

---

## 1. Create an interface

Create:

```java
Identifiable<ID>
```

It should require implementing classes to provide their ID.

Conceptually:

- `User` → `Long` ID
- `Product` → `String` ID

---

## 2. Create two domain classes

Create:

- `User`
- `Product`

Both should implement `Identifiable`, but use **different ID types**.

For example:

- `User` → `Long`
- `Product` → `String`

Give them 1–2 additional fields so they are not just IDs.

---

## 3. Create a generic Repository

Your repository should support:

```text
save(...)
findById(...)
delete(...)
findAll(...)
```

The repository should be generic over:

- the entity/object type
- the ID type

### Important constraint

The repository should only accept objects that have an ID.

**Do not use `Object` just to make the types work.**

---

## 4. Demonstrate type safety

In `main`, create repositories for both:

```text
User + Long
Product + String
```

Demonstrate:

```text
save user
find user
delete user
list users

save product
find product
delete product
list products
```

You should be able to use the returned values **without casting**.

---

# Interview Twist

Once your basic version works, ask yourself:

> How can I constrain the generic repository so that `T` must have an ID of type `ID`?

This is the interesting generics part.

Then, if you want to push yourself further, add a method that takes a collection of entities and inserts them into the repository.

Think about whether you need:

```java
List<T>
List<? extends T>
List<? super T>
```

and **why**.

Try to reason it out yourself before looking up PECS.

---

# What You Should Be Able to Explain

After implementing it, you should be able to explain:

1. Why `Repository<T, ID>` needs two type parameters.
2. Why `T` should have a bound.
3. The difference between a **generic class** and a **generic method**.
4. Why generics are preferable to `Object` + casting.
5. Where `? extends` / `? super` might be useful.
6. What happens to these generic types at runtime.

---

## Constraints

Keep this exercise **100% Core Java**.

Do not use:

- Spring
- JPA
- Hibernate
- Databases
- Framework-specific `Entity` classes

The purpose is to demonstrate **Java generics and type safety**, not framework knowledge.

---

## Review

When finished, review your implementation against the requirements above.

Then you can compare your solution with an interviewer-style review covering:

- correctness
- generic type design
- bounds
- wildcards
- API design
- type safety
- readability
- possible improvements
