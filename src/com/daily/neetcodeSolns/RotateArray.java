package com.daily.neetcodeSolns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RotateArray {

    public static void main(String[] args) {

//        new RotateArray().rotate(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 4);

//        int i = new RotateArray().numRescueBoats(new int[]{3, 2, 2, 1}, 3);
//        int i = new RotateArray().numRescueBoats(new int[]{1, 3, 2, 3, 2}, 3);
//        int i = new RotateArray().numRescueBoats(new int[]{5, 1, 4, 2}, 6);

//        int i = new RotateArray().maxArea(new int[]{1, 7, 2, 5, 4, 7, 3, 6});
//        System.out.println(i);

        int i = new RotateArray().calPoints(new String[]{"1", "2", "+", "C", "5", "D"});
        System.out.println(i);
    }


    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String str : operations) {
            switch (str) {
                case "C":
                    if (!stack.empty())
                        stack.pop();
                    break;
                case "D":
                    if (!stack.empty())
                        stack.push(2 * stack.peek());
                    break;
                case "+":
                    if (!stack.empty()) {
                        Integer firstElement = stack.pop();
                        Integer secondELement = stack.peek();
                        stack.push(firstElement);
                        stack.push(firstElement + secondELement);
                    }
                    break;
                default:
                    stack.push(Integer.parseInt(str));
                    break;

            }
        }
        int sum = 0;
        while (!stack.empty()) {
            sum += stack.pop();
        }
        return sum;
    }


//    public int trap(int[] height) {
//
//
//    }

    public int lengthOfLastWord(String s) {

        String trim = s.trim();
        String[] s1 = trim.split(" ");
        return s1[s1.length - 1].length();

    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0, j = nums.length;
        while (i < j) {
            if (nums[i] == nums[j]) {
                return (Math.abs(i - j) >= k);
            }
            i++;
            j--;
        }
        return false;
    }


    public int trapOld(int[] heights) {


        int leftArry[] = new int[heights.length];
        int rightArray[] = new int[heights.length];

        for (int i = 1; i < heights.length; i++) {
            leftArry[i] = Math.min(heights[i - 1], heights[i]);
        }

        for (int i = 1; i < heights.length; i++) {
            rightArray[i] = Math.max(heights[i - 1], heights[i]);
        }
        int sum = 0;

        for (int i = 0; i < heights.length; i++) {
            sum += (rightArray[i] * leftArry[i]) - heights[i];

        }
        return sum;

    }


    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxArea = 0;
        while (left < right) {
            int w = right - left;
            int h = Math.min(heights[right], heights[left]);
            int area = w * h;
            maxArea = Math.max(area, maxArea);
            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }


    public int numRescueBoats(int[] people, int limit) {
        int left = 0, right = people.length - 1;
        int count = 0;

        Arrays.sort(people);
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            count++;
        }
        return count;
    }

    //    k = 0   arr = 1,2,3,4,5,6,7,8
    //    k = 1   arr = 8,1,2,3,4,5,6,7
    //    k = 2   arr = 7,8,1,2,3,4,5,6
    //    k = 3   arr = 6,7,8,1,2,3,4,5

    public void rotate(int[] nums, int k) {
        for (int j = 0; j < k; j++) {
            int i = nums.length - 1;
            int ele = nums[i];
            for (; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[i] = ele;
        }


//        for (int i = 0; i < nums.length - 1; i++) {
//            int ele = nums[0];
//            for (int j = 1; j < nums.length - 1; j++) {
//
//                nums[i+1] = nums[i];
//
//            }
//
//        }


        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
