package com.daily.leetcodeSolns;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countCommas(1002);
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