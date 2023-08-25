package functional.interview;

public class CommonAlgorithm {
    public static void main(String[] args) {
        fibonacci();
        armstrongNumber(153);
        primeNumber(29);
        sumNumber(12345);
        reverseNumber(12345);
        palindromeNumber(121);
        factorialNumber(5);
        int n=5;
        System.out.println(factorialNumberUsingRecursion(n)+" is the factorial of "+n);
        petersonNumber(145);
    }
    private static void sumNumber(int i) {
        int temp = i;
        int sum = 0;
        while (i>0){
            int r = i%10;
            sum = sum+r;
            i = i/10;
        }
        System.out.println(sum+" is sum number of "+temp);
    }
    private static void reverseNumber(int i) {
        int temp = i;
        int sum = 0;
        while (i>0){
            int r = i%10;
            sum = sum*10+r;
            i = i/10;
        }
        System.out.println(sum+" is reverse number of "+temp);
    }
    private static void palindromeNumber(int i) {
        int temp = i;
        int sum= 0;
        while (i>0){
            int r = i%10;
            sum = sum*10+r;
            i = i/10;
        }
        if (sum==temp){
            System.out.println(temp+" is a palindrome number");
        }else {
            System.out.println(temp+" is not a palindrome number");
        }
    }

    private static void armstrongNumber(int i) {
        int temp = i;
        int sum = 0;
        while (i>0){
            int rem = i%10;
            sum = sum + rem*rem*rem;
            i= i/10;
        }
        if (sum==temp){
            System.out.println("\nArmstrong Number");
        }else {
            System.out.println("\nNot Armstrong Number");
        }
    }
    private static void primeNumber(int num) {
        boolean flag = false;
        for (int i=2;i<= num/2;++i){
            if(num % i == 0){
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println(num+" is a prime number");
        }else {
            System.out.println(num+" is not a prime number");
        }
    }
    private static void factorialNumber(int num) {
        int factorial = 1;
        for (int i=1;i<=num;i++){
            factorial = factorial*i;
        }
        System.out.println(factorial+" is the factorial of "+num);
    }
    private static int factorialNumberUsingRecursion(int num) {
        if(num == 0 || num == 1)
            return 1;
        else
            return (num * factorialNumberUsingRecursion(num - 1));
    }
    private static void petersonNumber(int num) {
        int temp = num;
        int factorial;
        int sum = 0;
        while (num!=0){
            factorial = 1;
            int r = num%10;
           for (int i=1;i<=r;i++){
               factorial = factorial*i;
           }
           sum = sum+factorial;
           num = num/10;
        }
        if (sum==temp)
            System.out.println(temp+" is the Peterson Number ");
        else
            System.out.println(temp+" is not Peterson Number ");
    }

    private static void fibonacci() {
        int num1=0,num2=1,num3,i,count=5;
        System.out.print(num1+" "+num2);
        for (i=2;i<count;i++){
            num3 = num1+num2;
            System.out.print(" "+num3);
            num1=num2;
            num2=num3;
        }
    }
}
