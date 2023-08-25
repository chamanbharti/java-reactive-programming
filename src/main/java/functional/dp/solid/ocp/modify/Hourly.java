package functional.dp.solid.ocp.modify;

public class Hourly implements IPayClassification{
    @Override
    public float calculateSalary() {
        System.out.println("calculate pay for Hourly salary");
        return 0;
    }
}
