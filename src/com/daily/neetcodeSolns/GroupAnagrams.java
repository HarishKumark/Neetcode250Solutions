package com.daily.neetcodeSolns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {



        new GroupAnagrams().groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"});
    }

    static String getHash(String s) {
        StringBuilder hash = new StringBuilder();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            hash.append(freq[i]);
        }

        return hash.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String key = getHash(strs[i]);
            if (!mp.containsKey(key)) {
                mp.put(key, res.size());
                res.add(new ArrayList<>());
            }
            res.get(mp.get(key)).add(strs[i]);
        }

        return res;
    }

}
