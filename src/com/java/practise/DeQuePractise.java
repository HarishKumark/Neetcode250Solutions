package com.java.practise;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeQuePractise {

    public static void main(String[] args) {

        System.out.println(isValid("{[()]}"));
    }

    public static boolean isValid(String input) {
        if (input == null) {
            return false;
        }

        Deque<Character> characters = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            if (c == '}' || c == ']' || c == ')') {
                if (!characters.isEmpty()) {
                    char ch = characters.peek();
                    if ((ch == '(' && c == ')') || (ch == '{' && c == '}') || (ch == '[' && c == ']')) {
                        characters.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                characters.push(c);
            }
        }
        return characters.isEmpty();
    }
}
