package com.daily.neetcodeSolns;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProductItself {
    public static void main(String[] args) {
        ProductItself productItself = new ProductItself();
        productItself.productExceptSelf(new int[]{1, 2, 4, 6});
    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int[] rightRes = new int[nums.length];
        Arrays.fill(rightRes, 1);

        for (int i = nums.length - 1; i > 0; i--) {
            rightRes[i - 1] = rightRes[i] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] *= rightRes[i];
        }

        return res;
    }


    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i != j && j != k && i != k) {
                        if (digits[k] % 2 == 0 && digits[i] != 0) {
                            set.add((digits[i] * 100) + (digits[j] * 10) + digits[k]);
                        }
                    }
                }
            }
        }
        return set.size();
    }
}
