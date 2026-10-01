package com.daily.neetcodeSolns;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid = validParentheses.isValid("[]");
        System.out.println(valid);
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{') {
                stack.push('}');
            } else if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else {
                if (stack.empty() || stack.pop() != ch) return false;
            }


        }
        return stack.empty();

    }
}
