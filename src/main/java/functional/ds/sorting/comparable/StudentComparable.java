package functional.ds.sorting.comparable;

public class StudentComparable implements Comparable<StudentComparable>{
    private int id;
    private String name;
    private int age;

    public StudentComparable(int id, String name,int age) {
        this.id = id;
        this.name = name;
        this.age=age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentComparable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(StudentComparable student) {
        //sort by name
       // return name.compareTo(student.name);
        //sort by age
        if(age == student.getAge()){
            return 0;
        } else if (age < student.age) {//reverse order
            return 1;
        }else {
            return -1;
        }
    }
}
