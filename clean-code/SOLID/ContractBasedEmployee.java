import Interfaces.IEmployee;

public class ContractBasedEmployee implements IEmployee {
    int employeeId;
    String employeeName;
    double minSalary;

    public ContractBasedEmployee(int employeeId, String employeeName, double minSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.minSalary = minSalary;
    }
    @Override
    public double getMinimumSalary(){
        return minSalary;
    }
}

