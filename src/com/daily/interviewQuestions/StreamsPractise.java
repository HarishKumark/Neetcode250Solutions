package com.daily.interviewQuestions;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPractise {


    public static void streamsEx() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        List<Integer> evenList = list.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
//        System.out.println(evenList);

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
//        System.out.println(collect3);


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

        Map<Integer, List<String>> collect6 = stringList.stream()
                .collect(Collectors.groupingBy(String::length));

//        System.out.println(collect6);

//        System.out.println(squareList);

        String str = "swiss";

        LinkedHashMap<Character, Long> collect7 = str.chars().mapToObj(ele -> (char) ele)
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting()));
        Optional<Character> first = collect7.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();


        Map<String, Long> collect8 = stringList.stream().collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
//        System.out.println(collect8);

        List<String> stringListNew = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        Map<String, List<String>> collect9 = stringListNew.stream()
                .collect(Collectors.groupingBy(e -> {
                    char[] charArray = e.toCharArray();
                    Arrays.sort(charArray);
                    return new String(charArray);
                }));
        String collect10 = stringListNew.stream().map(String::toUpperCase).collect(Collectors.joining(","));

        Map<String, Long> collect11 = stringListNew.stream()
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        collect11.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,          // Word
                        Map.Entry::getValue,        // Count
                        (sss, second) -> sss,   // Keep first value if keys repeat
                        LinkedHashMap::new));
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Map<String, List<Employee>> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        Map<String, Long> collect1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        Map<String, Double> collect2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        Map<String, Optional<Employee>> collect3 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        List<Employee> collect4 = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)
                        .reversed().thenComparing(Employee::getName))
                .collect(Collectors.toList());
        Optional<Float> any = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .map(e -> e.salary)
                .distinct()
                .skip(1).findFirst();
        List<Employee> collect5 = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3).collect(Collectors.toList());

        Map<String, Employee> employeesById = employeeList.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        Function.identity(),
                        (first, second) ->
                                first.getSalary() >= second.getSalary() ? first : second
                ));

        String str = "";

        String res = Optional.ofNullable(str)
                .filter(e -> !e.trim().isEmpty())
                .map(e -> e.toUpperCase())
                .orElse("UNKNOWN");

        Predicate<Employee> employeePredicate = employeeN -> employeeN.age > 30;
        Predicate<Employee> employeePredicateSal = employeeN -> employeeN.salary > 50000;
        List<Employee> collect6 = employeeList.stream()
                .filter(employeePredicate.and(employeePredicateSal))
                .collect(Collectors.toList());

        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        addition.apply(10, 5);
        subtraction.apply(10, 5);
        multiplication.apply(10, 5);


        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

        CompletableFuture<Integer> sumFuture =
                CompletableFuture.supplyAsync(() ->
                        numbers.stream()
                                .collect(Collectors.summingInt(Integer::intValue))
                );


        CompletableFuture<Integer> optionalCompletableFuture
                = CompletableFuture.supplyAsync(() ->
                numbers.stream()
                        .max(Integer::compareTo).get()
        );

        String join = sumFuture.
                thenCombine(optionalCompletableFuture,
                        (sum, max) -> "Sum: " + sum + ", Max: " + max).join();

        System.out.println(join);
    }

    class Employee {
        String id;
        String name;
        int age;
        String department;
        float salary;

        public Employee(String id, String name, int age, String department, float salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.department = department;
            this.salary = salary;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public float getSalary() {
            return salary;
        }

        public void setSalary(float salary) {
            this.salary = salary;
        }
    }

    @FunctionalInterface
    interface MathOperation {
        int apply(int a, int b);
    }
}
