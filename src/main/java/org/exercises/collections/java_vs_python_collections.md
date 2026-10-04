# Java vs Python Collections

## List

| Operation | Java (`ArrayList`) | Python (`list`) |
|---|---|---|
| Import | `import java.util.ArrayList;` | built-in |
| Initialize empty | `List<Integer> list = new ArrayList<>();` | `lst = []` |
| Initialize with values | `List<Integer> list = new ArrayList<>(List.of(1, 2, 3));` | `lst = [1, 2, 3]` |
| Add to end | `list.add(10)` | `lst.append(10)` |
| Add at index | `list.add(2, 10)` | `lst.insert(2, 10)` |
| Get by index | `list.get(0)` | `lst[0]` |
| Set by index | `list.set(0, 99)` | `lst[0] = 99` |
| Remove by index | `list.remove(0)` | `lst.pop(0)` |
| Remove by value | `list.remove(Integer.valueOf(10))` | `lst.remove(10)` |
| Remove last | `list.remove(list.size() - 1)` | `lst.pop()` |
| Contains | `list.contains(10)` | `10 in lst` |
| Size | `list.size()` | `len(lst)` |
| Is empty | `list.isEmpty()` | `not lst` or `len(lst) == 0` |
| Index of value | `list.indexOf(10)` | `lst.index(10)` |
| Sort ascending | `Collections.sort(list)` | `lst.sort()` |
| Sort with comparator | `list.sort(Comparator.reverseOrder())` | `lst.sort(reverse=True)` or `lst.sort(key=lambda x: -x)` |
| Sublist | `list.subList(1, 3)` | `lst[1:3]` |
| Clear | `list.clear()` | `lst.clear()` |
| Copy | `new ArrayList<>(list)` | `lst.copy()` or `lst[:]` |
| Iterate | `for (int x : list)` | `for x in lst:` |

---

## Stack (LIFO)

Java prefers `ArrayDeque` over the legacy `Stack` class.

| Operation | Java (`ArrayDeque` as Stack) | Python (`list` as Stack) |
|---|---|---|
| Import | `import java.util.ArrayDeque;` | built-in |
| Initialize | `Deque<Integer> stack = new ArrayDeque<>();` | `stack = []` |
| Push | `stack.push(10)` or `stack.offerFirst(10)` | `stack.append(10)` |
| Pop | `stack.pop()` or `stack.pollFirst()` | `stack.pop()` |
| Peek top | `stack.peek()` or `stack.peekFirst()` | `stack[-1]` |
| Is empty | `stack.isEmpty()` | `not stack` |
| Size | `stack.size()` | `len(stack)` |

---

## Queue (FIFO)

Java uses `LinkedList` or `ArrayDeque` as a `Queue`.

| Operation | Java (`ArrayDeque` as Queue) | Python (`collections.deque`) |
|---|---|---|
| Import | `import java.util.ArrayDeque;` | `from collections import deque` |
| Initialize | `Queue<Integer> q = new ArrayDeque<>();` | `q = deque()` |
| Enqueue (add to tail) | `q.offer(10)` | `q.append(10)` |
| Dequeue (remove from head) | `q.poll()` | `q.popleft()` |
| Peek head | `q.peek()` | `q[0]` |
| Is empty | `q.isEmpty()` | `not q` |
| Size | `q.size()` | `len(q)` |

---

## Deque (Double-Ended Queue)

| Operation | Java (`ArrayDeque`) | Python (`collections.deque`) |
|---|---|---|
| Import | `import java.util.ArrayDeque;` | `from collections import deque` |
| Initialize | `Deque<Integer> dq = new ArrayDeque<>();` | `dq = deque()` |
| Add to front | `dq.offerFirst(10)` | `dq.appendleft(10)` |
| Add to back | `dq.offerLast(10)` | `dq.append(10)` |
| Remove from front | `dq.pollFirst()` | `dq.popleft()` |
| Remove from back | `dq.pollLast()` | `dq.pop()` |
| Peek front | `dq.peekFirst()` | `dq[0]` |
| Peek back | `dq.peekLast()` | `dq[-1]` |
| Is empty | `dq.isEmpty()` | `not dq` |
| Size | `dq.size()` | `len(dq)` |

---

## PriorityQueue (Min-Heap by default)

| Operation | Java (`PriorityQueue`) | Python (`heapq`) |
|---|---|---|
| Import | `import java.util.PriorityQueue;` | `import heapq` |
| Initialize min-heap | `PriorityQueue<Integer> pq = new PriorityQueue<>();` | `pq = []` |
| Initialize max-heap | `PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());` | `pq = []` *(negate values on push/pop)* |
| Initialize with values | `PriorityQueue<Integer> pq = new PriorityQueue<>(List.of(3, 1, 2));` | `pq = [3, 1, 2]; heapq.heapify(pq)` |
| Push | `pq.offer(10)` | `heapq.heappush(pq, 10)` |
| Pop (remove min) | `pq.poll()` | `heapq.heappop(pq)` |
| Peek min | `pq.peek()` | `pq[0]` |
| Custom comparator | `new PriorityQueue<>((a, b) -> a.val - b.val)` | `heapq.heappush(pq, (priority, item))` |
| Size | `pq.size()` | `len(pq)` |
| Is empty | `pq.isEmpty()` | `not pq` |

