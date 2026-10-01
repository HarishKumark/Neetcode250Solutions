package com.daily.neetcodeSolns;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyStack {

    Queue<Integer> q1;

    public MyStack() {
        q1 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
        for (int i = 0; i < q1.size() - 1; i++) {
            q1.offer(q1.peek());
            q1.poll();
        }
    }

    public int pop() {

        return q1.poll();
    }

    public int top() {


        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(6);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());
//        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
