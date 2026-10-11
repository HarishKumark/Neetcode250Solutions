package com.daily.leetcodeSolns;

public class PalindromCheck {

    public static void main(String[] args) {

        PalindromCheck palindromCheck = new PalindromCheck();
        boolean palindrome = palindromCheck.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);

    }

    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if(left < str.length() && Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }

            while (right != -1 && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }
            if (left < str.length() && right != -1) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }


}
