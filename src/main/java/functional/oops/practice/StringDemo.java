package functional.oops.practice;
//https://www.tutorialspoint.com/java/lang/java_lang_string.htm
public class StringDemo {
    public static void main(String[] args) {
        String str = "Chaman Bharti";
        for (int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+"->"+str.codePointAt(i)+" ");
        }
        System.out.println();
        System.out.println(str.codePointBefore(1));
        System.out.println(str.charAt(1));
        System.out.println(str.codePointAt(1));
        for (int i=0;i<str.length();i++){
            System.out.print(str.codePointAt(i)+" ");
        }
        System.out.println("str:"+str.codePointCount(0,str.length()-1));

        str = "abc ABC 123 abc";

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
}
