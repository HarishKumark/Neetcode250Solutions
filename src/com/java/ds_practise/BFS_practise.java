package com.java.ds_practise;

import java.util.*;

public class BFS_practise {
    public static void main(String[] args) {


        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(1, List.of(2, 3));
        graph.put(2, List.of(4));
        graph.put(3, List.of(5));
        graph.put(4, List.of());
        graph.put(5, List.of());


        createBFS(graph);
    }


    public static void createBFS(Map<Integer, List<Integer>> map) {

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(1);
        visited.add(1);

        while (!queue.isEmpty()) {
            int val = queue.remove();
            System.out.println(val);
            for (Integer in : map.get(val)) {
                if (!visited.contains(in)) {
                    queue.add(in);
                    visited.add(in);
                }
            }
        }
    }


    public static int bfsShortestDistance(
            Map<Integer, List<Integer>> graph,
            int start,
            int target) {

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> distance = new HashMap<>();
        distance.put(start, 0);
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int val = queue.remove();
            for (Integer in : graph.get(val)) {
                if (!visited.contains(in)) {
                    queue.add(in);
                    visited.add(in);
                    distance.put(in, distance.get(val) + 1);
                }
            }
        }
        return distance.getOrDefault(target, -1);
    }
}
