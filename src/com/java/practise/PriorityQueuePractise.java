package com.java.practise;

import java.util.Map;
import java.util.PriorityQueue;

public class PriorityQueuePractise {

    public static void main(String[] args) {

        findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }

    public static int findKthLargest(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || k < 1 || k > numbers.length) {
            throw new IllegalArgumentException("Invalid input or k");
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int n : numbers) {
            priorityQueue.add(n);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}
