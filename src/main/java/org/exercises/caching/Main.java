package org.exercises.caching;

public class Main {
    void main() {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        IO.println(cache);
        cache.get(1);// 1 becomes most recently used
        cache.put(4, "D");// evicts key 2 - A recently used, C - recently inserted

        IO.println(cache);
    }
}
