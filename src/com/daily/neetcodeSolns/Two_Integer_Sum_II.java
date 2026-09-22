package com.daily.neetcodeSolns;

public class Two_Integer_Sum_II {

    public static void main(String[] args) {
        int[] ints = new Two_Integer_Sum_II().twoSum(new int[]{1, 2, 3, 4}, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                return new int[]{left, right};
            }
        }
        return new int[]{};
    }
}
