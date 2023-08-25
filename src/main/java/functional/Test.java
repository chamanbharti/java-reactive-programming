package functional;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,1,2,2,3,4);
        System.out.println("element count:"+list.stream().distinct().collect(Collectors.counting()));
        int sum = list.stream().distinct().reduce(0,(a,b) -> a+b).intValue();
        System.out.println("sum1:"+sum);
        sum = list.stream().distinct().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("sum2:"+sum);
        sum = list.stream().distinct().mapToInt(Integer::intValue).sum();
        System.out.println("sum2:"+sum);
        System.out.println(String.class.getModule());
        System.out.println(Connection.class.getModule());
        System.out.println(Date.class.getModule());
    }
}
