package com.daily.neetcodeSolns;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Palindrome_II {

    public static void main(String[] args) {

//        "radkar"
        boolean b = new Palindrome_II().validPalindrome("radkar");
        System.out.println(b);

    }

    public boolean validPalindrome(String s) {

        if (isPalindrome(s)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            String newS = s.substring(0, i) + s.substring(i + 1);

            if (isPalindrome(newS)) {
                return true;
            }
        }
        return false;

    }

    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
