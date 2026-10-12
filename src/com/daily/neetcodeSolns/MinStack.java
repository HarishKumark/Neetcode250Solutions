package com.daily.neetcodeSolns;

import java.util.Iterator;
import java.util.Stack;

class Pair {
    int value;
    int min;

    Pair(int value, int min) {
        this.value = value;
        this.min = min;
    }

}

public class MinStack {

    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int min = stack.empty() ? val : stack.peek().min;
        stack.push(new Pair(val, min));
    }

    public void pop() {
        if (!stack.empty()) {
            stack.pop();
        }
    }

    public int top() {
        if (!stack.empty()) {
            return stack.peek().value;
        }
        return 0;
    }

    public int getMin() {
        return stack.peek().min;
    }
}
