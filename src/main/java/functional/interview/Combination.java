package functional.interview;
//https://javahungry.blogspot.com/2013/06/find-all-possible-permutations-of-given.html
public class Combination {
    static StringBuilder output = new StringBuilder();
    static String inputString;

    public static void main(String[] args) {
        combine("wxyz");
    }
    private static void combine(String s){
        inputString = s;
        combine(0);
    }
    private static void combine(int start){
        for(int i=start;i<inputString.length();++i){
            output.append(inputString.charAt(i));
            System.out.println(output);
            if (i<inputString.length()){
                combine(i+1);
                output.setLength(output.length()-1);
            }
        }
    }
}
