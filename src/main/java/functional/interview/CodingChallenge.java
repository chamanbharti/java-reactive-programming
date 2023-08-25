package functional.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CodingChallenge {
    public static void main(String[] args) {
//https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062

        List<Integer> list = Arrays.asList(10,15,8,8,49,25,98,32,97);
        list.stream().forEach(no ->{
            System.out.println(IntStream.rangeClosed(2,no/2).noneMatch(i->no%i==0));
        });
       findOutAllTheEvenNumber(list);
       findOutAllTheOddNumber(list);
        findOutAllThePrimeNumber(list);
        findDuplicateNumber(list);
        findUniqueNumber(list);
        countEachElementOrWord();
    }
    private static void findDuplicateNumber(List<Integer> list) {
        System.out.println("findDuplicateNumber");
        Set<Integer> set1 = new HashSet<>();

        //list.stream().filter(item -> set1.add(item)).forEach(System.out::println);//[32, 49, 97, 98, 8, 25, 10, 15]
        list.stream().filter(item -> !set1.add(item)).forEach(System.out::println);//[8]
    }
    private static void findUniqueNumber(List<Integer> list) {
        System.out.println("findUniqueNumber");
        Set<Integer> set1 = new HashSet<>();
        //list.stream().filter(item -> set1.add(item)).forEach(System.out::println);
        list.stream().distinct().forEach(System.out::println);
    }

    private static void findOutAllTheEvenNumber(List<Integer> list) {
        System.out.println("Even Number");
        list.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
    }
    private static void findOutAllTheOddNumber(List<Integer> list) {
        System.out.println("Odd Number");
        list.stream().filter(i -> i % 2 != 0).forEach(System.out::println);
    }
    private static void findOutAllThePrimeNumber(List<Integer> list) {
        System.out.println("Prime Number");
        list.forEach(
          number -> System.out.println(
                  IntStream.rangeClosed(2,number/2)
                  .noneMatch(i -> number%i == 0)
                    )
        );
    }

    private static void countEachElementOrWord(){
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long>map = names.stream()
                .collect(
                    Collectors.groupingBy(
                            Function.identity(),
                            Collectors.counting()
                    )
               );
        System.out.println(map);
    }
}