> **Max-heap in Python**: negate values — push `-val`, pop and negate back `-heapq.heappop(pq)`.

---

## HashSet

| Operation | Java (`HashSet`) | Python (`set`) |
|---|---|---|
| Import | `import java.util.HashSet;` | built-in |
| Initialize empty | `Set<Integer> s = new HashSet<>();` | `s = set()` |
| Initialize with values | `Set<Integer> s = new HashSet<>(Set.of(1, 2, 3));` | `s = {1, 2, 3}` |
| Add | `s.add(10)` | `s.add(10)` |
| Remove | `s.remove(10)` | `s.remove(10)` *(KeyError if missing)* or `s.discard(10)` |
| Contains | `s.contains(10)` | `10 in s` |
| Size | `s.size()` | `len(s)` |
| Is empty | `s.isEmpty()` | `not s` |
| Union | `s.addAll(other)` *(modifies s)* | `s \| other` or `s.union(other)` |
| Intersection | `s.retainAll(other)` *(modifies s)* | `s & other` or `s.intersection(other)` |
| Difference | `s.removeAll(other)` *(modifies s)* | `s - other` or `s.difference(other)` |
| Contains all | `s.containsAll(other)` | `other.issubset(s)` |
| Clear | `s.clear()` | `s.clear()` |
| Iterate | `for (int x : s)` | `for x in s:` |

---

## LinkedHashSet (Insertion-Order Set)

Python has no direct equivalent — a `dict` with dummy values preserves insertion order in Python 3.7+.

| Operation | Java (`LinkedHashSet`) | Python (`dict` as ordered set) |
|---|---|---|
| Import | `import java.util.LinkedHashSet;` | built-in |
| Initialize | `Set<Integer> s = new LinkedHashSet<>();` | `s = {}` *(empty dict — NOT a set literal)* |
| Add | `s.add(10)` | `s[10] = None` |
| Remove | `s.remove(10)` | `s.pop(10, None)` |
| Contains | `s.contains(10)` | `10 in s` |
| Iterate in insertion order | `for (int x : s)` | `for x in s:` |
| Size | `s.size()` | `len(s)` |

---

## TreeSet (Sorted Set)

Python's `sortedcontainers.SortedList` or `SortedSet` is the closest equivalent (third-party).

| Operation | Java (`TreeSet`) | Python (`sortedcontainers.SortedList`) |
|---|---|---|
| Import | `import java.util.TreeSet;` | `from sortedcontainers import SortedList` |
| Initialize | `TreeSet<Integer> ts = new TreeSet<>();` | `ts = SortedList()` |
| Initialize with values | `new TreeSet<>(List.of(3, 1, 2))` | `SortedList([3, 1, 2])` |
| Add | `ts.add(10)` | `ts.add(10)` |
| Remove | `ts.remove(10)` | `ts.remove(10)` |
| Contains | `ts.contains(10)` | `10 in ts` |
| First (min) | `ts.first()` | `ts[0]` |
| Last (max) | `ts.last()` | `ts[-1]` |
| Poll first (remove min) | `ts.pollFirst()` | `ts.pop(0)` |
| Poll last (remove max) | `ts.pollLast()` | `ts.pop(-1)` |
| Floor (≤ e) | `ts.floor(e)` | *(manual binary search)* |
| Ceiling (≥ e) | `ts.ceiling(e)` | *(manual binary search)* |
| Lower (< e) | `ts.lower(e)` | *(manual binary search)* |
| Higher (> e) | `ts.higher(e)` | *(manual binary search)* |
| Iterate sorted | `for (int x : ts)` | `for x in ts:` |

---

## HashMap

