package com.daily.neetcodeSolns;

public class MergeSortedArray {

    public static void main(String[] args) {
        new MergeSortedArray().merge(new int[]{-3, -2, -1, 0, 0, 0}, 3, new int[]{-6, -5, -4}, 3);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        sortArray(nums1);

        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                nums1[i] = nums2[count++] + nums1[i];
            }
        }
        sortArray(nums1);

    }

    public void sortArray(int[] nums1) {
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                if (nums1[i] >= nums1[j]) {
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
    }
}
