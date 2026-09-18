package com.daily.leetcodeSolns;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.countCommas(1002);
//        solution.maxPalindromes("abaccdbbd", 3);
        System.out.println(solution.numberOfSets(4, 2));
    }


//    public int getValue(int n, int k){
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//            }
//        }
//    }

    public int numberOfSets(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;

        }
        for (int j = 1; j <= k; j++) {
            int runningTotal = 0;
            for (int l = 2; l <= n; l++) {
                runningTotal = (runningTotal+dp[l - 1][j - 1]) % 1_000_000_007;
                dp[l][j] = (dp[l - 1][j] + runningTotal)% 1_000_000_007;
            }
        }

        return dp[n][k];
    }

    public int numberOfSetsOld(int n, int k) {
        int segmentCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //remaining count
                segmentCount += remainingSets(j, n, k - 1);
            }
        }
        return segmentCount;
    }

    public int remainingSets(int startIndex, int n, int k) {
        if (k == 0) {
            return 1;
        }
        int count = 0;
        for (int i = startIndex; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                count += remainingSets(j, n, k - 1);
            }
        }
        return count;
    }


    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int count = 0;
        while (length > 0) {
            if (charArray[count++] != charArray[length - 1]) {
                return false;
            }
            length--;
        }
        return true;
    }

    public int maxPalindromes(String s, int k) {
        int length = s.length();
        int palindromeCount = 0;

        int index = 0;
        while ((k + index) <= length) {
            String str = s.substring(index, k + index);
            if (isPalindrome(str)) {
                palindromeCount++;
                index = index + k;
            } else if (index + k + 1 <= length) {
                if (isPalindrome(s.substring(index, k + index + 1))) {
                    palindromeCount++;
                    index = index + k + 1;
                } else {
                    index++;
                }
            } else {
                index++;
            }
        }
        return palindromeCount;
    }


    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int answer = 0;

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int sum = node.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];
        int avg = sum / count;
        if (node.val == avg) {
            answer++;
        }
        return new int[]{sum, count};
    }

    public int averageOfSubtree(TreeNode root) {
        answer = 0;
        dfs(root);
        return answer;
    }

    public long countCommas(long n) {
        long total = 0;
        if (n < 1_000) {
            return total;
        }
        if (n >= 1_000) {
            total += (n - 1000) + 1;
        }
        if (n >= 1_000_000) {
            total += (n - 1_000_000) + 1;
        }
        if (n >= 1_000_000_000) {
            total += (n - 1_000_000_000) + 1;
        }
        if (n >= 1_000_000_000_000L) {
            total += (n - 1_000_000_000_000L) + 1;
        }
        if (n >= 1000_000_000_000_000L) {
            total += (n - 1000_000_000_000_000L) + 1;
        }
        return total;
    }
}