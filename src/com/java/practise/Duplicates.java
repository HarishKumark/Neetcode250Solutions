package com.java.practise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Duplicates {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            list.add(i);
        }
        for (int i = 1; i < 5; i++) {
            list.add(i);
        }

        System.out.println(list);


        List<Integer> collect = list.stream()
                .collect(groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(ele -> ele.getKey().intValue())
                .collect(toList());


        System.out.println(collect);
    }
}
