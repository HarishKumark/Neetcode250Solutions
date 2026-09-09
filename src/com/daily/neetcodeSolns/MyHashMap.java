package com.daily.neetcodeSolns;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {

    Map<Integer, Integer> map;

    public MyHashMap() {
        map = new HashMap<>();
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return -1;
    }

    public void remove(int key) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
    }
}
