package functional.interview;
/*
[“amazon”, “amazed”, “amaze”, “amazing”, “amazes”]
https://leetcode.com/problems/longest-common-prefix/
https://java2blog.com/longest-common-prefix-in-array-of-strings-java/
https://www.java67.com/2022/02/how-to-find-longest-common-prefix-in.html
 */
public class CommonPrefix {

    public static void main(String[] args) {
        String[] array = {"amazon", "amazed", "amaze", "amazing", "amazes"};
        String longestCommonPrefix = findLongestCommonPrefix(array);
        System.out.print("the longest common prefix from these strings is: " +longestCommonPrefix);

    }
    private static String findLongestCommonPrefix(String[] array){
        /*
        if(array.length == 0) return "";
        String prefix = array[0];
        for(int i=1;i<array.length;i++){
            while (array[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
        */
        if(array == null || array.length == 0) return "";
        for (int i=0;i<array[0].length();i++){
        char c = array[0].charAt(i);
        for(int j=1;j< array.length;j++){
            if(i==array[j].length() || array[j].charAt(i) != c){
                return array[0].substring(0,i);
            }
        }
        }
        return array[0];
    }
}
