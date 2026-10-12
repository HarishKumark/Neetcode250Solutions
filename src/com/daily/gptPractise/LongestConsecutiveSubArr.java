package com.daily.gptPractise;

public class LongestConsecutiveSubArr {
    public static void main(String[] args) {
        int arr[] = new int[]{2, 3, 1, 2, 4, 3};
        int longestConsecutiveArraySum = minSubarrayLength(arr, 7);
        System.out.println(longestConsecutiveArraySum);

    }

    public static int minSubarrayLength(int arr[], int target) {
        int count = Integer.MAX_VALUE, sum = 0, right = 0;
        if (arr.length == 0) {
            return 0;
        }
        for (int left = 0; left < arr.length; left++) {
            sum += arr[left];
            while (sum >= target) {
                count = Math.min(count, left - right + 1);
                sum -= arr[right];
                right++;
            }
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }
}
