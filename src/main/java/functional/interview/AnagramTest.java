package functional.interview;

import java.util.Arrays;

public class AnagramTest {
    public static void main(String[] args) {
     isAnagram("HEART", "EARTH");
        isAnagram("TRIANGLE", "INTEGRAL");
        isAnagram("TOSS", "SHOT");

    }
    private static void isAnagram(String str1,String str2) {
        //str1=str1.toLowerCase();
        //str2=str2.toLowerCase();
        boolean status;
        if(str1.length() != str2.length()){
            status = false;
        }else {
            char[] array1 = str1.toLowerCase().toCharArray();
            char[] array2 = str2.toLowerCase().toCharArray();
           // Arrays.sort(array1);
           // Arrays.sort(array2);
            sort(array1);
            sort(array2);
            status = Arrays.equals(array1,array2);
        }
        if (status){
            System.out.println(str1+" and "+str2+" is anagram");
        }else {
            System.out.println(str1+" and "+str2+" is not anagram");
        }

    }
    private static void sort(char[] array){
        char temp;
        for(int i=0;i< array.length;i++){
            for(int j=i+1;j< array.length;j++){
              if(array[i]<array[j]){
                  temp = array[i];
                  array[i]=array[j];
                  array[j]=temp;
              }
            }
        }
    }


    private static void isAnagram1(String str1, String str2) {
        String s1 = str1.replaceAll("\\s","");
        String s2 = str2.replaceAll("\\s","");
        boolean status;
        if(s1.length() != s2.length()){
            status = false;
        }else {
            char[] array1 = str1.toLowerCase().toCharArray();
            char[] array2 = str1.toLowerCase().toCharArray();
            Arrays.sort(array1);
            Arrays.sort(array2);
            status = Arrays.equals(array1,array2);
        }
        if (status){
            System.out.println(str1+" and "+str2+" is anagram");
        }else{
            System.out.println(str1+" and "+str2+" is not anagram");
        }
    }
}
