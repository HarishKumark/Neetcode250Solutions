package com.daily.neetcodeSolns;

public class SortArrayWithoutInbuilt {

    public static void main(String[] args) {
        SortArrayWithoutInbuilt sortArrayWithoutInbuilt = new SortArrayWithoutInbuilt();
        int[] ints = sortArrayWithoutInbuilt.sortArray(new int[]{10, 9, 1, 1, 1, 2, 3, 1});

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }

    public int[] sortArray(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len-1; i++) {
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
        return nums;

    }

}
