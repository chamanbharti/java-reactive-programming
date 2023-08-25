package functional.dp.solid.ocp.modify;

public class Commision implements IPayClassification{
    @Override
    public float calculateSalary() {
        System.out.println("calculate pay for commision salary");
        return 0;
    }
}
