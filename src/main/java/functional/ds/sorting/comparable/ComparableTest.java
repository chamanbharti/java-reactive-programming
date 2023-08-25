package functional.ds.sorting.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/*
public interface java.lang.Comparable<T> {
  public abstract int compareTo(T);
}
 */
public class ComparableTest {
    public static void main(String[] args) {
        List<String> al=new ArrayList<String>();
        al.add("Viru");
        al.add("Saurav");
        al.add("Mukesh");
        al.add("Tahir");
        System.out.println(al);
        //Collections.sort(al);
        Collections.sort(al,Collections.reverseOrder());
        Iterator<String> itr = al.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("custom sorting");
        List<StudentComparable> list=new ArrayList<>();
        list.add(new StudentComparable(1,"Viru",67));
        list.add(new StudentComparable(5,"Saurav",27));
        list.add(new StudentComparable(7,"Mukesh",30));
        list.add(new StudentComparable(2,"Tahir",55));
        Collections.sort(list);
        //Collections.sort(list,Collections.reverseOrder());
        Iterator<StudentComparable> itr2 = list.iterator();
        while (itr2.hasNext()){
            System.out.println(itr2.next());
        }
    }
}
