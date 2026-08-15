package com.java.practise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Counting {

    public static void main(String[] args) {
//        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 1; i < 3; i++) {
////            list.add(i);
//            List<Integer> ll = new ArrayList<>();
//            for (int j = 0; j < 5; j++) {
//                ll.add(j);
//            }
//            list.add(ll);
//        }
//        System.out.println(list);
//        for (int i = 1; i <5 ; i++) {
//            list.add(i);
//        }
//
//        countFrequency(list);
//        nonRepeatChar("swiss");
//        System.out.println(secondHighest(list));
//        flattenList(list);

        String[] str = new String[]{"Java", "Code", "Scala", "Spring"};
        List<String> collect = Arrays.stream(str).collect(Collectors.toList());

        listIntoMap(collect);
    }

    class Employee {
        String name;
        String department;
        String salary;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }
    }

    public static void getHighestPaidEmp(List<Employee> list) {

        list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));


    }


    public static Map<Integer, String> listIntoMap(List<String> list) {

        Map<Integer, String> collect = list.stream().
                collect(Collectors.toMap(e -> e.length(), Function.identity(), (e1, e2) -> e1));

        System.out.println(collect);
        return collect;
    }

    public static void flattenList(List<List<Integer>> list) {
        List<Integer> collect = list.stream().flatMap(ele -> ele.stream()).collect(Collectors.toList());
        System.out.println(collect);
    }

    public static Optional<Integer> secondHighest(List<Integer> list) {
        return list.stream()
                .distinct().sorted((ele, ele2) -> ele2.compareTo(ele))
                .skip(1).findFirst();
    }

    public static void nonRepeatChar(String str) {

        Optional<Character> first = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(ele -> ele.getValue() == 1)
                .map(ele -> ele.getKey().charAt(0))
                .findFirst();


        System.out.println(first);
    }

    public static void countFrequency(List<Integer> list) {

        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);
    }


}
