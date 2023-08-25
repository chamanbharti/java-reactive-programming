package functional.interview;

import java.util.HashMap;
import java.util.Map;

public class HashCodeEqualsTest {
    public static void main(String[] args) {
        Employee e1 = new Employee(1);
        Employee e2 = new Employee(1);
        System.out.println("e1 and e2 equlas:"+e1.equals(e2));
        System.out.println("e1:"+e1.hashCode()+" e2:"+e2.hashCode());
        Map<Employee,String> map = new HashMap<>();
        map.put(e1,"Chaman");
        map.put(e2,"Chaman");
        System.out.println("map size:"+map.size());

        Integer i = new Integer(1);
        Integer ii = new Integer(1);
        System.out.println("i and ii equlas:"+i.equals(ii));
        System.out.println("i:"+i.hashCode()+" ii:"+ii.hashCode());
        Map<Integer,String>map2 = new HashMap<>();
        map2.put(i,"Chaman");
        map2.put(ii,"Chaman");
        System.out.println("map2 size:"+map2.size());
        System.out.println("Hashcode()");
        Human human = new Human(1235,null);
        System.out.println(human.hashCode());
        Human human1 = new Human(1235,null);
        System.out.println(human1.hashCode());
    }
}
class Employee{
    int id;
    public Employee(int id){
        this.id=id;
    }
    @Override
    public boolean equals(Object o) {
       if (this==o){
           return true;
       }
       if(o==null || getClass()!=o.getClass()){
           return false;
       }
       Employee other = (Employee)o;
       return id==other.id;
    }
    @Override
    public int hashCode() {
        //return Objects.hash(id);
        final int prime = 31;
        int result = 1;
        result = prime*result+id;
        return result;
    }
}
class Human extends Object{
    public int adharNumber;
    public String name;
    public Human(int adharNumber,String name){
        this.adharNumber=adharNumber;
        this.name=name;
    }


}
