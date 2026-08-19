package com.java.practise;

import java.util.*;
import java.util.function.BinaryOperator;
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
        int salary;

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

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }
    }

    public static void getHighestPaidEmp(List<Employee> list) {


        List<Employee> collect11 = list.stream().sorted(
                Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Comparator.comparingInt(Employee::getSalary)
                                .reversed())).collect(Collectors.toList());

        Map<String, Employee> collect10 = list.stream().collect(Collectors.toMap(Employee::getDepartment, Function.identity(), BinaryOperator.minBy(Comparator.comparingInt(Employee::getSalary))));

        list.stream().collect(Collectors.toMap(Employee::getDepartment, Function.identity(), (esal, newsal) -> esal.getSalary() > newsal.getSalary() ? esal : newsal));

        LinkedHashMap<String, Integer> collect9 = list.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary, Integer::max, LinkedHashMap::new));


        Map<String, Map<Boolean, Long>> collect8 = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.partitioningBy(e -> e.getSalary() >= 60_000, Collectors.counting())));

        Map<String, Map<Boolean, List<Employee>>> collect7 = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.partitioningBy(e -> e.getSalary() >= 60_000)));


        Map<String, IntSummaryStatistics> collect6 = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summarizingInt(Employee::getSalary)));
        Map<String, String> collect5 = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.joining(", "))));
        Map<String, Set<String>> collect4 = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toSet())));
        Map<String, List<String>> collect3 = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));


        list.stream().collect(Collectors.groupingBy(Employee::getDepartment)).entrySet().stream()
                .flatMap(e -> e.getValue().stream().map(
                        Employee::getName
                )).collect(Collectors.toList());

        Map<Boolean, Long> collect2 = list.stream().collect(Collectors.partitioningBy(employee -> employee.getSalary() >= 60_000, Collectors.counting()));

        Map<Boolean, List<Employee>> collect1 = list.stream().collect(Collectors.partitioningBy(employee -> employee.getSalary() >= 60_000));


        String notFound = list.stream().filter(e -> "HR".equalsIgnoreCase(e.getDepartment())).findFirst().map(Employee::getName).orElse("Not Found");

        list.stream().filter(e -> "HR".equalsIgnoreCase(e.getDepartment())).findAny();

        list.stream().filter(employee -> employee.getSalary() > 60000).findFirst();

        list.stream().filter(e -> "IT".equalsIgnoreCase(e.getDepartment()) && "ALICE".equalsIgnoreCase(e.getName())).map(e -> e.getName()).findFirst();

        list.stream().filter(e -> e.getDepartment().equalsIgnoreCase("IT")).findFirst();
        list.stream().min(Comparator.comparingInt(Employee::getSalary));

        list.stream().max(Comparator.comparingInt(Employee::getSalary));
        Map<String, Optional<Employee>> collect = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));

        list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));

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
