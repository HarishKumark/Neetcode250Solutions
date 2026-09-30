package com.daily.neetcodeSolns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_4_sum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; ) {

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long totalSum = Long.valueOf(nums[i]) + Long.valueOf(nums[j]) + Long.valueOf(nums[left]) + Long.valueOf(nums[right]);
                    if (totalSum > target) {
                        right--;
                    } else if (totalSum < target) {
                        left++;
                    } else {
                        ArrayList<Integer> list1 = new ArrayList<>();
                        list1.add(nums[i]);
                        list1.add(nums[j]);
                        list1.add(nums[left]);
                        list1.add(nums[right]);
                        list.add(list1);

                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) left++;
                    }
                }
                j++;
                while (j < nums.length && nums[j] == nums[j - 1]) {
                    j++;
                }
            }

        }
        return list;
    }


}
