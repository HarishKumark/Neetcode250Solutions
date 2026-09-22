package com.daily.neetcodeSolns;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Remove_Duplicates_From_Sorted_Array {
    public static void main(String[] args) {
        int i = new Remove_Duplicates_From_Sorted_Array().removeDuplicates(new int[]{1, 2, 2, 3, 4});
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        int duplicateCount = 0;
        Set<Integer> set = new TreeSet<>();
        for (int n : nums) {
            if (!set.contains(n)) {
                duplicateCount++;
            }
            set.add(n);
        }
        int idx = 0;
        for (Integer val : set) {
            nums[idx++] = val;
        }
        return duplicateCount;
    }

}