| Operation | Java (`HashMap`) | Python (`dict`) |
|---|---|---|
| Import | `import java.util.HashMap;` | built-in |
| Initialize empty | `Map<String, Integer> map = new HashMap<>();` | `m = {}` |
| Initialize with values | `Map.of("a", 1, "b", 2)` | `m = {"a": 1, "b": 2}` |
| Put | `map.put("key", 10)` | `m["key"] = 10` |
| Get | `map.get("key")` | `m["key"]` *(KeyError if missing)* |
| Get with default | `map.getOrDefault("key", 0)` | `m.get("key", 0)` |
| Contains key | `map.containsKey("key")` | `"key" in m` |
| Contains value | `map.containsValue(10)` | `10 in m.values()` |
| Remove by key | `map.remove("key")` | `m.pop("key")` or `del m["key"]` |
| Size | `map.size()` | `len(m)` |
| Is empty | `map.isEmpty()` | `not m` |
| Put if absent | `map.putIfAbsent("key", 0)` | `m.setdefault("key", 0)` |
| Merge / update value | `map.merge("key", 1, Integer::sum)` | `m["key"] = m.get("key", 0) + 1` |
| All keys | `map.keySet()` | `m.keys()` |
| All values | `map.values()` | `m.values()` |
| All entries | `map.entrySet()` | `m.items()` |
| Iterate entries | `for (var e : map.entrySet()) { e.getKey(); e.getValue(); }` | `for k, v in m.items():` |
| Compute if absent | `map.computeIfAbsent("key", k -> new ArrayList<>())` | `m.setdefault("key", [])` |
| Clear | `map.clear()` | `m.clear()` |

