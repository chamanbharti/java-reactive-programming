package functional.java_8_collectors.partitioningBy;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
https://www.educative.io/answers/what-is-collectorspartitioningby-in-java
https://www.logicbig.com/how-to/code-snippets/jcode-java-8-streams-collectors-partitioningby.html
There are two variations of the partitioningBy() method:
partitioningBy(Predicate<? super T> predicate)
partitioningBy(Predicate<? super T> predicate, Collector<? super T, A, D> downstream)
 */

public class PartitioningByExercise {
    public static void main(String[] args) {
        // create an Integer stream
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11);
        // Partitioning condition
        Predicate<Integer>predicate = num->num <= 5;
        // Apply the partitioningBy to partition the stream of numbers into two halves
        Map<Boolean, List<Integer>>map = list.stream().collect(Collectors.partitioningBy(predicate));
        System.out.println("Result of the partitioningBy method - " + map);

        // Partitioning condition to check whether the number is even
        Predicate<Integer>evenPredicate = num -> num % 2 ==0;
        // Apply the partitioningBy to partition the stream of numbers into two halves
        Map<Boolean, List<Integer>>map2 = list.stream().collect(Collectors.partitioningBy(evenPredicate));
        System.out.println("Result after the partitioning - " + map2);

        // Recreate the list
        list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        // Apply the partitioningBy to partition the stream of numbers into two partitions
        // and count the number of elements in each partition
        Map<Boolean,Long>map3 = list.stream().collect(Collectors.partitioningBy(evenPredicate,Collectors.counting()));
        System.out.println("Result of partitioning and reducing - " + map3);
    }
}
