package functional.ds.recursion;
/*
Recursion is a problem-solving technique in which the solution is dependent
on solutions to smaller instances of the same problem

F(n)=F(n−1)+F(n−2)

https://www.mygreatlearning.com/blog/fibonacci-series-in-java/
 */
public class RecursionAlgorithm {
    static int num1=0,num2=1,num3;
    static void fibonacciSeries(int num){

        System.out.print(num1+" "+num2+" ");
        for (int i=2;i<num;i++){
            num3 = num1+num2;
            System.out.print(num3+" ");
            num1=num2;
            num2=num3;
        }
    }
    static void fibonacciSeriesUsingRecursion(int num){

        if (num>0){
            num3 = num1+num2;
            System.out.print(" "+num3);
            num1=num2;
            num2=num3;
            fibonacciSeriesUsingRecursion(num-1);
        }
    }

    public static void main(String[] args) {
        int count = 10;
        fibonacciSeries(count);
        System.out.println("\nusing recursion");
        num1=0;
        num2=1;
        num3=0;
        System.out.print(num1+" "+num2);//printing 0 and 1
        fibonacciSeriesUsingRecursion(count-2);
    }
}
