package com.daily.neetcodeSolns;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {


        List<List<String>> lists = new GroupAnagrams().groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"});


        System.out.println(lists);
        System.out.println(majorityElement(new int[]{5,5,1,1,1,5,5}));;

    }


    public static  int majorityElement(int[] nums) {
        int maxCount = nums.length/2;
        int res = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0; i< nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            if(map.get(nums[i]) > maxCount){
                res = Math.max(nums[i], res);
            }
        }
        return res;
    }


    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char ch[] = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(str);
            map.put(key, orDefault);
        }
        return new ArrayList<>(map.values());
    }

}
