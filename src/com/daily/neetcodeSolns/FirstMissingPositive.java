package com.daily.neetcodeSolns;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public static void main(String[] args) {

        int i = new FirstMissingPositive().firstMissingPositive(new int[]{3,4,-1,1});
        System.out.println(i);
    }

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (!set.contains(nums[i] + 1)) {
                return nums[i] + 1;
            }
        }
        return nums[nums.length - 1] + 1;

    }
}
