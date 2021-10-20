import Interfaces.IBonus;
import Interfaces.IEmployee;

public abstract class Employee implements IEmployee, IBonus {
    int employeeId;
    String employeeName;
    double minSalary;

    public Employee(int employeeId, String employeeName, double minSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.minSalary = minSalary;
    }
}
