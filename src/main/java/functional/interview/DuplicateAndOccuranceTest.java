package functional.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
//https://stackabuse.com/java-finding-duplicate-elements-in-a-stream/
public class DuplicateAndOccuranceTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9,1, 2, 2, 7, 6, 6, 5, 7);

        List<Integer> deduped = list.stream().distinct().collect(Collectors.toList());
        System.out.println(deduped);
        List<Integer> items = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));

        Set<Integer> set = new HashSet<>(items.size());
        items.removeIf(p -> !set.add(p));

        System.out.println("items:"+items);    //[1, 2, 3, 4, 5, 6, 7, 8]
        System.out.println(set);
        System.out.println("1st approach");
        Map<Integer,Integer>map1 = new HashMap<>();
        for (Integer no:list){
            if(map1.containsKey(no)){
                map1.put(no, map1.get(no)+1);
            }else {
                map1.put(no, 1);
            }
        }
        System.out.println(map1);

        System.out.println("2nd approach");
        Map<Integer,Long>map2 = list.stream()
                .collect(
                         Collectors.groupingBy(
                                                Function.identity(),
                                                Collectors.counting()
                                               )
                        );
        System.out.println(map2);

        System.out.println("3rd approach");
        Map<Integer,Integer>map3 = list.stream()
                .collect(
                          Collectors.toMap(
                                              Function.identity(),
                                              value -> 1,
                                              Integer::sum
                                         )
                        );
        System.out.println(map3);

        String str = removeDuplicates("Javaprogram");

        System.out.println( str );

        /*
        List<Integer> intList = Arrays.asList(1, 2, 3);
        String result = intList.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining("", "", ""));

        System.out.println(result);//123
        */
        System.out.println("before removing:"+list);
        System.out.println("remove that no which has come more than one");
        String result = ListToString(list);
        System.out.println(removeDuplicates(result));
        System.out.println("removed duplicate:"+removeNoThatComesMoreThanOne(list));
    }
    private static List<Integer>  removeNoThatComesMoreThanOne(List<Integer> list){

        List<Integer> removedList = new ArrayList<>();
        for (Integer i:list){
            if (removedList.contains(i)){
                removedList.remove(i);
            }else {
                removedList.add(i);
            }
        }
        return removedList;
    }
    private static String ListToString(List<Integer> list){
        return list.stream().map(String::valueOf).collect(Collectors.joining());
    }
    private static String removeDuplicates( String str ) {

        final Set<Character> temp = new HashSet<>();
        for( final char c : str.toLowerCase().toCharArray() ) {
            if( !temp.add(c) ) {
                str = str.replace( Character.toString(c), "" );
            }
        }
        return str;
    }
}
