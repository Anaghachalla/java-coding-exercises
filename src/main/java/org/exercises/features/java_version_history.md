# Java Version History — Features to Learn (JDK 8–21)

> Stars indicate learning priority: ⭐⭐⭐ must-know · ⭐⭐ important · ⭐ good to know

---

## Java 8 (LTS) — 2014
- ⭐⭐⭐ Lambda expressions & functional interfaces
- ⭐⭐⭐ Stream API
- ⭐⭐⭐ `Optional<T>`
- ⭐⭐⭐ Date/Time API (`java.time`)
- ⭐⭐ Default & static methods in interfaces
- ⭐⭐ Method references (`ClassName::method`)
- ⭐⭐ `CompletableFuture`
- ⭐ `Base64` API — encode/decode

---

## Java 9 — 2017
- ⭐⭐ Collection factory methods — `List.of()`, `Set.of()`, `Map.of()`
- ⭐⭐ Stream enhancements — `takeWhile()`, `dropWhile()`, `iterate()`
- ⭐⭐ `Optional` enhancements — `ifPresentOrElse()`, `stream()`
- ⭐⭐ `CompletableFuture` enhancements — `orTimeout()`, `completeOnTimeout()`
- ⭐ Private interface methods
- ⭐ `ProcessHandle` — inspect/control OS processes
- ⭐ Module system (`module-info.java`)

---

## Java 10 — 2018
- ⭐⭐⭐ `var` — local variable type inference
- ⭐ `List.copyOf()`, `Collectors.toUnmodifiableList()`
- ⭐ `Optional.orElseThrow()` — no-arg, clearer intent than `get()`

---

## Java 11 (LTS) — 2018
- ⭐⭐⭐ String methods — `isBlank()`, `strip()`, `lines()`, `repeat()`
- ⭐⭐ `Files.readString()` / `writeString()`
- ⭐⭐ HTTP Client API (standardized)
- ⭐⭐ `var` in lambda parameters
- ⭐⭐ `Predicate.not()` — negate method references cleanly

---

## Java 12 — 2019
- ⭐⭐ `Collectors.teeing()` — merge two downstream collectors into one result

---

## Java 14 — 2020
- ⭐⭐⭐ Switch expressions (standard) — `yield`, arrow syntax (`case X -> ...`)
- ⭐⭐ Helpful NullPointerExceptions — pinpoints which variable was null

---

## Java 15 — 2020
- ⭐⭐⭐ Text blocks (standard) — multiline strings with `"""`
- ⭐⭐ `String.formatted()` — inline interpolation alternative to `String.format()`

---

## Java 16 — 2021
- ⭐⭐⭐ Records (standard) — concise immutable data classes
- ⭐⭐⭐ Pattern matching for `instanceof` (standard) — eliminates manual cast
- ⭐⭐ `Stream.toList()` — shorter than `collect(Collectors.toList())`
- ⭐⭐ `Stream.mapMulti()` — imperative alternative to `flatMap`

---

## Java 17 (LTS) — 2021
- ⭐⭐⭐ Sealed classes (standard) — restrict class hierarchies (`permits`)
- ⭐⭐ `RandomGenerator` — unified random API
- ⭐ `HexFormat` — encode/decode hex strings

---

## Java 18 — 2022
- ⭐ UTF-8 as default charset

---

## Java 21 (LTS) — 2023
- ⭐⭐⭐ Virtual threads (standard) — lightweight, cheap concurrency (Project Loom)
- ⭐⭐⭐ Pattern matching for `switch` (standard)
- ⭐⭐ Record patterns (standard) — deep destructuring in switch/instanceof
- ⭐⭐ Sequenced collections — `SequencedCollection`, `SequencedMap` with `getFirst/Last()`

---

## Learning Order Recommendation

1. **Java 8 fundamentals** — lambdas, streams, Optional, `java.time`
2. **Java 9–11 essentials** — `var`, collection factories, string/file utilities, HTTP client
3. **Java 14–15 language features** — switch expressions, text blocks
4. **Java 16–17 language features** — records, sealed classes, pattern `instanceof`
5. **Java 21 pattern matching** — switch patterns + record patterns together
6. **Java 21 concurrency** — virtual threads
