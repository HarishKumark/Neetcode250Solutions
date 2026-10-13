package com.daily.neetcodeSolns;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReversePolish {

    public static void main(String[] args) {
        ReversePolish reversePolish = new ReversePolish();
//        int i = reversePolish.evalRPN(new String[]{"1", "2", "+", "3", "*", "4", "-"});
        int i = reversePolish.evalRPN(new String[]{"4", "13", "5", "/", "+"});


        System.out.println(i);

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int first = stack.pop();
                    int sencd = stack.pop();
                    stack.push((sencd - first));
                    break;

                case "/":
                    int firstval = stack.pop();
                    int sencdval = stack.pop();
                    stack.push(Math.abs((sencdval / firstval)));
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
