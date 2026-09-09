package com.daily.neetcodeSolns;

import java.util.HashMap;
import java.util.Map;

public class MyHashSet {

    Map<Integer, Integer> map;

    public MyHashSet() {
        map = new HashMap<>();
    }

    public void add(int key) {
        map.put(key, key);
    }

    public void remove(int key) {
        if (contains(key)) {
            map.remove(key);
        }
    }

    public boolean contains(int key) {
        return map.containsKey(key);
    }
}
