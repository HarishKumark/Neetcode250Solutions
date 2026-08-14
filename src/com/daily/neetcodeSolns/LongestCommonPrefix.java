package com.daily.neetcodeSolns;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {

//        Input: strs = ["bat","bag","bank","band"]
//
//        Output: "ba"

//        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"ab", "ba"}));

        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"dance", "dag", "danger", "damage"}));
    }


    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int i = 0;
        String first = strs[0];
        for (int j = 0; j < first.length(); j++) {
            boolean allMatch = true;
            for (int k = 1; k < strs.length; k++) {
                if (j >= strs[k].length()  || strs[k].charAt(j) != first.charAt(j)) {
                    allMatch = false;
                    break;
                }
            }
            if (allMatch == false) {
                break;
            }
            i++;
        }

        if (i == 0) {
            return "";
        }
        return first.substring(0, i);
    }
}
