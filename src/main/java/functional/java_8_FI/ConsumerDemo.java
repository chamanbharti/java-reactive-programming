package functional.java_8_FI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class ConsumerDemo implements Consumer<List<Integer>> {


    /*
     @Override
    public void accept(Integer input) {
        System.out.println("Accept : "+input);
    }
    */
    public void accept(List<Integer> list) {
        for (Integer input:list) {
            System.out.println("Accept : " + input);
        }
    }
    public static void main(String[] args) {
        Integer input = 1010;
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        System.out.println("first approach");
        ConsumerDemo consumerDemo = new ConsumerDemo();
        //consumerDemo.accept(input);
        consumerDemo.accept(list);

        System.out.println("second approach");
        list.stream().forEach(t -> System.out.println("Accept : "+t));

        Consumer<String>c = System.out::println; //s->System.out.println(s);
        c.accept("Chaman");
        BiConsumer<String,String>cc = (a,b)->System.out.println(a+b);
        cc.accept("a","b");

        Supplier<String>s = ()->{
            String[] s1 = {"Sunny","Bunny","Chinny","Pinny"};
            int x =(int)(Math.random()*4);
            return s1[x];
        };
        System.out.println(s.get());
        Supplier<String> otps = ()->{
            String otp = "";
            for (int i=1;i<=6;i++){
                otp = otp+(int)(Math.random()*10);
            }
            return otp;
        };
        System.out.println(otps.get());

        Supplier<String> stringSupplier = ()->{
            String symbols="ABCDEFGHIJKLMNOPQRSTUVWXYZ#$@";
            Supplier<Integer>d = ()->(int)(Math.random()*10);
            Supplier<Character>ch = ()->symbols.charAt((int)(Math.random()*29));
            String pwd = "";
            for(int i=1;i<=8;i++){
                if(i%2==0){
                    pwd = pwd+d.get();
                }else{
                    pwd = pwd+ch.get();
                }
            }
            return pwd;
        };
        System.out.println(stringSupplier.get());

        BiPredicate<Integer,Integer>p = (a,b)->(a+b)%2==0;
        System.out.println(p.test(10,20));
        BiFunction<Integer,Integer,Integer>bf = (a,b)->a*b;
        System.out.println(bf.apply(10,20));

        List<Employee> l = new ArrayList<>();
        BiFunction<String,Integer,Employee> bfemployee = (name,rollno)-> new Employee(name,rollno);
        //l.add(new Employee("chaman",1));
        l.add(bfemployee.apply("chaman",1));
        l.add(bfemployee.apply("bharti",2));
        for (Employee e:l){
            System.out.println("name:"+e.getName());
            System.out.println("rollno:"+e.getRollno());
        }
    }

}
class Employee{
    private String name;
    private int rollno;

    public Employee(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
}