> Python `dict` maintains **insertion order** since Python 3.7 (equivalent to Java's `LinkedHashMap`).

---

## LinkedHashMap (Insertion-Order Map)

| Operation | Java (`LinkedHashMap`) | Python (`dict`) |
|---|---|---|
| Import | `import java.util.LinkedHashMap;` | built-in |
| Initialize | `Map<String, Integer> map = new LinkedHashMap<>();` | `m = {}` |
| All operations | *(same as HashMap above)* | *(same as dict above)* |
| Iteration order | insertion order | insertion order (Python 3.7+) |
| Access-order mode (LRU) | `new LinkedHashMap<>(capacity, 0.75f, true)` | use `functools.lru_cache` or `collections.OrderedDict` |

---

## TreeMap (Sorted Map)

Python's `sortedcontainers.SortedDict` is the closest equivalent.

| Operation | Java (`TreeMap`) | Python (`sortedcontainers.SortedDict`) |
|---|---|---|
| Import | `import java.util.TreeMap;` | `from sortedcontainers import SortedDict` |
| Initialize | `TreeMap<String, Integer> tm = new TreeMap<>();` | `tm = SortedDict()` |
| Put | `tm.put("b", 2)` | `tm["b"] = 2` |
| Get | `tm.get("b")` | `tm["b"]` |
| First key (min) | `tm.firstKey()` | `tm.keys()[0]` |
| Last key (max) | `tm.lastKey()` | `tm.keys()[-1]` |
| Floor key (≤ k) | `tm.floorKey("c")` | *(use `bisect` on `tm.keys()`)* |
| Ceiling key (≥ k) | `tm.ceilingKey("c")` | *(use `bisect` on `tm.keys()`)* |
| Poll first (remove min entry) | `tm.pollFirstEntry()` | `tm.popitem(0)` |
| Poll last (remove max entry) | `tm.pollLastEntry()` | `tm.popitem(-1)` |
| Iterate sorted | `for (var e : tm.entrySet())` | `for k, v in tm.items():` |

---

## Python-Only Collections (No Direct Java Equivalent)

### `collections.Counter`

A `dict` subclass that counts hashable objects. Java requires a manual `HashMap<T, Integer>` with explicit increment logic.

| Operation | Python (`Counter`) | Java equivalent (manual) |
|---|---|---|
| Import | `from collections import Counter` | `import java.util.HashMap;` |
| Count from iterable | `c = Counter([1, 1, 2, 3])` | manual loop with `map.merge(k, 1, Integer::sum)` |
| Count from string | `c = Counter("aabbcc")` | manual loop |
| Get count | `c["a"]` *(returns 0 if missing)* | `map.getOrDefault("a", 0)` |
| Most common N | `c.most_common(3)` | sort `entrySet()` by value descending |
| Increment | `c["a"] += 1` or `c.update(["a"])` | `map.merge("a", 1, Integer::sum)` |
| Decrement | `c.subtract(["a"])` | `map.merge("a", -1, Integer::sum)` |
| Remove zeros/negatives | `+c` | manual filter |
| Total count | `c.total()` *(3.10+)* or `sum(c.values())` | `map.values().stream().mapToInt(i->i).sum()` |
| Combine counts | `c1 + c2` | manual merge |
| Intersect (min counts) | `c1 & c2` | manual |
| Union (max counts) | `c1 \| c2` | manual |
| Iterate elements | `for k, v in c.items():` | `for (var e : map.entrySet())` |

```python
from collections import Counter

words = ["apple", "banana", "apple", "cherry", "banana", "apple"]
c = Counter(words)
# Counter({'apple': 3, 'banana': 2, 'cherry': 1})

c.most_common(2)   # [('apple', 3), ('banana', 2)]
c["apple"]         # 3
c["grape"]         # 0  (no KeyError)
c.update(["grape", "apple"])  # increment counts
```

---

### `collections.defaultdict`

A `dict` subclass that auto-initializes missing keys with a factory function. Java's closest is `computeIfAbsent`.

| Operation | Python (`defaultdict`) | Java equivalent |
|---|---|---|
| Import | `from collections import defaultdict` | built-in via `computeIfAbsent` |
| Init with int default (0) | `d = defaultdict(int)` | `map.getOrDefault(k, 0)` |
| Init with list default | `d = defaultdict(list)` | `map.computeIfAbsent(k, x -> new ArrayList<>())` |
| Init with set default | `d = defaultdict(set)` | `map.computeIfAbsent(k, x -> new HashSet<>())` |
| Access missing key | `d["missing"]` → default value, no exception | `map.getOrDefault("missing", default)` |
| Append to list value | `d["key"].append(10)` | `map.computeIfAbsent("key", x -> new ArrayList<>()).add(10)` |
| Custom default | `defaultdict(lambda: "N/A")` | `map.getOrDefault(k, "N/A")` |

```python
from collections import defaultdict

# Group words by first letter
words = ["apple", "avocado", "banana", "blueberry", "cherry"]
groups = defaultdict(list)
for w in words:
    groups[w[0]].append(w)
# defaultdict(<class 'list'>, {'a': ['apple', 'avocado'], 'b': ['banana', 'blueberry'], 'c': ['cherry']})

# Count occurrences
freq = defaultdict(int)
for w in words:
    freq[w] += 1
```

---

### `collections.OrderedDict`

A `dict` subclass that guaranteed insertion order before Python 3.7 and provides extra order-aware methods. Now mostly useful for `move_to_end` and LRU patterns.

| Operation | Python (`OrderedDict`) | Java equivalent |
|---|---|---|
| Import | `from collections import OrderedDict` | `import java.util.LinkedHashMap;` |
| Initialize | `od = OrderedDict()` | `new LinkedHashMap<>()` |
| Move key to end | `od.move_to_end("key")` | no direct equivalent |
| Move key to front | `od.move_to_end("key", last=False)` | no direct equivalent |
| Pop last item | `od.popitem(last=True)` | no direct equivalent |
| Pop first item | `od.popitem(last=False)` | `map.entrySet().iterator().next()` then remove |
| LRU cache pattern | move accessed key to end, pop first when full | `LinkedHashMap` with access-order mode |

```python
from collections import OrderedDict

lru = OrderedDict()
lru["a"] = 1
lru["b"] = 2
lru["c"] = 3

lru.move_to_end("a")          # a is now most-recently used
lru.popitem(last=False)       # evict least recently used ("b")
```

---

### `frozenset`

An immutable, hashable version of `set`. Can be used as a dict key or set element. Java's equivalent is `Collections.unmodifiableSet()`, but it remains hashable only if the underlying elements are — and it cannot be used as a `HashMap` key.

| Operation | Python (`frozenset`) | Java equivalent |
|---|---|---|
| Create | `fs = frozenset([1, 2, 3])` | `Collections.unmodifiableSet(new HashSet<>(List.of(1,2,3)))` |
| From set | `fs = frozenset(s)` | `Collections.unmodifiableSet(s)` |
| Contains | `2 in fs` | `fs.contains(2)` |
| Set operations | `fs1 & fs2`, `fs1 \| fs2`, `fs1 - fs2` | same as `HashSet` but result is mutable |
| Use as dict key | `d[frozenset([1,2])] = "val"` | not possible with unmodifiableSet |
| Use inside a set | `{frozenset([1,2]), frozenset([3,4])}` | not possible |
| Immutable | yes — no add/remove | `unmodifiableSet` throws `UnsupportedOperationException` |

```python
# frozenset as dict key — useful for grouping anagrams
from collections import defaultdict

words = ["eat", "tea", "tan", "ate", "nat", "bat"]
groups = defaultdict(list)
for w in words:
    groups[frozenset(w)].append(w)  # frozenset used as key
```

---

## Quick Reference: Java → Python Collection Mapping

| Java | Python |
|---|---|
| `ArrayList` | `list` |
| `LinkedList` (as queue) | `collections.deque` |
| `ArrayDeque` (stack / deque) | `collections.deque` or `list` |
| `PriorityQueue` | `heapq` module |
| `HashSet` | `set` |
| `LinkedHashSet` | `dict` (keys only, Python 3.7+) |
| `TreeSet` | `sortedcontainers.SortedList` |
| `HashMap` | `dict` |
| `LinkedHashMap` | `dict` (Python 3.7+) or `collections.OrderedDict` |
| `TreeMap` | `sortedcontainers.SortedDict` |
| `Stack` (legacy) | `list` (use `.append`/`.pop`) |
| *(no equivalent)* | `collections.Counter` |
| *(no equivalent)* | `collections.defaultdict` |
| *(no equivalent)* | `frozenset` |
