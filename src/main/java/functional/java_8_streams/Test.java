package functional.java_8_streams;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,15,8,49,49,25,98,98,32);

        // Given a list of integers, find out all the even numbers that exist in the list using Stream functions?

        //list.stream().filter(i->i%2==0).forEach(System.out::println);
       // list = list.stream().filter(i->i%2 == 0).collect(Collectors.toList());
        //System.out.println(list);

        //Given a list of integers, find out all the numbers starting with 1 using Stream functions?

        //list.stream().map(s->s + "").filter(i->i.startsWith("1")).forEach(System.out::println);

        //How to find duplicate elements in a given integers list in java using Stream functions?
        Set<Integer> set = new HashSet<>();
        //list.stream().filter(item-> set.add(item)).collect(Collectors.toSet());//for unique element
       list.stream().filter(item-> !set.add(item)).forEach(System.out::println);//98
        //int duplicate = list.stream().filter(item-> !set.add(item)).findAny().get();//98
        //System.out.println(duplicate);
        System.out.println(set);//[32, 49, 98, 8, 25, 10, 15]

        // Given the list of integers, find the first element of the list using Stream functions?
        //System.out.println(list.stream().findFirst().get());
        //list.stream().findFirst().ifPresent(System.out::println);

        System.out.println("Given a list of integers, find the total number of elements present in the list using Stream functions?");
        System.out.println(list.stream().count());
        System.out.println(list.stream().collect(Collectors.counting()));
        System.out.println(list.stream().collect(Collectors.averagingInt(Integer::intValue)));
        System.out.println(list.stream().collect(Collectors.summingInt(Integer::intValue)));

        // Given a list of integers, find the total sum of number of elements present in the list using Stream functions?
        int sum = list.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);

       // Given a list of integers, find the maximum value element present in it using Stream functions?
       int max = list.stream().max(Integer::compare).get();
        System.out.println(max);
        int min = list.stream().min(Integer::compare).get();
        System.out.println(min);

        // Given a String, find the first non-repeated character in it using Stream functions?
        String input = "Java Articles are Awesome";
        char[] array = input.toCharArray();
        Map<Character,Integer> map = new HashMap<>();

//        for (int i=input.length()-1;i>=0;i--){
        for (char ch:array){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else {
                map.put(ch,1);
            }
        }
        System.out.println(map);



        map.entrySet().stream().filter(item->item.getValue()==1).findFirst().ifPresent(s->System.out.println("first:"+s));

        Character result = input.chars() // Stream of String
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println(result);

        list.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long>map1 = names.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map1);

        System.setProperty("ENV", "DEV");
        System.out.println(System.getProperty("ENV"));
        String input1 = "Java Articles are Awesome";


    }
}
