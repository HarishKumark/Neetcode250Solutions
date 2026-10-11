package com.daily.leetcodeSolns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args) {
//        abcabcbb

//        System.out.println(lengthOfLongestSubstring("acbbbb"));

        System.out.println(longestConsecutiveZeros2(new int[]{1, 0, 1, 1, 0, 1}));





    }

    public static int longestZeroesofK(int arr[], int k) {

        int zerosCount = 0;
        int right = 0;
        int maxWindow = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zerosCount++;
            }
            while (zerosCount > k) {
                if (arr[right] == 0) {
                    zerosCount--;
                }
                right++;
            }

            maxWindow = Math.max(maxWindow, i - right + 1);
        }
        return maxWindow;
    }


    public static int longestConsecutiveZeros2(int[] arr) {
        int left = 0, zeroCount = 0, maxSize = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxSize = Math.max(maxSize, right - left + 1);
        }
        return maxSize;
    }


    //1, 0, 1, 1, 0, 1
    public static int longestConsecutiveZeros(int[] arr) {

        int maxSize = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            if (arr[i] == 0) {
                count++;
            }
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == 0) {
                    count++;
                }
                if (count > 1) {
                    break;
                }
                list.add(arr[j]);
            }
            maxSize = Math.max(maxSize, list.size());
        }
        return maxSize;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int maxSize = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i));
                    break;
                }
                set.add(s.charAt(j));
            }
            maxSize = Math.max(maxSize, set.size());

        }
        return maxSize;
    }


}
