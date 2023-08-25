package functional.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
  find teeter first non repeating character
 */
public class FirstNonRepeatingCharacterInString {
    public static void main(String[] args) {
        String str = "teeter";
        firstApproachUsingIndex(str);
        Character ch = secondApproachUsingLinkedHashMap(str);
        System.out.println("First Non Repeating Character is "+ch);

        Character ch2 =  thirdApproachUsingSetList(str);
        System.out.println("First Non Repeating Character is "+ch2);
        Character ch3 = fourthApproachUsingJava8(str);
        System.out.println("First Non Repeating Character is "+ch3);
    }



    private static void firstApproachUsingIndex(String str) {
        for(char ch:str.toCharArray()){
            if(str.indexOf(ch) == str.lastIndexOf(ch)){
                System.out.println("First Non Repeating Character is "+ch);
                break;
            }
        }
    }

    private static Character  secondApproachUsingLinkedHashMap(String str) {
        Map<Character,Integer>map = new LinkedHashMap<>();
        Character ch;
        int length = str.length();
        for (int i=0;i<length;i++){
            ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
       for (Map.Entry<Character,Integer>entry:map.entrySet()){
           if(entry.getValue() == 1){
               return entry.getKey();
           }
       }
       return null;
    }
    private static Character thirdApproachUsingSetList(String str) {
        Set<Character> repeatingChars = new HashSet<>();
        List<Character> nonRepeatingChars = new ArrayList<>();
        for(int i=0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if(repeatingChars.contains(letter))
                continue;
            if(nonRepeatingChars.contains(letter)) {
                nonRepeatingChars.remove((Character) letter);
                repeatingChars.add(letter);
            }
            else {
                nonRepeatingChars.add(letter);
            }
        }
        return nonRepeatingChars.get(0);
    }
    private static Character  fourthApproachUsingJava8(String str) {
        Map<Character,Integer>map = new LinkedHashMap<>();
        Character ch;
        int length = str.length();
        for (int i=0;i<length;i++){
            ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        return map.entrySet().stream().filter(s->s.getValue()==1).findFirst().get().getKey();
    }

}
