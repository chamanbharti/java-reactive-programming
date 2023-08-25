package functional.dp.solid.ocp.modify;

public class PayRoll {
    public void calculateSalary(Employee employee){
        employee.getSalaryType().calculateSalary();
    }
}
