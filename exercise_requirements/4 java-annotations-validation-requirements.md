# Java Annotations Interview Exercise: Annotation-Based Validation Framework

## Goal

Build a small **annotation-driven validation framework** using Core Java.

The purpose is to understand:

- Custom annotations
- Annotation metadata
- `@Target`
- `@Retention`
- Runtime annotations
- Reflection
- Annotation parameters
- Field inspection
- Designing a small framework around annotations

Do not use Spring, Hibernate Validator, Jakarta Bean Validation, or any third-party validation library.

---

# Core Exercise

Build a validation framework that allows a class to declare validation rules using custom annotations.

For example:

```java
class User {

    @NotNull
    private String name;

    @Min(18)
    private int age;
}
```

A validator should be able to receive a `User` object and inspect its annotations to determine whether it is valid.

Conceptually:

```java
Validator.validate(user);
```

should produce validation errors when the object's fields violate their annotations.

---

# 1. Create Custom Annotations

Create at least these annotations:

```text
@NotNull
@Min
@Max
```

### `@NotNull`

Indicates that a field must not contain `null`.

---

### `@Min`

Takes a numeric value representing the minimum allowed value.

Example:

```java
@Min(18)
private int age;
```

---

### `@Max`

Takes a numeric value representing the maximum allowed value.

Example:

```java
@Max(100)
private int age;
```

---

# 2. Configure Annotation Metadata

For every annotation, decide and configure:

- Where it can be used.
- How long it should be retained.

You should explicitly use:

```text
@Target
@Retention
```

Think carefully about whether the annotations need:

```text
RetentionPolicy.SOURCE
RetentionPolicy.CLASS
RetentionPolicy.RUNTIME
```

---

# 3. Create a Sample Domain Class

Create a class such as:

```text
User
```

with fields that use your annotations.

For example, conceptually:

```text
name → @NotNull
age  → @Min / @Max
```

Add enough fields to test different validation scenarios.

---

# 4. Create the Validator

Create a:

```text
Validator
```

class.

It should accept an arbitrary object and inspect its fields using reflection.

Conceptually:

```java
Validator.validate(user);
```

The validator should:

1. Determine the object's class.
2. Discover its fields.
3. Determine which fields have validation annotations.
4. Retrieve the annotations.
5. Read their configured values.
6. Read the corresponding field value.
7. Apply the appropriate validation rule.
8. Collect validation errors.

---

# 5. Validation Errors

Do not simply return:

```text
true / false
```

Return enough information to tell the caller what failed.

For example:

```text
name: must not be null
age: must be >= 18
age: must be <= 100
```

You may design your own error representation.

For example, you could create a:

```text
ValidationError
```

class containing information such as:

```text
field
message
```

---

# 6. Private Fields

Your sample domain class should contain private fields.

The validator therefore needs to consider how it can inspect the field values.

Think about:

```java
Field
```

and reflection access.

Do not simply make all fields public to avoid the problem.

---

# 7. Type Handling

Your `@Min` and `@Max` annotations are intended for numeric fields.

Think about what should happen if someone writes:

```java
@Min(18)
private String name;
```

You should decide how your framework handles invalid annotation usage.

Possible approaches include:

- Throwing an exception.
- Reporting a validation configuration error.
- Ignoring the annotation.

Choose one and document your decision.

---

# 8. Test Cases

Create tests for at least the following.

## Valid object

Example:

```text
name = "Alice"
age = 25
```

Expected:

```text
No validation errors
```

---

## Null value

Example:

```text
name = null
```

Expected:

```text
name: must not be null
```

---

## Value below minimum

Example:

```text
age = 15
```

Expected:

```text
age: must be >= 18
```

---

## Value above maximum

Example:

```text
age = 120
```

Expected:

```text
age: must be <= 100
```

---

## Multiple errors

Create an object that violates multiple validation rules.

The validator should report **all applicable errors**, rather than stopping at the first failure.

---

# Interview Twist 1: Class-Level Annotation

Create another annotation:

```text
@Validate
```

Apply it to classes.

For example:

```java
@Validate
class User {
    ...
}
```

Your validator should only validate classes marked with `@Validate`.

Think about:

- What `@Target` should `@Validate` use?
- What `@Retention` does it require?
- How can reflection determine whether the class has the annotation?

---

# Interview Twist 2: Annotation Parameters

Add another annotation such as:

```text
@Size(min = 3, max = 50)
```

Use it for strings.

Example:

```java
@Size(min = 3, max = 50)
private String name;
```

Your validator should read:

```text
min
max
```

from the annotation and validate the field accordingly.

---

# Interview Twist 3: Annotation Composition

Consider a field with multiple annotations:

```java
@NotNull
@Size(min = 3, max = 50)
private String name;
```

Make sure your validator can process **multiple annotations on the same field**.

---

# Questions You Should Be Able to Answer

After implementing the exercise, you should be able to explain:

## 1. What is an annotation?

What is the purpose of:

```java
@interface
```

?

---

## 2. Why does `@Retention(RUNTIME)` matter?

Why wouldn't `SOURCE` retention work for your validator?

---

## 3. What does `@Target` control?

What happens if you don't specify an appropriate target?

---

## 4. How does reflection access annotations?

For example, how would you retrieve an annotation from a `Field`?

---

## 5. Are annotations interfaces?

Understand the relationship between annotation types and interfaces.

---

## 6. Can annotation elements have arbitrary types?

Understand which types are allowed as annotation elements and why.

---

## 7. Why does the validator need reflection?

What information is available at compile time versus runtime?

---

## 8. What are the trade-offs?

What are the advantages and disadvantages of building a validation framework this way?

Consider:

- Runtime overhead
- Type safety
- Reflection
- Maintainability
- Ease of adding new validation rules

---

# Optional Challenge

Design the validator so that adding a new annotation does not require a large `if/else` chain.

For example, if you later add:

```text
@Email
@Pattern
@Positive
```

you should be able to extend the framework cleanly.

Think about whether you can separate:

```text
annotation discovery
        ↓
validation logic
        ↓
error collection
```

This is optional. Complete the basic implementation first.

---

# Restrictions

For the first implementation:

- Core Java only.
- No Spring.
- No Hibernate.
- No Jakarta Bean Validation.
- No third-party libraries.
- Use custom annotations.
- Use Java reflection.
- Validation must happen at runtime.

---

# Review Checklist

Before comparing your solution, verify that you can explain:

- How custom annotations are declared.
- Why `@Retention(RUNTIME)` is required.
- How `@Target` works.
- How annotation parameters work.
- How reflection discovers fields.
- How reflection retrieves annotations.
- How private fields can be inspected.
- How multiple annotations are handled.
- How invalid annotation usage is handled.
- How you would extend the framework with new validation annotations.
