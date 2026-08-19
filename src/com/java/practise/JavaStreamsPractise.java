package com.java.practise;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JavaStreamsPractise {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.stream().mapToInt(value -> value).summaryStatistics();


        list.stream().noneMatch(e -> e<0);

        list.stream().allMatch(e -> e>0);
        boolean b = list.stream().anyMatch(ele -> ele % 3 == 0);

        list.stream().distinct().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());


        list.stream().filter(ele -> ele % 2 == 0).map(ele -> ele * ele)
                .reduce(0, (integer, integer2) -> integer + integer2);

        Integer multiply = list.stream().reduce(1, (total, number) -> total * number);

        List<String> strList = new ArrayList<>();
        strList.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));

        strList.stream().collect(Collectors.groupingBy(String::length, Collectors.toList()));

        strList.stream().collect(Collectors.joining(", ", "[", "]"));

        strList.stream().mapToInt(String::length).average().orElse(0.0);

        strList.stream().filter(e -> e.length()>4).count();

        strList.stream().filter(e -> e.startsWith("a")).map(e -> e.toUpperCase()).collect(Collectors.toList());

        strList.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());

        strList.stream().sorted(Comparator.comparingInt(String::length).reversed()).collect(Collectors.toList());

        strList.stream().sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())).collect(Collectors.toList());

    }
}
