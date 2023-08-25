package functional.java_16_features;

import java.util.Comparator;
import java.util.Objects;

public record Student(int id, String firstName) implements Comparator<Student> { // Canonical Constructor

    public Student { // Compact Constructor = validation
        if (id <= 0) {
            System.out.println("ID cannot be 0 or negative");
        }
        Objects.requireNonNull(firstName);
    }

    // overloaded parameterized constructor > delegates(constructor)
    public Student(int id){
        this(id,"unknown");
    }
    public Student(String firstName){
        this(1,"Chaman");
    }


/*
public int compareTo(Object obj): It is used to compare the current object with the specified object.
It returns:
1 positive integer, if the current object is greater than the specified object.
-1 negative integer, if the current object is less than the specified object.
0 zero, if the current object is equal to the specified object.
 */

    /*
    @Override
    public int compareTo(Student st) {
        if(id == st.id){
            return 0;
        } else if (id > st.id) {
            return 1;
        }
        return -1;
    }
     */
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.id == o2.id){
            return 0;
        }else if(o1.id > o2.id){
            return 1;
        }
        else
            return -1;

    }

}