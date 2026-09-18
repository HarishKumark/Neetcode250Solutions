package com.daily.neetcodeSolns;

import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutive {

    public static void main(String[] args) {
        int res = new LongestConsecutive().longestConsecutive(new int[]{2, 20, 4, 10, 3, 4, 5});
        System.out.println("res ========= " + res);
    }


    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int outerSum = 0;
        for (int i = 0; i < nums.length; i++) {
            outerSum += nums[i];
            if (outerSum == k) {
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (outerSum + nums[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public List<Integer> majorityElement(int[] nums) {


        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer> collect = map.entrySet().stream().filter(ele -> ele.getValue() > nums.length / 3).map(Map.Entry::getKey).collect(Collectors.toList());
        return collect;

    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {

        }

        return maxProfit;
    }

    //2,3,4, 4,5,10,20
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int res = 1;
        Arrays.sort(nums);
        int currentLength = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                continue;
            } else if (nums[i + 1] - nums[i] == 1) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            res = Math.max(currentLength, res);
        }
        return res;
    }
}
