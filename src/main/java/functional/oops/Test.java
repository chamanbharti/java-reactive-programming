package functional.oops;


import java.util.*;
import java.util.stream.Stream;


public class Test {
    static StringBuilder output = new StringBuilder();
    static String inputString;
    public static void main(String[] args) {
        String str = "chaman";
        nonRepeatingCharacter(str);
        nonRepeatingCharacterUsingMap(str);
        nonRepeatingCharacterUsingListSet(str);
        sumOfContainedNumber("chaman1l2l3");
        sumOfContainedNumber2("chaman1 l 2 l 3");
        palindrome(121);
        palindrome("mom");
        armstrong(121);

        combination("wxyz");
    }

    private static void combination(String str) {
        inputString = str;
        System.out.println("The input string is :"+inputString);
        System.out.println("All possible combinations are :  ");
        combine();
    }
    private static void combine(){
        combine(0);
    }
    private static void combine(int start){
        for(int i=start;i<inputString.length();++i){
            output.append(inputString.charAt(i));
            System.out.println(output);
            if(i<inputString.length()){
                combine(i+1);
                output.setLength(output.length()-1);
            }
        }
    }

    private static void armstrong(int no){
        System.out.println("armstrong");
        int temp = no;
        int sum = 0;
        while (no>0){
            int rem = no%10;
            sum = sum + (rem*rem*rem);
            no = no/10;
        }
        if(temp == sum){
            System.out.println("armstrong");
        }
    }
    private static void palindrome(String s){
        System.out.println("Palindrome string/integer");
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        String rev = "";
        for (int i=s.length()-1;i>=0;i--){
            rev = rev + s.charAt(i);
        }
        if(s.equals(rev)){
            System.out.println("palindrome");
        }

    }
    private static void palindrome(int no){
        System.out.println("Palindrome using integer");
        int temp = no;
        int sum = 0;
        while (no>0){
            int rem = no % 10;
            sum = sum * 10 + rem;
            no = no / 10;
        }
        if(sum == temp){
            System.out.println("palindrome");
        }
    }

    private static void sumOfContainedNumber2(String s) {
        Integer sum = Arrays.stream(s.split(""))
                .filter(sa->sa.matches("\\d+"))
                .mapToInt(Integer::valueOf).sum();
        System.out.println("sum of contained space "+sum);
    }

    private static void sumOfContainedNumber(String chaman1l2l3) {
        Integer sum = Stream.of(chaman1l2l3.split(""))
                .filter(s->s.matches("\\d+"))
                .mapToInt(Integer::valueOf).sum();
        System.out.println("sum:"+sum);
    }

    private static void nonRepeatingCharacterUsingListSet(String str) {
        Set<Character>repeating = new HashSet<>();
        List<Character>nonRepeating = new ArrayList<>();
        Character ch;
        for (int i=0;i<str.length();i++){
            ch = str.charAt(i);
            if(repeating.contains(ch)){
                continue;
            }
            if (nonRepeating.contains(ch)){
                nonRepeating.remove(ch);
                repeating.add(ch);
            }else {
                nonRepeating.add(ch);
            }
        }
        System.out.println("non repeating character using set "+nonRepeating.get(0));
    }

    private static void nonRepeatingCharacter(String str) {
        for (char ch:str.toCharArray()){
            if(str.indexOf(ch) == str.lastIndexOf(ch)){
                System.out.println("non repeating character "+ch);
            }
        }
    }
    private static void nonRepeatingCharacterUsingMap(String str) {
        Map<Character,Integer>map = new HashMap<>();
        for (char ch:str.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        System.out.println(map);
        for (Map.Entry<Character,Integer>entry:map.entrySet()){
            if(entry.getValue()==1){
                System.out.println("non repeating character "+entry.getKey());
            }
        }
        System.out.println("map java8");
        System.out.println(map.entrySet().stream().filter(ch->ch.getValue()==1).findAny().get().getKey());
        //map.entrySet().stream().filter(ch->ch.getValue()==1).forEach(System.out::println);
    }
}
