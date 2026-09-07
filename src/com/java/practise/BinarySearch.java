package com.java.practise;

import java.util.*;
import java.util.stream.Collectors;

public class BinarySearch {

    public static void main(String[] args) {

    }


    //    numbers = [1, 2, 2, 2, 3, 4, 5]
//    target = 2
    public static int findFirstOccurrence(int[] numbers, int target) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int left = 0, right = numbers.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] == target) {
                res = mid;
                right = mid - 1;
            } else if (numbers[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }


    public static List<List<String>> groupAnagrams(String[] words) {

        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : words) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String string = new String(charArray);
            if (map.containsKey(string)) {
                map.get(string).add(s);
            } else {
                ArrayList<String> objects = new ArrayList<>();
                objects.add(s);
                map.put(string, objects);
            }
        }

        return new ArrayList<>(map.values());

    }


    public static List<Integer> topKFrequent(int[] numbers, int k) {

        if (numbers == null || numbers.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : numbers) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(entry -> entry.getValue()));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<Integer> res = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> poll = minHeap.poll();
            res.add(poll.getKey());
        }

        return res;
    }
}
