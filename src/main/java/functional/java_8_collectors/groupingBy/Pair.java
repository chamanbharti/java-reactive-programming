package functional.java_8_collectors.groupingBy;

public class Pair {
    private double salary;
    private Department department;

    public Pair(double salary, Department department) {
        this.salary = salary;
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "salary=" + salary +
                ", department=" + department +
                '}';
    }
}
