package functional.java9.stream_enhancement;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEnhancement {
    public static void main(String[] args) {
        System.out.println("takeWhile");
        Stream.of("a","b","c","","e","f")
                .takeWhile(s-> !s.isEmpty())
                .forEach(System.out::print);

        System.out.println("\ndropWhile");
        Stream.of("a","b","c","","e","f")
                .dropWhile(s-> !s.isEmpty())
                .forEach(System.out::print);

        System.out.println("\niterate");
        IntStream.iterate(3, x->x < 10, x->x + 3)
                .forEach(System.out::println);

        System.out.println("\nofNullable");
        long count = Stream.ofNullable(100).count();
        System.out.println(count);
        count = Stream.ofNullable(null).count();
        System.out.println(count);
    }
}
