package com.java.practise;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Counting {

    public static void main(String[] args) {


//
//        String s = "swiss";
//
//        Map<Character, Integer> map = new HashMap<>();
//
//        for (char str : s.toCharArray()) {
//            map.put(str, map.getOrDefault(str, 0) + 1);
//        }
//
//        for (char m : s.toCharArray()) {
//            if (map.get(m) == 1) {
//                return Optional.of(m);
//            }
//        }
//
//         s.chars().mapToObj(e -> (char)e).map(Character::new)
//                 .collect(Collectors.groupingBy(Function.identity(),  LinkedHashMap::new, Collectors.counting()));

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

        List<String> list = Arrays.stream(str).collect(Collectors.toList());

//        List<String> list1 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
//                .sorted(Comparator.comparingInt(e -> e.getValue().intValue()).reversed().thenComparing(entry -> entry.getKey()))
//                .limit(2).map(e -> e.getKey()).collect(Collectors.toList());


        List<String> collect = list.stream()
                .distinct()
                .sorted(Comparator.comparingInt(String::length).reversed()
                        .thenComparing(String::compareToIgnoreCase))
                .limit(3).collect(Collectors.toList());

        listIntoMap(list);
    }


    public static Set<Integer> findDuplicatesUsingStreams(int[] numbers) {

        return Arrays.stream(numbers).mapToObj(e -> e)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1 && e.getValue() <= 2).map(Map.Entry::getKey).distinct().collect(Collectors.toSet());
    }

    public static Set<Integer> findDuplicates(int[] numbers) {


        Map<Integer, Integer> map = new HashMap<>();

        for (int n : numbers) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (int n : numbers) {
            if (map.get(n) > 1 && map.get(n) <= 2) {
                if(!set.contains(n))
                    set.add(n);
            }
        }
        return set;
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


        Optional<Employee> hr = list.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("HR"))
                .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)));


        Map<String, Integer> collect14 = list.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary, Integer::max));

        Map<String, Integer> collect13 = list.stream()
                .filter(e -> e.getSalary() >= 60_000)
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));

        Comparator<Employee> bySalAsc = Comparator.comparingInt(Employee::getSalary).reversed();
        Comparator<Employee> employeeComparator = bySalAsc.thenComparing(Employee::getName);

        List<String> collect12 = list.stream().filter(e -> e.getSalary() >= 60_000)
                .sorted(employeeComparator).limit(3).map(Employee::getName).collect(Collectors.toList());

        list.stream().sorted(bySalAsc).collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));


        Comparator<Employee> byDepartment =
                Comparator.comparing(Employee::getDepartment);

        Comparator<Employee> bySalaryDescending =
                Comparator.comparingInt(Employee::getSalary).reversed();

        Comparator<Employee> byName =
                Comparator.comparing(Employee::getName);

        list.stream().sorted(byDepartment.thenComparing(bySalaryDescending).thenComparing(byName)).collect(Collectors.toList());

        List<Employee> collect11 = list.stream().sorted(
                Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Comparator.comparingInt(Employee::getSalary)
                                .reversed())).collect(Collectors.toList());

        Map<String, Employee> collect10 = list.stream().collect(Collectors.toMap(Employee::getDepartment, Function.identity(),
                BinaryOperator.minBy(Comparator.comparingInt(Employee::getSalary))));

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
