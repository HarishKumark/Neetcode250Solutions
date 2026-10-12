package com.daily.neetcodeSolns;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }


    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int pop = stack2.pop();

        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }

        return pop;
    }

    public int peek() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int peek = stack2.peek();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return peek;
    }

    public boolean empty() {
        return stack1.empty();
    }
}
