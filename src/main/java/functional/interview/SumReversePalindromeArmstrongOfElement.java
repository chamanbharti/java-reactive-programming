package functional.interview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumReversePalindromeArmstrongOfElement {

    public static void main(String[] args) {
        int no = -12345;
        sumOfElementUsingSimpleLogic(no);
        reverseOfGivenNo(454);
        reverseOfGivenNo(454);
        reverseOfGivenString("Chaman");
        palindrome(121);
        palindrome2();
        //armstrong(370);

        System.out.println(" Using IntStream.sum()");
        List<Integer> list = Arrays.asList(10,15,8,8,49,25,98,32,97);
        sumOfElementUsingList(list);
        sumOfElementUsingJava8(list);
        sumOfElementUsingJava8InStream(list);

        System.out.println("Using Stream#sum With Map");
        Map<String,Integer> map = new HashMap<>();
        map.put("A",12);
        map.put("B",13);
        map.put("C",14);
        sumOfElementUsingJava8Map(map);

        System.out.println("Using Stream#sum With Objects");
        Item item1 = new Item(1, 10);
        Item item2 = new Item(2, 15);
        Item item3 = new Item(3, 25);
        Item item4 = new Item(4, 40);

        List<Item> items = Arrays.asList(item1, item2, item3, item4);
        sumOfElementUsingCustomClass(items);

        System.out.println("Using Stream#sum With String");
        String string = "Item110Item225Item330Item445";//use=string.split("")
        sumOfContainedNoInStringWithoutSpace(string);
        String string1 = "Item 1 1 0 Item 2 2 5 Item 3 3 0 Item 4 4 5";//use=string.split(" ")
        sumOfContainedNoInStringWithSpace(string1);
        sumOfElementAsPerQuestion();
        removeCharacterFromString();

    }
    private static void sumOfElementUsingSimpleLogic(int no) {
        System.out.println("sum of element using simple logic");
        int sum = 0;
        while (no>0){
            int remainder = no % 10;
            sum = sum + remainder;
            no = no / 10;
        }
        System.out.println("Sum:"+sum);
    }
    private static void armstrong(int num) {
        int sum = 0;
        int temp = num;
        while (num>0){
            int r = num%10;
            sum = sum+r*r*r;
            num = num/10;
        }
        if(temp == sum){
            System.out.println("armstrong");
        }else{
            System.out.println("not armstrong");
        }
    }
    private static void reverseOfGivenNo(int i) {
        int sum = 0;
        while (i>0){
            int r = i%10;
            sum = sum*10+r;
            i = i/10;
        }
        System.out.println("sum of given no:"+sum);
    }
    private static void reverseOfGivenString(String str) {
        String rev = "";
        char[] chars = str.toCharArray();
        for (int i= chars.length-1;i>=0;i--){
            rev = rev+chars[i];
        }
        System.out.println("reverse String:"+rev);
    }

    private static void palindrome(int i) {
        int sum = 0;
        int temp = i;
        while (i>0){
            int r = i%10;
            sum = sum*10+r;
            i = i/10;
        }
        if(temp == sum){
            System.out.println("palindrome");
        }else{
            System.out.println("not palindrome");
        }

    }
    private static void palindrome2() {
        System.out.println("Enter no/string:");
        //Scanner input = new Scanner(System.in);
       // String str = input.nextLine();
        String str = "Chaman";
        String rev = "";
        String temp = str;
        for (int i=str.length()-1;i>=0;i--){
            rev = rev + str.charAt(i);
        }
        if(str.equals(rev)){
            System.out.println("palindrome");
        }else{
            System.out.println("not palindrome");
        }

    }


    private static void sumOfElementUsingList(List<Integer> list) {
        System.out.println("sum of element using List");
        int sum = 0;
        for (Integer no:list){
            sum = sum + no;
        }
        System.out.println("Sum:"+sum);
    }
    private static void sumOfElementUsingJava8(List<Integer> list) {
        System.out.println("sum of element using Java8");
// https://www.baeldung.com/java-stream-sum
        // Using Stream.reduce()
//        Integer sum = list.stream().reduce(0, (a,b) -> a+b);
//        Integer sum = list.stream().reduce(0, Integer::sum);
        Integer sum = list.stream().reduce(0,(a,b)-> Addition.add(a,b));
//        int sum = list.stream().mapToInt(i->i).sum();
//        int sum = list.stream().mapToInt(Integer::intValue).sum();
        // Using Stream.collect()
//        int sum = list.stream().collect(Collectors.summingInt(Integer::intValue));

        System.out.println("Sum:"+sum);
    }
    private static void sumOfElementUsingJava8InStream(List<Integer> list) {
        System.out.println("sum of element using Java8 InStream");
        Integer sum = list.stream().mapToInt(i->i).sum();
        System.out.println("Sum:"+sum);
    }
    private static void sumOfElementUsingJava8Map(Map<String,Integer> map){
        System.out.println("sum of element using Java8 Map");
//        Integer sum = map.values().stream().reduce(0,Integer::sum);
        Integer sum = map.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum:"+sum);
    }

    private static void sumOfElementUsingCustomClass(List<Item> items) {
        System.out.println("sumOfElementUsingCustomClass");
        //Integer sum = items.stream().map(x->x.getPrice()).reduce(0,(a,b)->a+b);
        //Integer sum = items.stream().map(x->x.getPrice()).reduce(0,Integer::sum);
        //Integer sum = items.stream().map(x->x.getPrice()).reduce(0,Addition::add);
        //Integer sum = items.stream().map(x->x.getPrice()).collect(Collectors.summingInt(Integer::intValue));
        Integer sum = items.stream().mapToInt(item->item.getPrice()).sum();

        System.out.println("Sum:"+sum);
    }
    private static void sumOfContainedNoInStringWithoutSpace(String string) {

        System.out.println("sumOfContainedNoInStringWithoutSpace");

        Integer sum = Arrays.stream(string.split(""))
      // Integer sum = Stream.of(string.split(""))
               .filter(s->s.matches("\\d+"))
               .mapToInt(Integer::valueOf)
               .sum();
        System.out.println("sum:"+sum);
    }
    private static void sumOfContainedNoInStringWithSpace(String string) {
        System.out.println("sumOfContainedNoInStringWithSpace");

        Integer sum = Arrays.stream(string.split(" "))
                // Integer sum = Stream.of(string.split(""))
                .filter(s->s.matches("\\d+"))
                .mapToInt(Integer::valueOf)
                .sum();
        System.out.println("sum:"+sum);
    }
    private static void sumOfElementAsPerQuestion(){
           /*
implement a singleton class and to make it threadsafe

Remove unwanted chars Given an array [“123f”, “1dsa12”, “1212ds”, “65fd”, “sadfa”, “asdasd”]
Each item can contain 0-9, a-z, A-Z where a-z, A-Z characters are unwanted
Sum of all the numbers after removing all the unwanted characters 123+112+1212+65
     */
            String[] array = {"123f", "1dsa12", "1212ds", "65fD", "sadfa", "asdasd"};
            String str = Stream.of(array).collect(Collectors.joining(","));
            System.out.println("removed digit:"+str.replaceAll("\\d+",""));
            System.out.println("only digit:"+str.replaceAll("\\D+",""));

            int sum = Arrays.stream(str.split(","))
                    //.map(s->s.replaceAll("([a-z])",""))
                    .map(s->s.replaceAll("([a-zA-Z])",""))
                    .filter(s->s.matches("\\d+"))
                    .mapToInt(Integer::valueOf)
                    .sum();
            System.out.println(sum);
        /*
        int sum = Arrays.stream(array)
                .peek(System.out::println)
                .map(s->s.replaceAll("([a-z])",""))
                .peek(System.out::println)
                .filter(s->s.matches("\\d+"))
                .peek(System.out::println)
                .mapToInt(Integer::valueOf)
                .peek(System.out::println)
                        .sum();
         */
        System.out.println(sum);
    }
    private static void removeCharacterFromString(){
        String str = "abc ABC 123 abc";

        // Remove a character from a string in Java
        System.out.println("String after removing all the 'a' s ="+str.replace("a",""));
        // Remove spaces from a string in Java
        System.out.println("String after removing all the spaces = "+str.replace(" ",""));
        // Remove a substring from a string in Java
        System.out.println("String after removing the first 'ab' substring = "+str.replaceFirst("ab",""));
        // Remove all the lowercase letters from a string in Java
        System.out.println("String after removing all the lowercase letters = "+str.replaceAll("([A-Z])",""));
        // Remove the last character from a string in Java
        System.out.println("String after removing the last character = "+str.substring(0,str.length()-1));
    }

    private static class Addition{
        private static int add(int a,int b){
            return a + b;
        }
    }


}
