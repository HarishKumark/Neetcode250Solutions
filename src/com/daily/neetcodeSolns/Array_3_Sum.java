package com.daily.neetcodeSolns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_3_Sum {
    public static void main(String[] args) {
        List<List<Integer>> list = new Array_3_Sum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(list);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int target = nums[i] + nums[left] + nums[right];
                if (target > 0) {
                    right--;
                } else if (target < 0) {
                    left++;
                } else {
                    ArrayList<Integer> list1 = new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[left]);
                    list1.add(nums[right]);
                    if (!list.contains(list1))
                        list.add(list1);
                    left++;
//                    while (nums[left] == nums[left - 1] && left < right) {
//                        left++;
//                    }
                }
            }
        }

        return list;
    }
}
