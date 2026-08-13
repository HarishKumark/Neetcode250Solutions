package com.daily.neetcodeSolns;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(
                new ValidAnagram().isAnagram("racecar", "carrace")
        );
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                if (map.get(t.charAt(i)) > 0) {
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);

                    if (map.get(t.charAt(i)) == 0) {
                        map.remove(t.charAt(i));
                    }

                } else {
                    map.remove(t.charAt(i));
                }
            }
        }


        return map.isEmpty();
    }
}
