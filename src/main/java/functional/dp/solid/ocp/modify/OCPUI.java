package functional.dp.solid.ocp.modify;

public class OCPUI {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("chaman");

        Commision commision = new Commision();
        employee.setSalaryType(commision);

        PayRoll payRoll = new PayRoll();
        payRoll.calculateSalary(employee);
    }
}
