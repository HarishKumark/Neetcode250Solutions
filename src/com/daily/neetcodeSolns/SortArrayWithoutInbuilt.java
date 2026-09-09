package com.daily.neetcodeSolns;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class SortArrayWithoutInbuilt {

    public static void main(String[] args) {
        SortArrayWithoutInbuilt sortArrayWithoutInbuilt = new SortArrayWithoutInbuilt();
//        int[] ints = sortArrayWithoutInbuilt.sortArray(new int[]{10, 9, 1, 1, 1, 2, 3, 1});
//
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i]);
//        }

        sortArrayWithoutInbuilt.topKFrequent(new int[]{3, 0, 1, 0}, 1);

    }

    public int[] sortArray(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;

    }

    public void sortColors(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;

        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(k)
                .mapToInt(ele -> ele.intValue())
                .toArray();

    }


}
