package functional.dp.solid.ocp.modify;

public class Salary implements IPayClassification{
    @Override
    public float calculateSalary() {
        System.out.println("calculate pay for monthly salary");
        return 0;
    }
}
