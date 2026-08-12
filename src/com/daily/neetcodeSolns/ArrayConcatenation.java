package com.daily.neetcodeSolns;

import java.util.ArrayList;
import java.util.List;

public class ArrayConcatenation {

    public static void main(String[] args) {


    }


    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] temp = new int[2 * len];

        for (int i = 0; i < len; i++) {
            temp[i] = nums[i];
            temp[i + len] = nums[i];
        }
        return temp;
    }
}
