package functional.dp.solid.srp;

public class Employee {
    private int id;
    private String name;
    private Address address;

    public Employee(int id, String name,Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void printMe() {
        System.out.println("Employee id is "+this.id+" employee name is "+this.name);
    }
}
