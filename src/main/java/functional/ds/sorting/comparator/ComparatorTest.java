package functional.ds.sorting.comparator;

import functional.ds.sorting.comparator.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
public interface java.util.Comparator<T> {
  public abstract int compare(T, T);
  public abstract boolean equals(java.lang.Object);
  public default java.util.Comparator<T> reversed();
  public default java.util.Comparator<T> thenComparing(java.util.Comparator<? super T>);
  public default <U> java.util.Comparator<T> thenComparing(java.util.function.Function<? super T, ? extends U>, java.util.Comparator<? super U>);
  public default <U extends java.lang.Comparable<? super U>> java.util.Comparator<T> thenComparing(java.util.function.Function<? super T, ? extends U>);
  public default java.util.Comparator<T> thenComparingInt(java.util.function.ToIntFunction<? super T>);
  public default java.util.Comparator<T> thenComparingLong(java.util.function.ToLongFunction<? super T>);
  public default java.util.Comparator<T> thenComparingDouble(java.util.function.ToDoubleFunction<? super T>);
  public static <T extends java.lang.Comparable<? super T>> java.util.Comparator<T> reverseOrder();
  public static <T extends java.lang.Comparable<? super T>> java.util.Comparator<T> naturalOrder();
  public static <T> java.util.Comparator<T> nullsFirst(java.util.Comparator<? super T>);
  public static <T> java.util.Comparator<T> nullsLast(java.util.Comparator<? super T>);
  public static <T, U> java.util.Comparator<T> comparing(java.util.function.Function<? super T, ? extends U>, java.util.Comparator<? super U>);
  public static <T, U extends java.lang.Comparable<? super U>> java.util.Comparator<T> comparing(java.util.function.Function<? super T, ? extends U>);
  public static <T> java.util.Comparator<T> comparingInt(java.util.function.ToIntFunction<? super T>);
  public static <T> java.util.Comparator<T> comparingLong(java.util.function.ToLongFunction<? super T>);
  public static <T> java.util.Comparator<T> comparingDouble(java.util.function.ToDoubleFunction<? super T>);
}
 */

// https://mkyong.com/java8/java-8-lambda-comparator-example/
public class ComparatorTest {
    public static void main(String[] args) {
        ArrayList<Student> al=new ArrayList<>();
        al.add(new Student(101,"Vijay",23));
        al.add(new Student(106,"Ajay",27));
        al.add(new Student(105,"Chaman",21));

        System.out.println("Using implementation class");
        Collections.sort(al,new NameComparator());
        System.out.println(al);

        System.out.println("Sort By Name:Using Annonymous class");
        Comparator<Student> byName = new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(al,byName);
        System.out.println(al);

        System.out.println("Sort By Age:Using Annonymous class");
        Collections.sort(al,new Comparator<>(){
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(al);

        System.out.println("Using Java8 Lambda Expression");
        Comparator<Student> byName2 = (o1,o2) -> o1.getName().compareTo(o2.getName());
        Collections.sort(al,byName2);
        System.out.println(al);

        System.out.println("Using Java8 Comparator.comparing");
        Comparator<Student> byName3 = Comparator.comparing(Student::getName);
        Collections.sort(al,byName3);
        System.out.println(al);

        System.out.println("Sort with Lambda 1st Approach");
        // In Java 8, the List interface is supports the sort method directly,
        // no need to use Collections.sort anymore.
        al.sort(new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(al);
        System.out.println("Sort with Lambda 2nd Approach");
        al.sort( (o1,o2) -> o1.getAge() - o2.getAge());
        System.out.println(al);

        System.out.println("Reverse Order 1st Approach");
        Comparator<Student> reverseOrder = (o1,o2) -> o1.getAge() - o2.getAge();
        al.sort(reverseOrder.reversed());
        System.out.println(al);

        System.out.println("Reverse Order 2nd Approach");
        Comparator<Student> reverseOrder2 = Comparator.comparing(Student::getAge);
        al.sort(reverseOrder2.reversed());
        System.out.println(al);

        System.out.println("Sorting by age");

        Collections.sort(al,new AgeComparator().reversed());
        for(Student st: al){
            System.out.println(st.rollno+" "+st.name+" "+st.age);
        }
        System.out.println("Using java8");
        //Sorting elements on the basis of name
        Comparator<Student>cm2 = Comparator.comparing(Student::getAge);
        Collections.sort(al,cm2.reversed());
        System.out.println("Sorting by Age using java8");
        for(Student st: al){
            System.out.println(st.rollno+" "+st.name+" "+st.age);
        }

        al=new ArrayList<Student>();
        al.add(new Student(101,"Vijay",23));
        al.add(new Student(106,"Ajay",27));
        al.add(new Student(105,null,21));
        Comparator<Student> cm3=Comparator.comparing(Student::getName,Comparator.nullsFirst(String::compareTo));
        Collections.sort(al,cm3);
        System.out.println("Considers null to be less than non-null");
        for(Student st: al){
            System.out.println(st.rollno+" "+st.name+" "+st.age);
        }
        Comparator<Student> cm4=Comparator.comparing(Student::getName,Comparator.nullsLast(String::compareTo));
        Collections.sort(al,cm4);
        System.out.println("Considers null to be greater than non-null");
        for(Student st: al){
            System.out.println(st.rollno+" "+st.name+" "+st.age);
        }
    }

}
