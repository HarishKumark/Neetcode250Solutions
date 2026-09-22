package com.daily.neetcodeSolns;

public class Best_Time_to_Buy_and_Sell_Stock_II {

    public static void main(String[] args) {

        System.out.println(new Best_Time_to_Buy_and_Sell_Stock_II().isPalindrome("0P"));
    }


    public boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        String str = sb.toString().toLowerCase();
        if (str.isEmpty()) return true;
        if (str.length() > 2) {

            int left = 0;
            int right = str.length() - 1;

            while (left <= right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                right--;
                left++;
            }
            return true;
        }
        return false;

    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
            left++;
        }
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];

            }
        }
        return maxProfit;
    }

}
