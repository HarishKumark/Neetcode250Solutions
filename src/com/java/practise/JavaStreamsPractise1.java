package com.java.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamsPractise1 {

    public static void main(String[] args) {

        System.out.println(reverseWords("  Java   makes coding fun  "));
        System.out.println(reverseWordsStreams("  Java   makes coding fun  "));

    }

    public static void moveZeroes(int[] numbers){
        if (numbers == null || numbers.length == 0) {
            return;
        }

        int count =0;
        for (int i = 0; i <numbers.length ; i++) {
            if(numbers[i]!=0){
                numbers[count++] = numbers[i];
            }
        }
        for (int i = count; i <numbers.length ; i++) {
            numbers[i] = 0;
        }

    }

    public static String reverseWordsStreams(String input) {

        String collect = Arrays.stream(input.trim().split("\\s+"))
                .sorted(Comparator.reverseOrder()).collect(Collectors.joining(" "));
        return collect;
    }

    public static String reverseWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }

        String[] s = input.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            if (!s[i].isEmpty())
                sb.append(" ").append(s[i]);
        }
        return sb.toString().trim();
    }
}
