package functional.oops.practice;

import java.util.stream.Collectors;
import java.util.stream.Stream;
//https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
//https://www.digitalocean.com/community/tutorials/regular-expression-in-java-regex-example
public class RegexPatternDemo {
    public static void main(String[] args) {
        String[] array = {"123f", "1dsa12", "1212 ds", "65fD", "sadfa", "asdasd"};
        String str = Stream.of(array).collect(Collectors.joining(","));
        System.out.println(str);
        System.out.println(str.replaceAll("\\s",""));
    }
}
