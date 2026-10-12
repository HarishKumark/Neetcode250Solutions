package com.daily.interviewQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsPractise {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        List<Integer> evenList = list.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenList);

        List<Integer> squareList = list.stream()
                .map(e -> e * e).collect(Collectors.toList());

        list.stream().sorted().findFirst();
        list.stream().sorted(Comparator.reverseOrder()).findFirst();

        list.stream().max(Integer::compareTo);
        list.stream().min(Integer::compareTo);

        list.stream().collect(Collectors.summingInt(Integer::intValue));
        list.stream().collect(Collectors.averagingInt(Integer::intValue));

        list.stream().distinct().sorted(Comparator.reverseOrder())
                .skip(1).findFirst();

        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());

        Map<Integer, Long> collect1 = list.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));

        List<Integer> collect2 = collect1.entrySet().stream().filter(e -> e.getValue() > 1)
                .map(e -> e.getKey()).collect(Collectors.toList());


        Map<Boolean, List<Integer>> collect3 = list.stream().collect(Collectors.partitioningBy(e -> e % 2 == 0, Collectors.toList()));
        System.out.println(collect3);


        List<List<Integer>> listNew = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = i + 1; j < 10; j++) {
                l.add(j);
            }
            listNew.add(l);
        }
        listNew.stream().flatMap(e -> e.stream()).collect(Collectors.toList());


        List<Integer> list1 = Arrays.asList(1, 2, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(2, 2, 4, 6);

        List<Integer> collect4 = list1.stream()
                .filter(e -> list2.contains(e))
                .distinct()
                .collect(Collectors.toList());
        List<String> stringList = Arrays.asList("abc", "abcd", "abcde");

        List<String> collect5 = stringList.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(String::compareTo))
                .collect(Collectors.toList());



//        System.out.println(squareList);
    }
}
