package com.daily.neetcodeSolns;

public class SubArraySumII {
    public static void main(String[] args) {

        int i = new SubArraySumII().subarraySum(new int[]{2, -1, 1, 2}, 2);
        System.out.println(i);
    }

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                res++;
            }
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
