package com.java.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Odd_Even {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <11 ; i++) {
            list.add(i);
        }
        Map<Boolean, List<Integer>> collect = list.stream().collect(Collectors.partitioningBy(ele -> ele % 2 == 0));
        System.out.println(collect);
    }
}
