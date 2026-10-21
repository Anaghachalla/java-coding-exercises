package org.exercises.caching;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int maxSize;

    public LRUCache(int maxSize) {
        super(maxSize, 0.75f, true);

        if (maxSize <= 0) {
            throw new IllegalArgumentException(
                    "Cache size must be positive"
            );
        }

        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }
}
