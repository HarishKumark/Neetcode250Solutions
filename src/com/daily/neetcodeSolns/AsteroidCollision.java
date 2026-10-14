package com.daily.neetcodeSolns;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
//        int[] ints1 = {2, 4, -4, -1};
        int[] ints1 = {10, 2, -5};
        int[] ints = asteroidCollision.asteroidCollision(ints1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            while (!stack.empty() && asteroids[i] > 0 && stack.peek() > 0) {
                Integer peek = stack.peek() + asteroids[i];
                if (peek > 0) {
                    asteroids[i] = 0;
                } else if (peek < 0) {
                    stack.pop();
                } else {
                    stack.pop();
                    asteroids[i] = 0;
                }
            }
            if (asteroids[i] != 0) {
                stack.push(asteroids[i]);
            }
        }
        int arr[] = new int[stack.size()];
        int idx = stack.size() - 1;
        while (!stack.isEmpty()) {
            arr[idx--] = stack.pop();
        }
        return arr;
    }
}
