# Java Collections Interview Exercise: LRU Cache

## Goal

Build a generic **Least Recently Used (LRU) Cache** using Core Java collections.

The focus is on:

- Choosing appropriate collection types
- Generics
- `Map`
- `equals()` / `hashCode()`
- Time complexity
- Encapsulation
- Designing a clean API

Do **not** look up an implementation before completing the exercise.

---

# Requirements

## 1. Generic Cache

Create a generic cache:

```text
LruCache<K, V>
```

It should support arbitrary key and value types.

For example:

```text
LruCache<String, User>
LruCache<Long, Product>
```

---

## 2. Fixed Capacity

The cache must be created with a maximum capacity.

Example:

```text
capacity = 3
```

The cache must never contain more than 3 entries.

Reject invalid capacities such as zero or negative values.

---

## 3. Required Operations

Implement:

```text
put(K key, V value)
get(K key)
remove(K key)
size()
containsKey(K key)
```

You may decide the exact return types where appropriate.

---

## 4. LRU Behaviour

The cache must evict the **least recently used** entry when its capacity is exceeded.

For a cache with capacity `3`:

```text
put(A, 1)
put(B, 2)
put(C, 3)
```

Current order:

```text
A B C
```

Now:

```text
get(A)
```

`A` becomes recently used.

Conceptually:

```text
B C A
```

Now:

```text
put(D, 4)
```

`B` must be evicted because it is the least recently used entry.

---

## 5. Access Must Affect Recency

A successful `get()` must update the entry's recency.

For example:

```text
put(A, 1)
put(B, 2)
put(C, 3)

get(A)

put(D, 4)
```

`B`, not `A`, should be evicted.

---

## 6. Updating an Existing Key

If:

```text
put(A, 1)
```

is followed by:

```text
put(A, 100)
```

the cache should:

- Update the value.
- Treat `A` as recently used.
- **Not** increase the cache size.

---

## 7. Remove

If:

```text
remove(A)
```

is called:

- `A` should no longer exist in the cache.
- The cache size should decrease.
- The removed entry should no longer participate in LRU ordering.

Decide what your method should return if the key doesn't exist.

---

## 8. Missing Keys

Calling:

```text
get(unknownKey)
```

must not modify the cache's contents.

Decide how your API represents a missing value.

---

# Complexity Requirement

Your target complexity should be:

| Operation | Target |
|---|---:|
| `get` | O(1) |
| `put` | O(1) |
| `remove` | O(1) |
| `containsKey` | O(1) |

Do **not** solve the problem by scanning a list on every access.

Be prepared to explain why your chosen data structures achieve the required complexity.

---

# Collection Choice

Before implementing, decide which Java collection(s) you want to use.

Consider:

```text
HashMap
LinkedHashMap
LinkedList
ArrayList
Deque
```

You should be able to explain:

> Why did you choose this collection?

and:

> What would be the trade-offs of another approach?

---

# Important Java Concepts

Your implementation should make you think about:

### `Map`

Why is a map useful for the key → value lookup?

### `equals()` and `hashCode()`

What happens if your cache uses custom objects as keys?

What contract must those objects satisfy?

### Generics

Why should the cache be:

```text
LruCache<K, V>
```

rather than:

```text
LruCache
```

using `Object`?

### Encapsulation

The internal collection(s) should not be exposed directly to callers.

---

# Testing Requirements

Test at least the following scenarios.

## Basic insertion

```text
put(A, 1)
put(B, 2)
put(C, 3)
```

Verify that all three exist.

---

## Eviction

With capacity `3`:

```text
put(A, 1)
put(B, 2)
put(C, 3)
put(D, 4)
```

Verify that `A` is evicted.

---

## Access changes order

```text
put(A, 1)
put(B, 2)
put(C, 3)

get(A)

put(D, 4)
```

Verify that `B` is evicted.

---

## Update existing key

```text
put(A, 1)
put(A, 100)
```

Verify:

- Value is `100`.
- Size remains `1`.
- `A` becomes recently used.

---

## Remove

Test:

```text
remove(A)
```

and removing a key that doesn't exist.

---

## Capacity of one

Test:

```text
capacity = 1
```

Verify that inserting a second key evicts the first.

---

## Invalid capacity

Test zero and negative capacities.

---

# Interview Follow-Up Questions

Once your implementation works, try answering these without looking them up.

### 1.

Why can't a simple `HashMap<K, V>` implement LRU behaviour by itself?

### 2.

Why would an `ArrayList` make a straightforward LRU implementation inefficient?

### 3.

How does `LinkedHashMap` relate to this problem?

### 4.

Can you implement the cache using:

```text
HashMap + doubly linked list
```

?

If yes, what does each data structure provide?

### 5.

Why does the doubly linked list need O(1) removal?

### 6.

What changes would be required to make the cache thread-safe?

Do **not** implement the thread-safe version yet unless you want an additional challenge.

---

# Optional Challenge

After your own implementation is complete, create a second implementation using:

```text
LinkedHashMap
```

Compare it with your first implementation.

Be able to explain:

- How `LinkedHashMap` maintains ordering.
- What access-order means.
- How `removeEldestEntry()` can be used.
- Why this can make the implementation much smaller.

---

# Restrictions

For the first implementation:

- Use Core Java only.
- Use generics.
- Do not use a third-party cache library.
- Do not copy an LRU implementation.
- Aim for O(1) `get`, `put`, and `remove`.

You may use standard Java collections, but you should understand the data structures and complexity behind your choices.

---

# Review Checklist

Before comparing your solution, verify that you can explain:

- Why your data structure gives O(1) lookup.
- How recency is tracked.
- How eviction works.
- What happens when an existing key is updated.
- Why `equals()` and `hashCode()` matter.
- Why generics are used.
- Why your implementation maintains the capacity invariant.
- How you would make it thread-safe.
- How `LinkedHashMap` could simplify the design.
